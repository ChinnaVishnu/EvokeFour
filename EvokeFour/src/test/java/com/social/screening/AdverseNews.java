package com.social.screening;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

public class AdverseNews extends mainbase {

	@DataProvider(name = "DP4")
	public Object[][] createData4() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "AdverseNews",
				"AdverseNews");
		return (retObjArr);
	}

	@Test(priority = 54, dataProvider = "DP4")
	public void adveseSecond(String Adverse, String Entity, String Director, String empty, String exceptedreult,
			String actualresult, String testresult) throws InterruptedException {

		ExtentTestManager.startTest("  Adverse News ");

		Thread.sleep(12000);

		driver.findElement(By.xpath("//div[5]/div")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Screening']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='  Adverse News']/input")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath(".//*[@id='searchId']")).sendKeys(Adverse);

		driver.findElement(By.xpath(".//*[@id='searchView']/table/tbody/tr/td[3]/input")).click();

		Thread.sleep(22000);

		String AdverseNewsactual = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		String AdverseNewexcepted = exceptedreult;

		// driver.navigate().refresh();

		// Assert.assertEquals(AdverseNewsactual, AdverseNewexcepted);
		Double resPercentage = LetterPairSimilarity.compareStrings(AdverseNewsactual, AdverseNewexcepted);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO, "Adverse News excepted is started" + AdverseNewexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Adverse News actual is started" + AdverseNewsactual);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "Adverse News
			// Result Comparison is
			// "+AdverseNewsactual.equals(AdverseNewexcepted));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Adverse News Result is Pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
					.addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));

			String sec = MissingJSON.difference(AdverseNewsactual, AdverseNewexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			// test.log(LogStatus.FAIL, "CIBIL Suit Filed Cases result is
			// fail");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Adverse News   Result is FAIL");

			ExtentTestManager.getTest().log(LogStatus.INFO, "Adverse News excepted is started" + AdverseNewexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Adverse News actual is started" + AdverseNewsactual);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Adverse News Result Comparison  is  " + AdverseNewsactual.equals(AdverseNewexcepted));

			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
					.addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));

			String sec = MissingJSON.difference(AdverseNewsactual, AdverseNewexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

	}
}
