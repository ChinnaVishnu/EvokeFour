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

public class CanaraBank extends mainbase {

	@DataProvider(name = "DP65")
	public Object[][] createData65() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "CanaraBank",
				"CanaraBank");
		return (retObjArr);
	}

	@Test(priority = 70, dataProvider = "DP65")
	public void CanaraBank(String BankNamecarana, String Email, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Bank : Canara Bank ");

		/*
		 * Thread.sleep(5000);
		 * 
		 * driver.findElement(By.xpath("//a[text()='  Financial/Tax/Legal']"
		 * )).click();
		 */
		Thread.sleep(8000);

		driver.findElement(By.xpath("//a[text()='Financial']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='  Bank Statements Upload']/input")).click();

		Thread.sleep(8000);

		String user = "madhu188";

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

		WebElement Banknamecarana = driver.findElement(By.xpath(".//*[@id='fileType']"));

		Select selectbankcarana = new Select(Banknamecarana);

		selectbankcarana.selectByVisibleText(BankNamecarana);

		driver.findElement(By.xpath(".//*[@id='UploadFileButton']")).click();

		Thread.sleep(4000);

		ProcessBuilder bulidercanara = new ProcessBuilder(
				"D:\\AUTOMATION REQUIRED DOCS\\BanksUploads\\CanaraBank\\batch12_upload.exe");
		bulidercanara.start();

		Thread.sleep(10000);

		driver.findElement(By.xpath(".//*[@id='upload']")).click();
		Thread.sleep(42000);

		String bankcanaraexce = exceptedreult;

		String bankcanararesultact = driver.findElement(By.xpath(".//*[@id='result']")).getText();

		Double resPercentage = LetterPairSimilarity.compareStrings(bankcanararesultact, bankcanaraexce);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {
			System.out.println("pass");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : Canara bank   excepted is started" + bankcanaraexce);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : Canara bank   actual is started" + bankcanararesultact);
			// ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : Canara
			// bank Result Comparison is
			// "+bankcanararesultact.equals(bankcanaraexce));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Bank : Canara bank    Result is pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Bank : Canara bank  Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : Canara bank   excepted is started" + bankcanaraexce);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : Canara bank   actual is started" + bankcanararesultact);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : Canara bank   Result Comparison  is " + bankcanararesultact.equals(bankcanaraexce));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		driver.close();
		driver.switchTo().window(mainhandle);

		// Assert.assertEquals(bankcanararesultact, bankcanaraexce);

	}

}
