package com.voteridVerification;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoteridGoa extends mainbase {

	// div[@id='loadingmessage']

	// .......................................

	// div[@id='loadingmessage']/img

	@DataProvider(name = "DP59")
	public Object[][] createData59() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"voteridverificationGoa", "voteridverificationGoa");
		return (retObjArr);
	}

	@Test(priority = 10, dataProvider = "DP59")
	public void voteridGoaverification(String District, String Voter, String Number, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" VoterId : Goa ");

		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[1]/a[4]")).click();

		String mainhandleJharkhand = driver.getWindowHandle();

		String childhandleJharkhand = "";

		Set<String> handlesJharkhand = driver.getWindowHandles();

		for (String handle : handlesJharkhand) {

			if (!handle.equals(mainhandleJharkhand)) {

				childhandleJharkhand = handle;

			}

		}

		driver.switchTo().window(childhandleJharkhand);

		Thread.sleep(2000);

		WebElement elementgoa = driver.findElement(By.xpath(".//*[@id='gen_type4_district']"));

		Select selectgoa = new Select(elementgoa);

		selectgoa.selectByVisibleText(District);

		driver.findElement(By.xpath(".//*[@id='gen_type4_epicNo']")).sendKeys(Voter);

		driver.findElement(By.xpath(".//*[@id='submit']")).click();

		try {
			driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			try {

				Thread.sleep(130000);

				String voteridgoactualresult = driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
				String voteridgoaexcepted = exceptedreult;

				Double resPercentage = LetterPairSimilarity.compareStrings(voteridgoactualresult, voteridgoaexcepted);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

				if (resPercentage > 0 && (resPercentage * 100) > 80) {

					System.out.println("pass");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId : Goa  excepted is started" + voteridgoaexcepted);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId : Goa  actual is started" + voteridgoactualresult);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId : Goa  Result Comparison  is " + voteridgoactualresult.equals(voteridgoaexcepted));
					ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : Goa  Result is Pass");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					String sec = MissingJSON.difference(voteridgoactualresult, voteridgoaexcepted);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				} else {

					System.out.println("not matching");
					// test.log(LogStatus.FAIL, "VoterId : Goa Result is Fail");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId : Goa  excepted is started" + voteridgoaexcepted);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId : Goa  actual is started" + voteridgoactualresult);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId : Goa  Result Comparison  is " + voteridgoactualresult.equals(voteridgoaexcepted));
					ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Goa  Result is Fail");
					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					String sec = MissingJSON.difference(voteridgoactualresult, voteridgoaexcepted);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				}

			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.ERROR, "VoterId : Goa Request on site timed out");
				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.ERROR,
						"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (Exception e) {
			System.out.println("no page");
			System.out.println(e);
		}

		driver.close();

		driver.switchTo().window(mainhandleJharkhand);

		// Assert.assertEquals(voteridgoactualresult, voteridgoaexcepted);

	}

}
