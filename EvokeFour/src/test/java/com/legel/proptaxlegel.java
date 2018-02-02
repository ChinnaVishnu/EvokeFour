package com.legel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.PropertaxAhmedabaapage;
import com.allclasses.PropertaxBangolrepage;
import com.allclasses.Propertaxchinnapage;
import com.allclasses.Propertaxhyderabadpage;
import com.allclasses.Propertaxpuneapage;
import com.allclasses.hew;
import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class proptaxlegel extends mainbase {

	// ................................................proptaxahmabad..............................................................//

	@DataProvider(name = "DP29")
	public Object[][] createData29() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"PropertyTaxVerificationAhmedabad", "PropertyTaxVerificationAhmedabad");
		return (retObjArr);
	}

	@Test(priority = 46, dataProvider = "DP29")
	public void PropertaxAhmedabad(String Tenement, String Voter, String AC, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" PropertyTax : Ahmedabad ");

		PropertaxAhmedabaapage vo = new PropertaxAhmedabaapage(driver);

		vo.clickpropAhamabad(Tenement, exceptedreult);

	}

	// .......................................................proptaxbangolre........................................................//

	@DataProvider(name = "DP32")
	public Object[][] createData32() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"PropertyTaxVerificationBangalore", "PropertyTaxVerificationBangalore");
		return (retObjArr);
	}

	@Test(priority = 47, dataProvider = "DP32")
	public void PropertyTaxBangalore(String SAS, String Name, String AC, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("PropertyTax : Bangalore  ");

		PropertaxBangolrepage vo = new PropertaxBangolrepage(driver);

		vo.clickbangolre(SAS, Name, exceptedreult);

	}

	// ..................................................proptaxChanni................................................................//

	@DataProvider(name = "DP33")
	public Object[][] createData33() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"PropertyTaxVerificationChennai", "PropertyTaxVerificationChennai");
		return (retObjArr);
	}

	@Test(priority = 48, dataProvider = "DP33")
	public void PropertyTaxChinna(String Zone, String Ward, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("PropertyTax : Chennai ");

		Propertaxchinnapage vo = new Propertaxchinnapage(driver);

		vo.clickchinnatax(Zone, Ward, Bill, exceptedreult);

	}

	// ........................................................proptaxHyderabad......................................................//

	@DataProvider(name = "DP31")
	public Object[][] createData31() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"PropertyTaxVerificationHyderabad", "PropertyTaxVerificationHyderabad");
		return (retObjArr);
	}

	@Test(priority = 49, dataProvider = "DP31")
	public void PropertyTaxHyderabad(String Circle, String Number, String AC, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" PropertyTax : Hyderabad ");

		Propertaxhyderabadpage vo = new Propertaxhyderabadpage(driver);

		vo.clickproperrtaxhyderbad(Circle, Number, exceptedreult);

	}

	// .........................................................proptaxpune........................................................//

	@DataProvider(name = "DP30")
	public Object[][] createData30() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"PropertyTaxVerificationPune", "PropertyTaxVerificationPune");
		return (retObjArr);
	}

	@Test(priority = 50, dataProvider = "DP30")
	public void PropertyTaxPune(String Property, String Section, String Peth, String Account, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" PropertyTax : Pune ");

		Propertaxpuneapage vo = new Propertaxpuneapage(driver);

		vo.clickpune(Property, Section, Peth, Account, exceptedreult);

	}

	// .........................................................CBILSuiteFiles.......................................................//

	// ............................................................CIBILSuitFiledCases .....................................................................//

	@DataProvider(name = "DP2")
	public Object[][] createData2() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"CIBILSuitFiledCases", "CIBILSuitFiledCases");
		return (retObjArr);
	}

	@Test(priority = 51, dataProvider = "DP2")
	public void CIBIL(String Suit, String Entity, String Director, String empty, String exceptedreult,
			String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest("CIBIL Suit Filed Cases");

		// Thread.sleep(6000);
		// driver.findElement(By.xpath("//a[text()='
		// Financial/Tax/Legal']")).click();

		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[text()='Legal']")).click();

		Thread.sleep(6000);

		driver.findElement(By.xpath("//div[text()='  CIBIL Suit Filed Cases']/input")).click();

		Thread.sleep(2000);
		// .....................................Suit Filed Accounts
		// of...............................................................//
		WebElement elementSuit = driver.findElement(By.xpath("//select[@id='suit_filed_accounts']"));

		Select selectSuit = new Select(elementSuit);

		selectSuit.selectByVisibleText(Suit);

		Thread.sleep(2000);

		// ........................................Entity
		// Name......................................................................//

		driver.findElement(By.xpath(".//*[@id='entityName']")).sendKeys(Entity);
		Thread.sleep(2000);
		// ..........................................Director
		// Name.................................................................//
		driver.findElement(By.xpath(".//*[@id='directorName']")).sendKeys(Director);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='cibilSuitFiles']/table/tbody/tr[4]/td[2]/input")).click();

		Thread.sleep(60000);
		// waitForAjax(5);

		String Cbilresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		String Cbilactreult = exceptedreult;

		// driver.navigate().refresh();

		System.out.println(Cbilresult.equals(Cbilactreult));
		Double resPercentage = LetterPairSimilarity.compareStrings(Cbilresult, Cbilactreult);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {
			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, "CIBIL Suit Filed Cases Expected:" + Cbilactreult);
			ExtentTestManager.getTest().log(LogStatus.INFO, "CIBIL Suit Filed Cases Actual:" + Cbilresult);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "CIBIL Suit Filed
			// Cases Result Comparison is "+Cbilresult.equals(Cbilactreult));
			ExtentTestManager.getTest().log(LogStatus.PASS, "CIBIL Suit Filed Cases  Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(Cbilresult, Cbilactreult);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "CIBIL Suit Filed Cases  result is fail");

			ExtentTestManager.getTest().log(LogStatus.INFO, "CIBIL Suit Filed Cases Expected:" + Cbilactreult);
			ExtentTestManager.getTest().log(LogStatus.INFO, "CIBIL Suit Filed Cases Actual:" + Cbilresult);
			// test.log(LogStatus.INFO, "CIBIL Suit Filed Cases Result
			// Comparison is "+Cbilresult.equals(Cbilactreult));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(Cbilresult, Cbilactreult);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}
	}

}
