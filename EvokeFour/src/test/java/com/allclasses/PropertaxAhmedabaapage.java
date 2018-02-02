package com.allclasses;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.relevantcodes.extentreports.LogStatus;



public class PropertaxAhmedabaapage  {

	
	WebDriver driver;
	public PropertaxAhmedabaapage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	
	public void clickpropAhamabad(String Tenement,String exceptedreult ) throws InterruptedException, IOException{
		
		
		Thread.sleep(6000);

	
		
		driver.findElement(By.xpath("//div[2]/div/div[3]/div")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[text()='Legal']")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  PropertyTax Verification']/input")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='TaxIdDetails']/div[1]/a[1]")).click();
		
		Thread.sleep(6000);
		
		String mainhandle=driver.getWindowHandle();

		String childhandle="";

		Set<String>handles=	driver.getWindowHandles();

		for (String handle : handles) {

		if (!handle.equals(mainhandle)) {
			
			childhandle=handle;
			
		}


		}

		driver.switchTo().window(childhandle);	

	  driver.findElement(By.xpath("//input[@id='ahm_taxId']")).sendKeys(Tenement);
	  
	  
	  
	  driver.findElement(By.xpath("//button[@id='submit']")).click();
	  
	  


		try {
		    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		   try {
			

			Thread.sleep(30000);
				
			String prpAhanbad=exceptedreult; 
			
			
			
			String prpAhanbadresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

			 Double resPercentage = LetterPairSimilarity.compareStrings(prpAhanbadresult, prpAhanbad);

				System.out.println("resPercentage "+resPercentage*100);
				String total=Double.toString(resPercentage*100);

				ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
				


				if(resPercentage> 0 && (resPercentage*100) > 80){
			System.out.println("pass");
			
			


			ExtentTestManager.getTest().log(LogStatus.PASS, "PropertyTax : Ahmedabad  Result is pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Ahmedabad Expected:"+prpAhanbad);
			ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Ahmedabad  Actual:"+prpAhanbadresult);
		//test.log(LogStatus.INFO, " PropertyTax : Ahmedabad   Result Comparison  is "+prpAhanbadresult.equals(prpAhanbad));


			String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


		

		//MissingJSON m=new MissingJSON();
		   String sec=MissingJSON.difference(prpAhanbadresult, prpAhanbad);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
			
			
			
			
			
			
			}else{

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "PropertyTax : Ahmedabad   Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Ahmedabad Expected:"+prpAhanbad);
			ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Ahmedabad  Actual:"+prpAhanbadresult);
			//ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Ahmedabad   Result Comparison  is "+prpAhanbadresult.equals(prpAhanbad));
			String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


			
			
			//MissingJSON m=new MissingJSON();
			   String sec=MissingJSON.difference(prpAhanbadresult, prpAhanbad);


			   System.out.println(sec);

			   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
			
			
			
			
			}

			

			 
		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Ahmedabad Request on site timed out");
			   
				String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


			   
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }
			
			
			
			
			driver.close();
			
			driver.switchTo().window(mainhandle);

			//Assert.assertEquals(prpAhanbadresult, prpAhanbad);


		}	
	
}
