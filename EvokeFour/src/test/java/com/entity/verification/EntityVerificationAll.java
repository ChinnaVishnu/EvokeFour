package com.entity.verification;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.ShopActDelhipage;
import com.allclasses.ShopActHarayanapage;
import com.allclasses.ShopActmumbaipage;
import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class EntityVerificationAll extends mainbase {

	// ...............................ShopActDelhi....................................................................................//

	@DataProvider(name = "DP11")
	public Object[][] createData11() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ShopActVerificationDelhi", "ShopActVerificationDelhi");
		return (retObjArr);
	}

	@Test(priority = 23, dataProvider = "DP11")
	public void ShopActVerificationDelhi(String Establishment, String Category, String Locality, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Shop Act : Delhi ");

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();

		ShopActDelhipage shop = new ShopActDelhipage(driver);

		shop.shopactdelhi(Establishment, Category, Locality, Nature, exceptedreult);

	}

	// .................................................ShopActHarayana...............................................................//

	@DataProvider(name = "DP12")
	public Object[][] createData12() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ShopActVerificationHaryana", "ShopActVerificationHaryana");
		return (retObjArr);
	}

	@Test(priority = 24, dataProvider = "DP12")
	public void ShopActVerificationHaryana(String Applicationnumber, String Category, String Locality, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("Shop Act : Haryana ");

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();

		ShopActHarayanapage sh = new ShopActHarayanapage(driver);

		sh.clickshopactharayana(Applicationnumber, exceptedreult);

	}

	// ..........................................................ShopActMumbai......................................................//

	@DataProvider(name = "DP10")
	public Object[][] createData10() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ShopActVerificationMumbai", "ShopActVerificationMumbai");
		return (retObjArr);
	}

	@Test(priority = 25, dataProvider = "DP10")
	public void ShopActVerificationMumbai(String Applicationnumber, String State, String Number, String empty,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("Shop Act : Mumbai ");

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();

		ShopActmumbaipage sh = new ShopActmumbaipage(driver);

		sh.clickmumbai(Applicationnumber, exceptedreult);

	}

	// ...................................CIN(Data.GOv)..............................................................................//

	@DataProvider(name = "DP82")
	public Object[][] createData82() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "CINDatagov",
				"CINDatagov");
		return (retObjArr);
	}

	@Test(priority = 26, dataProvider = "DP82")
	public void Cininputnew(String Number, String Ward, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest(" CIN(Data.gov) ");

		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='  CIN(Data.gov)']/input")).click();
		Thread.sleep(8000);
		driver.findElement(By.xpath(".//*[@id='voterId']")).sendKeys(Number);

		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();

		Thread.sleep(19000);

		String cininputnumber = exceptedreult;

		String cininputnumberresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(cininputnumberresult, cininputnumber);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.PASS, " CIN(Data.gov)  Result is pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, " CIN(Data.gov) Expected:" + cininputnumber);
			ExtentTestManager.getTest().log(LogStatus.INFO, " CIN(Data.gov) Actual:" + cininputnumberresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" CIN(Data.gov) Result Comparison  is " + cininputnumber.equals(cininputnumberresult));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(cininputnumberresult, cininputnumber);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, " CIN(Data.gov)  Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO, " CIN(Data.gov) Expected:" + cininputnumber);
			ExtentTestManager.getTest().log(LogStatus.INFO, " CIN(Data.gov) Input Actual:" + cininputnumberresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" CIN(Data.gov) Result Comparison  is " + cininputnumber.equals(cininputnumberresult));
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Error in identifying page1 :"
					+ test.addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));
			ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :"
					+ test.addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));

		}
	}

	// ................................................... CIN Network Input.........................................................//

	@DataProvider(name = "DP34")
	public Object[][] createData34() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "CINNetworkInput",
				"CINNetworkInput");
		return (retObjArr);
	}

	@Test(priority = 27, dataProvider = "DP34")
	public void Cininput(String cinnumber, String Ward, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest(" CIN Network Input ");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();

		Thread.sleep(4000);

		driver.findElement(By.xpath("//div[text()='  CIN Network Input']/input[@value='cinNetwork']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='cinNet']")).sendKeys(cinnumber);

		driver.findElement(By.xpath(".//*[@id='cinNetwork']/table/tbody/tr[2]/td[2]/input")).click();

		Thread.sleep(12000);

		String cininputnumber = actualresult;

		String cininputnumberresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		// Assert.assertEquals(cininputnumberresult, cininputnumber);

		// Assert.assertTrue(cininputnumber.contains(cininputnumberresult));
		System.out.println(cininputnumber.equals(cininputnumberresult));
		Double resPercentage = LetterPairSimilarity.compareStrings(cininputnumberresult, cininputnumber);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.PASS, " Cin Input  Result is pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, " Cin Input Expected:" + cininputnumber);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Cin Input Actual:" + cininputnumberresult);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					" Cin Input Result Comparison  is " + cininputnumber.equals(cininputnumberresult));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(cininputnumberresult, cininputnumber);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Cin Input  Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO, " Cin Input Expected:" + cininputnumber);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Cin Input Actual:" + cininputnumberresult);
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Error in identifying page1 :"
					+ test.addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(cininputnumberresult, cininputnumber);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

	}

	// ............................................. Importer Exporter...........................................................//

	@DataProvider(name = "DP28")
	public Object[][] createData28() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ImporterExporterCode", "ImporterExporterCode");
		return (retObjArr);
	}

	@Test(priority = 28, dataProvider = "DP28")
	public void ImpoterExpotercode(String Number, String Name, String AC, String Nature, String exceptedreult,
			String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest(" Importer Exporter Code ");

		Thread.sleep(9000);
		driver.findElement(By.xpath("//a[text()='Entity Verification']")).click();

		driver.findElement(By.xpath("//div[text()='  Importer Exporter Code']/input[@value='getIecInfo']")).click();

		/*
		 * driver.findElement(By.xpath(
		 * "//td[text()='Importer Exporter Code ']/input")).click();
		 */
		driver.findElement(By.xpath(".//*[@id='iec']")).sendKeys(Number);

		driver.findElement(By.xpath(".//*[@id='name']")).sendKeys(Name);

		driver.findElement(By.xpath(".//*[@id='iecview']/table/tbody/tr[4]/td[2]/input")).click();

		// waitForAjax(5);

		Thread.sleep(80000);
		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);

		String voteridImporter = exceptedreult;

		String voteridImporterresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(voteridImporterresult, voteridImporter);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			System.out.println("pass");
			ExtentTestManager.getTest().log(LogStatus.PASS, " Importer Exporter Code Result is Pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, " Importer Exporter Code Expected:" + voteridImporter);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Importer Exporter Code Actual:" + voteridImporterresult);
			// test.log(LogStatus.INFO, " Importer Exporter Code Result
			// Comparison is "+voteridImporterresult.equals(voteridImporter));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(voteridImporterresult, voteridImporter);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Importer Exporter Code Verification Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO, " Importer Exporter Code Expected:" + voteridImporter);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Importer Exporter Code Actual:" + voteridImporterresult);

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(voteridImporterresult, voteridImporter);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}

	}

}
