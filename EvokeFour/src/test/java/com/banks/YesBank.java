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

public class YesBank extends mainbase {

	@DataProvider(name = "DP67")
	public Object[][] createData67() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "YesBank",
				"YesBank");
		return (retObjArr);
	}

	@Test(priority = 80, dataProvider = "DP67")
	public void YesBank(String Banknameyesbank, String Email, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Bank : Yes Bank ");

		Thread.sleep(8000);

		driver.findElement(By.xpath("//a[text()='Financial']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='  Bank Statements Upload']/input")).click();

		Thread.sleep(8000);

		String user = "testabc123";

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

		WebElement Banknameyes = driver.findElement(By.xpath(".//*[@id='fileType']"));

		Select selectbankyes = new Select(Banknameyes);

		selectbankyes.selectByVisibleText(Banknameyesbank);

		driver.findElement(By.xpath(".//*[@id='UploadFileButton']")).click();

		Thread.sleep(5000);

		ProcessBuilder bulideyes = new ProcessBuilder(
				"D:\\AUTOMATION REQUIRED DOCS\\BanksUploads\\YesBank\\batch12_upload.exe");
		bulideyes.start();

		Thread.sleep(10000);

		driver.findElement(By.xpath(".//*[@id='upload']")).click();
		Thread.sleep(59000);

		String bankyesexce = exceptedreult;

		String bankyesresultact = driver.findElement(By.xpath(".//*[@id='result']")).getText();

		Double resPercentage = LetterPairSimilarity.compareStrings(bankyesresultact, bankyesexce);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			System.out.println("pass");
			ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : Yes bank   excepted is started" + bankyesexce);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : Yes bank   actual is started" + bankyesresultact);
			// ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : Yes bank
			// Result Comparison is "+bankyesresultact.equals(bankyesexce));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Bank : Yes bank    Result is pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Bank : Yes bank  Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : Yes bank   excepted is started" + bankyesexce);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : Yes bank   actual is started" + bankyesresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : Yes bank   Result Comparison  is " + bankyesresultact.equals(bankyesexce));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		driver.close();
		driver.switchTo().window(mainhandle);

		// Assert.assertEquals(bankyesresultact, bankyesexce);

	}

}
