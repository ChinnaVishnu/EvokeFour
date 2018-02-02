package com.captha.sources;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class Otherverificationpan extends mainbase {

	@DataProvider(name = "DP13")
	public Object[][] createData13() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"OtherVerificationpan", "OtherVerificationpan");
		return (retObjArr);
	}

	@Test(priority = 19, dataProvider = "DP13")
	public void OTHERVERIFICATIONPAN(String Enter, String Category, String State, String empty, String exceptedreult,
			String actualresult, String testresult)
					throws BiffException, IOException, InterruptedException, HeadlessException, AWTException {

		ExtentTestManager.startTest(" Other Verification : PAN ");

		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[2]/div/div")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Individual Verification']")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[text()='  PAN with Captcha']/input")).click();

		// driver.findElement(By.xpath("//td[text()='PAN with
		// Captcha']/input")).click();

		Thread.sleep(7000);
		// driver.findElement(By.xpath(".//*[@id='panpopup']/img")).click();

		String mainhandleandhra = driver.getWindowHandle();

		String childhandleAndhra = "";

		Set<String> handlesandhra = driver.getWindowHandles();

		for (String handle : handlesandhra) {

			if (!handle.equals(mainhandleandhra)) {

				childhandleAndhra = handle;

			}

		}

		driver.switchTo().window(childhandleAndhra);

		/*
		 * try{
		 * 
		 * if(driver.findElement(By.xpath(".//*[@id='panNo']")).isDisplayed()){
		 */

		driver.findElement(By.xpath(".//*[@id='panNo']")).sendKeys(Enter);

		Thread.sleep(15000);

		driver.findElement(By.xpath(".//*[@id='panDiv']/div/span[1]/input")).click();
		Thread.sleep(20000);

		try {

			// Check the presence of alert
			Alert alert = driver.switchTo().alert();
			// Alert present; set the flag
			ExtentTestManager.getTest().log(LogStatus.ERROR,
					"Other Verification :PAN  please  Enter the current  captcha ");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
					.addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

			// if present consume the alert
			alert.accept();

			// foundAlert = true;

		} catch (NoAlertPresentException ex) {
			ex.printStackTrace();
			System.out.println("no alert");
			Thread.sleep(28000);

			String actualpanresult = driver.findElement(By.xpath(".//*[@id='result']")).getText();

			String panresultexp = exceptedreult;

			// System.out.println(panresultexp.equals(actualpanresult));
			Double resPercentage = LetterPairSimilarity.compareStrings(actualpanresult, panresultexp);

			System.out.println("resPercentage " + resPercentage * 100);
			String total = Double.toString(resPercentage * 100);

			ExtentTestManager.getTest().log(LogStatus.INFO, "percentage of actual and expected :: " + total);

			if (resPercentage > 0 && (resPercentage * 100) > 80) {

				System.out.println(" PASS    ");

				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification : PAN   resultexcepted is started" + panresultexp);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification : PAN   resultactual is started" + actualpanresult);
				// ExtentTestManager.getTest().log(LogStatus.INFO, "Other
				// Verification : PAN resultcomparison is
				// "+panresultexp.equals(actualpanresult));
				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Other Verification : PAN   verification Result is Pass");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			} else {

				System.out.println("not matching");
				// ExtentTestManager.getTest().log(LogStatus.ERROR, "Other
				// Verification :PAN result fail is capche isnot showing");

				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification : PAN   resultexcepted is started" + panresultexp);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification : PAN   resultactual is started" + actualpanresult);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Other Verification : PAN   resultcomparison is " + panresultexp.equals(actualpanresult));
				ExtentTestManager.getTest().log(LogStatus.FAIL,
						"Other Verification : PAN   verification Result is FAIL");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				// test.log(LogStatus.INFO, "OTHERVERIFICATIONPAN result fail is
				// excepted showing"+panresultexp);
				// test.log(LogStatus.INFO, "OTHERVERIFICATIONPAN result fail is
				// actual isnot showing"+actualpanresult);

			}

			driver.close();
		}

		// driver.close();

		/*
		 * else{
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.SKIP,
		 * "Other Verification : PAN window is not showing site is Busy please Try Later "
		 * ); }
		 * 
		 * 
		 * 
		 * 
		 * {
		 * 
		 * System.out.println("hi");
		 * 
		 * 
		 * 
		 * 
		 * } }catch (org.openqa.selenium.NoSuchElementException e){
		 * 
		 * ExtentTestManager.getTest().log(LogStatus.SKIP,
		 * "Other Verification : PAN window is not showing site is Busy please Try Later "
		 * );
		 * 
		 * }
		 */

		driver.switchTo().window(mainhandleandhra);
	}
}
