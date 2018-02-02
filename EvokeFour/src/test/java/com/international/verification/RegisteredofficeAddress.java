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

public class RegisteredofficeAddress extends mainbase {

	@DataProvider(name = "DP4")
	public Object[][] createData4() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"RegisteredofficeAddress", "RegisteredofficeAddress");
		return (retObjArr);
	}

	@Test(priority = 88, dataProvider = "DP4")
	public void RegisteredofficeAddressVerification(String CompanyRegistredId, String Entity, String Director,
			String empty, String exceptedreult, String actualresult, String testresult) throws InterruptedException {

		Thread.sleep(4000);
		ExtentTestManager.startTest("  International Verification : Registered Office Address ");

		driver.findElement(By.xpath("//a[text()='Company House API']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='  Registered Office Address']/input")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='companyHouseRegAddrId']")).sendKeys(CompanyRegistredId);
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='companyHouseRegAddr']/table/tbody/tr[3]/td/input")).click();

		Thread.sleep(28000);

		String RegisteredofficeAddressexcepted = exceptedreult;

		String RegisteredofficeAddressactualresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(RegisteredofficeAddressactualresult,
				RegisteredofficeAddressexcepted);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  RegisteredofficeAddress excepted is started"
							+ RegisteredofficeAddressexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  RegisteredofficeAddress actual is started"
							+ RegisteredofficeAddressactualresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "International
			// Verification : Company By Name Result Comparison is
			// "+comapnybynameactualresult.equals(companybynameexcepted));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"International Verification :  RegisteredofficeAddress Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(RegisteredofficeAddressactualresult, RegisteredofficeAddressexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  RegisteredofficeAddress excepted is started"
							+ RegisteredofficeAddressexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  RegisteredofficeAddress actual is started"
							+ RegisteredofficeAddressactualresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  RegisteredofficeAddress Result Comparison  is "
							+ RegisteredofficeAddressactualresult.equals(RegisteredofficeAddressexcepted));
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"International Verification :  RegisteredofficeAddress Result is FAIL");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(RegisteredofficeAddressactualresult, RegisteredofficeAddressexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

		// Assert.assertEquals(formdrivingdelhictualresult,
		// formdrivingdelhiexcepted);

	}

}
