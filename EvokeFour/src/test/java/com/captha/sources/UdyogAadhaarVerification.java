package com.captha.sources;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class UdyogAadhaarVerification extends mainbase {

	@DataProvider(name = "DP15")
	public Object[][] createData15() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"UdyogAadhaarVerification", "UdyogAadhaarVerification");
		return (retObjArr);
	}

	@Test(priority = 5, dataProvider = "DP15")
	public void UdyogAadhaarVerification(String UAM, String Service, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult) throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Udyog Aadhaar Verification   ");
		Thread.sleep(18000);

		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();

		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[text()='  Udyog Aadhaar Verification']/input[@value='udyog']")).click();

		Thread.sleep(9000);

		String mainhandleandhra = driver.getWindowHandle();

		String childhandleAndhra = "";

		Set<String> handlesandhra = driver.getWindowHandles();

		for (String handle : handlesandhra) {

			if (!handle.equals(mainhandleandhra)) {

				childhandleAndhra = handle;

			}

		}

		driver.switchTo().window(childhandleAndhra);
		// Thread.sleep(35000);

		try {

			if (driver.findElement(By.xpath(".//*[@id='uamNo']")).isDisplayed()) {
				driver.findElement(By.xpath(".//*[@id='uamNo']")).sendKeys(UAM);

				Thread.sleep(25000);

				driver.findElement(By.xpath(".//*[@id='udyogAadharDiv']/div[2]/span[1]/input")).click();

				Thread.sleep(42000);

				String UdyogAadhaarVerificationAct = driver.findElement(By.xpath(".//*[@id='result']")).getText();

				String UdyogAadharr = exceptedreult;

				// System.out.println(UdyogAadharr.equals(UdyogAadhaarVerificationAct));

				Double resPercentage = LetterPairSimilarity.compareStrings(UdyogAadhaarVerificationAct, UdyogAadharr);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "percentage of actual and expected :: " + total);

				if (resPercentage > 0 && (resPercentage * 100) > 80) {

					System.out.println(" PASS    ");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Udyog Aadhaar Verification   resultexcepted is started" + UdyogAadharr);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Udyog Aadhaar Verification   resultactual is started" + UdyogAadhaarVerificationAct);
					// ExtentTestManager.getTest().log(LogStatus.INFO, "Udyog
					// Aadhaar Verification Result Comparison is
					// "+UdyogAadharr.equals(UdyogAadhaarVerificationAct));
					ExtentTestManager.getTest().log(LogStatus.PASS, "Udyog Aadhaar Verification   Result is Pass");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				} else {

					System.out.println("not matching");
					ExtentTestManager.getTest().log(LogStatus.FAIL, " Udyog Aadhaar Verification  Result is Fail");
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Udyog Aadhaar Verification   resultexcepted is started" + UdyogAadharr);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Udyog Aadhaar Verification   resultactual is started" + UdyogAadhaarVerificationAct);
					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				}

				// Assert.assertEquals(UdyogAadhaarVerificationAct,
				// UdyogAadharr);

			}

			else {
				ExtentTestManager.getTest().log(LogStatus.SKIP, "Udyog Aadhaar Verification is not showing ");
			}
		} catch (NoSuchElementException e) {

			ExtentTestManager.getTest().log(LogStatus.SKIP,
					"Udyog Aadhaar Verification is Showing blank  please Try Later ");
			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		driver.close();
		driver.switchTo().window(mainhandleandhra);

	}
}
