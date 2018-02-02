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

public class FormDrivingLicenseMadayapradesh extends mainbase {

	@DataProvider(name = "DP55")
	public Object[][] createData55() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"formDrivingLicencemadyapadesh", "formDrivingLicencemadyapadesh");
		return (retObjArr);
	}

	@Test(priority = 5, dataProvider = "DP55")
	public void FORMDrivingLicenceINFOmadyapradesh(String IDType, String State, String Number, String Nature,
			String exceptedreult, String actualresult, String testresult) throws WriteException, BiffException,
					IOException, InterruptedException, HeadlessException, AWTException {

		ExtentTestManager.startTest(" FORM : Driving License - Madhya Pradesh ");
		Thread.sleep(6000);

		driver.findElement(By.xpath("//div[text()='  Driving License']/input")).click();

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

		driver.findElement(By.xpath(".//*[@id='voterId']")).sendKeys(Number);

		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();

		Thread.sleep(28000);

		String formdrivingmadyaexcepted = exceptedreult;

		String formdrivingmadyactualresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(formdrivingmadyactualresult,
				formdrivingmadyaexcepted);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Madhya Pradesh excepted is started" + formdrivingmadyaexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Madhya Pradesh actual is started" + formdrivingmadyactualresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Driving
			// License - Madhya Pradesh Result Comparison is
			// "+formdrivingmadyactualresult.equals(formdrivingmadyaexcepted));
			ExtentTestManager.getTest().log(LogStatus.PASS, "FORM : Driving License - Madhya Pradesh Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow
			// :"+ExtentTestManager.getTest().addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

			String sec = MissingJSON.difference(formdrivingmadyactualresult, formdrivingmadyaexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					" FORM : Driving License - Madhya Pradesh  Verification Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Madhya Pradesh excepted is started" + formdrivingmadyaexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Madhya Pradesh actual is started" + formdrivingmadyactualresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Madhya Pradesh Result Comparison  is "
							+ formdrivingmadyactualresult.equals(formdrivingmadyaexcepted));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));
			// ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow
			// :"+ExtentTestManager.getTest().addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

			String sec = MissingJSON.difference(formdrivingmadyactualresult, formdrivingmadyaexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

		// Assert.assertEquals(formdrivingmadyactualresult,
		// formdrivingmadyaexcepted);

	}

}
