package com.legel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

public class CourtVerificationSecond extends mainbase {

	@DataProvider(name = "DP49")
	 public Object[][] createData49() throws Exception{
	  Object[][] retObjArr=getTableArray("D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "Logingmailcourt","Logingmailcourt");
		  	         return(retObjArr);
		  	     } 
	  
	  
@Test(priority=52,dataProvider="DP49")
public void Courtverification(String Enter ,String Ward ,String Bill,String Nature ,String exceptedreult,String actualresult,String testresult) throws   IOException, InterruptedException{		  		

	ExtentTestManager.startTest(" Court Verification : GetDetails "); 
	  
	  
	  
	
	
	//Thread.sleep(4000);
	
	//driver.findElement(By.xpath("//div[2]/div[2]/div")).click();
	
	
	Thread.sleep(4000);
	
	  driver.findElement(By.xpath("//a[text()='Legal']")).click();
	  
	  Thread.sleep(4000);
	  
	  
	  driver.findElement(By.xpath("(//input[@name='inputType'])[37]")).click();
	  
	  Thread.sleep(4000);
	  
	  driver.findElement(By.xpath(".//*[@id='courtverification']/table[1]/tbody/tr/td[2]/input")).click();	

	  driver.findElement(By.xpath(".//*[@id='c_verifyId']")).sendKeys(Enter);
	  	
	  driver.findElement(By.xpath(".//*[@id='get_court_div']/table/tbody/tr[3]/td[2]/input")).click();

	  //Thread.sleep(1000);
	  
	  
	  
	 Thread.sleep(50000);
		// waitForAjax(5);
	  
	 
	 String courtverresult=exceptedreult; 
	 

		String courtverresultact=driver.findElement(By.xpath(".//*[@id='reslut']")).getText();
		
		//driver.navigate().refresh();
		


		
	//Assert.assertEquals(courtverresultact, courtverresult);	
	//System.out.println(courtverresultact.equals(courtverresult));

	Double resPercentage = LetterPairSimilarity.compareStrings(courtverresultact, courtverresult);

	System.out.println("resPercentage "+resPercentage*100);
	String total=Double.toString(resPercentage*100);

	ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");


	


	if(resPercentage> 0 && (resPercentage*100) > 80){
	System.out.println("pass");

		
		System.out.println("pass");
		
		ExtentTestManager.getTest().log(LogStatus.INFO, " Court Verification excepted is started"+courtverresult);
		ExtentTestManager.getTest().log(LogStatus.INFO, " Court Verification actual is started"+courtverresultact);
		ExtentTestManager.getTest().log(LogStatus.INFO, " Court Verification Result Comparison  is "+courtverresultact.equals(courtverresult));
		ExtentTestManager.getTest().log(LogStatus.PASS, " Court Verification    Result is Pass");

		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
		
		
		
		
		   String sec=MissingJSON.difference(courtverresultact, courtverresult);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		
		
	}else{
		
		System.out.println("not matching");
		ExtentTestManager.getTest().log(LogStatus.INFO, " Court Verification excepted is started"+courtverresult);
		ExtentTestManager.getTest().log(LogStatus.INFO, " Court Verification actual is started"+courtverresultact);
		ExtentTestManager.getTest().log(LogStatus.INFO, " Court Verification Result Comparison  is "+courtverresultact.equals(courtverresult));
		ExtentTestManager.getTest().log(LogStatus.FAIL, " Court Verification    Result is Fail");

		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.FAIL, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		String sec=MissingJSON.difference(courtverresultact, courtverresult);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		
		
	}

}


	
	
	
}
