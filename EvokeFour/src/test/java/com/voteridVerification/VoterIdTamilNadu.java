package com.voteridVerification;

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
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoterIdTamilNadu extends mainbase {

	@DataProvider(name = "DP2")
	public Object[][] createData2() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VoterIdVerificationTamilNadu", "VoterIdVerificationTamilNadu");
		return (retObjArr);
	}

	@Test(priority = 19, dataProvider = "DP2")
	public void VoterIdTamilNadu(String EPICNumber, String emptyone, String emptysecond, String emptythrid,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("VoterId : TamilNadu ");

		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[1]/a[5]")).click();

		String mainhandleJharkhand = driver.getWindowHandle();

		String childhandleJharkhand = "";

		Set<String> handlesJharkhand = driver.getWindowHandles();

		for (String handle : handlesJharkhand) {

			if (!handle.equals(mainhandleJharkhand)) {

				childhandleJharkhand = handle;

			}

		}

		driver.switchTo().window(childhandleJharkhand);

		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='gen_type3_epicNo']")).sendKeys(EPICNumber);

		driver.findElement(By.xpath(".//*[@id='submit']")).click();

		try {
			driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			try {

				Thread.sleep(30000);
				// Thread.sleep(7000);
				String voteridTamkilnaduexp = exceptedreult;

				String voteridTamilnaduresult = driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

				Double resPercentage = LetterPairSimilarity.compareStrings(voteridTamilnaduresult,
						voteridTamkilnaduexp);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

				if (resPercentage > 0 && (resPercentage * 100) > 80) {

					System.out.println("pass");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId : TamilNadu excepted is started" + voteridTamkilnaduexp);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId : TamilNadu actual is started" + voteridTamilnaduresult);
					// ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId
					// : TamilNadu Result Comparison is
					// "+voteridTamilnaduresult.equals(voteridTamkilnaduexp));
					ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : TamilNadu Result is Pass");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					String sec = MissingJSON.difference(voteridTamilnaduresult, voteridTamkilnaduexp);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				} else {

					System.out.println("not matching");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Telangana  Result is Fail");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId : TamilNadu excepted is started" + voteridTamkilnaduexp);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"VoterId : TamilNadu actual is started" + voteridTamilnaduresult);
					ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : TamilNadu Result Comparison  is "
							+ voteridTamilnaduresult.equals(voteridTamkilnaduexp));
					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					String sec = MissingJSON.difference(voteridTamilnaduresult, voteridTamkilnaduexp);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				}

			} catch (org.openqa.selenium.ElementNotVisibleException e) {
				ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : TamilNadu Request on site timed out");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (Exception e) {
			System.out.println("no page");
			System.out.println(e);
		}

		driver.close();

		driver.switchTo().window(mainhandleJharkhand);

		// Assert.assertEquals(voteridTelanagaresult, voteridTelanaga);

	}

}
