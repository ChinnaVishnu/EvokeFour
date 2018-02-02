package com.base.pack;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.jboss.netty.handler.timeout.TimeoutException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GetScreenshort {

	private static final long DEFAULT_WAIT_TIME = 60;
	public static String reportPath;
	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;

	public static String testrobot(String screenShotName) throws HeadlessException, AWTException, IOException {

		final long serialVersionUID = 1L;

		String dateTimeString = new SimpleDateFormat("MMddhhmmss").format(new Date());
		// This code will capture screenshot of current screen
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

		// This will store screenshot on Specific location

		String fileName = reportPath + "screenshot/" + screenShotName + dateTimeString + ".jpg";

		ImageIO.write(image, "png", new File(fileName));

		return "screenshot\\" + screenShotName + dateTimeString + ".jpg";

	}

	public static String capture(WebDriver driver, String screenShotName) {
		String dateTimeString = new SimpleDateFormat("MMddhhmmss").format(new Date());
		reportPath = userdirectory();
		try {
			String screenShotPath = reportPath + "screenshot/" + screenShotName + dateTimeString + ".jpg";
			new File(reportPath + "screenshot").mkdir();
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(screenShotPath));
			final BufferedImage image = ImageIO.read(new URL("file:///" + screenShotPath));

			Graphics g = image.getGraphics();
			g.setFont(g.getFont().deriveFont(30f));
			g.setFont(new Font("default", Font.BOLD, 30));
			g.setColor(Color.red);
			g.drawString(driver.getTitle() + " :: " + driver.getCurrentUrl(), 50, 50);
			g.dispose();
			ImageIO.write(image, "png", new File(screenShotPath));

		} catch (IOException e) {
			test.log(LogStatus.FAIL, "Unable to Take Screenshot!!</br>" + e.getMessage());
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Unable to Take Screenshot!!</br>" + e.getMessage());
		}
		return "screenshot\\" + screenShotName + dateTimeString + ".jpg";
	}

	public static String userdirectory() {
		String path = System.getProperty("user.dir");
		reportPath = path + "/Reports/";
		return reportPath;
	}

	public void waitForPage() {
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
			Thread.sleep(1000);
			final JavascriptExecutor executor = (JavascriptExecutor) driver;
			ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver arg0) {
					return executor.executeScript("return document.readyState").equals("complete");
				}
			};

			wait.until(condition);
		} catch (TimeoutException e) {
			test.log(LogStatus.FAIL,
					"Page not loaded within " + DEFAULT_WAIT_TIME + " Seconds</br><pre>" + e.getMessage());
		} catch (WebDriverException e) {
			test.log(LogStatus.FAIL,
					"Element not found within " + DEFAULT_WAIT_TIME + " Seconds</br><pre>" + e.getMessage());
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Page not loaded within " + DEFAULT_WAIT_TIME + " Seconds</br><pre>" + e.getMessage());
		}
	}
}
