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


public class VoterIdDaDraAndSecondpage  {

	
	WebDriver driver;
	public VoterIdDaDraAndSecondpage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	this.driver=driver;	
	}

public void click(String EPIC,String exceptedreult) throws InterruptedException, IOException{
	
 /*  Thread.sleep(6000);
	
	driver.findElement(By.xpath("//td[text()='VoterId Verification']/input")).click();*/
	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();
	
	
	Thread.sleep(6000);
	driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[2]/a[4]")).click();
	
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
	
	Thread.sleep(65000);
	

	try {
	driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
	try {


	
	
	 String prpvoteriddarda=exceptedreult; 
	 
	 
	 String voteriddardaresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
		
	 Double resPercentage = LetterPairSimilarity.compareStrings(voteriddardaresult, prpvoteriddarda);

		System.out.println("resPercentage "+resPercentage*100);
		String total=Double.toString(resPercentage*100);

		ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
		
		

		if(resPercentage> 0 && (resPercentage*100) > 80){
	   
		    

ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Dadra and Haveli excepted is started"+prpvoteriddarda);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Dadra and Haveli actual is started"+voteriddardaresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Dadra and Haveli Result Comparison  is "+voteriddardaresult.equals(prpvoteriddarda));
ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : Dadra and Haveli  Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
String sec=MissingJSON.difference(voteriddardaresult, prpvoteriddarda);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 


	   
	   
	   
	   }else{

	   System.out.println("not matching");
	   ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Dadra and Haveli Result is Fail");

ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Dadra and Haveli excepted is started"+prpvoteriddarda);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Dadra and Haveli actual is started"+voteriddardaresult);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Dadra and Haveli Result Comparison  is "+voteriddardaresult.equals(prpvoteriddarda));
String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
	   
String sec=MissingJSON.difference(voteriddardaresult, prpvoteriddarda);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);   
	   
	   
	   }
	
	   
} catch (Exception e) {
	ExtentTestManager.getTest().log(LogStatus.ERROR, "VoterId : Dadra and Haveli Request on site timed out");
	ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));

}

} catch(Exception e) {
   System.out.println("no page");
   System.out.println(e);
}
	 
	 
	driver.close();
	
	 driver.switchTo().window(mainhandleJharkhand);

	 //Assert.assertEquals(voteriddardaresult, prpvoteriddarda);	

 
}


	
}
