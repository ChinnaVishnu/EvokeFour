package com.membershipverification;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

public class MembershipCostAccountant extends mainbase {

	@DataProvider(name = "DP7")
	public Object[][] createData7() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"MembershipVerificationCostAccountant", "MembershipVerificationCostAccountant");
		return (retObjArr);
	}

	@Test(priority = 93, dataProvider = "DP7")
	public void FormCstKaranataka(String MemberSearch, String State, String Number, String empty, String exceptedreult,
			String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest("MembershipVerification :CostAccountant");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[2]/div/div")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Professionals Verification']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()=' Cost Accountant']/input")).click();
		Thread.sleep(3000);

		/*
		 * driver.findElement(By.xpath("//div[@id='memberDetails']/div/input")).
		 * click(); Thread.sleep(3000);
		 */

		driver.findElement(By.xpath(".//*[@id='costAccMemberNo']")).sendKeys(MemberSearch);

		driver.findElement(By.xpath(".//*[@id='cost_accountant_div']/table/tbody/tr[2]/td/input")).click();

		Thread.sleep(18000);

		// waitForAjax(5);

		String MembershipVerificationcostAccount = exceptedreult;

		String MembershipVerificationcostAccountAresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(MembershipVerificationcostAccount,
				MembershipVerificationcostAccountAresult);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {
			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"MembershipVerification : CostAccountant Expected:" + MembershipVerificationcostAccount);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"MembershipVerification : CostAccountant  Actual:" + MembershipVerificationcostAccountAresult);
			ExtentTestManager.getTest().log(LogStatus.PASS, "MembershipVerification : CostAccountant  Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(MembershipVerificationcostAccountAresult,
					MembershipVerificationcostAccount);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "MembershipVerification : CostAccountant Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"MembershipVerification : CostAccountant Expected:" + MembershipVerificationcostAccount);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"MembershipVerification : CostAccountant  Actual:" + MembershipVerificationcostAccountAresult);

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(MembershipVerificationcostAccountAresult,
					MembershipVerificationcostAccount);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}
	}

}
