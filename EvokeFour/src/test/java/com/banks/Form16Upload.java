package com.banks;

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

public class Form16Upload extends mainbase {

	@DataProvider(name = "DP63")
	public Object[][] createData63() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "Form16Upload",
				"Form16Upload");
		return (retObjArr);
	}

	@Test(priority = 83, dataProvider = "DP63")
	public void Formsixteenuploaddocumention(String BankNameaxis, String Email, String Bill, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Form 16 Upload ");

		Thread.sleep(3000);

		// driver.findElement(By.xpath("//div[2]/div/div[3]/div")).click();

		driver.findElement(By.xpath("//a[text()='Financial']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()=' Form 16 Upload']/input")).click();

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

		driver.manage().window().maximize();

		driver.findElement(By.xpath(".//*[@id='UploadFileButton']")).click();

		Thread.sleep(3000);
		ProcessBuilder bulidersecond = new ProcessBuilder(
				"D:\\AUTOMATION REQUIRED DOCS\\Form16\\Form\\batch12_upload.exe");
		bulidersecond.start();

		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='pdfPassword']")).sendKeys(BankNameaxis);

		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='upload']")).click();

		Thread.sleep(12000);

		String Formsixteenexce = exceptedreult;

		String Formsixteentactresult = driver.findElement(By.xpath(".//*[@id='result']")).getText();

		Double resPercentage = LetterPairSimilarity.compareStrings(Formsixteentactresult, Formsixteenexce);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO, " Form 16 Upload   excepted is started" + Formsixteenexce);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Form 16 Upload   actual is started" + Formsixteentactresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Form 16 Upload   Result Comparison  is " + Formsixteentactresult.equals(Formsixteenexce));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Form 16 Upload    Result is pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, " Form 16 Upload  Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO, " Form 16 Upload   excepted is started" + Formsixteenexce);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Form 16 Upload   actual is started" + Formsixteentactresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Form 16 Upload   Result Comparison  is " + Formsixteentactresult.equals(Formsixteenexce));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		driver.close();
		driver.switchTo().window(mainhandle);

		// Assert.assertEquals(bankaxisresulttact, bankaxisexce);

	}

}
