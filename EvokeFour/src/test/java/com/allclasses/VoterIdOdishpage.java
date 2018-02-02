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


public class VoterIdOdishpage   {

	
	public WebDriver driver;
	public VoterIdOdishpage(WebDriver driver) {
		super();
       this.driver=driver;
	}

	
public void clickvoteridodish(String EPIC,String exceptedreult) throws InterruptedException, IOException{
	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();
	Thread.sleep(8000);
	driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[2]/a[1]")).click();
	
	
	Thread.sleep(8000);

	String mainhandleJharkhand=driver.getWindowHandle();

	 String childhandleJharkhand="";

	 Set<String>handlesJharkhand=driver.getWindowHandles();

	 for (String handle : handlesJharkhand) {

	 if (!handle.equals(mainhandleJharkhand)) {
	 	
	 	childhandleJharkhand=handle;
	 	
	 }


	 }

	 driver.switchTo().window(childhandleJharkhand);	
	
	driver.findElement(By.xpath(".//*[@id='gen_type3_epicNo']")).sendKeys(EPIC);
	
	
	driver.findElement(By.xpath(".//*[@id='submit']")).click();
	
	
	 try {
		    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		   try {
	
	
	
	Thread.sleep(10000);
	
	String voteridodish=exceptedreult;	


	 String voteridodishresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
		
	 Double resPercentage = LetterPairSimilarity.compareStrings(voteridodishresult, voteridodish);

		System.out.println("resPercentage "+resPercentage*100);
		String total=Double.toString(resPercentage*100);

		ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
		
	

		if(resPercentage> 0 && (resPercentage*100) > 80){
	   

	   System.out.println("pass");


ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Odisha excepted is started"+voteridodish);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Odisha actual is started"+voteridodishresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Odisha  Result Comparison  is "+voteridodish.contains(voteridodishresult));
ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : Odisha Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

String sec=MissingJSON.difference(voteridodishresult, voteridodish);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);   
	   
	   
	   }else{

	   System.out.println("not matching");
	   ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Odisha Result is Fail");

ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Odisha excepted is started"+voteridodish);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Odisha actual is started"+voteridodishresult);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Odisha  Result Comparison  is "+voteridodish.contains(voteridodishresult));
String sec=MissingJSON.difference(voteridodishresult, voteridodish);
String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 	   
	   
	   
	   }
		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Odisha Request on site timed out");
			   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			   ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }
	
	driver.close();
	
   driver.switchTo().window(mainhandleJharkhand);	

   //Assert.assertEquals(voteridodishresult, voteridodish);	 
 // Assert.assertTrue(voteridodish.contains(voteridodishresult)); 
   
}

	
	
}
	
	
	
