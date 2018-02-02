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
import com.relevantcodes.extentreports.LogStatus;



public class VoteridKaranatakapage  {

	
	
	public WebDriver driver;
	public VoteridKaranatakapage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public void clickvoteridkaranaka(String District     ,String Voter,String exceptedreult) throws InterruptedException, IOException{
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();

Thread.sleep(3000);
driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[4]/a[5]")).click();



String mainhandlekaranataka=driver.getWindowHandle();

String childhandlekaranataka="";

Set<String>handleskaranataka=driver.getWindowHandles();

for (String handle : handleskaranataka) {

if (!handle.equals(mainhandlekaranataka)) {
	
	childhandlekaranataka=handle;
	
}


}

driver.switchTo().window(childhandlekaranataka);	

WebElement elementkar=driver.findElement(By.xpath(".//*[@id='gen_type4_district']"));
	


Select selectkar=new Select(elementkar);

selectkar.selectByVisibleText(District);


driver.findElement(By.xpath(".//*[@id='gen_type4_epicNo']")).sendKeys(Voter);


driver.findElement(By.xpath(".//*[@id='submit']")).click();

try {
    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
   try {
	

Thread.sleep(3000);
String voteridkaranataka=exceptedreult;




   String   voteridkaranatakaresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
	

   Double resPercentage = LetterPairSimilarity.compareStrings(voteridkaranatakaresult, voteridkaranataka);

	System.out.println("resPercentage "+resPercentage*100);
	String total=Double.toString(resPercentage*100);

	ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
	
	
	if(resPercentage> 0 && (resPercentage*100) > 80){
  
  


ExtentTestManager.getTest().log(LogStatus.PASS, " VoterId : Karnataka Result is pass");
ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Karnataka excepted is started"+voteridkaranataka);
ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Karnataka actual is started"+voteridkaranatakaresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Karnataka Result Comparison  is "+voteridkaranatakaresult.equals(voteridkaranataka));


String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


  
  
  
  
  
  }else{

  System.out.println("not matching");
  ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Karnataka Result is Fail");
  ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Karnataka excepted is started"+voteridkaranataka);
  ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Karnataka actual is started"+voteridkaranatakaresult);
  ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : Karnataka Result Comparison  is "+voteridkaranatakaresult.equals(voteridkaranataka));

  
  
  
  
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



driver.switchTo().window(mainhandlekaranataka);

 
//Assert.assertEquals(voteridkaranatakaresult, voteridkaranataka);


	}	
}
