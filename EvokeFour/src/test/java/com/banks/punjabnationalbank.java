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

public class punjabnationalbank extends mainbase {

	@DataProvider(name = "DP72")
	public Object[][] createData72() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"punjabnationalbank", "punjabnationalbank");
		return (retObjArr);
	}

	@Test(priority = 77, dataProvider = "DP72")
	public void punjabnationalbank(String BankNamepunjab, String Email, String Bill, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Bank : PunjabNational Bank ");

		Thread.sleep(8000);
		driver.findElement(By.xpath("//a[text()='Financial']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='  Bank Statements Upload']/input")).click();

		Thread.sleep(8000);

		String user = "sriram12";

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

		WebElement Banknamepunjab = driver.findElement(By.xpath(".//*[@id='fileType']"));

		Select selectpunjab = new Select(Banknamepunjab);

		selectpunjab.selectByVisibleText(BankNamepunjab);

		driver.findElement(By.xpath(".//*[@id='UploadFileButton']")).click();

		Thread.sleep(5000);

		ProcessBuilder buliderpunjab = new ProcessBuilder(
				"D:\\AUTOMATION REQUIRED DOCS\\BanksUploads\\PunjabNationalBank\\batch12_upload.exe");
		buliderpunjab.start();

		Thread.sleep(10000);

		driver.findElement(By.xpath(".//*[@id='upload']")).click();
		Thread.sleep(15000);

		String bankpunjabexce = exceptedreult;

		String bankpunjabresultact = driver.findElement(By.xpath(".//*[@id='result']")).getText();

		Double resPercentage = LetterPairSimilarity.compareStrings(bankpunjabresultact, bankpunjabexce);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : PunjabNational bank   excepted is started" + bankpunjabexce);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : PunjabNational bank   actual is started" + bankpunjabresultact);
			// ExtentTestManager.getTest().log(LogStatus.INFO, " Bank :
			// PunjabNational bank Result Comparison is
			// "+bankpunjabresultact.equals(bankpunjabexce));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Bank : PunjabNational bank    Result is pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Bank : PunjabNational bank  Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : PunjabNational bank   excepted is started" + bankpunjabexce);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : PunjabNational bank   actual is started" + bankpunjabresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : PunjabNational bank   Result Comparison  is "
					+ bankpunjabresultact.equals(bankpunjabexce));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		driver.close();
		driver.switchTo().window(mainhandle);

		// Assert.assertEquals(bankpunjabresultact, bankpunjabexce);

	}

}
