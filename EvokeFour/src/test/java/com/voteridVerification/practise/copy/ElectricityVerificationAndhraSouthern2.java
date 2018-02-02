package com.voteridVerification.practise.copy;

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
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class ElectricityVerificationAndhraSouthern2 extends mainbase {

	
	
	@DataProvider(name = "DP9")
	public Object[][] createData9() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"ElectricityVerificationAPSouthern", "ElectricityVerificationAPSouthern");
		return (retObjArr);
	}

	@Test(priority = 15, dataProvider = "DP9")
	public void ElectricityAndhraPradeshEstern(String PowerDistribution, String ServiceNumber, String Bill, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Electricity Verification :Andhra Pradesh(Southern) ");
		//Thread.sleep(8000);

		//driver.findElement(By.xpath("//div[4]/div")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("//a[text()='Andhra Pradesh']")).click();
		Thread.sleep(7000);
		
		
		
		

		/*
		 * driver.findElement(By.xpath(
		 * "//td[text()='Electricity Verification']/input")).click();
		 * 
		 * Thread.sleep(7000); driver.findElement(By.xpath(
		 * ".//*[@id='electricityDetails']/table/tbody/tr[1]/td[1]/a")).click();
		 */

		String mainhandleandhra = driver.getWindowHandle();

		String childhandleAndhra = "";

		Set<String> handlesandhra = driver.getWindowHandles();

		for (String handle : handlesandhra) {

			if (!handle.equals(mainhandleandhra)) {

				childhandleAndhra = handle;

			}

		}

		driver.switchTo().window(childhandleAndhra);


				Thread.sleep(8000);
				WebElement element = driver.findElement(By.xpath("//select[@onchange='selectPowerDistribution()']"));

				Select select = new Select(element);

				select.selectByVisibleText(PowerDistribution);

				Thread.sleep(8000);
				driver.findElement(By.xpath("//input[@id='electricityNo2']")).sendKeys(ServiceNumber);

				
		String att=		driver.findElement(By.xpath("//img[@id='captchasouth']")).getAttribute("src");
				System.out.println("image url"+att);
				
				
				driver.findElement(By.xpath("//input[@id='captchaCodeSouth']")).sendKeys(att);
				
				//Thread.sleep(10000);
				 Thread.sleep(10000);

			driver.findElement(By.xpath(".//*[@id='electricitySouthernDiv']/div/span[1]/input")).click();

			
			 Thread.sleep(20000);
		driver.close();
		driver.switchTo().window(mainhandleandhra);
		// Assert.assertEquals(electricitytamilnaduactualresult,
		// electricitytamilnadu);

	}
}
