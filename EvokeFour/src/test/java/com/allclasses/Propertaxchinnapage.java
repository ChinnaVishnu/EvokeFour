package com.allclasses;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.relevantcodes.extentreports.LogStatus;



public class Propertaxchinnapage  {

	
	
	WebDriver driver;
	public Propertaxchinnapage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public void clickchinnatax(String Zone,String Ward,String Bill ,String exceptedreult) throws InterruptedException{
		
		//driver.findElement(By.xpath("//a[text()='  Financial/Tax/Legal']")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[text()='Legal']")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  PropertyTax Verification']/input")).click();

		
		Thread.sleep(6000);

		 	
		
		driver.findElement(By.xpath(".//*[@id='TaxIdDetails']/div[1]/a[3]")).click();
		String mainhandleChennai=driver.getWindowHandle();

		String childhandleChennai="";

		Set<String>handlesChennai=driver.getWindowHandles();

		for (String handle : handlesChennai) {

		if (!handle.equals(mainhandleChennai)) {

		childhandleChennai=handle;

		}


		}

		driver.switchTo().window(childhandleChennai);	

		driver.findElement(By.xpath(".//*[@id='chn_zone']")).sendKeys(Zone);

		driver.findElement(By.xpath(".//*[@id='chn_ward']")).sendKeys(Ward);

		driver.findElement(By.xpath(".//*[@id='chn_bill_number']")).sendKeys(Bill);

		driver.findElement(By.xpath(".//*[@id='submit']")).click();

		

		try {
		    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		   try {
			   
			   
			   Thread.sleep(26000);
			   
			   String prpchinnnatax=exceptedreult; 
			   String prpchinnnataxresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText(); 

			   Double resPercentage = LetterPairSimilarity.compareStrings(prpchinnnataxresult, prpchinnnatax);

				System.out.println("resPercentage "+resPercentage*100);
				String total=Double.toString(resPercentage*100);

				ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
				


				if(resPercentage> 0 && (resPercentage*100) > 80){
			System.out.println("pass");

		ExtentTestManager.getTest().log(LogStatus.PASS, "PropertyTax : Chennai  Result is pass");

		ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Chennai  excepted is started"+prpchinnnatax);
		ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Chennai  actual is started"+prpchinnnataxresult);
		ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Chennai  Result Comparison  is "+prpchinnnataxresult.equals(prpchinnnatax));


		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
		String sec=MissingJSON.difference(prpchinnnataxresult, prpchinnnatax);


		System.out.println(sec);

		ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 



		}else{

		System.out.println("not matching");
		ExtentTestManager.getTest().log(LogStatus.FAIL, " PropertyTax : Chennai Result is Fail");

		ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Chennai  excepted is started"+prpchinnnatax);
		ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Chennai  actual is started"+prpchinnnataxresult);
		ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Chennai  Result Comparison  is "+prpchinnnataxresult.equals(prpchinnnatax));
		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		
		
		String sec=MissingJSON.difference(prpchinnnataxresult, prpchinnnatax);


		System.out.println(sec);

		ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		
		}
			   
			   
		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.ERROR, "PropertyTax : Chennai Request on site timed out");
			   
			   
				String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


			   
			   
			   
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }





		driver.close();
		driver.switchTo().window(mainhandleChennai);;	

		//Assert.assertEquals(prpchinnnataxresult, prpchinnnatax);


		}
		
	}
	
	


