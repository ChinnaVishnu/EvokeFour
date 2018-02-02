package com.electricity.address;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.FormBsnlInfopage;
import com.allclasses.Harayanapage;
import com.allclasses.Himachalpradeshele;
import com.allclasses.Jharkhandelepage;
import com.allclasses.Keralaapage;
import com.allclasses.Madayaprdesheelepage;
import com.allclasses.Rajasthanelectrpage;
import com.allclasses.Telanganaelepage;
import com.allclasses.karanatakaelectpage;
import com.allclasses.punjablepage;
import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class ElectricityChhattisgarhAll extends mainbase {

	// .........................................ElectricityChattisgh...................................................................//

	@DataProvider(name = "DP39")
	public Object[][] createData39() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationChhattisgarh", "ElectricityVerificationChhattisgarh");
		return (retObjArr);
	}

	@Test(priority = 29, dataProvider = "DP39")
	public void ElectricityChhattisgarh(String Account, String Numberse, String Bill, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Electricity : Chhattisgarh ");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//div[4]/div")).click();

		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Chhattisgarh']")).click();

		Thread.sleep(9000);

		String mainhandleChhattisgarch = driver.getWindowHandle();

		String childhandleChhattisgarch = "";

		Set<String> handlesChhattisgarch = driver.getWindowHandles();

		for (String handle : handlesChhattisgarch) {

			if (!handle.equals(mainhandleChhattisgarch)) {

				childhandleChhattisgarch = handle;

			}

		}

		driver.switchTo().window(childhandleChhattisgarch);

		driver.findElement(By.xpath(".//*[@id='ctl00_maincontent_txtBillpayment']")).sendKeys(Account);

		driver.findElement(By.xpath(".//*[@id='submit']")).click();

		try {
			driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			try {

				Thread.sleep(7000);

				driver.manage().window().maximize();

				Thread.sleep(2000);
				String Chhattisgareleresult = exceptedreult;

				String Chhattisgareleresultact = driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

				Double resPercentage = LetterPairSimilarity.compareStrings(Chhattisgareleresultact,
						Chhattisgareleresult);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

				if (resPercentage > 0 && (resPercentage * 100) > 80) {

					System.out.println("pass");

					ExtentTestManager.getTest().log(LogStatus.PASS, " Electricity : Chhattisgarh Result is Pass");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							" Electricity : Chhattisgarh Result excepted is started" + Chhattisgareleresult);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" Electricity : Chhattisgarh Result actual is started" + Chhattisgareleresultact);
					// ExtentTestManager.getTest().log(LogStatus.INFO, "
					// Electricity : Chhattisgarh Result Comparison is
					// "+Chhattisgareleresult.equals(Chhattisgareleresultact));

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					String sec = MissingJSON.difference(Chhattisgareleresultact, Chhattisgareleresult);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				} else {

					System.out.println("not matching");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : Chhattisgarh Result is Fail");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							" Electricity : Chhattisgarh Result excepted is started" + Chhattisgareleresult);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" Electricity : Chhattisgarh Result actual is started" + Chhattisgareleresultact);
					ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Chhattisgarh Result Comparison  is "
							+ Chhattisgareleresult.equals(Chhattisgareleresultact));

					String sec = MissingJSON.difference(Chhattisgareleresultact, Chhattisgareleresult);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				}

			} catch (Exception e) {

				ExtentTestManager.getTest().log(LogStatus.ERROR,
						"Electricity : Chhattisgarh Source website is busy! Please try after some time");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (Exception e) {
			System.out.println("no page");
			System.out.println(e);
		}

		driver.close();
		driver.switchTo().window(mainhandleChhattisgarch);
		;

		// Assert.assertEquals(Chhattisgareleresultact, Chhattisgareleresult);

	}

	// ....................................................................................electricityGoa.............................//

	@DataProvider(name = "DP3")
	public Object[][] createData3() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationGoa", "ElectricityVerificationGoa");
		return (retObjArr);
	}

	@Test(priority = 30, dataProvider = "DP3")
	public void ElectricityGoA(String ConsumerNumber, String BU, String Number, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Electricity : GoA ");

		Thread.sleep(5000);

		// driver.findElement(By.xpath("//a[text()='Address
		// Verification']")).click();

		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Goa']")).click();

		Thread.sleep(9000);

		String mainhandle = driver.getWindowHandle();

		String childhandle = "";

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {

			if (!handle.equals(mainhandle)) {

				childhandle = handle;

			}

		}

		driver.switchTo().window(childhandle);

		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='consumerID_GA']")).sendKeys(ConsumerNumber);

		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='submit']")).click();

		// Thread.sleep(13000);

		try {
			driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			try {

				Thread.sleep(30000);

				String elegoaexcepted = exceptedreult;

				String elegoaactualresult = driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

				Double resPercentage = LetterPairSimilarity.compareStrings(elegoaactualresult, elegoaexcepted);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

				if (resPercentage > 0 && (resPercentage * 100) > 80) {

					System.out.println("pass");

					System.out.println("pass");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Electricity : GoA excepted is started" + elegoaexcepted);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Electricity : GoA actual is started" + elegoaactualresult);
					// ExtentTestManager.getTest().log(LogStatus.INFO,
					// "Electricity : GoA Result Comparison is
					// "+elegoaactualresult.equals(elegoaexcepted));
					ExtentTestManager.getTest().log(LogStatus.PASS, "Electricity : GoA Result is Pass");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					String sec = MissingJSON.difference(elegoaactualresult, elegoaexcepted);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				} else {

					System.out.println("not matching");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Electricity : GoA excepted is started" + elegoaexcepted);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Electricity : GoA actual is started" + elegoaactualresult);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Electricity : GoA Result Comparison  is " + elegoaactualresult.equals(elegoaexcepted));

					ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : GoA Result is Fail");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					String sec = MissingJSON.difference(elegoaactualresult, elegoaexcepted);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				}

			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.ERROR, "Electricity : GoA  Request on site timed out");

				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (Exception e) {
			System.out.println("no page");
			System.out.println(e);
		}

		driver.close();

		driver.switchTo().window(mainhandle);
		// Assert.assertEquals(elegoaactualresult, elegoaexcepted);

	}

	// .......................................................electricitymaharastricty.............................................//
	@DataProvider(name = "DP58")
	public Object[][] createData58() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationMaharashtra", "ElectricityVerificationMaharashtra");
		return (retObjArr);
	}

	@Test(priority = 31, dataProvider = "DP58")
	public void ElectricityMaharashtra(String ConsumerNumber, String BU, String Number, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Electricity : Maharashtra ");

		Thread.sleep(5000);

		// driver.findElement(By.xpath("//a[text()='Address
		// Verification']")).click();

		Thread.sleep(9000);
		driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Maharashtra']")).click();

		Thread.sleep(9000);

		String mainhandle = driver.getWindowHandle();

		String childhandle = "";

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {

			if (!handle.equals(mainhandle)) {

				childhandle = handle;

			}

		}

		driver.switchTo().window(childhandle);

		driver.findElement(By.xpath(".//*[@id='consumerNo']")).sendKeys(ConsumerNumber);

		WebElement elementelectmaha = driver.findElement(By.xpath(".//*[@id='billingNo']"));
		Select selectdriv = new Select(elementelectmaha);

		selectdriv.selectByVisibleText(BU);

		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='submit']")).click();

		// Thread.sleep(13000);

		try {
			driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			try {

				Thread.sleep(60000);

				String elemaharastraexcepted = exceptedreult;

				String elemaharastractualresult = driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

				Double resPercentage = LetterPairSimilarity.compareStrings(elemaharastractualresult,
						elemaharastraexcepted);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

				if (resPercentage > 0 && (resPercentage * 100) > 80) {

					System.out.println("pass");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Electricity : Maharashtra excepted is started" + elemaharastraexcepted);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Electricity : Maharashtra actual is started" + elemaharastractualresult);
					// ExtentTestManager.getTest().log(LogStatus.INFO,
					// "Electricity : Maharashtra Result Comparison is
					// "+elemaharastractualresult.equals(elemaharastraexcepted));
					ExtentTestManager.getTest().log(LogStatus.PASS, "Electricity : Maharashtra Result is Pass");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));
					String sec = MissingJSON.difference(elemaharastractualresult, elemaharastraexcepted);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				} else {

					System.out.println("not matching");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Electricity : Maharashtra excepted is started" + elemaharastraexcepted);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Electricity : Maharashtra actual is started" + elemaharastractualresult);
					ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : Maharashtra Result Comparison  is "
							+ elemaharastractualresult.equals(elemaharastraexcepted));

					ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : Maharashtra Result is Fail");
					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					String sec = MissingJSON.difference(elemaharastractualresult, elemaharastraexcepted);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				}

			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.ERROR,
						"Electricity : Maharashtra  Request on site timed out");
				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (Exception e) {
			System.out.println("no page");
			System.out.println(e);
		}

		driver.close();

		driver.switchTo().window(mainhandle);
		// Assert.assertEquals(elemaharastractualresult, elemaharastraexcepted);

	}

	// ........................................................electricityHarayana...................................................//
	@DataProvider(name = "DP44")
	public Object[][] createData44() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationHaryana", "ElectricityVerificationHaryana");
		return (retObjArr);
	}

	@Test(priority = 32, dataProvider = "DP44")
	public void ElectricityHaryana(String Number, String Ward, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Electricity : Haryana ");

		Harayanapage vo = new Harayanapage(driver);

		vo.clickonHarayana(Number, exceptedreult);

	}

	// ......................................electricityHimacahalaparades,.........................................................//

	@DataProvider(name = "DP42")
	public Object[][] createData42() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationHimachalPradesh", "ElectricityVerificationHimachalPradesh");
		return (retObjArr);
	}

	@Test(priority = 33, dataProvider = "DP42")
	public void ElectricityHimachal(String Number, String Ward, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult) throws InterruptedException {

		ExtentTestManager.startTest(" Electricity : Himachal Pradesh ");

		Himachalpradeshele vo = new Himachalpradeshele(driver);

		vo.clickHimachalpradesh(Number, exceptedreult);

	}

	// .....................................................................................electricityJharakhad..........................//

	@DataProvider(name = "DP41")
	public Object[][] createData41() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationJharkhand", "ElectricityVerificationJharkhand");
		return (retObjArr);
	}

	@Test(priority = 34, dataProvider = "DP41")
	public void ElectricityJharkhand(String Number, String Email, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Electricity : Jharkhand ");

		Jharkhandelepage vo = new Jharkhandelepage(driver);

		vo.Jharkhandelepage(Number, exceptedreult);

	}

	// .....................................................electricityKaranakata...........................................//

	@DataProvider(name = "DP36")
	public Object[][] createData36() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationKarnataka", "ElectricityVerificationKarnataka");
		return (retObjArr);
	}

	@Test(priority = 35, dataProvider = "DP36")
	public void ElectricityKarnataka(String Account, String Number, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult) throws InterruptedException, IOException {

		ExtentTestManager.startTest("Electricity: Karnataka ");

		karanatakaelectpage vo = new karanatakaelectpage(driver);

		vo.clickkarantaka(Account, exceptedreult);

	}

	// ...............................................................electricityKerala............................................//

	@DataProvider(name = "DP45")
	public Object[][] createData45() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationKerala", "ElectricityVerificationKerala");
		return (retObjArr);
	}

	@Test(priority = 36, dataProvider = "DP45")
	public void ElectricityKerala(String Number, String Ward, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult) throws InterruptedException, IOException {

		ExtentTestManager.startTest(" Electricity : Kerala ");

		Keralaapage vo = new Keralaapage(driver);

		vo.clikkerala(Number, Ward, Bill, exceptedreult);

	}

	// .........................................................ElectrictyMadayapradesh.........................................//

	@DataProvider(name = "DP38")
	public Object[][] createData38() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationMadhyaPradesh", "ElectricityVerificationMadhyaPradesh");
		return (retObjArr);
	}

	@Test(priority = 37, dataProvider = "DP38")
	public void ElectricityMadhyaPradesh(String IVRS, String Numberse, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult) throws WriteException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Electricity : Madhya Pradesh ");

		Madayaprdesheelepage vo = new Madayaprdesheelepage(driver);

		vo.clickmadayapradesh(IVRS, exceptedreult);

	}

	// ....................................ElectrictyPunjaba........................................................................//

	@DataProvider(name = "DP43")
	public Object[][] createData43() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationPunjab", "ElectricityVerificationPunjab");
		return (retObjArr);
	}

	@Test(priority = 38, dataProvider = "DP43")
	public void ElectricityPunjab(String Account, String Ward, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest(" Electricity : Punjab ");

		punjablepage vo = new punjablepage(driver);

		vo.clickpujejabele(Account, exceptedreult);

	}

	// .............................................................electricityRajastahn.........................................//

	@DataProvider(name = "DP40")
	public Object[][] createData40() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationRajasthan", "ElectricityVerificationRajasthan");
		return (retObjArr);
	}

	@Test(priority = 39, dataProvider = "DP40")
	public void ElectricityRajasthan(String Number, String Email, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult) throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Electricity : Rajasthan");

		Rajasthanelectrpage vo = new Rajasthanelectrpage(driver);

		vo.clickrajasthanele(Number, Email, exceptedreult);

	}

	// ......................................electricityTelanaga............................................................//

	@DataProvider(name = "DP37")
	public Object[][] createData37() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationTelangana", "ElectricityVerificationTelangana");
		return (retObjArr);
	}

	@Test(priority = 40, dataProvider = "DP37")
	public void ElectricityTelangana(String Number, String Numberse, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("Electricity : Telangana ");

		Telanganaelepage vo = new Telanganaelepage(driver);

		vo.clicktelangana(Number, exceptedreult);

	}

	// ......................................electricityAndhrapradesh............................................................//

	@DataProvider(name = "DP35")
	public Object[][] createData35() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationAndhraPradesh", "ElectricityVerificationAndhraPradesh");
		return (retObjArr);
	}

	@Test(priority = 41, dataProvider = "DP35")
	public void ElectricityAndhraPradesh(String Power, String Number, String Bill, String Nature, String exceptedreult,
			String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Electricity : Andhra Pradesh(Southern power)  ");

		Thread.sleep(9000);

		// driver.findElement(By.xpath("//a[text()='Address
		// Verification']")).click();

		// Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Andhra Pradesh']")).click();

		String mainhandleandhra = driver.getWindowHandle();

		String childhandleAndhra = "";

		Set<String> handlesandhra = driver.getWindowHandles();

		for (String handle : handlesandhra) {

			if (!handle.equals(mainhandleandhra)) {

				childhandleAndhra = handle;

			}

		}

		driver.switchTo().window(childhandleAndhra);

		Thread.sleep(3000);

		WebElement element = driver.findElement(By.xpath("//select[@onchange='selectPowerDistribution()']"));

		Select select = new Select(element);

		select.selectByVisibleText(Power);

		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='electricityNo2']")).sendKeys(Number);

		driver.findElement(By.xpath(".//*[@id='electricitySouthernDiv']/div/span[1]/input")).click();

		try {
			driver.manage().timeouts().pageLoadTimeout(75000, TimeUnit.MILLISECONDS);
			try {

				Thread.sleep(13000);
				String electryandhrapradesh = exceptedreult;

				String electryandhrapradeshresult = driver.findElement(By.xpath(".//*[@id='result']")).getText();

				Double resPercentage = LetterPairSimilarity.compareStrings(electryandhrapradeshresult,
						electryandhrapradesh);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

				if (resPercentage > 0 && (resPercentage * 100) > 80) {
					System.out.println("pass");

					ExtentTestManager.getTest().log(LogStatus.PASS, "Electricity: Andhra  Pradesh Result is Pass");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							" Electricity: Andhra  Pradesh  result excepted is started" + electryandhrapradesh);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" Electricity: Andhra  Pradesh  result resultactual is started"
									+ electryandhrapradeshresult);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" Electricity: Andhra  Pradesh  result Result Comparison  is "
									+ electryandhrapradeshresult.equals(electryandhrapradesh));

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					String sec = MissingJSON.difference(electryandhrapradeshresult, electryandhrapradesh);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				} else {

					System.out.println("not matching");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity: Andhra  Pradesh Result is Fail");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							" Electricity: Andhra  Pradesh  result excepted is started" + electryandhrapradesh);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" Electricity: Andhra  Pradesh  result resultactual is started"
									+ electryandhrapradeshresult);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							" Electricity: Andhra  Pradesh  result Result Comparison  is "
									+ electryandhrapradeshresult.equals(electryandhrapradesh));
					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

					String sec = MissingJSON.difference(electryandhrapradeshresult, electryandhrapradesh);

					System.out.println(sec);

					ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

				}

			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.ERROR,
						"Electricity : Andhra  Pradesh(Southern power)  Request on site timed out");
				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS,
						"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (Exception e) {
			System.out.println("no page");
			System.out.println(e);
		}

		driver.close();

		driver.switchTo().window(mainhandleandhra);

		// Assert.assertEquals(electryandhrapradeshresult,
		// electryandhrapradesh);

	}

	// ............................................BSNLLANDLine......................................................................//

	// ............................................................FormBsnlLandline
	// .....................................................................//

	@DataProvider(name = "DP6")
	public Object[][] createData6() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"FormBSNLLandline", "FormBSNLLandline");
		return (retObjArr);
	}

	@Test(priority = 42, dataProvider = "DP6")
	public void FormBsnlLandline(String IDType, String Bsnlone, String bsnltwo, String Gender, String exceptedreult,
			String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest("FORM : BSNL-Info ");

		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[text()='  BSNL Landline']/input")).click();

		Thread.sleep(7000);

		driver.findElement(By.xpath(".//*[@id='stdCode']")).sendKeys(Bsnlone);

		driver.findElement(By.xpath(".//*[@id='landlineNo']")).sendKeys(bsnltwo);
		Thread.sleep(7000);

		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();

		Thread.sleep(29000);

		String FormBsnlLandline = exceptedreult;

		String FormBsnlLandlineresult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(FormBsnlLandlineresult, FormBsnlLandline);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {
			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : BSNL-Info Expected:" + FormBsnlLandline);
			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : BSNL-Info Actual:" + FormBsnlLandlineresult);
			ExtentTestManager.getTest().log(LogStatus.PASS, "FORM : BSNL-Info Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(FormBsnlLandlineresult, FormBsnlLandline);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "FORM : BSNL-Info  Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : BSNL-Info Expected:" + FormBsnlLandline);
			ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : BSNL-Info Actual:" + FormBsnlLandlineresult);

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));
			String sec = MissingJSON.difference(FormBsnlLandlineresult, FormBsnlLandline);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}
	}

	// ................................................LPGGasDetails..............................................................//

	@DataProvider(name = "DP61")
	public Object[][] createData61() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "LPGDetails",
				"LPGDetails");
		return (retObjArr);
	}

	@Test(priority = 43, dataProvider = "DP61")
	public void FormLPGDetails(String IDType, String Number, String empty, String Nature, String exceptedreult,
			String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest(" Form : LPG-Info ");

		// Thread.sleep(7000);
		// driver.findElement(By.xpath("//div[2]/div[3]/div")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[text()='Govt. Sources']")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[text()='  LPG Details']/input")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='voterId']")).sendKeys(Number);

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();

		Thread.sleep(92000);

		// waitForAjax(5);

		String FormLPGresult = exceptedreult;

		String FORMLPGactRe = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(FORMLPGactRe, FormLPGresult);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : LPG-Info  Expected:" + FormLPGresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : LPG-Info  Actual:" + FORMLPGactRe);
			// ExtentTestManager.getTest().log(LogStatus.INFO, "Form : LPG-Info
			// Result Comparison is "+FormLPGresult.equals(FORMLPGactRe));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Form : LPG-Info   Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(FORMLPGactRe, FormLPGresult);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Form : LPG-Info   Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : LPG-Info  Expected:" + FormLPGresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : LPG-Info  Actual:" + FORMLPGactRe);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Form : LPG-Info  Result Comparison  is " + FormLPGresult.equals(FORMLPGactRe));

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(FORMLPGactRe, FormLPGresult);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}
	}

	// ................................WaterBill....................................................................................//

	@DataProvider(name = "DP63")
	public Object[][] createData63() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login", "WaterBill",
				"WaterBill");
		return (retObjArr);
	}

	@Test(priority = 44, dataProvider = "DP63")
	public void FormWaterbillinfo(String FormIdtype, String State, String FormIdNumber, String empty,
			String exceptedreult, String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest(" Form : WaterBill-Info ");

		// Thread.sleep(7000);
		// driver.findElement(By.xpath("//div[2]/div[3]/div")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[text()='Govt. Sources']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='  Water Bill']/input")).click();

		Thread.sleep(4000);

		WebElement elementstate = driver.findElement(By.xpath(".//*[@id='wbstate']"));

		Select selectstate = new Select(elementstate);

		selectstate.selectByVisibleText(State);

		driver.findElement(By.xpath(".//*[@id='voterId']")).sendKeys(FormIdNumber);

		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();

		// waitForAjax(5);

		Thread.sleep(54000);

		String Formwaterbillinforesult = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();
		String waterbillresult = exceptedreult;

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(Formwaterbillinforesult, waterbillresult);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {
			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : WaterBill-Info Expected:" + waterbillresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : WaterBill-Info Actual:" + Formwaterbillinforesult);
			// test.log(LogStatus.INFO, "Form : WaterBill-Info Result Comparison
			// is "+Formwaterbillinforesult.equals(waterbillresult));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Form : WaterBill-Info Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(Formwaterbillinforesult, waterbillresult);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Form : WaterBill-Info  Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : WaterBill-Info Expected:" + waterbillresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : WaterBill-Info Actual:" + Formwaterbillinforesult);

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(Formwaterbillinforesult, waterbillresult);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}
	}

	// ...................................................Pincodeinformation.........................................................//

	@DataProvider(name = "DP60")
	public Object[][] createData60() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"FormPincodenInformation", "FormPincodenInformation");
		return (retObjArr);
	}

	@Test(priority = 45, dataProvider = "DP60")
	public void FormPincodenInMatchion(String Type, String Number, String empty, String Nature, String exceptedreult,
			String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest(" Form : PinCode-Info  ");

		Thread.sleep(19000);

		// driver.findElement(By.xpath("//div[2]/div[3]/div")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Private Sources']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='  Pincode Verification']/input")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(".//*[@id='pincode']")).sendKeys(Number);

		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();

		// waitForAjax(5);
		Thread.sleep(59000);

		String FormpininfoApi = exceptedreult;

		String FORMpinbillinfo = driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

		// driver.navigate().refresh();

		Double resPercentage = LetterPairSimilarity.compareStrings(FORMpinbillinfo, FormpininfoApi);

		System.out.println("resPercentage " + resPercentage * 100);
		String total = Double.toString(resPercentage * 100);

		ExtentTestManager.getTest().log(LogStatus.INFO, "<b>" + "Expected VS Actual (%) :" + total + "</b>\n");

		if (resPercentage > 0 && (resPercentage * 100) > 80) {

			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : PinCode-Info Expected:" + FormpininfoApi);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : PinCode-Info Actual:" + FORMpinbillinfo);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Form : PinCode-Info Result Comparison  is " + FORMpinbillinfo.equals(FormpininfoApi));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Form : PinCode-Info Result is Pass");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			// MissingJSON m=new MissingJSON();
			String sec = MissingJSON.difference(FORMpinbillinfo, FormpininfoApi);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		} else {

			System.out.println("not matching");
			test.log(LogStatus.FAIL, "Form : PinCode-Info  Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : PinCode-Info Expected:" + FormpininfoApi);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Form : PinCode-Info Actual:" + FORMpinbillinfo);
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Form : PinCode-Info Result Comparison  is " + FORMpinbillinfo.equals(FormpininfoApi));
			ExtentTestManager.getTest().log(LogStatus.PASS, "Form : PinCode-Info Result is Fail");

			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS,
					"Screenshortbelow :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			String sec = MissingJSON.difference(FORMpinbillinfo, FormpininfoApi);

			System.out.println(sec);

			ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : " + sec);

		}
	}

}
