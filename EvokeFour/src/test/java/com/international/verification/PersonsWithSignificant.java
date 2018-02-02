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

public class PersonsWithSignificant extends mainbase {

	@DataProvider(name = "DP4")
	public Object[][] createData4() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"PersonsWithSignificant", "PersonsWithSignificant");
		return (retObjArr);
	}

	@Test(priority = 91, dataProvider = "DP4")
	public void RegisteredofficeAddressVerification(String CompanypersonswithId, String Email, String Director,
			String empty, String exceptedreult, String actualresult, String testresult) throws InterruptedException {

		Thread.sleep(4000);
		ExtentTestManager.startTest("  International Verification :  Persons With Significant ");

		driver.findElement(By.xpath("//a[text()='Company House API']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='  Persons With Significant']/input[@value='companyHouseSignificant']")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath(".//*[@id='companyHouseSignificantCompanyId']")).sendKeys(CompanypersonswithId);

		driver.findElement(By.xpath(".//*[@id='companyHouseSignificantList']")).sendKeys(Email);

		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='companyHouseSignificant']/table/tbody/tr[3]/td[3]/input")).click();

		Thread.sleep(28000);

		String personswithexcepted = exceptedreult;

		String personswithsigactualresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(personswithsigactualresult, personswithexcepted);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  PersonsWithSignificant excepted is started" + personswithexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  PersonsWithSignificant actual is started"
							+ personswithsigactualresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "International
			// Verification : Company By Name Result Comparison is
			// "+comapnybynameactualresult.equals(companybynameexcepted));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"International Verification :  PersonsWithSignificant Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(personswithsigactualresult, personswithexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  PersonsWithSignificant excepted is started" + personswithexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  PersonsWithSignificant actual is started"
							+ personswithsigactualresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  PersonsWithSignificant Result Comparison  is "
							+ personswithsigactualresult.equals(personswithexcepted));
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"International Verification :  PersonsWithSignificant Result is FAIL");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(personswithsigactualresult, personswithexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

		// Assert.assertEquals(formdrivingdelhictualresult,
		// formdrivingdelhiexcepted);

	}
}
