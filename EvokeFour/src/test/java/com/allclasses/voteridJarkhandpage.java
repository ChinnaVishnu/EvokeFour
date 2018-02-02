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
import com.relevantcodes.extentreports.LogStatus;


public class voteridJarkhandpage  {

	
	
	public WebDriver driver;
	public voteridJarkhandpage(WebDriver driver) {
		super();
		
		this.driver=driver;
		
	}

	
	public void clickjharajkanad(String Photo  ,String JarkhDistrict  ,String JarkhAC ,String exceptedreult) throws InterruptedException, IOException{
		
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();
		

		Thread.sleep(6000);
		 driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[3]/a[3]")).click();


		 String mainhandleJharkhand=driver.getWindowHandle();

		 String childhandleJharkhand="";

		 Set<String>handlesJharkhand=driver.getWindowHandles();

		 for (String handle : handlesJharkhand) {

		 if (!handle.equals(mainhandleJharkhand)) {
		 	
		 	childhandleJharkhand=handle;
		 	
		 }


		 }

		 driver.switchTo().window(childhandleJharkhand);	






		 driver.findElement(By.xpath(".//*[@id='gen_type2_epicNo']")).sendKeys(Photo);

		 WebElement elementpp=driver.findElement(By.xpath(".//*[@id='gen_type2_district']"));

		 Select select=new Select(elementpp);

		 select.selectByIndex(1);

		 Thread.sleep(4000);
		
		 driver.findElement(By.xpath(".//*[@id='submit']")).click();
		

			try {
			    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			   try {
				
		 
		 
				   Thread.sleep(69000);
		 String voteridjaharkahard=exceptedreult;

		 String VoterIdJharkhandresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
			
		 
		 
		 Thread.sleep(12000);

		 Double resPercentage = LetterPairSimilarity.compareStrings(VoterIdJharkhandresult, voteridjaharkahard);

			System.out.println("resPercentage "+resPercentage*100);
			String total=Double.toString(resPercentage*100);

			ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
			
			
			if(resPercentage> 0 && (resPercentage*100) > 80){
		   
			    


		   ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Jharkhand excepted is started"+voteridjaharkahard);
		   ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Jharkhand actual is started"+VoterIdJharkhandresult);
		 //  ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Jharkhand  Result Comparison  is "+voteridjaharkahard.contains(VoterIdJharkhandresult));
		   ExtentTestManager.getTest().log(LogStatus.PASS, " VoterId : Jharkhand Result is pass");


		   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		   ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		   String sec=MissingJSON.difference(VoterIdJharkhandresult, voteridjaharkahard);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		   
		   
		   
		   }else{

		   System.out.println("not matching");
		   ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Jharkhand  Result is Fail");


		   ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Jharkhand excepted is started"+voteridjaharkahard);
		   ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Jharkhand actual is started"+VoterIdJharkhandresult);
		   ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Jharkhand  Result Comparison  is "+voteridjaharkahard.contains(VoterIdJharkhandresult));
		   
		   
		   
		   
		   String sec=MissingJSON.difference(VoterIdJharkhandresult, voteridjaharkahard);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		   
		   }
		
		 
			   
		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.ERROR, "VoterId : Jharkhand Request on site timed out");
			   ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));

		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }

		 
		 
		 
		 
		 driver.close();

		 driver.switchTo().window(mainhandleJharkhand);
		
		 
		// Assert.assertTrue(voteridjaharkahard.contains(VoterIdJharkhandresult));
		 
		 //Assert.assertEquals(VoterIdJharkhandresult, voteridjaharkahard);		  	
	  	
	  	
	 

	
	
	
}
}