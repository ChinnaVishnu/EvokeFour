package com.captha.sources;

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

public class voteridverificationdelhi extends mainbase {

	@DataProvider(name = "DP5")
	public Object[][] createData5() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"voteridverificationdelhi", "voteridverificationdelhi");
		return (retObjArr);
	}

	@Test(priority = 7, dataProvider = "DP5")
	public void Electricityverificationdelhi(String Card, String Service, String Bill, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" VoterId : Delhi ");
		Thread.sleep(10000);

		driver.findElement(By.xpath("//a[text()='Individual Verification']")).click();

		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[3]/a[1]")).click();

		Thread.sleep(10000);

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

				driver.findElement(By.xpath(".//*[@id='gen_epicNo']")).sendKeys(Card);

				Thread.sleep(20000);

				driver.findElement(By.xpath(".//*[@id='submit']")).click();
				Thread.sleep(30000);

				String voteriddelhiactualresult = driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

				String voteriddelhi = exceptedreult;

				// System.out.println(voteriddelhi.equals(voteriddelhiactualresult));

				Double resPercentage = LetterPairSimilarity.compareStrings(voteriddelhiactualresult, voteriddelhi);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "percentage of actual and expected :: " + total);

				if (resPercentage > 0 && (resPercentage * 100) > 80) {

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId :	Delhi   resultexcepted is started" + voteriddelhi);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId :	Delhi   resultactual is started" + voteriddelhiactualresult);
					// ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId
					// : Delhi resultcomparison is
					// "+voteriddelhi.contains(voteriddelhiactualresult));
					ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId :	Delhi   Result is Pass");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				} else {

					System.out.println("not matching");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId :	Delhi  Result is Fail");
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId :	Delhi   resultexcepted is started" + voteriddelhi);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId :	Delhi   resultactual is started" + voteriddelhiactualresult);
					// ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId
					// : Delhi resultcomparison is
					// "+voteriddelhi.contains(voteriddelhiactualresult));
					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				}

			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.ERROR, "VoterId : Delhi Request on site timed out");
				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.ERROR,
						"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (Exception e) {
			System.out.println("no page");
			System.out.println(e);
		}

		driver.close();
		driver.switchTo().window(mainhandleandhra);
		// Assert.assertEquals(voteriddelhiactualresult, voteriddelhi);

	}

}
