package com.allclasses;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.relevantcodes.extentreports.LogStatus;


public class PropertaxBangolrepage  {

	
	
	WebDriver driver;
	public PropertaxBangolrepage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	
public void clickbangolre(String SAS ,String Name,String exceptedreult) throws InterruptedException{

	
	Thread.sleep(6000);

	
	
	//driver.findElement(By.xpath("//a[text()='  Financial/Tax/Legal']")).click();
	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//a[text()='Legal']")).click();
	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//div[text()='  PropertyTax Verification']/input")).click();

	
	Thread.sleep(6000);
	 driver.findElement(By.xpath(".//*[@id='TaxIdDetails']/div[2]/a[2]")).click();


	 String mainhandleBangolre=driver.getWindowHandle();

	 String childhandleBangolre="";

	 Set<String>handlesBangolre=driver.getWindowHandles();

	 for (String handle : handlesBangolre) {

	 if (!handle.equals(mainhandleBangolre)) {
	 	
	 	childhandleBangolre=handle;
	 	
	 }


	 }

	 driver.switchTo().window(childhandleBangolre);	



	 driver.findElement(By.xpath("//input[@id='sasNumber']")).sendKeys(SAS);


	 driver.findElement(By.xpath("//input[@id='name']")).sendKeys(Name);

	 driver.findElement(By.xpath(".//*[@id='submit']")).click();
	 
	 
	 
	// Thread.sleep(92000);

	 

try {
   driver.manage().timeouts().pageLoadTimeout(50000, TimeUnit.MILLISECONDS);
  try {
	   
	  Thread.sleep(22000);
	  String prpbangolretax=exceptedreult; 
		String prpbangolretaxresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

		
		 Double resPercentage = LetterPairSimilarity.compareStrings(prpbangolretaxresult, prpbangolretax);

			System.out.println("resPercentage "+resPercentage*100);
			String total=Double.toString(resPercentage*100);

			ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
			


			if(resPercentage> 0 && (resPercentage*100) > 80){
		System.out.println("pass");
		
ExtentTestManager.getTest().log(LogStatus.PASS, " PropertyTax : Bangalore   Result is Pass");

ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Bangalore  excepted is started"+prpbangolretax);
ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Bangalore  actual is started"+prpbangolretaxresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Bangalore  Result Comparison  is "+prpbangolretaxresult.equals(prpbangolretax));


String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

String sec=MissingJSON.difference(prpbangolretaxresult, prpbangolretax);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	
		
		
		
		}else{

		System.out.println("not matching");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "PropertyTax : Bangalore   Result is Fail");
		

ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Bangalore  excepted is started"+prpbangolretax);
ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Bangalore  actual is started"+prpbangolretaxresult);
ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Bangalore  Result Comparison  is "+prpbangolretaxresult.equals(prpbangolretax));

String sec=MissingJSON.difference(prpbangolretaxresult, prpbangolretax);

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.FAIL, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	
		
		
		}

	 
		   
	   } catch (Exception e) {
		   ExtentTestManager.getTest().log(LogStatus.INFO, "PropertyTax : Bangalore  pageLoading problem");
		   
			String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


		   
	   }

	} catch(Exception e) {
	      System.out.println("no page");
	      System.out.println(e);
	  }
	 
	 
	 
	 
    driver.close();
	 driver.switchTo().window(mainhandleBangolre);	

	 //Assert.assertEquals(prpbangolretaxresult, prpbangolretax);


}



	
}
