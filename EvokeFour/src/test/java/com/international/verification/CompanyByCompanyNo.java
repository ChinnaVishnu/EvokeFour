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

public class CompanyByCompanyNo extends mainbase {

	@DataProvider(name = "DP4")
	public Object[][] createData4() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"CompanyByCompanyNo", "CompanyByCompanyNo");
		return (retObjArr);
	}

	@Test(priority = 86, dataProvider = "DP4")
	public void CompanyByNameVerification(String CompanyId, String Entity, String Director, String empty,
			String exceptedreult, String actualresult, String testresult) throws InterruptedException {

		Thread.sleep(4000);

		ExtentTestManager.startTest("  International Verification : Company By Company No ");

		driver.findElement(By.xpath("//a[text()='Company House API']")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[text()='  Company By Company No']/input[@value='companyHouseById']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='companyHouseCompanyId']")).sendKeys(CompanyId);

		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='companyHouseById']/table/tbody/tr[3]/td/input")).click();

		Thread.sleep(28000);

		String companybycompanynoexcepted = exceptedreult;

		String companybycompanynoactualresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(companybycompanynoactualresult,
				companybycompanynoexcepted);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Company By Company No  excepted is started"
							+ companybycompanynoexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Company By Company No actual is started"
							+ companybycompanynoactualresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "International
			// Verification : Company By Name Result Comparison is
			// "+comapnybynameactualresult.equals(companybynameexcepted));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"International Verification :  Company By Company No Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(companybycompanynoactualresult, companybycompanynoexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Company By Company No  excepted is started"
							+ companybycompanynoexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Company By Company No actual is started"
							+ companybycompanynoactualresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "International
			// Verification : Company By Name Result Comparison is
			// "+comapnybynameactualresult.equals(companybynameexcepted));
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"International Verification :  Company By Company No Result is Fail");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(companybycompanynoactualresult, companybycompanynoexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

		// Assert.assertEquals(formdrivingdelhictualresult,
		// formdrivingdelhiexcepted);

	}

}