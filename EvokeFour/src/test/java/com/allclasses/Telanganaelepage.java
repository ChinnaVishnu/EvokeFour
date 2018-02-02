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


public class Telanganaelepage  {


	WebDriver driver;
	public Telanganaelepage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	
public void clicktelangana(String Number,String exceptedreult) throws InterruptedException, IOException{
	
	 Thread.sleep(3000);
	 //driver.findElement(By.xpath("//a[text()='Address Verification']")).click();	  
	 	  
	 Thread.sleep(9000);
	 driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();


	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Telangana']")).click();

	 Thread.sleep(9000);

//driver.findElement(By.xpath(".//*[@id='SOURCESTABLE']/tbody/tr[3]/td[3]/input")).click();	


//driver.findElement(By.xpath(".//*[@id='electricityDetails']/table/tbody/tr[3]/td[3]/a")).click();

String mainhandleTelangana=driver.getWindowHandle();

String childhandleTelangana="";

Set<String>handlesTelangana=	driver.getWindowHandles();

for (String handle : handlesTelangana) {

if (!handle.equals(mainhandleTelangana)) {

childhandleTelangana=handle;

}


}

driver.switchTo().window(childhandleTelangana);	

driver.findElement(By.xpath(".//*[@id='usNo']")).sendKeys(Number);


driver.findElement(By.xpath(".//*[@id='panDiv']/div/span[1]/input")).click();



try {
    driver.manage().timeouts().pageLoadTimeout(75000, TimeUnit.MILLISECONDS);
   try {


Thread.sleep(9000);

String electrytelanagaresult=exceptedreult; 

driver.manage().window().maximize();

Thread.sleep(9000);



String electrytelanagaresultact=driver.findElement(By.xpath(".//*[@id='tsresult']")).getText();
	


Double resPercentage = LetterPairSimilarity.compareStrings(electrytelanagaresultact, electrytelanagaresult);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



if(resPercentage> 0 && (resPercentage*100) > 80){
	
	System.out.println("pass");
	
	
	
	

	ExtentTestManager.getTest().log(LogStatus.PASS, "Electricity :	Telangana Result is Pass");

	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity :	Telangana  Result resultexcepted is started"+electrytelanagaresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity :	Telangana  Result actual is started"+electrytelanagaresultact);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity :	Telangana  Result Comparison  is "+electrytelanagaresultact.equals(electrytelanagaresult));
	

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
	 String sec=MissingJSON.difference(electrytelanagaresultact, electrytelanagaresult);


	   System.out.println(sec);

	   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	
	
	
}else{
	
	System.out.println("not matching");
	ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity :	Telangana Result is Fail");
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity :	Telangana  Result resultexcepted is started"+electrytelanagaresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity :	Telangana  Result actual is started"+electrytelanagaresultact);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity :	Telangana  Result Comparison  is "+electrytelanagaresultact.equals(electrytelanagaresult));
	 String sec=MissingJSON.difference(electrytelanagaresultact, electrytelanagaresult);


	   System.out.println(sec);

	   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.FAIL, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	
	
	
}



   } catch (Exception e) {
	   ExtentTestManager.getTest().log(LogStatus.ERROR, "Electricity : Telangana  Request on site timed out");
	   
		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


	   
   }

   } catch(Exception e) {
      System.out.println("no page");
      System.out.println(e);
   }




driver.close();
driver.switchTo().window(mainhandleTelangana);;	


//Assert.assertEquals(electrytelanagaresultact, electrytelanagaresult);	 	  	  





}

	
}
	
	
