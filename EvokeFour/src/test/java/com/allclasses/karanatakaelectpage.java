package com.allclasses;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.LogStatus;


public class karanatakaelectpage {

	
	WebDriver driver;
	public karanatakaelectpage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	
public void clickkarantaka(String Account,String exceptedreult) throws InterruptedException, IOException{
	
	

	 Thread.sleep(3000);
	  
	// driver.findElement(By.xpath("//a[text()='Address Verification']")).click();	  
	 	  
	 Thread.sleep(9000);
	 driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();


	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Karnataka']")).click();

	 Thread.sleep(9000);

String mainhandleKaranataka=driver.getWindowHandle();

String childhandleKaranataka="";

Set<String>handlesKaranataka=	driver.getWindowHandles();

for (String handle : handlesKaranataka) {

if (!handle.equals(mainhandleKaranataka)) {
	
	childhandleKaranataka=handle;
	
}


}

driver.switchTo().window(childhandleKaranataka);	


driver.findElement(By.xpath(".//*[@id='appNo']")).sendKeys(Account);



driver.findElement(By.xpath(".//*[@id='cinDiv']/div/span[1]/input")).click();


try {
    driver.manage().timeouts().pageLoadTimeout(75000, TimeUnit.MILLISECONDS);
   try {


Thread.sleep(59000);


 String electrykaranataka=exceptedreult; 

String electrykaranatakaresult=driver.findElement(By.xpath(".//*[@id='result']")).getText();
	


Double resPercentage = LetterPairSimilarity.compareStrings(electrykaranatakaresult, electrykaranataka);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



if(resPercentage> 0 && (resPercentage*100) > 80){
System.out.println("pass");
	
	System.out.println("pass");
	ExtentTestManager.getTest().log(LogStatus.PASS, " Electricity: Karnataka   Result is Pass");


	

	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Karnataka  Result excepted is started"+electrykaranataka);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Karnataka  Result actual is started"+electrykaranatakaresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Karnataka   Result Comparison  is "+electrykaranatakaresult.equals(electrykaranataka));
	

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
	
	
	 String sec=MissingJSON.difference(electrykaranatakaresult, electrykaranataka);


	   System.out.println(sec);

	   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	
	
	
	
}else{
	
	System.out.println("not matching");
	ExtentTestManager.getTest().log(LogStatus.FAIL, " Electricity: Karnataka  Result  is Fail");
	

	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Karnataka  Result excepted is started"+electrykaranataka);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Karnataka  Result actual is started"+electrykaranatakaresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Karnataka   Result Comparison  is "+electrykaranatakaresult.equals(electrykaranataka));
	 String sec=MissingJSON.difference(electrykaranatakaresult, electrykaranataka);


	   System.out.println(sec);

	   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 

	   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.FAIL, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
	
	
}


	} catch (Exception e) {
		ExtentTestManager.getTest().log(LogStatus.ERROR, "Electricity : Karnataka  Request on site timed out");
		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.ERROR, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
	}

	} catch(Exception e) {
	   System.out.println("no page");
	   System.out.println(e);
	}


driver.close();

driver.switchTo().window(mainhandleKaranataka);	;

  
//Assert.assertEquals(electrykaranatakaresult, electrykaranataka);	 	  
  
 


}
	
	
}
