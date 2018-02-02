package com.drivinglinces.indival;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
import jxl.write.WriteException;

public class FormDrivingLicenseKerala extends mainbase {

	@DataProvider(name = "DP56")
	public Object[][] createData56() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"formDrivingLicencekerala", "formDrivingLicencekerala");
		return (retObjArr);
	}

	@Test(priority = 4, dataProvider = "DP56")
	public void FORMDrivingLicenceINFOkerala(String IDType, String State, String DOB, String Number,
			String exceptedreult, String actualresult, String testresult) throws WriteException, BiffException,
					IOException, InterruptedException, HeadlessException, AWTException {

		ExtentTestManager.startTest(" FORM : Driving License - Kerala ");
		Thread.sleep(6000);

		driver.findElement(By.xpath("//div[text()='  Driving License']/input")).click();
		Thread.sleep(5000);

		/*
		 * WebElement
		 * elementpan=driver.findElement(By.xpath(".//*[@id='idType']")); Select
		 * selectdriv=new Select(elementpan);
		 * 
		 * selectdriv.selectByVisibleText(IDType);
		 */

		WebElement elementdriveinglince = driver.findElement(By.xpath(".//*[@id='dlstate']"));
		Select selectdriving = new Select(elementdriveinglince);

		selectdriving.selectByVisibleText(State);

		Thread.sleep(4000);

		String srt = DOB;

		System.out.println(srt);

		driver.findElement(By.xpath(".//*[@id='dob']")).sendKeys(DOB);

		driver.findElement(By.xpath(".//*[@id='voterId']")).sendKeys(Number);

		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();

		Thread.sleep(59000);

		String formdrivingkeralaaexcepted = exceptedreult;

		String formdrivingkeralaactualresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(formdrivingkeralaactualresult,
				formdrivingkeralaaexcepted);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Kerala excepted is started" + formdrivingkeralaaexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Kerala actual is started" + formdrivingkeralaactualresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Driving
			// License - Kerala Result Comparison is
			// "+formdrivingkeralaactualresult.equals(formdrivingkeralaaexcepted));
			ExtentTestManager.getTest().log(LogStatus.PASS, "FORM : Driving License - Kerala Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));
			String sec = MissingJSON.difference(formdrivingkeralaactualresult, formdrivingkeralaaexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
					.addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, " FORM : Driving License - Kerala Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Kerala excepted is started" + formdrivingkeralaaexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Kerala actual is started" + formdrivingkeralaactualresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Driving License - Kerala Result Comparison  is "
					+ formdrivingkeralaactualresult.equals(formdrivingkeralaaexcepted));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(formdrivingkeralaactualresult, formdrivingkeralaaexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
					.addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

		}

		// Assert.assertEquals(formdrivingkeralaactualresult,
		// formdrivingkeralaaexcepted);

	}

}
