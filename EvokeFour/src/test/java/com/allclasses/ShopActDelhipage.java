package com.allclasses;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.LogStatus;



public class ShopActDelhipage {

	
	
	
	public WebDriver driver;
	public ShopActDelhipage(WebDriver driver) {
		super();
		
		
		this.driver=driver;
	}

	
	public void shopactdelhi(String Establishment,String Category ,String Locality  ,String Nature,String exceptedreult ) throws InterruptedException, IOException{

		  
		Thread.sleep(5000);
		 driver.findElement(By.xpath("//div[text()='  Shop Act Verification']/input")).click();

		 Thread.sleep(2000);
		 driver.findElement(By.xpath(".//*[@id='shopActDetails']/div[2]/a")).click();
		  
		  String mainhandleDelhi=driver.getWindowHandle();

		  String childhandleDelhi="";

		  Set<String>handlesDelhi=	driver.getWindowHandles();

		  for (String handle : handlesDelhi) {

		  if (!handle.equals(mainhandleDelhi)) {
		  	
			  childhandleDelhi=handle;
		  	
		  }


		  }


		  driver.switchTo().window(childhandleDelhi);	

		  
		  
		  
		  driver.findElement(By.xpath(".//*[@id='appNo']")).sendKeys(Establishment);
		  
		 WebElement elementcat= driver.findElement(By.xpath(".//*[@id='shopCategory']"));
		  
		  
			Select selectcategory=new Select(elementcat);

			selectcategory.selectByVisibleText(Category);
			
			
		driver.findElement(By.xpath(".//*[@id='lcal']")).sendKeys(Locality);


		WebElement elementnature=driver.findElement(By.xpath(".//*[@id='nobid']"));


		Select selectnature=new Select(elementnature);

		selectnature.selectByVisibleText(Nature);
		  
		driver.findElement(By.xpath(".//*[@id='cinDiv']/div/span[1]/input")).click();

		 
		 try {
			    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			   try {
		Thread.sleep(35000);

		
		String expexctedshopdelhi=exceptedreult;
		
		
		
		String ShopActDelhiresult=driver.findElement(By.xpath(".//*[@id='result']")).getText();

		  
		Double resPercentage = LetterPairSimilarity.compareStrings(ShopActDelhiresult, expexctedshopdelhi);

		System.out.println("resPercentage "+resPercentage*100);
		String total=Double.toString(resPercentage*100);

		ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



		if(resPercentage> 0 && (resPercentage*100) > 80){
			
			System.out.println("pass");
			

		System.out.println("pass");
		   

	ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Delhi excepted is started"+expexctedshopdelhi);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Delhi actual is started"+ShopActDelhiresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Delhi Result Comparison  is "+ShopActDelhiresult.equals(expexctedshopdelhi));
	ExtentTestManager.getTest().log(LogStatus.PASS, "Shop Act : Delhi Result is Pass");

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


String sec=MissingJSON.difference(ShopActDelhiresult, expexctedshopdelhi);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	   
		   
		   
		   
		   
		   
		   }else{

		   System.out.println("not matching");
		   ExtentTestManager.getTest().log(LogStatus.FAIL, "Shop Act : Delhi Result is Fail");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Delhi excepted is started"+expexctedshopdelhi);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Delhi actual is started"+ShopActDelhiresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Delhi Result Comparison  is "+ShopActDelhiresult.equals(expexctedshopdelhi));

			String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


		String sec=MissingJSON.difference(ShopActDelhiresult, expexctedshopdelhi);


		System.out.println(sec);

		ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 

		   
		   
		   
		   }
		
		

			   } catch (Exception e) {
				   ExtentTestManager.getTest().log(LogStatus.ERROR, "Shop Act : Delhi  Request on site timed out");
				   
				   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				   ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				   
			   }

			} catch(Exception e) {
			      System.out.println("no page");
			      System.out.println(e);
			  }
		
		
	driver.close();

	driver.switchTo().window(mainhandleDelhi);		

	//Assert.assertEquals(ShopActDelhiresult, expexctedshopdelhi);		
	
	
	
	
	
	
	
	
	
	}	
	
}
