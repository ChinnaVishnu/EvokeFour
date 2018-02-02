package com.allclasses;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.google.common.base.Function;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.LogStatus;


public class Harayanapage  {

	
	public WebElement fluentWait(final By locator){
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	        .withTimeout(1, TimeUnit.SECONDS)
	        .pollingEvery(1, TimeUnit.SECONDS)
	        .ignoring(NoSuchElementException.class);
	        

	    WebElement foo = wait.until(
	        new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                return driver.findElement(locator);
	            }
	        }
	    );
	    return foo;
	};

	
	
	public WebDriver driver;
	public Harayanapage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	
	public void clickonHarayana(String Number,String exceptedreult) throws InterruptedException, IOException{
		
		  

		 Thread.sleep(5000);
		  
		  
		// driver.findElement(By.xpath("//a[text()='Address Verification']")).click();	  
		 	  
		 Thread.sleep(9000);
		 driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();


		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Haryana']")).click();

		 Thread.sleep(9000);
		 
	   	
		String mainhandleHaryana=driver.getWindowHandle();

		String childhandleHaryana="";

		Set<String>handlesHaryana  =	driver.getWindowHandles();

		for (String handle : handlesHaryana) {

		if (!handle.equals(mainhandleHaryana)) {
			
			childhandleHaryana=handle;
			
		}


		}

		driver.switchTo().window(childhandleHaryana);	




		driver.findElement(By.xpath(".//*[@id='textAccountNumber']")).sendKeys(Number);

		driver.findElement(By.xpath(".//*[@id='submit']")).click();


		try {
		    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		   try {


		Thread.sleep(45000);
		
		
		 String Harayanasult=exceptedreult; 
		 
		 

String Harayanasultact=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();



Double resPercentage = LetterPairSimilarity.compareStrings(Harayanasultact, Harayanasult);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



if(resPercentage> 0 && (resPercentage*100) > 80){
	
	System.out.println("pass");
	ExtentTestManager.getTest().log(LogStatus.PASS, " Electricity : Haryana  Result is Pass");
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Haryana  Result excepted is started"+Harayanasult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Haryana  Result actual is started"+Harayanasultact);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Haryana  Result  Comparison  is "+Harayanasultact.equals(Harayanasult));
	

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


	String sec=MissingJSON.difference(Harayanasultact, Harayanasult);


	System.out.println(sec);

	ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);	
	
	
}else{
	
	System.out.println("not matching");
	ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : Haryana Result is Fail");
	
	
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Haryana  Result excepted is started"+Harayanasult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Haryana  Result actual is started"+Harayanasultact);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Haryana  Result  Comparison  is "+Harayanasultact.equals(Harayanasult));
	

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	
	
	
	
	
	String sec=MissingJSON.difference(Harayanasultact, Harayanasult);


	System.out.println(sec);

	ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);
	
	
}
		 
		 
		 

		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.ERROR, "Electricity : Haryana Request on site timed out");
				String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.ERROR, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			   
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  } 
				 
		
		
		
		driver.close();
		driver.switchTo().window(mainhandleHaryana);

	  
		//Assert.assertEquals(Harayanasultact, Harayanasult);	  
	



}

}
