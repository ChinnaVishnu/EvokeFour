package com.voteridVerification.practise;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

public class ElectricityVerificationAndhraSouthern extends mainbase {

	
	
	@DataProvider(name = "DP9")
	public Object[][] createData9() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationAPSouthern", "ElectricityVerificationAPSouthern");
		return (retObjArr);
	}

	@Test(priority = 15, dataProvider = "DP9")
	public void ElectricityAndhraPradeshEstern(String PowerDistribution, String ServiceNumber, String Bill, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Electricity Verification :Andhra Pradesh(Southern) ");
		//Thread.sleep(8000);

		//driver.findElement(By.xpath("//div[4]/div")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[text()='Andhra Pradesh']")).click();
		Thread.sleep(7000);
		
		
		
		

		/*
		 * driver.findElement(By.xpath(
		 * "//td[text()='Electricity Verification']/input")).click();
		 * 
		 * Thread.sleep(7000); driver.findElement(By.xpath(
		 * ".//*[@id='electricityDetails']/table/tbody/tr[1]/td[1]/a")).click();
		 */

		String mainhandleandhra = driver.getWindowHandle();

		String childhandleAndhra = "";

		Set<String> handlesandhra = driver.getWindowHandles();

		for (String handle : handlesandhra) {

			if (!handle.equals(mainhandleandhra)) {

				childhandleAndhra = handle;

			}

		}

		driver.switchTo().window(childhandleAndhra);

		try {
			driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			try {

				Thread.sleep(8000);
				WebElement element = driver.findElement(By.xpath("//select[@onchange='selectPowerDistribution()']"));

				Select select = new Select(element);

				select.selectByVisibleText(PowerDistribution);

				Thread.sleep(8000);
				driver.findElement(By.xpath("//input[@id='electricityNo2']")).sendKeys(ServiceNumber);

				Thread.sleep(10000);
				// Thread.sleep(20000);

				driver.findElement(By.xpath(".//*[@id='electricitySouthernDiv']/div/span[1]/input")).click();

				Thread.sleep(40000);

				String electricitytamilnaduactualresult = driver.findElement(By.xpath(".//*[@id='result']"))
						.getText();

				String electricitytamilnadu = exceptedreult;

				/// System.out.println(electricitytamilnadu.equals(electricitytamilnaduactualresult));

				Double resPercentage = LetterPairSimilarity.compareStrings(electricitytamilnaduactualresult,
						electricitytamilnadu);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "percentage of actual and expected :: " + total);

				if (resPercentage > 0 && (resPercentage * 100) > 80) {

					System.out.println(" PASS    ");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							" ElectricityVerificationAPSouthern   resultexcepted is started" + electricitytamilnadu);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" ElectricityVerificationAPSouthern    resultactual is started" + electricitytamilnaduactualresult);
					ExtentTestManager.getTest().log(LogStatus.INFO, " ElectricityVerificationAPSouthern   resultcomparison is "
							+ electricitytamilnadu.equals(electricitytamilnaduactualresult));
					ExtentTestManager.getTest().log(LogStatus.PASS, " ElectricityVerificationAPSouthern     Result is Pass");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				} else {

					System.out.println("not matching");
					ExtentTestManager.getTest().log(LogStatus.FAIL, " ElectricityVerificationAPSouthern   Result is Fail");
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" ElectricityVerificationAPSouthern    resultexcepted is started" + electricitytamilnadu);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" ElectricityVerificationAPSouthern   resultactual is started" + electricitytamilnaduactualresult);
					ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Tamilnadu    resultcomparison is "
							+ electricitytamilnadu.equals(electricitytamilnaduactualresult));
					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					// ExtentTestManager.getTest().log(LogStatus.WARNING, "
					// Electricity : Tamilnadu Request timeout ");
				}

			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.ERROR,
						"ElectricityVerificationAPSouthern   Unknown issuse ");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (Exception e) {
			System.out.println("no page");
			System.out.println(e);
		}

		driver.close();
		driver.switchTo().window(mainhandleandhra);
		// Assert.assertEquals(electricitytamilnaduactualresult,
		// electricitytamilnadu);

	}
}
