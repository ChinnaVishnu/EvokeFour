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


public class VoteridHarayanapage  {

	
	WebDriver driver;
	public VoteridHarayanapage(WebDriver driver) {
		super();
		this.driver=driver;
	}

	
public void clickvoteridharayana(String EPIC,String exceptedreult) throws InterruptedException, IOException{
	

 
	Thread.sleep(6000);
	driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[1]/a[3]")).click();
	String mainhandleHaryana=driver.getWindowHandle();

	String childhandleHaryana="";

	Set<String>handlesHaryana  =	driver.getWindowHandles();

	for (String handle : handlesHaryana) {

	if (!handle.equals(mainhandleHaryana)) {
		
		childhandleHaryana=handle;
		
	}


	}

	driver.switchTo().window(childhandleHaryana);	

	
	Thread.sleep(4000);
	driver.findElement(By.xpath(".//*[@id='gen_type3_epicNo']")).sendKeys(EPIC);

	driver.findElement(By.xpath(".//*[@id='submit']")).click();
	
	
	
	try {
		  driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		 try {
	
	Thread.sleep(19000);
	String voterharayana=exceptedreult;  
	
	
	String voterharayanaresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
	

	Double resPercentage = LetterPairSimilarity.compareStrings(voterharayanaresult, voterharayana);

	System.out.println("resPercentage "+resPercentage*100);
	String total=Double.toString(resPercentage*100);

	ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
	
	




	if(resPercentage> 0 && (resPercentage*100) > 80){
   
	    

	   System.out.println("pass");

ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Haryana excepted is started"+voterharayana);
ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Haryana actual is started"+voterharayanaresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Haryana Result Comparison  is "+voterharayanaresult.equals(voterharayana));

ExtentTestManager.getTest().log(LogStatus.PASS, " VoterId : Haryana   Result is pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	   
String sec=MissingJSON.difference(voterharayanaresult, voterharayana);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);  	   
	   
	   
	   }else{

	   System.out.println("not matching");
	   ExtentTestManager.getTest().log(LogStatus.FAIL, " VoterId : Haryana  Result is Fail");
	   

ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Haryana excepted is started"+voterharayana);
ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Haryana actual is started"+voterharayanaresult);
ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Haryana Result Comparison  is "+voterharayanaresult.equals(voterharayana));



String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

String sec=MissingJSON.difference(voterharayanaresult, voterharayana);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);  
	   
	   
	   }
	
	   
		 } catch (Exception e) {
			 ExtentTestManager.getTest().log(LogStatus.ERROR, "VoterId : Haryana Request on site timed out");
			 String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			 ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		 }

		} catch(Exception e) {
		    System.out.println("no page");
		    System.out.println(e);
		}
	   
	   
	driver.close();
	
	driver.switchTo().window(mainhandleHaryana);
  	
  	
	// Assert.assertEquals(voterharayanaresult, voterharayana);	
  	
  	

  }
}

