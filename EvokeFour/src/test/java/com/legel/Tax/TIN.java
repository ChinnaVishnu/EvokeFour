package com.legel.Tax;

import java.io.IOException;

import org.openqa.selenium.By;
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

public class TIN extends mainbase {

	@DataProvider(name = "DP4")
	public Object[][] createData4() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "FormTin",
				"FormTin");
		return (retObjArr);
	}

	@Test(priority = 92, dataProvider = "DP4")
	public void FormTinInfoApi(String IDType, String Number, String FormIdNumber, String empty, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" FORM : Tin Info ");

		// Thread.sleep(32000);

		// Thread.sleep(4000);

		// driver.findElement(By.xpath("//div[2]/div/div[3]/div")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Tax']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='  TIN']/input[@value='tinNo']")).click();

		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='voterId']")).sendKeys(Number);

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();

		Thread.sleep(32000);

		// waitForAjax(5);

		String FormTininfoApi = exceptedreult;

		String FORMTinbillinfo = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		// Assert.assertEquals(FORMTinbillinfo, FormTininfoApi);

		System.out.println(FORMTinbillinfo.equals(FormTininfoApi));

		Double resPercentage = LetterPairSimilarity.compareStrings(FORMTinbillinfo, FormTininfoApi);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {
			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Tin Info excepted is started" + FormTininfoApi);
			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Tin Info actual is started" + FORMTinbillinfo);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Tin Info
			// Result Comparison is "+FORMTinbillinfo.equals(FormTininfoApi));
			ExtentTestManager.getTest().log(LogStatus.PASS, "FORM : Tin Info  Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "FORM : Tin Info  Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Tin Info excepted is started" + FormTininfoApi);
			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Tin Info actual is started" + FORMTinbillinfo);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : Tin Info Result Comparison  is " + FORMTinbillinfo.equals(FormTininfoApi));
			ExtentTestManager.getTest().log(LogStatus.FAIL, "FORM : Tin Info  Result is FAIL");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}
	}

}
