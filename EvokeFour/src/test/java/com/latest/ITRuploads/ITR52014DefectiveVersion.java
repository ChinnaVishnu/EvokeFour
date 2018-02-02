package com.latest.ITRuploads;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class ITR52014DefectiveVersion extends mainbase {

	@DataProvider(name = "1")
	public Object[][] createData1() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "ITR52014",
				"ITR52014");
		return (retObjArr);
	}

	@Test(priority = 65, dataProvider = "1")
	public void ITRUploadVVSS(String ITRVersion, String Password, String empty, String seempty, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" ITR5-2014 ");

		// Thread.sleep(14000);
		// driver.findElement(By.xpath("//div[2]/div[2]/div")).click();

		Thread.sleep(8000);
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
				"D:\\AUTOMATION REQUIRED DOCS\\NewITRUploads\\ITRAllVersions\\ITR5-2014-defective\\batch12_upload.exe");
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

			ExtentTestManager.getTest().log(LogStatus.INFO, " ITR5-2014  excepted is started" + uploadresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO, " ITR5-2014 actual is started" + uploadresultact);
			// ExtentTestManager.getTest().log(LogStatus.INFO, " ITR5-2014
			// Result Comparison is "+uploadresultact.equals(uploadresult));
			ExtentTestManager.getTest().log(LogStatus.PASS, " ITR5-2014  Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, " ITR5-2014  Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO, " ITR5-2014  excepted is started" + uploadresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO, " ITR5-2014  actual is started" + uploadresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" ITR5-2014  Result Comparison  is " + uploadresultact.equals(uploadresult));
			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		driver.close();
		driver.switchTo().window(mainhandleHaryana);

		// Assert.assertEquals(uploadresultact, uploadresult);

	}
}