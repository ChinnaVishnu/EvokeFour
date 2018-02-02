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
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class CINVerification2 extends mainbase {

	@DataProvider(name = "DP7")
	public Object[][] createData7() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "CINVerification",
				"CINVerification");
		return (retObjArr);
	}

	@Test(priority = 1, dataProvider = "DP7")
	public void CINVerification(String Company, String Service, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult) throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" CIN Verification ");

		Thread.sleep(7000);

		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();
		// driver.findElement(By.xpath("//td[text()='CIN Verification
		// ']/input")).click();

		Thread.sleep(7000);

		driver.findElement(By.xpath("//div[text()='  CIN Verification']/input[@value='cin']")).click();

		Thread.sleep(19000);

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

		try {
			if (driver.findElement(By.xpath(".//*[@id='cin']")).isDisplayed()) {
				// driver.findElement(By.xpath(".//*[@id='cin']")).sendKeys(Company);

				driver.findElement(By.xpath(".//*[@id='cin']")).sendKeys(Company);

				Thread.sleep(25000);

				driver.findElement(By.xpath(".//*[@id='cinDiv']/div/span[1]/input")).click();

				// Thread.sleep(60000);

				try {
					driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
					try {

						Thread.sleep(50000);
						String CINVactualresult = driver.findElement(By.xpath(".//*[@id='result']")).getText();

						/*
						 * System.out.println("indx 1 :"
						 * +CINVactualresult.indexOf(
						 * "Address other than R/o where all or any books of account and papers are maintained"
						 * )); System.out.println(
						 * "**************************    "+CINVactualresult);
						 * 
						 * 
						 * int starIndx =CINVactualresult.indexOf(
						 * "Address other than R/o where all or any books of account and papers are maintained"
						 * );
						 * 
						 * System.out.println("hi "+starIndx);
						 * 
						 * 
						 * CINVactualresult=
						 * CINVactualresult.replace(CINVactualresult.substring(
						 * starIndx,starIndx+97), "");
						 * 
						 * 
						 * 
						 * System.out.println("@@@@@@@@@@    "
						 * +CINVactualresult);
						 */

						String CINVresult = exceptedreult;

						// System.out.println(CINVresult.equals(CINVactualresult));

						// Assert.assertEquals(CINVactualresult, CINVresult);

						Double resPercentage = LetterPairSimilarity.compareStrings(CINVactualresult, CINVresult);

						System.out.println("resPercentage " + resPercentage * 100);
						String total = Double.toString(resPercentage * 100);

						ExtentTestManager.getTest().log(LogStatus.INFO,
								"percentage of actual and expected :: " + total);

						if (resPercentage > 0 && (resPercentage * 100) > 80) {

							System.out.println(" PASS    ");

							ExtentTestManager.getTest().log(LogStatus.INFO,
									"CIN Verification   result excepted is started" + CINVresult);
							ExtentTestManager.getTest().log(LogStatus.INFO,
									"CIN Verification   Result actual is started" + CINVactualresult);
							// ExtentTestManager.getTest().log(LogStatus.INFO,
							// "CIN Verification Result Comparison is
							// "+CINVresult.contains(CINVactualresult));
							ExtentTestManager.getTest().log(LogStatus.PASS, "CIN Verification   Result is Pass");

							String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

							ExtentTestManager.getTest().log(LogStatus.PASS, "Screen short below :"
									+ ExtentTestManager.getTest().addScreenCapture(screenshortpath));
							String sec = MissingJSON.difference(CINVactualresult, CINVresult);

							System.out.println(sec);

							ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

						} else {

							System.out.println("not matching");
							// test.log(LogStatus.WARNING, "CINVerification
							// result ");

							ExtentTestManager.getTest().log(LogStatus.FAIL, "CIN Verification  result ");
							ExtentTestManager.getTest().log(LogStatus.INFO,
									"CIN Verification  excepted result   " + CINVresult);
							ExtentTestManager.getTest().log(LogStatus.INFO,
									"CIN Verification  Actual result  " + CINVactualresult);
							ExtentTestManager.getTest().log(LogStatus.INFO,
									"CIN Verification  comparison result  " + CINVresult.contains(CINVactualresult));
							// test.log(LogStatus.FATAL, "CINVerification
							// Missing space ");

							String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

							ExtentTestManager.getTest().log(LogStatus.PASS, "Screen short below :"
									+ ExtentTestManager.getTest().addScreenCapture(screenshortpath));
							String sec = MissingJSON.difference(CINVactualresult, CINVresult);

							System.out.println(sec);

							ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

						}
					} catch (Exception e) {
						ExtentTestManager.getTest().log(LogStatus.ERROR, "CIN Verification  Request on site timed out");
						String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					}

				} catch (Exception e) {
					System.out.println("no page");
					System.out.println(e);
				}

			}
		}

		catch (NoSuchElementException e) {

			ExtentTestManager.getTest().log(LogStatus.SKIP,
					"CINVerification Source site is window is not showing  please Try agin ");
			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		driver.close();
		driver.switchTo().window(mainhandleandhra);
		// Assert.assertTrue(CINVresult.contains(CINVactualresult));

	}
}
