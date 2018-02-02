package com.banks;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class EPFdetailsWithLogin extends mainbase {

	@DataProvider(name = "DP9")
	public Object[][] createData9() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"EPFDetailsWithlogin", "EPFDetailsWithlogin");
		return (retObjArr);
	}

	@Test(priority = 20, dataProvider = "DP9")
	public void OtherverificationApi(String UAN, String Password, String Number, String empty, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" EPF Details (With login) ");

		Thread.sleep(7000);

		// driver.findElement(By.xpath("//div[2]/div/div[3]/div")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[text()='Financial']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[text()='  EPF Details']/input")).click();

		Thread.sleep(3000);
		String mainhandle = driver.getWindowHandle();

		String childhandle = "";

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {

			if (!handle.equals(mainhandle)) {

				childhandle = handle;

			}

		}

		driver.switchTo().window(childhandle);

		try {

			driver.findElement(By.xpath(".//*[@id='uan']")).sendKeys(UAN);

			driver.findElement(By.xpath(".//*[@id='epfpass']")).sendKeys(Password);

			Thread.sleep(15000);
			driver.findElement(By.xpath(".//*[@id='button']")).click();

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.SKIP, "EPF Details (With login) Showing blank ");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		try {
			driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			try {

				Thread.sleep(40000);
				// driver.manage().timeouts().implicitlyWait(2,
				// TimeUnit.MINUTES);

				String Otherverification = exceptedreult;
				String Otherverificationresult = driver.findElement(By.xpath(".//*[@id='result_data']")).getText();

				Double resPercentage = LetterPairSimilarity.compareStrings(Otherverificationresult, Otherverification);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

				if (resPercentage > 0 && (resPercentage * 100) > 80) {

					System.out.println("pass");
					ExtentTestManager.getTest().log(LogStatus.PASS, " EPF Details (With login) Result is Pass");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							" EPF Details (With login) Expected:" + Otherverification);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" EPF Details (With login)  Actual:" + Otherverificationresult);
					ExtentTestManager.getTest().log(LogStatus.PASS, " EPF Details (With login) Result is Pass");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					MissingJSON m = new MissingJSON();
					String sec = m.difference(Otherverificationresult, Otherverification);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				} else {

					System.out.println("not matching");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "EPF Details (With login)  Result is Fail");
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" EPF Details (With login) Expected:" + Otherverification);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" EPF Details (With login) Actual:" + Otherverificationresult);
					// test.log(LogStatus.INFO, " Other Verification Result
					// Comparison is
					// "+Otherverificationresult.equals(Otherverification));
					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.FAIL,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					MissingJSON m = new MissingJSON();
					String sec = m.difference(Otherverificationresult, Otherverification);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				}

			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.ERROR, "EPF Details (With login)  Request on site timed out");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.FAIL,
						"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (Exception e) {
			System.out.println("no page");
			System.out.println(e);
		}

		driver.close();
		driver.switchTo().window(mainhandle);
		// Assert.assertEquals(Otherverificationresult, Otherverification);

	}

}
