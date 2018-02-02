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

public class FormPaninfo extends mainbase {

	@DataProvider(name = "DP53")
	public Object[][] createData53() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"FormPanInformation", "FormPanInformation");
		return (retObjArr);
	}

	@Test(priority = 2, dataProvider = "DP53")
	public void FORMPANINFO(String IDType, String Idnumber, String empty, String Nature, String exceptedreult,
			String actualresult, String testresult) throws WriteException, BiffException, IOException,
					InterruptedException, HeadlessException, AWTException {

		ExtentTestManager.startTest(" FORM : PAN-Info ");

		Thread.sleep(9000);

		driver.findElement(By.xpath("//div[text()='  PAN']/input[@value='panInfo']")).click();

		Thread.sleep(9000);

		/*
		 * WebElement
		 * elementpan=driver.findElement(By.xpath(".//*[@id='idType']")); Select
		 * select=new Select(elementpan);
		 * 
		 * select.selectByVisibleText(IDType);
		 * 
		 * Thread.sleep(3000);
		 */

		driver.findElement(By.xpath(".//*[@id='voterId']")).sendKeys(Idnumber);

		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();

		Thread.sleep(27000);

		String formpaninfoexcepted = exceptedreult;

		String formpaninfoactualresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(formpaninfoactualresult, formpaninfoexcepted);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : PAN-Info excepted is started" + formpaninfoexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : PAN-Info actual is started" + formpaninfoactualresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : PAN-Info
			// Result Comparison is
			// "+formpaninfoactualresult.equals(formpaninfoexcepted));
			ExtentTestManager.getTest().log(LogStatus.PASS, "FORM : PAN-Info Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
					.addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

			String sec = MissingJSON.difference(formpaninfoactualresult, formpaninfoexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "FORM : PAN-Info Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : PAN-Info excepted is started" + formpaninfoexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : PAN-Info actual is started" + formpaninfoactualresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : PAN-Info Result Comparison  is " + formpaninfoactualresult.equals(formpaninfoexcepted));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
					.addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

			String sec = MissingJSON.difference(formpaninfoactualresult, formpaninfoexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

		// Assert.assertEquals(formpaninfoactualresult, formpaninfoexcepted);

	}

}
