package com.legel.Tax;

import java.io.IOException;

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

public class CstTamilnadu extends mainbase {

	// ...........................................................FORMCSTTAMILNADU.....................................................................//

	@DataProvider(name = "DP8")
	public Object[][] createData8() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "CSTTamilnadu",
				"CSTTamilnadu");
		return (retObjArr);
	}

	@Test(priority = 59, dataProvider = "DP8")
	public void FormCStTamilNadu(String IDType, String State, String Number, String empty, String exceptedreult,
			String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest(" FORM : CST Info-Tamilnadu ");

		// String csttamilexcepted=exceptedreult;

		/*
		 * FormCstinfotamailnadupage cst=new FormCstinfotamailnadupage(driver);
		 * 
		 * cst.clicktamilnad(IDType, State, Number);
		 */

		Thread.sleep(4000);
		// driver.findElement(By.xpath("//div[2]/div[2]/div")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Tax']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='  CST']/input")).click();

		Thread.sleep(4000);
		WebElement elementsecond = driver.findElement(By.xpath(".//*[@id='cststate']"));

		Thread.sleep(2000);
		Select selectsecond = new Select(elementsecond);

		selectsecond.selectByVisibleText(State);

		driver.findElement(By.xpath(".//*[@id='voterId']")).sendKeys(Number);
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();

		Thread.sleep(48000);

		// waitForAjax(5);

		String FORMCSTTAMILNADU = exceptedreult;

		String FORMCSTTAMILNADUresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(FORMCSTTAMILNADUresult, FORMCSTTAMILNADU);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {
			System.out.println("pass");
			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : CST Info-Tamilnadu Expected:" + FORMCSTTAMILNADU);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : CST Info-Tamilnadu Actual:" + FORMCSTTAMILNADUresult);
			ExtentTestManager.getTest().log(LogStatus.PASS, "FORM : CST Info-Tamilnadu Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(FORMCSTTAMILNADUresult, FORMCSTTAMILNADU);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.SKIP, "FORM : CST Info-Tamilnadu Result is SKIP");
			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : CST Info-Tamilnadu Expected:" + FORMCSTTAMILNADU);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"FORM : CST Info-Tamilnadu Actual:" + FORMCSTTAMILNADUresult);

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.SKIP,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(FORMCSTTAMILNADUresult, FORMCSTTAMILNADU);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}
	}

}
