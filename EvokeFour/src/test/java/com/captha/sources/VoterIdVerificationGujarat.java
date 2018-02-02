package com.captha.sources;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class VoterIdVerificationGujarat extends mainbase {



@DataProvider(name = "DP3")
	 public Object[][] createData3() throws Exception{
	  Object[][] retObjArr=getTableArray("D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "VoterIdVerificationGujarat","VoterIdVerificationGujarat");
		  	         return(retObjArr);
		  	     } 
	  
	  
@Test(priority=8,dataProvider="DP3")
public void voteridGujarath (String IDCard   ,String Service  ,String Bill ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  BiffException, IOException, InterruptedException{		  		

	  ExtentTestManager.startTest("VoterId : Gujarat "); 
	  Thread.sleep(9000);
	  driver.findElement(By.xpath("//a[text()='Individual Verification']")).click();
	  
	  
	  Thread.sleep(6000);
			driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();
		
		  Thread.sleep(7000);
		driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[1]/a[2]")).click();


		String mainhandleandhra=driver.getWindowHandle();

		String childhandleAndhra="";

		Set<String>handlesandhra=	driver.getWindowHandles();

		for (String handle : handlesandhra) {

		if (!handle.equals(mainhandleandhra)) {
			
			childhandleAndhra=handle;
			
		}


		}

		driver.switchTo().window(childhandleAndhra);	
       
		driver.manage().window().maximize();
		
		

		try {
		    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		   try {
		
		Thread.sleep(9000);
		driver.findElement(By.xpath("//input[@placeholder='ID Card No.']")).sendKeys(IDCard);
		
		Thread.sleep(15000);
		
		
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		
		Thread.sleep(35000);
		
		

		
		
String voteridactualresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
	
String voteridgujarath=exceptedreult;



//System.out.println(voteridgujarath.equals(voteridactualresult));

Double resPercentage = LetterPairSimilarity.compareStrings(voteridactualresult, voteridgujarath);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"percentage of actual and expected :: "+total);



if(resPercentage> 0 && (resPercentage*100) > 80){



ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Gujarat   resultexcepted is started"+voteridgujarath);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Gujarat   resultactual is started"+voteridactualresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Gujarat   resultcomparison is "+voteridgujarath.equals(voteridactualresult));
ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : Gujarat  Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screen short below :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	
}else{

System.out.println("not matching");
ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Gujarat  Result is Fail");
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Gujarat   resultexcepted is started"+voteridgujarath);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Gujarat   resultactual is started"+voteridactualresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Gujarat   resultcomparison is "+voteridgujarath.equals(voteridactualresult));

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screen short below :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));



}


		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.ERROR, "VoterId : Gujarat Request on site timed out");
			   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			   ExtentTestManager.getTest().log(LogStatus.ERROR, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
 
			   
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }


driver.close();
driver.switchTo().window(mainhandleandhra);
//Assert.assertEquals(voteridactualresult, voteridgujarath);	

}
	
	
}
