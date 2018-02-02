package com.allclasses;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.base.pack.ExtentTestManager;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;


import com.relevantcodes.extentreports.LogStatus;


public class Himachalpradeshele  {

	
	WebDriver driver;
	public Himachalpradeshele(WebDriver driver) {
		super();
	
		
		this.driver=driver;
	}

public void clickHimachalpradesh(String Number,String exceptedreult) throws InterruptedException{

	
	 Thread.sleep(3000);
	  
	// driver.findElement(By.xpath("//a[text()='Address Verification']")).click();	  
	 	  
	 Thread.sleep(9000);
	 driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();


	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Himachal Pradesh']")).click();

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



driver.findElement(By.xpath(".//*[@id='kno']")).sendKeys(Number);

driver.findElement(By.xpath(".//*[@id='submit']")).click();


try {
	    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
	   try {

Thread.sleep(19000);


driver.manage().window().maximize();
Thread.sleep(2000);

String Himachalpradeshele=exceptedreult; 


String Himachalpradesheleact=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

//System.out.println(Himachalpradesheleact.equals(Himachalpradeshele));



Double resPercentage = LetterPairSimilarity.compareStrings(Himachalpradesheleact, Himachalpradeshele);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



if(resPercentage> 0 && (resPercentage*100) > 80){
	
	System.out.println("pass");
	
	   ExtentTestManager.getTest().log(LogStatus.PASS, "Electricity : Himachal Pradesh Result is Pass");
	
		ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result excepted is started"+Himachalpradeshele);
		ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result actual is started"+Himachalpradesheleact);
		//ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result Comparison  is "+Himachalpradesheleact.equals(Himachalpradeshele));
	
		String screenshortpath=GetScreenshort2.capture(driver, "ScreenshortForExtentReport");
	
		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


		 String sec=MissingJSON.difference(Himachalpradesheleact, Himachalpradeshele);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	
}else{
	System.out.println("FAIL ");
	
	ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : Himachal Pradesh Result is Fail");
	
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result excepted is started"+Himachalpradeshele);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result actual is started"+Himachalpradesheleact);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result Comparison  is "+Himachalpradesheleact.equals(Himachalpradeshele));
	
	 String sec=MissingJSON.difference(Himachalpradesheleact, Himachalpradeshele);


	   System.out.println(sec);

	   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	
}
//if (Himachalpradesheleact.equals(Himachalpradeshele)) {
//	
//	System.out.println("pass");
//	
//	
//	ExtentTestManager.getTest().log(LogStatus.PASS, "Electricity : Himachal Pradesh Result is Pass");
//
//	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result excepted is started"+Himachalpradeshele);
//	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result actual is started"+Himachalpradesheleact);
//	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result Comparison  is "+Himachalpradesheleact.equals(Himachalpradeshele));
//	
//
//	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");
//
//	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
//
//
//	
//	
//	
//	
//}else{
//	
//	System.out.println("not matching");
//	ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : Himachal Pradesh Result is Fail");
//	
//
//	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result excepted is started"+Himachalpradeshele);
//	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result actual is started"+Himachalpradesheleact);
//	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Himachal Pradesh Result Comparison  is "+Himachalpradesheleact.equals(Himachalpradeshele));
//	
//	
//	
//	
//}


	   } catch (Exception e) {
		   ExtentTestManager.getTest().log(LogStatus.ERROR, "Electricity : Himachal Pradesh Request on site timed out");
			String screenshortpath=GetScreenshort2.capture(driver, "ScreenshortForExtentReport");
			
			ExtentTestManager.getTest().log(LogStatus.ERROR, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


		   
	   }

	} catch(Exception e) {
	      System.out.println("no page");
	      System.out.println(e);
	  }




driver.close();
driver.switchTo().window(mainhandle);;
	
//Assert.assertEquals(Himachalpradesheleact, Himachalpradeshele);	 
 




}
	
	
}
