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

public class OfficersAppointmentList extends mainbase {

	@DataProvider(name = "DP4")
	public Object[][] createData4() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"OfficersAppointmentList", "OfficersAppointmentList");
		return (retObjArr);
	}

	@Test(priority = 90, dataProvider = "DP4")
	public void CompanyByNameVerification(String CompanyAppointmentId, String Entity, String Director, String empty,
			String exceptedreult, String actualresult, String testresult) throws InterruptedException {

		Thread.sleep(4000);

		ExtentTestManager.startTest("  International Verification : Officers Appointment List ");

		driver.findElement(By.xpath("//a[text()='Company House API']")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[text()='  Officers Appointment List']/input")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath(".//*[@id='companyHouseAppointmentCompanyId']")).sendKeys(CompanyAppointmentId);

		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='companyHouseOfficersAppointment']/table/tbody/tr[3]/td[2]/input"))
				.click();

		Thread.sleep(28000);

		String officersAppointmentlistexcepted = exceptedreult;

		String officersAppointmentlistactualresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(officersAppointmentlistactualresult,
				officersAppointmentlistexcepted);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Officers Appointment List No  excepted is started"
							+ officersAppointmentlistexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Officers Appointment List No actual is started"
							+ officersAppointmentlistactualresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "International
			// Verification : Company By Name Result Comparison is
			// "+comapnybynameactualresult.equals(companybynameexcepted));
			ExtentTestManager.getTest().log(LogStatus.PASS,
					"International Verification :  Officers Appointment List No Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(officersAppointmentlistactualresult, officersAppointmentlistexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Officers Appointment List No  excepted is started"
							+ officersAppointmentlistexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"International Verification :  Officers Appointment List No actual is started"
							+ officersAppointmentlistactualresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "International
			// Verification : Company By Name Result Comparison is
			// "+comapnybynameactualresult.equals(companybynameexcepted));
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"International Verification :  Officers Appointment List No Result is Fail");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(officersAppointmentlistactualresult, officersAppointmentlistexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

		// Assert.assertEquals(formdrivingdelhictualresult,
		// formdrivingdelhiexcepted);

	}
}
