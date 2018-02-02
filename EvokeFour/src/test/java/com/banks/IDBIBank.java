package com.banks;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class IDBIBank extends mainbase {

	@DataProvider(name = "DP75")
	public Object[][] createData75() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "IDBIBank",
				"IDBIBank");
		return (retObjArr);
	}

	@Test(priority = 73, dataProvider = "DP75")
	public void IDBIBank(String BankNameIdbi, String Email, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Bank : IDBIBank  ");

		Thread.sleep(8000);

		driver.findElement(By.xpath("//a[text()='Financial']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='  Bank Statements Upload']/input")).click();

		// driver.findElement(By.xpath(".//*[@id='SOURCESTABLE']/tbody/tr[1]/td[4]/input")).click();

		Thread.sleep(8000);

		String user = "mahesh324";

		Randomwords rr = new Randomwords();
		String words = rr.stp();

		driver.findElement(By.xpath("//input[@name='customerId']")).clear();
		driver.findElement(By.xpath("//input[@name='customerId']")).sendKeys(words + user);

		System.out.println(words + user);

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='uploadbankpdf']")).click();
		Thread.sleep(2000);
		String mainhandle = driver.getWindowHandle();

		String childhandle = "";

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {

			if (!handle.equals(mainhandle)) {

				childhandle = handle;

			}

		}

		driver.switchTo().window(childhandle);

		WebElement Banknamestandard = driver.findElement(By.xpath(".//*[@id='fileType']"));

		Select selectstandard = new Select(Banknamestandard);

		selectstandard.selectByVisibleText(BankNameIdbi);

		driver.findElement(By.xpath(".//*[@id='UploadFileButton']")).click();

		Thread.sleep(5000);

		ProcessBuilder bulideridbi = new ProcessBuilder(
				"D:\\AUTOMATION REQUIRED DOCS\\BanksUploads\\Idbibank\\batch12_upload.exe");
		bulideridbi.start();

		Thread.sleep(10000);

		driver.findElement(By.xpath(".//*[@id='upload']")).click();

		Thread.sleep(35000);

		String bankidbiexce = exceptedreult;

		String bankidbiresultact = driver.findElement(By.xpath(".//*[@id='result']")).getText();

		Double resPercentage = LetterPairSimilarity.compareStrings(bankidbiresultact, bankidbiexce);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			System.out.println("pass");
			ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : IDBIBank   excepted is started" + bankidbiexce);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : IDBIBank   actual is started" + bankidbiresultact);
			// ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : IDBIBank
			// Result Comparison is "+bankidbiresultact.equals(bankidbiexce));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Bank : IDBIBank    Result is pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Bank : IDBIBank  Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : IDBIBank   excepted is started" + bankidbiexce);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : IDBIBank   actual is started" + bankidbiresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : IDBIBank   Result Comparison  is " + bankidbiresultact.equals(bankidbiexce));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		driver.close();
		driver.switchTo().window(mainhandle);

		// Assert.assertEquals(bankidbiresultact, bankidbiexce);

	}

}
