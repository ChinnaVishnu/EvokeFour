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

public class AxisBank2 extends mainbase {

	@DataProvider(name = "DP63")
	public Object[][] createData63() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "Axisbank",
				"Axisbank");
		return (retObjArr);
	}

	@Test(priority = 68, dataProvider = "DP63")
	public void AxisBankAxix(String BankNameaxis, String Email, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Bank : Axis Bank ");

		Thread.sleep(8000);

		// driver.findElement(By.xpath("//a[text()='
		// Financial/Tax/Legal']")).click();

		driver.findElement(By.xpath("//a[text()='Financial']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='  Bank Statements Upload']/input")).click();

		Thread.sleep(8000);

		String user = "Raghu";

		Randomwords rr = new Randomwords();
		String words = rr.stp();
		driver.findElement(By.xpath("//input[@name='customerId']")).clear();

		driver.findElement(By.xpath("//input[@name='customerId']")).sendKeys(words + user);

		System.out.println(words + user);

		// driver.findElement(By.xpath(".//*[@id='SOURCESTABLE']/tbody/tr[1]/td[4]/input")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='uploadbankpdf']")).click();

		String mainhandle = driver.getWindowHandle();

		String childhandle = "";

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {

			if (!handle.equals(mainhandle)) {

				childhandle = handle;

			}

		}

		driver.switchTo().window(childhandle);

		// ...........................select the axis banks are some many but it
		// will pass the index it is working......................//

		WebElement Bankname = driver.findElement(By.xpath(".//*[@id='fileType']"));

		Select selectbank = new Select(Bankname);

		selectbank.selectByIndex(0);

		driver.findElement(By.xpath(".//*[@id='UploadFileButton']")).click();
		Thread.sleep(10000);

		ProcessBuilder bulidersecond = new ProcessBuilder(
				"D:\\AUTOMATION REQUIRED DOCS\\BanksUploads\\AxisBank\\batch12_upload.exe");
		bulidersecond.start();

		Thread.sleep(10000);

		driver.findElement(By.xpath(".//*[@id='upload']")).click();

		Thread.sleep(19000);

		String bankaxisexce = exceptedreult;

		String bankaxisresulttact = driver.findElement(By.xpath(".//*[@id='result']")).getText();

		Double resPercentage = LetterPairSimilarity.compareStrings(bankaxisresulttact, bankaxisexce);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : Axis Bank   excepted is started" + bankaxisexce);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : Axis Bank   actual is started" + bankaxisresulttact);
			// ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : Axis
			// Bank Result Comparison is
			// "+bankaxisresulttact.equals(bankaxisexce));
			ExtentTestManager.getTest().log(LogStatus.PASS, " Bank : Axis Bank    Result is pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Bank : Axis Bank  Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO, " Bank : Axis Bank   excepted is started" + bankaxisexce);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : Axis Bank   actual is started" + bankaxisresulttact);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Bank : Axis Bank   Result Comparison  is " + bankaxisresulttact.equals(bankaxisexce));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

		driver.close();
		driver.switchTo().window(mainhandle);

		// Assert.assertEquals(bankaxisresulttact, bankaxisexce);

	}

}
