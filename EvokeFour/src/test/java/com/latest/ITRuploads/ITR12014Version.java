package com.latest.ITRuploads;

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

public class ITR12014Version extends mainbase {

	@DataProvider(name = "DP47")
	public Object[][] createData47() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "ITR12014",
				"ITR12014");
		return (retObjArr);
	}

	@Test(priority = 61, dataProvider = "DP47")
	public void ITRUploadVV(String ITRVersion, String Password, String empty, String seempty, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" ITR1-2014 ");

		// Thread.sleep(14000);
		// driver.findElement(By.xpath("//div[2]/div/div[3]/div")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Tax']")).click();

		Thread.sleep(4000);

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='   ITR Upload']/input")).click();

		String mainhandleHaryana = driver.getWindowHandle();

		String childhandleHaryana = "";

		Set<String> handlesHaryana = driver.getWindowHandles();

		for (String handle : handlesHaryana) {

			if (!handle.equals(mainhandleHaryana)) {

				childhandleHaryana = handle;

			}

		}

		driver.switchTo().window(childhandleHaryana);

		driver.manage().window().maximize();

		Thread.sleep(4000);
		WebElement element = driver.findElement(By.xpath(".//*[@id='fileType']"));

		Select select = new Select(element);

		select.selectByVisibleText(ITRVersion);

		driver.findElement(By.xpath(".//*[@id='UploadFileButton']")).click();

		Thread.sleep(4000);
		ProcessBuilder bulidersecond = new ProcessBuilder(
				"D:\\AUTOMATION REQUIRED DOCS\\NewITRUploads\\ITRAllVersions\\ITR1-2014\\batch12_upload.exe");
		bulidersecond.start();

		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='pdfPassword']")).sendKeys(Password);

		Thread.sleep(12000);

		driver.findElement(By.xpath(".//*[@id='upload']")).click();

		Thread.sleep(35000);

		String uploadresult = exceptedreult;

		String uploadresultact = driver.findElement(By.xpath(".//*[@id='result']")).getText();

		Double resPercentage = LetterPairSimilarity.compareStrings(uploadresultact, uploadresult);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {
			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, " ITR1-2014  excepted is started" + uploadresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO, " ITR1-2014 actual is started" + uploadresultact);
			// ExtentTestManager.getTest().log(LogStatus.INFO, " ITR2-2015
			// Result Comparison is "+uploadresultact.equals(uploadresult));
			ExtentTestManager.getTest().log(LogStatus.PASS, " ITR1-2014  Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, " ITR1-2014  Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO, " ITR1-2014  excepted is started" + uploadresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO, " ITR1-2014  actual is started" + uploadresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" ITR1-2014  Result Comparison  is " + uploadresultact.equals(uploadresult));
			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		driver.close();
		driver.switchTo().window(mainhandleHaryana);

		// Assert.assertEquals(uploadresultact, uploadresult);

	}
}