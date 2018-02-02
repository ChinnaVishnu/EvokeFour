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


public class VoteridTripurapage  {

	
	
	WebDriver driver;
	public VoteridTripurapage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	
	public void clickonvoteridtripura(String EPIC,String exceptedreult) throws InterruptedException, IOException{
		
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();
		
		driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[2]/a[3]")).click();
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
			
		Thread.sleep(13000);
		
		String voteridtripura=exceptedreult; 
		
		

		 String voteridtripuraresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
			

		 Double resPercentage = LetterPairSimilarity.compareStrings(voteridtripuraresult, voteridtripura);

			System.out.println("resPercentage "+resPercentage*100);
			String total=Double.toString(resPercentage*100);

			ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
			
		

			if(resPercentage> 0 && (resPercentage*100) > 80){


		   System.out.println("pass");

		   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Tripura excepted is started"+voteridtripura);
		   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Tripura actual is started"+voteridtripuraresult);
		   //ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Tripura Result Comparison  is "+voteridtripuraresult.equals(voteridtripura));
		   ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : Tripura Result is Pass");

		   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		   ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		   String sec=MissingJSON.difference(voteridtripuraresult, voteridtripura);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		   
		   }else{

		   System.out.println("not matching");
		   ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Tripura  Result is Fail");
		   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Tripura excepted is started"+voteridtripura);
		   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Tripura actual is started"+voteridtripuraresult);
		   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Tripura Result Comparison  is "+voteridtripuraresult.equals(voteridtripura));
		 
		   String sec=MissingJSON.difference(voteridtripuraresult, voteridtripura);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		   
		   
		   
		   }
		
			 
		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Tripura Request on site timed out");
			   
				String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


			   
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }
		driver.close();
		driver.switchTo().window(mainhandle);	

		 //Assert.assertEquals(voteridtripuraresult, voteridtripura);	 


	}

	
	
}
