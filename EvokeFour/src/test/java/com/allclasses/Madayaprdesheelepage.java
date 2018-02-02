package com.allclasses;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.LogStatus;


public class Madayaprdesheelepage  {


	WebDriver driver;
	public Madayaprdesheelepage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	
public void clickmadayapradesh(String IVRS,String exceptedreult) throws InterruptedException{
	
	Thread.sleep(6000);

	
	  
	//driver.findElement(By.xpath("//a[text()='Address Verification']")).click();	  
	 	  
	 Thread.sleep(9000);
	 driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();


	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Madhya Pradesh']")).click();

	 Thread.sleep(9000);


String mainhandleMadayapradesh=driver.getWindowHandle();

String childhandleMadayapradesh="";

Set<String>handlesMadayapradesh=	driver.getWindowHandles();

for (String handle : handlesMadayapradesh) {

if (!handle.equals(handlesMadayapradesh)) {
	
	childhandleMadayapradesh=handle;
	
}


}

driver.switchTo().window(childhandleMadayapradesh);	


driver.findElement(By.xpath(".//*[@id='ivrsID_MP']")).sendKeys(IVRS);


driver.findElement(By.xpath(".//*[@id='submit']")).click();
	



Thread.sleep(20000);

driver.manage().window().maximize();

Thread.sleep(5000);

 
 String electrymadayaresult=exceptedreult; 
 

try {
driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
try {

   Thread.sleep(30000);
   
	String  electrymadayaresulttact=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
		


	Double resPercentage = LetterPairSimilarity.compareStrings(electrymadayaresulttact, electrymadayaresult);

	System.out.println("resPercentage "+resPercentage*100);
	String total=Double.toString(resPercentage*100);

	ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
	


	if(resPercentage> 0 && (resPercentage*100) > 80){
		
		System.out.println("pass");
		
		
		System.out.println("pass");
		ExtentTestManager.getTest().log(LogStatus.PASS, " Electricity : Madhya Pradesh Result is Pass");

		ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Madhya Pradesh  Result excepted is started"+electrymadayaresult);
		ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Madhya Pradesh   Result resultactual is started"+electrymadayaresulttact);
		//ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Madhya Pradesh  Result Comparison  is "+electrymadayaresult.equals(electrymadayaresulttact));
		

		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
		
		String sec=MissingJSON.difference(electrymadayaresulttact, electrymadayaresult);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		
	}else{
		
		System.out.println("not matching");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : Madhya Pradesh  Result is Fail");
		ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Madhya Pradesh  Result excepted is started"+electrymadayaresult);
		ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Madhya Pradesh   Result resultactual is started"+electrymadayaresulttact);
		ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Madhya Pradesh  Result Comparison  is "+electrymadayaresult.equals(electrymadayaresulttact));
		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
		

		
		String sec=MissingJSON.difference(electrymadayaresulttact, electrymadayaresult);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 	
		
		
	}
 
 



	   
	   
   } catch (Exception e) {
	   ExtentTestManager.getTest().log(LogStatus.ERROR, "Electricity : Madhya Pradesh  Request on site timed out");
	   
		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
		

   }

} catch(Exception e) {
      System.out.println("no page");
      System.out.println(e);
  }




driver.close();
driver.switchTo().window(mainhandleMadayapradesh);;	

	
	
}
}