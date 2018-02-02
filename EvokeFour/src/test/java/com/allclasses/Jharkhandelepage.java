package com.allclasses;

import java.io.IOException;
import java.io.StringWriter;
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


public class Jharkhandelepage  {

	
	WebDriver driver;
	public Jharkhandelepage(WebDriver driver) {
		super();


		this.driver=driver;
	}

	
public void Jharkhandelepage(String Number ,String exceptedreult) throws InterruptedException, IOException{
	

	 Thread.sleep(3000);
	  
	 //driver.findElement(By.xpath("//a[text()='Address Verification']")).click();	  
	 	  
	 Thread.sleep(9000);
	 driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();


	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Jharkhand']")).click();

	 Thread.sleep(9000);


String mainhandle=driver.getWindowHandle();

String childhandle="";

Set<String>handles=	driver.getWindowHandles();

for (String handle : handles) {

if (!handle.equals(mainhandle)) {
	
	childhandle=handle;
	
}


}

driver.switchTo().window(childhandle);	


   


		driver.findElement(By.xpath(".//*[@id='jh_kNumber']")).sendKeys(Number);


		driver.findElement(By.xpath(".//*[@id='submit']")).click();



try {
    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
   try {



		Thread.sleep(9000);

		String electJharkahadndaresult=exceptedreult; 
		
		  driver.manage().window().maximize(); 
		  
		  Thread.sleep(5000);
		
		String electJharkahadndaresultact=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

		Double resPercentage = LetterPairSimilarity.compareStrings(electJharkahadndaresultact, electJharkahadndaresult);

		System.out.println("resPercentage "+resPercentage*100);
		String total=Double.toString(resPercentage*100);

		ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



		if(resPercentage> 0 && (resPercentage*100) > 80){
			
			System.out.println("pass");

			ExtentTestManager.getTest().log(LogStatus.PASS, " Electricity : Jharkhand Result is Pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Jharkhand Result excepted is started"+electJharkahadndaresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Jharkhand Result actual is started"+electJharkahadndaresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Jharkhand Result Comparison  is "+electJharkahadndaresult.equals(electJharkahadndaresultact));
			

			String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			 String sec=MissingJSON.difference(electJharkahadndaresultact, electJharkahadndaresult);


			   System.out.println(sec);

			   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
			
			
		}else{
			
			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : Jharkhand Result is Fail");

			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Jharkhand Result excepted is started"+electJharkahadndaresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Jharkhand Result actual is started"+electJharkahadndaresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Jharkhand Result Comparison  is "+electJharkahadndaresult.equals(electJharkahadndaresultact));
			

			 String sec=MissingJSON.difference(electJharkahadndaresultact, electJharkahadndaresult);


			   System.out.println(sec);

			   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
			
		}
		
		
		
		
		

   } catch (Exception e) {
	   ExtentTestManager.getTest().log(LogStatus.ERROR, "Electricity : Jharkhand Source website is busy! Please try after some time");
	   
	   
		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


   }

} catch(Exception e) {
      System.out.println("no page");
      System.out.println(e);
  }
		
		

		driver.close();
		driver.switchTo().window(mainhandle);

		//Assert.assertEquals(electJharkahadndaresultact, electJharkahadndaresult);	
	  
	  
	 
	 
}

}