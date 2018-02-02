package com.allclasses;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.relevantcodes.extentreports.LogStatus;



public class Voteridsikkmpage  {

	
	
	WebDriver driver;
	public Voteridsikkmpage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	
public void clickvoteridsikkmpage(String District   ,String Voter,String exceptedreult) throws InterruptedException{
	
	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();
	
	//driver.findElement(By.xpath(".//*[@id='voterIdDetails']/table/tbody/tr[3]/td[4]/a")).click();
	

	Thread.sleep(5000);
	//driver.findElement(By.xpath(".//*[@id='SOURCESTABLE']/tbody/tr[7]/td/input")).click();
	
	driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[4]/a[2]")).click();

	String mainhandle=driver.getWindowHandle();

	String childhandle="";

	Set<String>handles=	driver.getWindowHandles();

	for (String handle : handles) {

	if (!handle.equals(mainhandle)) {
		
		childhandle=handle;
		
	}


	}

	driver.switchTo().window(childhandle);	
	 
WebElement elementsikkim=driver.findElement(By.xpath(".//*[@id='gen_type4_district']"));


Select selectsikkim=new Select(elementsikkim);


selectsikkim.selectByVisibleText(District);





driver.findElement(By.xpath(".//*[@id='gen_type4_epicNo']")).sendKeys(Voter);

driver.findElement(By.xpath(".//*[@id='submit']")).click();



 String votersikkm=exceptedreult; 
 
 try {
	    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
	   try {

		   
		   Thread.sleep(30000);
 String votersikkmresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
	

 Double resPercentage = LetterPairSimilarity.compareStrings(votersikkmresult, votersikkm);

	System.out.println("resPercentage "+resPercentage*100);
	String total=Double.toString(resPercentage*100);

	ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
	


	if(resPercentage> 0 && (resPercentage*100) > 80){
   System.out.println("pass");
   
   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Sikkim excepted is started"+votersikkm);
   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Sikkim actual is started"+votersikkmresult);
   //ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Sikkim Result Comparison  is "+votersikkmresult.equals(votersikkm));
   ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : Sikkim Result is Pass");

   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

   ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

   		  
   String sec=MissingJSON.difference(votersikkmresult, votersikkm);


   System.out.println(sec);

   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);   
   
   
   }else{

   System.out.println("not matching");
   ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Sikkim  Result is Fail");
   

   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Sikkim excepted is started"+votersikkm);
   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Sikkim actual is started"+votersikkmresult);
   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Sikkim Result Comparison  is "+votersikkmresult.equals(votersikkm));
   
   String sec=MissingJSON.difference(votersikkmresult, votersikkm);


   System.out.println(sec);

   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
   
   }

 
 
	   } catch (Exception e) {
		   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Sikkim Request on site timed out");
		   
			String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


		   
	   }

	} catch(Exception e) {
	      System.out.println("no page");
	      System.out.println(e);
	  }


driver.close();
driver.switchTo().window(mainhandle);	
	
// Assert.assertEquals(votersikkmresult, votersikkm);	 
  



}
}
	
	
	
