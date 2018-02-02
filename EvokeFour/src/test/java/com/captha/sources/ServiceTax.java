package com.captha.sources;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class ServiceTax extends mainbase {

	// ....................................................... ServiceTax .........................................................................//

	@DataProvider(name = "DP50")
	public Object[][] createData50() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "ServiceTax",
				"ServiceTax");
		return (retObjArr);
	}

	@Test(priority = 22, dataProvider = "DP50")
	public void EpFWithoutLogin(String Service, String RequestID, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("  ServiceTax ");

		try {
			Thread.sleep(6000);

			driver.findElement(By.xpath("//a[text()='Tax']")).click();

			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[text()='  Service Tax']/input")).click();

			Thread.sleep(2000);

			driver.findElement(By.xpath(".//*[@id='ServiceTaxNumber']")).sendKeys(Service);

			Thread.sleep(2000);

			driver.findElement(By.xpath(".//*[@id='RequestId']")).sendKeys(RequestID);

			Thread.sleep(9000);
			driver.findElement(By.xpath(".//*[@id='ProccedButton']")).click();

			Thread.sleep(12000);
			driver.findElement(By.xpath("//div[6]/button")).click();

			Thread.sleep(29000);

			String EpfLoginresult = exceptedreult;

			String EpfLoginresultact = driver.findElement(By.xpath("//pre[@id='ResponseResult']")).getText();

			System.out.println(EpfLoginresultact.equals(EpfLoginresult));

			Double resPercentage = LetterPairSimilarity.compareStrings(EpfLoginresultact, EpfLoginresult);

			System.out.println("resPercentage " + resPercentage * 100);
			String total = Double.toString(resPercentage * 100);

			ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

			if (resPercentage > 0 && (resPercentage * 100) > 80) {

				System.out.println("pass");
				ExtentTestManager.getTest().log(LogStatus.INFO,
						" ServiceTax Result excepted is started" + EpfLoginresult);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						" ServiceTax Result actual is started" + EpfLoginresultact);
				// ExtentTestManager.getTest().log(LogStatus.INFO, " EPF Without
				// Login Result Comparison is
				// "+EpfLoginresultact.equals(EpfLoginresult));
				ExtentTestManager.getTest().log(LogStatus.PASS, " ServiceTax Result is Pass");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			} else {

				System.out.println("not matching");
				ExtentTestManager.getTest().log(LogStatus.FAIL, " ServiceTax  Result  is Fail");

				ExtentTestManager.getTest().log(LogStatus.INFO,
						" ServiceTax Result excepted is started" + EpfLoginresult);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						" ServiceTax Result actual is started" + EpfLoginresultact);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						" ServiceTax Result Comparison  is " + EpfLoginresultact.equals(EpfLoginresult));
				ExtentTestManager.getTest().log(LogStatus.FAIL, " ServiceTax Result is FAIL");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.FAIL,
						"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

			driver.findElement(By.xpath("//button[@class='close']")).click();

			// Assert.assertEquals(EpfLoginresultact, EpfLoginresult);

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					" ServiceTax   Captcha not Showing ");
			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

	}

}
