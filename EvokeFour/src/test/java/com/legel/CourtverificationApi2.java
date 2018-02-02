package com.legel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Courtverifiactionpage;
import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class CourtverificationApi2 extends mainbase {

	@DataProvider(name = "DP49")
	public Object[][] createData49() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"CourtVerificationAddDetails", "CourtVerificationAddDetails");
		return (retObjArr);
	}

	@Test(priority = 52, dataProvider = "DP49")
	public void Courtverification(String Enter, String Email, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Court verification :ADD Details  ");

		/*
		 * Courtverifiactionpage vo=new Courtverifiactionpage(driver);
		 * 
		 * vo.clickcourtvrification(Enter,exceptedreult);
		 */

		/*
		 * Thread.sleep(6000);
		 * 
		 * driver.findElement(By.xpath(".//*[@id='panel-1']/div[2]/div[1]")).
		 * click();
		 */

		Thread.sleep(6000);

		driver.findElement(By.xpath("//a[text()='Legal']")).click();

		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  Court Verification']/input")).click();

		Thread.sleep(6000);

		driver.findElement(By.xpath(".//*[@id='courtverification']/table[1]/tbody/tr/td[1]/input")).click();

		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='c_name']")).sendKeys(Enter);

		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='c_address']")).sendKeys(Email);

		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='add_court_div']/table/tbody/tr[4]/td[2]/input")).click();

		Thread.sleep(50000);
		// waitForAjax(5);

		String courtverresult = exceptedreult;

		String courtverresultact = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		// Assert.assertEquals(courtverresultact, courtverresult);
		// System.out.println(courtverresultact.equals(courtverresult));

		Double resPercentage = LetterPairSimilarity.compareStrings(courtverresultact, courtverresult);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {
			System.out.println("pass");

			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, " Court Verification excepted is started" + courtverresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Court Verification actual is started" + courtverresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Court Verification Result Comparison  is " + courtverresultact.equals(courtverresult));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Court Verification    Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(courtverresultact, courtverresult);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.INFO, " Court Verification excepted is started" + courtverresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Court Verification actual is started" + courtverresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Court Verification Result Comparison  is " + courtverresultact.equals(courtverresult));
			ExtentTestManager.getTest().log(LogStatus.FAIL, " Court Verification    Result is Fail");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(courtverresultact, courtverresult);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

	}

}
