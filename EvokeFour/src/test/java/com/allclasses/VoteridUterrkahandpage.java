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


public class VoteridUterrkahandpage 

{
 
	
	WebDriver driver;
	public VoteridUterrkahandpage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
	
	
public void clickvoteriduterrekhand(String District    ,String Voter,String exceptedreult) throws InterruptedException, IOException{	
	
	
	Thread.sleep(6000);
driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();
	
Thread.sleep(6000);
driver.findElement(By.xpath("//a[text()='Uttarakhand']")).click();
Thread.sleep(6000);
	
	//driver.findElement(By.xpath(".//*[@id='voterIdDetails']/table/tbody/tr[4]/td[1]/a")).click();
	String mainhandle=driver.getWindowHandle();

	String childhandle="";

	Set<String>handles=	driver.getWindowHandles();

	for (String handle : handles) {

	if (!handle.equals(mainhandle)) {
		
		childhandle=handle;
		
	}


	}

	driver.switchTo().window(childhandle);	
	
	try {
	    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
	   try {
		   
	

	Thread.sleep(4000);
WebElement elementutt=driver.findElement(By.xpath("//select[@onchange='showCaptcha()']"));



Select selectUttarakhand=new Select(elementutt);

selectUttarakhand.selectByVisibleText(District);

Thread.sleep(4000);
driver.findElement(By.xpath(".//*[@id='gen_type5_epicNo']")).sendKeys(Voter);



Thread.sleep(9000);


driver.findElement(By.xpath(".//*[@id='submit']")).click();


   
Thread.sleep(10000);
	
String voteriduterrekh=exceptedreult; 



String  voteriduterrekhresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
	

Double resPercentage = LetterPairSimilarity.compareStrings(voteriduterrekhresult, voteriduterrekh);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



if(resPercentage> 0 && (resPercentage*100) > 80){

  System.out.println("pass");

  ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Uttarakhand excepted is started"+voteriduterrekh);
  ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Uttarakhand actual is started"+voteriduterrekhresult);
  ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Uttarakhand Result Comparison  is "+voteriduterrekh.equals(voteriduterrekhresult));
  ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : Uttarakhand  Result is Pass");

  String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

  ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
  String sec=MissingJSON.difference(voteriduterrekhresult, voteriduterrekh);


  System.out.println(sec);

  ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
  
  
  }else{

  System.out.println("not matching");
  ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Uttarakhand Result is Fail");
  
  ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Uttarakhand excepted is started"+voteriduterrekh);
  ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Uttarakhand actual is started"+voteriduterrekhresult);
  ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Uttarakhand Result Comparison  is "+voteriduterrekh.equals(voteriduterrekhresult));
  String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

  ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

  String sec=MissingJSON.difference(voteriduterrekhresult, voteriduterrekh);


  System.out.println(sec);

  ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
  
  }


   } catch (Exception e) {
	   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Uttarakhand Request on site timed out");
	   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	   ExtentTestManager.getTest().log(LogStatus.FAIL, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	   
	   
   }

} catch(Exception e) {
      System.out.println("no page");
      System.out.println(e);
  }



	driver.close();
	 driver.switchTo().window(mainhandle);	

	//Assert.assertEquals(voteriduterrekhresult, voteriduterrekh);	 

}


}
