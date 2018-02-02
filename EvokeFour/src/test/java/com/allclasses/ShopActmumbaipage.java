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



public class ShopActmumbaipage  {

	
	
	WebDriver driver;
	public ShopActmumbaipage(WebDriver driver) {
		super();
		
		
		this.driver=driver;
	}

	
	
public void clickmumbai(String Applicationnumber,String exceptedreult) throws InterruptedException, IOException{

	Thread.sleep(5000);
	 driver.findElement(By.xpath("//div[text()='  Shop Act Verification']/input")).click();

	 Thread.sleep(5000);
    driver.findElement(By.xpath(".//*[@id='shopActDetails']/div[1]/a[1]")).click();
    

	Thread.sleep(2000);
	
	String mainhandle=driver.getWindowHandle();

	String childhandle="";

	Set<String>handles=	driver.getWindowHandles();

	for (String handle : handles) {

	if (!handle.equals(mainhandle)) {
		
		childhandle=handle;
		
	}


	}

	driver.switchTo().window(childhandle);	
    
    driver.findElement(By.xpath(".//*[@id='appNo']")).sendKeys(Applicationnumber);
    
   driver.findElement(By.xpath(".//*[@id='cinDiv']/div/span[1]/input")).click(); 
    
   
   try {
	    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
	   try {
   
   Thread.sleep(35000); 
   
   String exceptedmumbai=exceptedreult;
   
   String ShopActMumbairesult=driver.findElement(By.xpath(".//*[@id='result']")).getText();

  
   Double resPercentage = LetterPairSimilarity.compareStrings(ShopActMumbairesult, exceptedmumbai);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



if(resPercentage> 0 && (resPercentage*100) > 80){
	
	System.out.println("pass");
	

   


ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act: Mumbai excepted is started"+exceptedmumbai);
ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act: Mumbai actual is started"+ShopActMumbairesult);
ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act: Mumbai Result Comparison  is "+ShopActMumbairesult.equals(exceptedmumbai));
ExtentTestManager.getTest().log(LogStatus.PASS, "Shop Act: Mumbai Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
String sec=MissingJSON.difference(ShopActMumbairesult, exceptedmumbai);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	   



   }else{

   System.out.println("not matching");
  
   
   
ExtentTestManager.getTest().log(LogStatus.FAIL, "Shop Act: Mumbai Result is Fail");
ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act: Mumbai excepted is started"+exceptedmumbai);
ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act: Mumbai actual is started"+ShopActMumbairesult);
ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act: Mumbai Result Comparison  is "+ShopActMumbairesult.equals(exceptedmumbai));
   
String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
String sec=MissingJSON.difference(ShopActMumbairesult, exceptedmumbai);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 

   
   }
   

	   } catch (Exception e) {
		   ExtentTestManager.getTest().log(LogStatus.ERROR, "Shop Act : Mumbai  Request on site timed out");
		   
		   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		   ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		   
	   }

	} catch(Exception e) {
	      System.out.println("no page");
	      System.out.println(e);
	  }


   
   driver.close();
   
   driver.switchTo().window(mainhandle);	
	
  //Assert.assertEquals(ShopActMumbairesult, exceptedmumbai);		
	
	

}
	
	
}
	
	

