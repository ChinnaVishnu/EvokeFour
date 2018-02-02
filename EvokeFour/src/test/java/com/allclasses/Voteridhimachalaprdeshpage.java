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



public class Voteridhimachalaprdeshpage  {

	
	
	WebDriver driver;
	public Voteridhimachalaprdeshpage(WebDriver driver) {
		super();
		
		this.driver=driver;
	}

	
public void clickvoteridhimachal(String District   ,String Voter,String exceptedreult) throws InterruptedException, IOException{
	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();

	Thread.sleep(4000);
	driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[3]/a[2]")).click();
	Thread.sleep(4000);
	
	String mainhandleHaryana=driver.getWindowHandle();

	String childhandleHaryana="";

	Set<String>handlesHaryana  =	driver.getWindowHandles();

	for (String handle : handlesHaryana) {

	if (!handle.equals(mainhandleHaryana)) {
		
		childhandleHaryana=handle;
		
	}


	}

	driver.switchTo().window(childhandleHaryana);	


WebElement element =driver.findElement(By.xpath(".//*[@id='gen_type4_district']"));

	

	Select select=new Select(element);
	
	select.selectByVisibleText(District);
	
driver.findElement(By.xpath(".//*[@id='gen_type4_epicNo']")).sendKeys(Voter);
Thread.sleep(5000);	
	
driver.findElement(By.xpath(".//*[@id='submit']")).click();	
	
try {
    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
   try {
	
	Thread.sleep(24000);
	
	String voterHimachla=exceptedreult;
	
String voteridhimachlaresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
	
Double resPercentage = LetterPairSimilarity.compareStrings(voteridhimachlaresult, voterHimachla);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");


if(resPercentage> 0 && (resPercentage*100) > 80){

    
   

ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : HimachalPradesh excepted is started"+voterHimachla);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : HimachalPradesh actual is started"+voteridhimachlaresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : HimachalPradesh Result Comparison  is "+voteridhimachlaresult.equals(voterHimachla));
ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : HimachalPradesh Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


String sec=MissingJSON.difference(voteridhimachlaresult, voterHimachla);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);  
   
   
   
   
   
   }else{

   System.out.println("not matching");
   ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : HimachalPradesh Result is Fail");
   

ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : HimachalPradesh excepted is started"+voterHimachla);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : HimachalPradesh actual is started"+voteridhimachlaresult);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : HimachalPradesh Result Comparison  is "+voteridhimachlaresult.equals(voterHimachla));
String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
   

String sec=MissingJSON.difference(voteridhimachlaresult, voterHimachla);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);   


   }


   } catch (Exception e) {
	   ExtentTestManager.getTest().log(LogStatus.ERROR, "VoterId : HimachalPradesh Request on site timed out");
	   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");
	   ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
 
	   
	   
   }

} catch(Exception e) {
      System.out.println("no page");
      System.out.println(e);
  }



	
	driver.close();
	
	
	driver.switchTo().window(mainhandleHaryana);	
  	
  
	 //Assert.assertEquals(voteridhimachlaresult, voterHimachla);	

  	
  	
  	
  	
  	

  }
}
