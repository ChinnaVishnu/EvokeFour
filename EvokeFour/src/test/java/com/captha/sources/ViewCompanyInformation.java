package com.captha.sources;

import java.io.IOException;
import java.util.Set;

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

public class ViewCompanyInformation extends mainbase {

	@DataProvider(name = "DP16")
	public Object[][] createData16() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ViewCompanyInformation", "ViewCompanyInformation");
		return (retObjArr);
	}

	@Test(priority = 4, dataProvider = "DP16")
	public void ViewCompanyInformation(String Companyname, String Service, String Bill, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" View Company Information ");
		Thread.sleep(18000);

		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();

		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[text()='  View Company Information']/input")).click();

		Thread.sleep(9000);

		String mainhandleandhra = driver.getWindowHandle();

		String childhandleAndhra = "";

		Set<String> handlesandhra = driver.getWindowHandles();

		for (String handle : handlesandhra) {

			if (!handle.equals(mainhandleandhra)) {

				childhandleAndhra = handle;

			}

		}

		driver.switchTo().window(childhandleAndhra);

		driver.findElement(By.xpath(".//*[@id='name']")).sendKeys(Companyname);

		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='find']")).click();

		Thread.sleep(59000);

		try {
			driver.findElement(By.xpath(".//*[@id='cinDiv']/div/span[1]/input")).click();

			Thread.sleep(45000);

			String viewcompanyinformationAct = driver.findElement(By.xpath(".//*[@id='result']")).getText();

			String viewcompanyinformation = exceptedreult;

			// System.out.println(viewcompanyinformation.equals(viewcompanyinformationAct));

			Double resPercentage = LetterPairSimilarity.compareStrings(viewcompanyinformationAct,
					viewcompanyinformation);

			System.out.println("resPercentage " + resPercentage * 100);
			String total = Double.toString(resPercentage * 100);

			ExtentTestManager.getTest().log(LogStatus.INFO, "percentage of actual and expected :: " + total);

			if (resPercentage > 0 && (resPercentage * 100) > 80) {

				ExtentTestManager.getTest().log(LogStatus.INFO,
						"View Company Information   resultexcepted is started" + viewcompanyinformation);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"View Company Information  resultactual is started" + viewcompanyinformationAct);
				// ExtentTestManager.getTest().log(LogStatus.INFO, "View Company
				// Information Result Comparison is
				// "+viewcompanyinformation.equals(viewcompanyinformationAct));
				ExtentTestManager.getTest().log(LogStatus.PASS, "View Company Information Result is Pass");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			} else {

				System.out.println("not matching");
				ExtentTestManager.getTest().log(LogStatus.FAIL, " View Company Information  Result is Fail");
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"View Company Information   resultexcepted is started" + viewcompanyinformation);
				ExtentTestManager.getTest().log(LogStatus.INFO,
						"View Company Information  resultactual is started" + viewcompanyinformationAct);
				ExtentTestManager.getTest().log(LogStatus.INFO, "View Company Information Result Comparison is "
						+ viewcompanyinformation.equals(viewcompanyinformationAct));

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (org.openqa.selenium.UnhandledAlertException e) {

			System.out.println("");
			ExtentTestManager.getTest().log(LogStatus.WARNING,
					" View Company Information  Result is Captcha is not showing");

		}

		driver.close();
		driver.switchTo().window(mainhandleandhra);
		// Assert.assertEquals(viewcompanyinformationAct,
		// viewcompanyinformation);

	}

}
