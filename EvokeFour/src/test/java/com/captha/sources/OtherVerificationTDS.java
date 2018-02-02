package com.captha.sources;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class OtherVerificationTDS extends mainbase {

	@DataProvider(name = "DP11")
	public Object[][] createData11() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"OtherVerificationtds", "OtherVerificationtds");
		return (retObjArr);
	}

	@Test(priority = 12, dataProvider = "DP11")
	public void OTHERVERIFICATIONTDS(String Login, String Password, String Date, String Assessment,
			String exceptedreult, String actualresult, String testresult)
					throws BiffException, IOException, InterruptedException, HeadlessException, AWTException {

		ExtentTestManager.startTest(" Other Verification : TDS ");

		/*
		 * Thread.sleep(7000);
		 * 
		 * driver.findElement(By.xpath("//div[2]/div[2]/div")).click();
		 */

		Thread.sleep(9000);
		driver.findElement(By.xpath("//a[text()='Tax']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[text()='  TDS(Form-26 AS)']/input")).click();

		Thread.sleep(7000);
		// driver.findElement(By.xpath(".//*[@id='itrv']/table/tbody/tr/td[7]/img")).click();

		String mainhandleandhra = driver.getWindowHandle();

		String childhandleAndhra = "";

		Set<String> handlesandhra = driver.getWindowHandles();

		for (String handle : handlesandhra) {

			if (!handle.equals(mainhandleandhra)) {

				childhandleAndhra = handle;

			}

		}

		driver.switchTo().window(childhandleAndhra);

		driver.findElement(By.xpath(".//*[@id='tdsuser']")).sendKeys(Login);

		driver.findElement(By.xpath(".//*[@id='tdspass']")).sendKeys(Password);

		driver.findElement(By.xpath(".//*[@id='dob']")).sendKeys(Date);

		WebElement elemenettds = driver.findElement(By.xpath(".//*[@id='assessmentYear']"));
		Select selecttds = new Select(elemenettds);
		selecttds.selectByVisibleText(Assessment);

		Thread.sleep(15000);

		// boolean foundAlert = false;

		driver.findElement(By.xpath(".//*[@id='button']")).click();

		Thread.sleep(20000);
		try {

			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			// Alert present; set the flag
			ExtentTestManager.getTest().log(LogStatus.ERROR,
					"Other Verification : TDS  please  Enter the current  captcha !!");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
					.addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

			// if present consume the alert
			alert.accept();

			// foundAlert = true;

		} catch (NoAlertPresentException ex) {
			ex.printStackTrace();
			System.out.println("no alert");
			// foundAlert = false;

			Thread.sleep(25000);
			String actualtdsresult = driver.findElement(By.xpath(".//*[@id='result']")).getText();

			String tdsresultexp = exceptedreult;

			// Assert.assertEquals(actualtdsresult, tdsresultexp);
			// System.out.println(tdsresultexp.equals(actualtdsresult));

			Double resPercentage = LetterPairSimilarity.compareStrings(actualtdsresult, tdsresultexp);

			System.out.println("resPercentage " + resPercentage * 100);
			String total = Double.toString(resPercentage * 100);

			ExtentTestManager.getTest().log(LogStatus.INFO, "percentage of actual and expected :: " + total);

			if (resPercentage > 0 && (resPercentage * 100) > 80) {

				System.out.println(" PASS    ");

				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification :TDS   resultexcepted is started" + tdsresultexp);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification :TDS   resultactual is started" + actualtdsresult);
				// ExtentTestManager.getTest().log(LogStatus.INFO, "Other
				// Verification :TDS resultcomparison is
				// "+tdsresultexp.equals(actualtdsresult));
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Other Verification :TDS   verification Result is Pass");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			} else {

				System.out.println("not matching");
				// ExtentTestManager.getTest().log(LogStatus.ERROR, "Other
				// Verification :TDS result is capche not showing");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Other Verification :TDS  result is FAIL ");
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification :TDS   resultexcepted is started" + tdsresultexp);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification :TDS   resultactual is started" + actualtdsresult);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification :TDS   resultcomparison is " + tdsresultexp.equals(actualtdsresult));
				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

			driver.close();
			// Assert.assertEquals(actualtdsresult, tdsresultexp);
		}

		driver.switchTo().window(mainhandleandhra);

	}
}
