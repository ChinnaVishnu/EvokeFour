package com.captha.sources;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class OtherverificationCST extends mainbase {

	@DataProvider(name = "DP12")
	public Object[][] createData12() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"OtherverificationCST", "OtherverificationCST");
		return (retObjArr);
	}

	@Test(priority = 11, dataProvider = "DP12")
	public void OtherverificationCSTVV(String Enter, String Category, String State, String empty, String exceptedreult,
			String actualresult, String testresult) throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Other Verification :  Excise Tax ");

		Thread.sleep(9000);

		driver.findElement(By.xpath("//div[2]/div/div[3]/div")).click();

		Thread.sleep(9000);
		driver.findElement(By.xpath("//a[text()='Tax']")).click();
		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[text()='  Excise Tax']/input")).click();

		Thread.sleep(9000);
		// driver.findElement(By.xpath(".//*[@id='itrv']/table/tbody/tr/td[6]/img")).click();

		String mainhandleandhra = driver.getWindowHandle();

		String childhandleAndhra = "";

		Set<String> handlesandhra = driver.getWindowHandles();

		for (String handle : handlesandhra) {

			if (!handle.equals(mainhandleandhra)) {

				childhandleAndhra = handle;

			}

		}

		driver.switchTo().window(childhandleAndhra);

		driver.findElement(By.xpath(".//*[@id='cstNo']")).sendKeys(Enter);

		Thread.sleep(20000);

		driver.findElement(By.xpath(".//*[@id='cstDiv']/div/span[1]/input")).click();

		try {

			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			// Alert present; set the flag
			ExtentTestManager.getTest().log(LogStatus.ERROR,
					"Other Verification :CST  please  Enter the  current captcha   ");

			// if present consume the alert
			alert.accept();

			// foundAlert = true;

		} catch (NoAlertPresentException ex) {
			ex.printStackTrace();
			System.out.println("no alert");
			Thread.sleep(30000);

			String othercstactualresult = driver.findElement(By.xpath(".//*[@id='result']")).getText();
			String othercst = exceptedreult;

			// System.out.println(othercstactualresult.equals(othercst));

			Double resPercentage = LetterPairSimilarity.compareStrings(othercstactualresult, othercst);

			System.out.println("resPercentage " + resPercentage * 100);
			String total = Double.toString(resPercentage * 100);

			ExtentTestManager.getTest().log(LogStatus.INFO, "percentage of actual and expected :: " + total);

			if (resPercentage > 0 && (resPercentage * 100) > 80) {

				System.out.println(" PASS    ");

				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification : CST resultexcepted is started" + othercst);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification : CST resultactual is started" + othercstactualresult);
				// ExtentTestManager.getTest().log(LogStatus.INFO, "Other
				// Verification : CST resultcomparison is
				// "+othercst.equals(othercstactualresult));
				ExtentTestManager.getTest().log(LogStatus.PASS, "Other Verification : CST verification Result is Pass");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			} else {

				System.out.println("not matching");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Other Verification : CST   Result is Fail");
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification : CST resultexcepted is started" + othercst);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification : CST resultactual is started" + othercstactualresult);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification : CST resultcomparison is " + othercst.equals(othercstactualresult));

			}
			driver.close();
			// Assert.assertEquals(othercstactualresult, othercst);
		}

		driver.switchTo().window(mainhandleandhra);
	}
}
