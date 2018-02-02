package com.captha.sources;

import java.io.IOException;
import java.util.Set;

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

public class DINVerification extends mainbase {

	@DataProvider(name = "DP8")
	public Object[][] createData8() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "DINVerification",
				"DINVerification");
		return (retObjArr);
	}

	@Test(priority = 2, dataProvider = "DP8")
	public void DINVerification(String Username, String Password, String DPIN, String Nature, String exceptedreult,
			String actualresult, String testresult) throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" DIN Verification  ");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[text()='  DIN Verification']/input")).click();

		Thread.sleep(17000);

		String mainhandleandhra = driver.getWindowHandle();

		String childhandleAndhra = "";

		Set<String> handlesandhra = driver.getWindowHandles();

		for (String handle : handlesandhra) {

			if (!handle.equals(mainhandleandhra)) {

				childhandleAndhra = handle;

			}

		}

		driver.switchTo().window(childhandleAndhra);

		driver.manage().window().maximize();

		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(Username);

		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(Password);

		driver.findElement(By.xpath(".//*[@id='din']")).sendKeys(DPIN);

		Thread.sleep(20000);

		driver.findElement(By.xpath(".//*[@id='submit']")).click();

		Thread.sleep(40000);

		try {
			String dinactualresult = driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

			/*
			 * System.out.println("**************************    "
			 * +dinactualresult);
			 * 
			 * System.out.println("indx 1 :"+dinactualresult.indexOf("Date"));
			 * System.out.println("indx 2 :"+ dinactualresult.indexOf(
			 * "Company/LLP Status")); int starIndx
			 * =dinactualresult.indexOf("Date"); System.out.println("String :"
			 * +dinactualresult.substring(starIndx, starIndx+41));
			 * dinactualresult=
			 * dinactualresult.replace(dinactualresult.substring(starIndx,
			 * starIndx+41), "");
			 * 
			 * System.out.println("after replacing ............");
			 * System.out.println(dinactualresult);
			 * System.out.println("-----------------------------");
			 */

			String dinresult = exceptedreult;

			// System.out.println(dinactualresult.equals(dinresult));

			Double resPercentage = LetterPairSimilarity.compareStrings(dinactualresult, dinresult);

			System.out.println("resPercentage " + resPercentage * 100);
			String total = Double.toString(resPercentage * 100);

			ExtentTestManager.getTest().log(LogStatus.INFO, "percentage of actual and expected :: " + total);

			if (resPercentage > 0 && (resPercentage * 100) > 80) {

				System.out.println(" PASS    ");

				ExtentTestManager.getTest().log(LogStatus.INFO,
						"DIN Verification resultexcepted is started" + dinresult);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"DIN Verification resultactual is started" + dinactualresult);
				// ExtentTestManager.getTest().log(LogStatus.INFO, "DIN
				// Verification Result Comparison is
				// "+dinactualresult.equals(dinresult));
				ExtentTestManager.getTest().log(LogStatus.PASS, "DIN Verification    Result is Pass");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));
				String sec = MissingJSON.difference(dinactualresult, dinresult);

				System.out.println(sec);

				ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

			} else {

				System.out.println("not matching");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "DINVerification  Result is Fail");

				ExtentTestManager.getTest().log(LogStatus.INFO,
						"DIN Verification resultexcepted is started" + dinresult);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"DIN Verification resultactual is started" + dinactualresult);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"DIN Verification    Result Comparison is " + dinactualresult.equals(dinresult));

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));
				String sec = MissingJSON.difference(dinactualresult, dinresult);

				System.out.println(sec);

				ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("StringIndexOutOfBoundsException for DIN verification !!");
			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			ExtentTestManager.getTest().log(LogStatus.ERROR,
					"DIN Verification   Please Enter current captcha  for DIN verification !!");

		}
		driver.close();
		driver.switchTo().window(mainhandleandhra);

		// Assert.assertFalse(dinactualresult.contains(dinresult));

		// Assert.assertEquals(dinactualresult, dinresult);

	}
}
