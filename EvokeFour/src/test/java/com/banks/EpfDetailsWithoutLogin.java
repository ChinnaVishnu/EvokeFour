package com.banks;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

public class EpfDetailsWithoutLogin extends mainbase {

	// ....................................................... EPF
	// Details(Without Login)
	// .........................................................................//

	@DataProvider(name = "DP50")
	public Object[][] createData50() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"EPFDetailsWithoutLogin", "EPFDetailsWithoutLogin");
		return (retObjArr);
	}

	@Test(priority = 21, dataProvider = "DP50")
	public void EpFWithoutLogin(String Company, String Employee, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("  EPF Details(Without Login) ");

		try {
			Thread.sleep(6000);

			driver.findElement(By.xpath("//a[text()='Financial']")).click();

			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[text()='  EPF Company Details']/input")).click();

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

			try {

				driver.findElement(By.xpath(".//*[@id='compName']")).sendKeys(Company);
				// driver.findElement(By.xpath(".//*[@id='empName']")).sendKeys(Employee);
				Thread.sleep(20000);

				driver.findElement(By.xpath(".//*[@id='details']/table/tbody/tr[4]/td[2]/input")).click();

			} catch (Exception e) {

				ExtentTestManager.getTest().log(LogStatus.SKIP, "EPF Details(Without Login) Showing blank ");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.FAIL,
						"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				// driver.close();

				// driver.switchTo().window(mainhandle);

			}

			try {
				driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
				try {

					Thread.sleep(29000);

					String EpfLoginresult = exceptedreult;

					String EpfLoginresultact = driver.findElement(By.xpath(".//*[@id='result_data']")).getText();

					System.out.println(EpfLoginresultact.equals(EpfLoginresult));

					Double resPercentage = LetterPairSimilarity.compareStrings(EpfLoginresultact, EpfLoginresult);

					System.out.println("resPercentage " + resPercentage * 100);
					String total = Double.toString(resPercentage * 100);

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

					if (resPercentage > 0 && (resPercentage * 100) > 80) {

						System.out.println("pass");
						ExtentTestManager.getTest().log(LogStatus.INFO,
								" EPF Without Login Result excepted is started" + EpfLoginresult);
						ExtentTestManager.getTest().log(LogStatus.INFO,
								" EPF Without Login Result actual is started" + EpfLoginresultact);
						// ExtentTestManager.getTest().log(LogStatus.INFO, " EPF
						// Without Login Result Comparison is
						// "+EpfLoginresultact.equals(EpfLoginresult));
						ExtentTestManager.getTest().log(LogStatus.PASS, " EPF Without Login Result is Pass");

						String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

						ExtentTestManager.getTest().log(LogStatus.PASS,
								"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					} else {

						System.out.println("not matching");
						ExtentTestManager.getTest().log(LogStatus.FAIL, " EPF Without Login Result  is Fail");

						ExtentTestManager.getTest().log(LogStatus.INFO,
								" EPF Without Login Result excepted is started" + EpfLoginresult);
						ExtentTestManager.getTest().log(LogStatus.INFO,
								" EPF Without Login Result actual is started" + EpfLoginresultact);
						ExtentTestManager.getTest().log(LogStatus.INFO,
								" EPF Without Login Result Comparison  is " + EpfLoginresultact.equals(EpfLoginresult));
						ExtentTestManager.getTest().log(LogStatus.FAIL, " EPF Without Login Result is FAIL");

						String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

						ExtentTestManager.getTest().log(LogStatus.FAIL,
								"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					}

				} catch (Exception e) {
					ExtentTestManager.getTest().log(LogStatus.ERROR, "EPF Without Login  Request on site timed out");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.FAIL,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				}

			} catch (Exception e) {
				System.out.println("no page");
				System.out.println(e);
			}

			driver.close();

			driver.switchTo().window(mainhandle);

			// Assert.assertEquals(EpfLoginresultact, EpfLoginresult);

		} catch (Exception e) {

			ExtentTestManager.getTest().log(LogStatus.SKIP,
					" EPF Without Login Result is Skipping Because Request For Time Out and it is Showing Blank ");
			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.SKIP,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		}

	}

}
