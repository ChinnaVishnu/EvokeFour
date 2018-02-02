package com.captha.sources;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

public class SignatoryDetails extends mainbase {

	@DataProvider(name = "DP6")
	public Object[][] createData6() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"SignatoryDetails", "SignatoryDetails");
		return (retObjArr);
	}

	@Test(priority = 3, dataProvider = "DP6")
	public void SignatoryDetails(String Company, String Service, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult) throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Signatory Details ");
		Thread.sleep(9000);

		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();

		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[text()='  Signatory Details']/input[@value='cin']")).click();

		Thread.sleep(20000);

		String mainhandleandhra = driver.getWindowHandle();

		String childhandleAndhra = "";

		Set<String> handlesandhra = driver.getWindowHandles();

		for (String handle : handlesandhra) {

			if (!handle.equals(mainhandleandhra)) {

				childhandleAndhra = handle;

			}

		}

		driver.switchTo().window(childhandleAndhra);

		driver.manage().window().maximize();

		driver.findElement(By.xpath(".//*[@id='cin']")).sendKeys(Company);

		Thread.sleep(15000);

		driver.findElement(By.xpath(".//*[@id='cinDiv']/div/span[1]/input")).click();

		try {
			driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			try {

				Thread.sleep(45000);

				String signatureactualresult = driver.findElement(By.xpath(".//*[@id='result']")).getText();

				String signatureresult = exceptedreult;

				// Assert.assertEquals(signatureactualresult, signatureresult);

				// System.out.println(signatureresult.equals(signatureactualresult));

				Double resPercentage = LetterPairSimilarity.compareStrings(signatureactualresult, signatureresult);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "percentage of actual and expected :: " + total);

				if (resPercentage > 0 && (resPercentage * 100) > 80) {

					System.out.println(" PASS    ");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Signatory Details   resultexcepted is started" + signatureresult);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Signatory Details   resultactual is started" + signatureactualresult);
					// ExtentTestManager.getTest().log(LogStatus.INFO,
					// "Signatory Details resultcomparison is
					// "+signatureresult.equals(signatureactualresult));
					ExtentTestManager.getTest().log(LogStatus.PASS, "Signatory Details    Result is Pass");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				} else {

					System.out.println("not matching");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Signatory Details  Result is Fail");
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Signatory Details   resultexcepted is started" + signatureresult);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Signatory Details   resultactual is started" + signatureactualresult);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Signatory Details   resultcomparison is " + signatureresult.equals(signatureactualresult));

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				}

			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.ERROR, "Signatory Details  Request on site timed out");
				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (Exception e) {
			System.out.println("no page");
			System.out.println(e);
		}

		driver.close();
		driver.switchTo().window(mainhandleandhra);

	}
}
