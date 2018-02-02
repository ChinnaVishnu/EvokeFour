package com.identity.verification;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class AadhaarVerificationFour2 extends mainbase {
	@DataProvider(name = "DP1")
	public Object[][] createData1() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"AadhaarVerification", "AadhaarVerification");
		return (retObjArr);
	}

	@Test(priority = 1, dataProvider = "DP1")
	public void Aadharverification(String AADHAAR, String Applicants, String Birth, String Gender, String exceptedreult,
			String actualresult, String testresult)
					throws IOException, InterruptedException, HeadlessException, AWTException {
		ExtentTestManager.startTest(" Aadhar : verification");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='  Aadhaar Verification']/input")).click();

		// .................................AADHAAR Number (12
		// Digits)..................................................................//
		driver.findElement(By.xpath("//input[@id='strAadhaar']")).sendKeys(AADHAAR);

		// ...................................Applicants Name as per AADHAAR
		// card......................................................//

		driver.findElement(By.xpath("//input[@id='strAadhaarName']")).sendKeys(Applicants);

		// ...........................................................Year of
		// Birth....................................................//

		driver.findElement(By.xpath("//input[@id='strYear']")).sendKeys(Birth);

		// ..........................................................Gender............................................................//

		WebElement Genderele = driver.findElement(By.xpath("//select[@id='strGender']"));

		Select selectGender = new Select(Genderele);

		selectGender.selectByVisibleText(Gender);

		ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
				.addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));

		// ......................Submit................................................................................................//
		try {

			driver.findElement(By.xpath("//div[@id='aadhar']/table/tbody/tr[4]/td[1]/input")).click();

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-250)", "");

			Thread.sleep(35000);

			Alert alert = driver.switchTo().alert();

			Thread.sleep(11000);

			String Aadharverificationexcepted = exceptedreult;
			String Actalalet = alert.getText();

			try {

				Assert.assertEquals(Actalalet, Aadharverificationexcepted);
				// System.out.println(Aadharverificationexcepted.equals(Actalalet));
			} catch (Throwable e) {

				System.out.println(e.getMessage());
				ExtentTestManager.getTest().log(LogStatus.INFO, e.getMessage());

			}

			Double resPercentage = LetterPairSimilarity.compareStrings(Actalalet, Aadharverificationexcepted);

			System.out.println("resPercentage " + resPercentage * 100);
			String total = Double.toString(resPercentage * 100);

			ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

			// Assert.assertEquals(Formwaterbillinforesult, waterbillresult);
			// System.out.println(Formwaterbillinforesult.equals(waterbillresult));

			if (Actalalet.equals(Aadharverificationexcepted)) {

				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Aadhar verification  excepted is started" + Aadharverificationexcepted);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Aadhar verification  resultactual is started" + Actalalet);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Aadhar verification  Result Comparison is " + Aadharverificationexcepted.equals(Actalalet));
				ExtentTestManager.getTest().log(LogStatus.PASS, "Aadhar : verification Result is Pass");

				ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
						.addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

			} else {

				System.out.println("not matching");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Aadhar : verification result is Fail");
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Aadhar verification  excepted is started" + Aadharverificationexcepted);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Aadhar verification  resultactual is started" + Actalalet);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"Aadhar verification  Result Comparison is " + Aadharverificationexcepted.equals(Actalalet));

				ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
						.addScreenCapture(GetScreenshort.testrobot("ScreenshortForExtentReport")));

			}

			System.out.println("this is  not coming loading....");

			alert.accept();

			/*
			 * if(driver.findElement(By.xpath(".//*[@id='loadingmessage']/img"))
			 * .isDisplayed()){
			 * 
			 * Thread.sleep(16000);
			 * 
			 * 
			 * driver.navigate().refresh();
			 * 
			 * }
			 * 
			 * else {
			 * 
			 * Thread.sleep(16000); System.out.println("loading......"); }
			 * 
			 */

			Thread.sleep(1000);

			driver.navigate().refresh();

		} catch (org.openqa.selenium.NoAlertPresentException e) {

			ExtentTestManager.getTest().log(LogStatus.WARNING,
					"Aadhar verification   server did not provide any stacktrace information");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
					.addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));

			driver.navigate().refresh();

			System.out.println("no");

		} catch (org.openqa.selenium.UnhandledAlertException e) {
			// TODO: handle exception

			ExtentTestManager.getTest().log(LogStatus.WARNING, "Aadhar verification   Alert Please provide!!");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :" + ExtentTestManager.getTest()
					.addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));

			driver.navigate().refresh();

			System.out.println("unh;;");

		}

	}
}
