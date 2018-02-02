package com.social.screening;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

public class VechileRegistration extends mainbase {

	@DataProvider(name = "1")
	public Object[][] createData1() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VechileRegistrationStatus", "VechileRegistrationStatus");
		return (retObjArr);
	}

	@Test(priority = 57, dataProvider = "1")
	public void VechileRegistration(String frist, String second, String empty, String emptysecond, String exceptedreult,
			String actualresult, String testresult) throws InterruptedException, IOException {

		ExtentTestManager.startTest(" Vehicle Registration Status  ");

		/*
		 * Thread.sleep(4000);
		 * 
		 * driver.findElement(By.xpath("//a[text()='Social/Screening/Others']"))
		 * .click();
		 */

		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[text()='Others']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='  Vehicle Registration Status']/input")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath(".//*[@id='reNo']")).sendKeys(frist);

		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='reNo1']")).sendKeys(second);

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='vahanSearch_div']/table/tbody/tr/td[3]/input")).click();

		Thread.sleep(49000);

		String exceptedresultvechile = exceptedreult;

		String VechileRegact = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// System.out.println(VechileRegact.equals(exceptedresultvechile));

		Double resPercentage = LetterPairSimilarity.compareStrings(VechileRegact, exceptedresultvechile);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.PASS, " VechileRegistrationStatus   Result is Pass");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" VechileRegistrationStatus  excepted is started" + exceptedresultvechile);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" VechileRegistrationStatus actual is started" + VechileRegact);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" VechileRegistrationStatus Result Comparison  is " + VechileRegact.equals(exceptedresultvechile));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(VechileRegact, exceptedresultvechile);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

		else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, " VechileRegistrationStatus  Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO,
					" VechileRegistrationStatus File  excepted is started" + exceptedresultvechile);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" VechileRegistrationStatus actual is started" + VechileRegact);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" VechileRegistrationStatus  Result Comparison  is " + VechileRegact.equals(exceptedresultvechile));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(VechileRegact, exceptedresultvechile);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

	}

}
