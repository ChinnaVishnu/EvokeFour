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


public class ShopActHarayanapage {

	
	public WebDriver driver;
	public ShopActHarayanapage(WebDriver driver) {
		super();
         this.driver=driver;
         
      
	}
	
public void clickshopactharayana(String Applicationnumber,String exceptedreult) throws InterruptedException, IOException{

	Thread.sleep(5000);
	 driver.findElement(By.xpath("//div[text()='  Shop Act Verification']/input")).click();

	 

		Thread.sleep(5000);
driver.findElement(By.xpath(".//*[@id='shopActDetails']/div[1]/a[2]")).click();

String mainhandleDelhi=driver.getWindowHandle();

  String childhandleDelhi="";

  Set<String>handlesDelhi=	driver.getWindowHandles();

  for (String handle : handlesDelhi) {

  if (!handle.equals(mainhandleDelhi)) {
  	
	  childhandleDelhi=handle;
  	
  }


  }


  driver.switchTo().window(childhandleDelhi);
  
 driver.findElement(By.xpath(".//*[@id='appNo']")).sendKeys(Applicationnumber); 


driver.findElement(By.xpath(".//*[@id='cinDiv']/div/span[1]/input")).click();

try {
    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
   try {
	   
   
Thread.sleep(15000);
String expexctedShopActHarayana=exceptedreult;

String ShopActharayanaresult=driver.findElement(By.xpath(".//*[@id='result']")).getText();

  
Double resPercentage = LetterPairSimilarity.compareStrings(ShopActharayanaresult, expexctedShopActHarayana);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



if(resPercentage> 0 && (resPercentage*100) > 80){
	
	System.out.println("pass");
	

   
   

ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Haryana excepted is started"+expexctedShopActHarayana);
ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Haryana actual is started"+ShopActharayanaresult);
ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Haryana Result Comparison  is "+ShopActharayanaresult.equals(expexctedShopActHarayana));
ExtentTestManager.getTest().log(LogStatus.PASS, "Shop Act : Haryana Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

String sec=MissingJSON.difference(ShopActharayanaresult, expexctedShopActHarayana);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	   

   
   
   
   }else{

   System.out.println("not matching");
   ExtentTestManager.getTest().log(LogStatus.FAIL, "Shop Act : Haryana Result is Fail");
   ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Haryana excepted is started"+expexctedShopActHarayana);
   ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Haryana actual is started"+ShopActharayanaresult);
   ExtentTestManager.getTest().log(LogStatus.INFO, "Shop Act : Haryana Result Comparison  is "+ShopActharayanaresult.equals(expexctedShopActHarayana));
   
   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

   ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


   String sec=MissingJSON.difference(ShopActharayanaresult, expexctedShopActHarayana);


   System.out.println(sec);

   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
   	   
 
   }
   


   } catch (Exception e) {
	   ExtentTestManager.getTest().log(LogStatus.ERROR, "Shop Act : Haryana  Request on site timed out");
	   
	   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	   ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	   
   }

} catch(Exception e) {
      System.out.println("no page");
      System.out.println(e);
  }



 driver.close();

 driver.switchTo().window(mainhandleDelhi);	

// Assert.assertEquals(ShopActharayanaresult, expexctedShopActHarayana);	


}

}
