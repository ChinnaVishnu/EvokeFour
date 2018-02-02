package com.captha.sources;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class ITRAcknowledgement extends mainbase {

	@DataProvider(name = "DP1")
	public Object[][] createData1() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ITRAcknowledgement", "ITRAcknowledgement");
		return (retObjArr);
	}

	@Test(priority = 17, dataProvider = "DP1")
	public void otherverificationefilling(String loginid, String Password, String dateofbirth, String empty,
			String exceptedreult, String actualresult, String testresult)
					throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("  ITR Acknowledgement ");

		// Thread.sleep(9000);

		// driver.findElement(By.xpath("//div[2]/div/div[3]/div")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[text()='Tax']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[text()='  ITR Acknowledgement']/input")).click();

		Thread.sleep(7000);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// driver.findElement(By.xpath(".//*[@id='itrv']/table/tbody/tr/td[1]/img")).click();
		String mainhandle = driver.getWindowHandle();
		String childhandle = "";
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(mainhandle)) {
				childhandle = handle;

			}
		}
		Thread.sleep(6000);
		driver.switchTo().window(childhandle);
		driver.findElement(By.xpath(".//*[@id='efilluser']")).sendKeys(loginid);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='efillpass']")).sendKeys(Password);

		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='dob']")).sendKeys(dateofbirth);

		Thread.sleep(30000);
		try {
			driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			try {

				driver.findElement(By.xpath(".//*[@id='button']")).click();

				Thread.sleep(40000);

				try {

					// Check the presence of alert
					Alert alert = driver.switchTo().alert();
					// Alert present; set the flag
					ExtentTestManager.getTest().log(LogStatus.ERROR,
							"ITR Acknowledgement  please  Enter the current  captcha !!");
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

					String otherdfillingactualresult = driver.findElement(By.xpath("//pre[@id='result']")).getText();
					String otherefillingresult = exceptedreult;

					// System.out.println(otherefillingresult.equals(otherdfillingactualresult));
					Double resPercentage = LetterPairSimilarity.compareStrings(otherdfillingactualresult,
							otherefillingresult);

					System.out.println("resPercentage " + resPercentage * 100);
					String total = Double.toString(resPercentage * 100);

					ExtentTestManager.getTest().log(LogStatus.INFO, "percentage of actual and expected :: " + total);

					if (resPercentage > 0 && (resPercentage * 100) > 80) {

						System.out.println(" PASS    ");

						ExtentTestManager.getTest().log(LogStatus.INFO,
								"ITR Acknowledgement resultexcepted is started" + otherefillingresult);
						ExtentTestManager.getTest().log(LogStatus.INFO,
								"ITR Acknowledgement resultactual is started" + otherdfillingactualresult);
						// ExtentTestManager.getTest().log(LogStatus.INFO,
						// "Other Verification : e-Filing resultcomparison is
						// "+otherefillingresult.equals(otherdfillingactualresult));
						ExtentTestManager.getTest().log(LogStatus.PASS, "ITR Acknowledgement  Result is Pass");

						String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					} else {

						System.out.println("not matching");
						// test.log(LogStatus.FATAL, "Other Verification :
						// e-Filing please provide time");
						// ExtentTestManager.getTest().log(LogStatus.ERROR,
						// "Other Verification : e-Filing Request timeout issuse
						// ");
						ExtentTestManager.getTest().log(LogStatus.FAIL, " ITR Acknowledgement  Result is Fail");

						ExtentTestManager.getTest().log(LogStatus.INFO,
								" ITR Acknowledgement resultexcepted is started" + otherefillingresult);
						ExtentTestManager.getTest().log(LogStatus.INFO,
								" ITR Acknowledgement resultactual is started" + otherdfillingactualresult);
						ExtentTestManager.getTest().log(LogStatus.INFO, " ITR Acknowledgement resultcomparison is "
								+ otherefillingresult.equals(otherdfillingactualresult));

						String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

						// driver.close();
					}
					driver.close();
				} catch (Exception e) {
					ExtentTestManager.getTest().log(LogStatus.ERROR, " ITR Acknowledgement  Request timeout issuse ");
					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				}

			} catch (Exception e) {
				System.out.println("no page");
				System.out.println(e);
			}

		} finally {
			// test.log(LogStatus.WARNING, "Other Verification : e-Filing
			// Request @@@ issuse ");
			System.out.println("hi");
		}

		// driver.close();

		driver.switchTo().window(mainhandle);

	}

}
