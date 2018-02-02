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

public class FormDrivingLicenseDelhi extends mainbase {

	@DataProvider(name = "DP57")
	public Object[][] createData57() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"FormDrivingLicenceDelhi", "FormDrivingLicenceDelhi");
		return (retObjArr);
	}

	@Test(priority = 3, dataProvider = "DP57")
	public void FORMDrivingLicenceINFODelhi(String IDType, String State, String Number, String Nature,
			String exceptedreult, String actualresult, String testresult) throws WriteException, BiffException,
					IOException, InterruptedException, HeadlessException, AWTException {

		ExtentTestManager.startTest(" FORM : Driving License - Delhi ");

		Thread.sleep(6000);

		driver.findElement(By.xpath("//div[text()='  Driving License']/input")).click();

		// driver.findElement(By.xpath(".//*[@id='SOURCESTABLE']/tbody/tr[4]/td[1]/input")).click();

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

		// driver.findElement(By.xpath(".//*[@id='json']/div[12]/table/tbody/tr/td[2]/div/input")).click();

		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();

		Thread.sleep(28000);

		String formdrivingdelhiexcepted = exceptedreult;

		String formdrivingdelhictualresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(formdrivingdelhictualresult,
				formdrivingdelhiexcepted);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Delhi excepted is started" + formdrivingdelhiexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Delhi actual is started" + formdrivingdelhictualresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Driving
			// License - Delhi Result Comparison is
			// "+formdrivingdelhictualresult.equals(formdrivingdelhiexcepted));
			ExtentTestManager.getTest().log(LogStatus.PASS, "FORM : Driving License - Delhi Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow
			// :"+ExtentTestManager.getTest().addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

			String sec = MissingJSON.difference(formdrivingdelhictualresult, formdrivingdelhiexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "FORM : Driving License - Delhi  Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Delhi excepted is started" + formdrivingdelhiexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Driving License - Delhi actual is started" + formdrivingdelhictualresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Driving License - Delhi Result Comparison  is "
					+ formdrivingdelhictualresult.equals(formdrivingdelhiexcepted));
			String sec = MissingJSON.difference(formdrivingdelhictualresult, formdrivingdelhiexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
					.addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);
		}

		// Assert.assertEquals(formdrivingdelhictualresult,
		// formdrivingdelhiexcepted);

	}
}
