package com.base.pack;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class mainbase extends Utills {

	public static ExtentReports extent;
	public static ExtentTest test;
	public static Properties Repository = new Properties();

	public File f;
	public FileInputStream FI;
	/*
	 * @BeforeSuite public void ram() throws IOException, InterruptedException{
	 * loadPropertiesFile(); selectBrowser(Repository.getProperty("browser"));
	 * impliciteWait(30); driver.get(Repository.getProperty("url"));
	 * impliciteWait(30);
	 * driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(Repository.
	 * getProperty("username"));
	 * driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(Repository.
	 * getProperty("password"));
	 * driver.findElement(By.xpath(".//*[@id='LoginButton']")).click();
	 * Thread.sleep(6000);
	 * driver.findElement(By.xpath("//td[@align='center']")).click();
	 * 
	 * }
	 */

	@BeforeSuite
	public void clickfrist() throws InterruptedException, IOException {

		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		impliciteWait(30);
		driver.get(Repository.getProperty("url"));
		impliciteWait(30);

		WebElement element = driver.findElement(By.xpath(".//*[@id='username']"));
		element.sendKeys(Repository.getProperty("username"));
		mainbase.highLightElement(driver, element);

		WebElement elementse = driver.findElement(By.xpath(".//*[@id='password']"));
		elementse.sendKeys(Repository.getProperty("password"));
		mainbase.highLightElement(driver, elementse);
		driver.findElement(By.xpath(".//*[@id='LoginButton']")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("//td[@align='center']")).click();

		// BalloonPopUp.currentRunningTestCase(testCaseName);
	}

	public WebElement findElement(By by) {
		WebElement elem = driver.findElement(by);
		// draw a border around the found element
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		}
		return elem;
	}

	public void loadPropertiesFile() throws IOException {

		f = new File("D:\\AUTOMATION REQUIRED DOCS\\config.properties");

		// f=new
		// File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");

		FI = new FileInputStream(f);
		Repository.load(FI);
	}

	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}

	public String[][] getTableArray(String xlFilePath, String sheetName, String tableName, String startname)
			throws Exception {
		String[][] tabArray = null;

		Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
		Sheet sheet = workbook.getSheet(sheetName);
		int startRow, startCol, endRow, endCol, ci, cj;
		Cell tableStart = sheet.findCell(tableName);
		startRow = tableStart.getRow();
		startCol = tableStart.getColumn();

		Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);

		endRow = tableEnd.getRow();
		endCol = tableEnd.getColumn();
		System.out.println(
				"startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol + ", endCol=" + endCol);
		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;

		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}

		return (tabArray);
	}

	@AfterMethod
	public void getResult(ITestResult result, ITestContext testContext) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");
			ExtentTestManager.getTest().log(LogStatus.FAIL, result.getThrowable());

		}

		ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
		ExtentManager.getReporter().flush();

	}

}
