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


public class punjablepage  {

	
	WebDriver driver;
	public punjablepage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

public void clickpujejabele(String Account,String exceptedreult) throws InterruptedException, IOException{


	 Thread.sleep(3000);
	 //driver.findElement(By.xpath("//a[text()='Address Verification']")).click();	  
	 	  
	 Thread.sleep(9000);
	 driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();


	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Punjab']")).click();

	 Thread.sleep(9000);


	String mainhandlePunjab=driver.getWindowHandle();

	String childhandlePunjab="";

	Set<String>handlesPunjab  =	driver.getWindowHandles();

	for (String handle : handlesPunjab) {

	if (!handle.equals(mainhandlePunjab)) {
		
		childhandlePunjab=handle;
		
	}


	}

	driver.switchTo().window(childhandlePunjab);	


	driver.findElement(By.xpath(".//*[@id='txtconsumerno']")).sendKeys(Account);


	driver.findElement(By.xpath(".//*[@id='submit']")).click();

	


	try {
	    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
	   try {
	Thread.sleep(4000);
	String punjabeleeresult=exceptedreult; 


String punjabeleeresultact=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

Double resPercentage = LetterPairSimilarity.compareStrings(punjabeleeresultact, punjabeleeresult);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



if(resPercentage> 0 && (resPercentage*100) > 80){
	
	System.out.println("pass");
	ExtentTestManager.getTest().log(LogStatus.PASS, " Electricity : Punjab Result is Pass");

	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Punjab Result excepted is started"+punjabeleeresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Punjab Result actual is started"+punjabeleeresultact);
	//ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Punjab Result Comparison  is "+punjabeleeresultact.equals(punjabeleeresult));
	

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	String sec=MissingJSON.difference(punjabeleeresultact, punjabeleeresult);


	System.out.println(sec);

	ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);
	
	
}else{
	
	System.out.println("not matching");
	ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : Punjab Result is Fail");
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Punjab Result excepted is started"+punjabeleeresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Punjab Result actual is started"+punjabeleeresultact);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Punjab Result Comparison  is "+punjabeleeresultact.equals(punjabeleeresult));
	

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	String sec=MissingJSON.difference(punjabeleeresultact, punjabeleeresult);


	System.out.println(sec);

	ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);
	
	
}


	   } catch (Exception e) {
		   ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : Punjab Request on site timed out");
			String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


		   
		   
	   }

	} catch(Exception e) {
	      System.out.println("no page");
	      System.out.println(e);
	  }
	
	
	
	driver.close();
	driver.switchTo().window(mainhandlePunjab);;
	
 
	//Assert.assertEquals(punjabeleeresultact, punjabeleeresult);	



}


	
	
	
}
