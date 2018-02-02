package com.international.verification;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

public class CompanyByName extends mainbase {

	@DataProvider(name = "DP4")
	public Object[][] createData4() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "CompanyByName",
				"CompanyByName");
		return (retObjArr);
	}

	@Test(priority = 85, dataProvider = "DP4")
	public void CompanyByNameVerification(String CompanyName, String Entity, String Director, String empty,
			String exceptedreult, String actualresult, String testresult) throws InterruptedException {

		Thread.sleep(5000);

		ExtentTestManager.startTest("  International Verification : Company By Name ");

		driver.findElement(By.xpath("//div[6]/div")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='  Company By Name']/input")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath(".//*[@id='companyHouseName']")).sendKeys(CompanyName);

		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='companyHouseByName']/table/tbody/tr[3]/td[2]/input")).click();

		Thread.sleep(28000);

		String companybynameexcepted = exceptedreult;

		String comapnybynameactualresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(comapnybynameactualresult, companybynameexcepted);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Company By Name excepted is started" + companybynameexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Company By Name actual is started" + comapnybynameactualresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "International
			// Verification : Company By Name Result Comparison is
			// "+comapnybynameactualresult.equals(companybynameexcepted));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"International Verification :  Company By Name Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(comapnybynameactualresult, companybynameexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Company By Name excepted is started" + companybynameexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Company By Name actual is started" + comapnybynameactualresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Company By Name Result Comparison  is "
							+ comapnybynameactualresult.equals(companybynameexcepted));
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"International Verification :  Company By Name Result is FAIL");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(comapnybynameactualresult, companybynameexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

		// Assert.assertEquals(formdrivingdelhictualresult,
		// formdrivingdelhiexcepted);

	}

}
