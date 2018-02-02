package com.allclasses;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.openqa.selenium.support.ui.Select;


import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.relevantcodes.extentreports.LogStatus;


public class VoterIdtelangapage  {

	
	
	WebDriver driver;
	public VoterIdtelangapage(WebDriver driver) {
		super();
		
		
		this.driver=driver;
	}

public void clickvoteridTelanga(String Photo  ,String District  ,String AC,String exceptedreult ) throws InterruptedException{
	Thread.sleep(6000);
	driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[3]/a[5]")).click();
	
	String mainhandleJharkhand=driver.getWindowHandle();

	 String childhandleJharkhand="";

	 Set<String>handlesJharkhand=driver.getWindowHandles();

	 for (String handle : handlesJharkhand) {

	 if (!handle.equals(mainhandleJharkhand)) {
	 	
	 	childhandleJharkhand=handle;
	 	
	 }


	 }

	 driver.switchTo().window(childhandleJharkhand);	
	 
	 Thread.sleep(6000);
	driver.findElement(By.xpath(".//*[@id='gen_type2_epicNo']")).sendKeys(Photo);
	
	

WebElement element =driver.findElement(By.xpath(".//*[@id='gen_type2_district']"));

	Select select=new Select(element);
	
	select.selectByVisibleText(District);
	
	
	
	

WebElement elementsecond =driver.findElement(By.xpath(".//*[@id='gen_type2_voting_town']"));


	Select selectsecond=new Select(elementsecond);
	
	selectsecond.selectByVisibleText(AC);
	
	
	driver.findElement(By.xpath(".//*[@id='submit']")).click();
	
	 
	 try {
		    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		   try {

			   
			   Thread.sleep(30000);
	//Thread.sleep(7000);
	String voteridTelanaga=exceptedreult;
	

	 String voteridTelanagaresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
		
	 Double resPercentage = LetterPairSimilarity.compareStrings(voteridTelanagaresult, voteridTelanaga);

		System.out.println("resPercentage "+resPercentage*100);
		String total=Double.toString(resPercentage*100);

		ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
		
		




		if(resPercentage> 0 && (resPercentage*100) > 80){
	   

	   System.out.println("pass");
	   

ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Telangana excepted is started"+voteridTelanaga);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Telangana actual is started"+voteridTelanagaresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Telangana Result Comparison  is "+voteridTelanagaresult.equals(voteridTelanaga));
ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : Telangana Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

String sec=MissingJSON.difference(voteridTelanagaresult, voteridTelanaga);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 

	   
	   
	   
	   }else{

	   System.out.println("not matching");
	   ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Telangana  Result is Fail");

ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Telangana excepted is started"+voteridTelanaga);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Telangana actual is started"+voteridTelanagaresult);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Telangana Result Comparison  is "+voteridTelanagaresult.equals(voteridTelanaga));
	   
String sec=MissingJSON.difference(voteridTelanagaresult, voteridTelanaga);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	   
	   
	   }
	

		 
		   } catch (org.openqa.selenium.ElementNotVisibleException e) {
			   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Telangana Request on site timed out");
			   
				String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


			   
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }
	
	driver.close();
	
	driver.switchTo().window(mainhandleJharkhand);

  
	 //Assert.assertEquals(voteridTelanagaresult, voteridTelanaga);	
	

	
}
	
}
