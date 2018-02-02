package com.legel.Tax;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

public class DinCaptchaHandleing extends mainbase {

	@DataProvider(name = "DP52")
	public Object[][] createData52() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"DinCaptchaHandleing", "DinCaptchaHandleing");
		return (retObjArr);
	}

	@Test(priority = 82, dataProvider = "DP52")
	public void testDinCaptcha(String Dpinnumber, String enter, String empty, String emptysecond, String exceptedreult,
			String actualresult, String testresult) throws InterruptedException {

		ExtentTestManager.startTest(" DIN(Captcha Handling)  ");

		// Thread.sleep(4000);
		// driver.findElement(By.xpath("//div[2]/div/div")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()=' DIN(Captcha Handling)']/input[@value='dinCaptchaHandle']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='dinNumber']")).sendKeys(Dpinnumber);

		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='dinCaptchaHandle_Div']/table/tbody/tr[2]/td[2]/input")).click();

		Thread.sleep(28000);

		String dincaptchahandleexcepted = exceptedreult;

		String dinexceptactualresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(dinexceptactualresult, dincaptchahandleexcepted);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO,
					"DIN(Captcha Handling) excepted is started" + dincaptchahandleexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"DIN(Captcha Handling)  actual is started" + dinexceptactualresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, "DIN(Captcha Handling) Result Comparison  is "
					+ dinexceptactualresult.equals(dincaptchahandleexcepted));
			ExtentTestManager.getTest().log(LogStatus.PASS, "DIN(Captcha Handling) Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(dinexceptactualresult, dincaptchahandleexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"DIN(Captcha Handling) excepted is started" + dincaptchahandleexcepted);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"DIN(Captcha Handling) actual is started" + dinexceptactualresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, "DIN(Captcha Handling) Result Comparison  is "
					+ dinexceptactualresult.equals(dincaptchahandleexcepted));
			ExtentTestManager.getTest().log(LogStatus.FAIL, "DIN(Captcha Handling) Result is Fail");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(dinexceptactualresult, dincaptchahandleexcepted);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

	}

}
