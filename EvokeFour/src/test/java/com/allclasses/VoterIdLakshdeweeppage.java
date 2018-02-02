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


public class VoterIdLakshdeweeppage  {

	
	
	WebDriver driver;
	public VoterIdLakshdeweeppage(WebDriver driver) {
		super();
     
		this.driver=driver;

	}

	public void clickvoterlakshdeep(String EPIC,String exceptedreult) throws InterruptedException, IOException{
		

		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[2]/a[5]")).click();
		
		Thread.sleep(3000);

		String mainhandle=driver.getWindowHandle();

		String childhandle="";

		Set<String>handles=	driver.getWindowHandles();

		for (String handle : handles) {

		if (!handle.equals(mainhandle)) {
			
			childhandle=handle;
			
		}


		}

		driver.switchTo().window(childhandle);
		
		driver.findElement(By.xpath(".//*[@id='gen_type3_epicNo']")).sendKeys(EPIC);
		
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		
		
		

		try {
		    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		   try {

		Thread.sleep(12000);
		String voterLakshdeep=exceptedreult;
		
		
		

		 String voterLakshdeepresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
			

		 Double resPercentage = LetterPairSimilarity.compareStrings(voterLakshdeepresult, voterLakshdeep);

			System.out.println("resPercentage "+resPercentage*100);
			String total=Double.toString(resPercentage*100);

			ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
			
		

			if(resPercentage> 0 && (resPercentage*100) > 80){

		   System.out.println("pass");
		  
		  


ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Lakshadweep excepted is started"+voterLakshdeep);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Lakshadweep actual is started"+voterLakshdeepresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Lakshadweep Result Comparison  is "+voterLakshdeepresult.equals(voterLakshdeep));
ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : Lakshadweep Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		   
String sec=MissingJSON.difference(voterLakshdeepresult, voterLakshdeep);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);    
		   
		   
		   
		   
		   
		   }else{

		   System.out.println("not matching");
		   ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Lakshadweep Result is Fail");
		   

ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Lakshadweep excepted is started"+voterLakshdeep);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Lakshadweep actual is started"+voterLakshdeepresult);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Lakshadweep Result Comparison  is "+voterLakshdeepresult.equals(voterLakshdeep));

		   
		   
//ExtentTestManager.getTest().log(LogStatus.INFO,"1",voterLakshdeep);
	   
String sec=MissingJSON.difference(voterLakshdeepresult, voterLakshdeep);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 	   
		   
		   
		   }
			
			
			
			 
		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Lakshadweep Request on site timed out");
				String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


			   
			   
			   
			   
			   
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }
	
		   
		
		
		driver.close();
		driver.switchTo().window(mainhandle);	
		
		
		// Assert.assertEquals(voterLakshdeepresult, voterLakshdeep);	 	  
	  
	  
	  

}
		
		

	
	
	
	
}
