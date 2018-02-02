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

public class INDUSINDBank extends mainbase {

	@DataProvider(name = "DP69")
	public Object[][] createData69() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "INDUSINDBank",
				"INDUSINDBank");
		return (retObjArr);
	}

	@Test(priority = 74, dataProvider = "DP69")
	public void INDUSINDBank(String Banknamehdfc, String Email, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Bank : INDUSIND Bank ");

		Thread.sleep(8000);

		driver.findElement(By.xpath("//a[text()='Financial']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='  Bank Statements Upload']/input")).click();

		Thread.sleep(8000);

		String user = "pawan87";

		Randomwords rr = new Randomwords();
		String words = rr.stp();

		driver.findElement(By.xpath("//input[@name='customerId']")).clear();
		driver.findElement(By.xpath("//input[@name='customerId']")).sendKeys(words + user);

		System.out.println(words + user);
		// driver.findElement(By.xpath(".//*[@id='SOURCESTABLE']/tbody/tr[1]/td[4]/input")).click();

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

		WebElement Banknameindusind = driver.findElement(By.xpath(".//*[@id='fileType']"));

		Select selectindusind = new Select(Banknameindusind);

		selectindusind.selectByVisibleText(Banknamehdfc);

		driver.findElement(By.xpath(".//*[@id='UploadFileButton']")).click();

		Thread.sleep(5000);

		ProcessBuilder buliderhdfc = new ProcessBuilder(
				"D:\\AUTOMATION REQUIRED DOCS\\BanksUploads\\IndusinedBank\\batch12_upload.exe");
		buliderhdfc.start();

		Thread.sleep(10000);

		driver.findElement(By.xpath(".//*[@id='upload']")).click();

		Thread.sleep(35000);

		String bankindusindexce = exceptedreult;

		String bankindusindresultact = driver.findElement(By.xpath(".//*[@id='result']")).getText();

		Double resPercentage = LetterPairSimilarity.compareStrings(bankindusindresultact, bankindusindexce);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			System.out.println("pass");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : INDUSIND bank   excepted is started" + bankindusindexce);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : INDUSIND bank   actual is started" + bankindusindresultact);
			// ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : INDUSIND
			// bank Result Comparison is
			// "+bankindusindresultact.equals(bankindusindexce));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Bank : INDUSIND bank    Result is pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Bank : INDUSIND bank  Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : INDUSIND bank   excepted is started" + bankindusindexce);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : INDUSIND bank   actual is started" + bankindusindresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : INDUSIND bank   Result Comparison  is " + bankindusindresultact.equals(bankindusindexce));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		driver.close();
		driver.switchTo().window(mainhandle);

		// Assert.assertEquals(bankindusindresultact, bankindusindexce);

	}

}
