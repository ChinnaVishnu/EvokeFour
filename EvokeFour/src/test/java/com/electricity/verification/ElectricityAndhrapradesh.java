package com.electricity.verification;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class ElectricityAndhrapradesh  extends mainbase{

	


@DataProvider(name = "DP35")
	 public Object[][] createData35() throws Exception{
	  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "LogingmailAndhraele","LogingmailAndhraele");
		  	         return(retObjArr);
		  	     } 
	  
	  
@Test(dataProvider="DP35")
public void ElectricityAndhraPradesh (String Power,String Number ,String Bill ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		

	  ExtentTestManager.startTest(" Electricity : Andhra Pradesh(Southern power)  "); 
	  
	  Thread.sleep(9000);
	  
driver.findElement(By.xpath("//a[text()='Address Verification']")).click();	  
	  
Thread.sleep(6000);
driver.findElement(By.xpath("(//input[@name='inputType'])[38]")).click();


Thread.sleep(3000);
driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Andhra Pradesh']")).click();



	String mainhandleandhra=driver.getWindowHandle();

	String childhandleAndhra="";

	Set<String>handlesandhra=	driver.getWindowHandles();

	for (String handle : handlesandhra) {

	if (!handle.equals(mainhandleandhra)) {
		
		childhandleAndhra=handle;
		
	}


	}

	driver.switchTo().window(childhandleAndhra);	

	Thread.sleep(3000);

	WebElement element =driver.findElement(By.xpath("//select[@onchange='selectPowerDistribution()']"));

	
		Select select=new Select(element);
		
		select.selectByVisibleText(Power);
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='electricityNo2']")).sendKeys(Number);
		

		
	driver.findElement(By.xpath(".//*[@id='electricitySouthernDiv']/div/span[1]/input")).click();

	
	try {
	    driver.manage().timeouts().pageLoadTimeout(75000, TimeUnit.MILLISECONDS);
	   try {

		   
	  
	Thread.sleep(13000);	
	String electryandhrapradesh=exceptedreult; 
    
	
String electryandhrapradeshresult=driver.findElement(By.xpath(".//*[@id='result']")).getText();
	

	

Double resPercentage = LetterPairSimilarity.compareStrings(electryandhrapradeshresult, electryandhrapradesh);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



if(resPercentage> 0 && (resPercentage*100) > 80){
System.out.println("pass");
	

	ExtentTestManager.getTest().log(LogStatus.PASS, "Electricity: Andhra  Pradesh Result is Pass");

	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Andhra  Pradesh  result excepted is started"+electryandhrapradesh);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Andhra  Pradesh  result resultactual is started"+electryandhrapradeshresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Andhra  Pradesh  result Result Comparison  is "+electryandhrapradeshresult.equals(electryandhrapradesh));
	

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
	
	
	String sec=MissingJSON.difference(electryandhrapradeshresult, electryandhrapradesh);


	   System.out.println(sec);

	   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	
	
	
	
}else{
	
	System.out.println("not matching");
	ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity: Andhra  Pradesh Result is Fail");
	

	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Andhra  Pradesh  result excepted is started"+electryandhrapradesh);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Andhra  Pradesh  result resultactual is started"+electryandhrapradeshresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity: Andhra  Pradesh  result Result Comparison  is "+electryandhrapradeshresult.equals(electryandhrapradesh));
	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	String sec=MissingJSON.difference(electryandhrapradeshresult, electryandhrapradesh);


	   System.out.println(sec);

	   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	
	
}

	  
	
	   } catch (Exception e) {
		   ExtentTestManager.getTest().log(LogStatus.ERROR, "Electricity : Andhra  Pradesh(Southern power)  Request on site timed out");
			String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		   
	}

	} catch(Exception e) {
	   System.out.println("no page");
	   System.out.println(e);
	}
	
	
	
	
	driver.close();


	driver.switchTo().window(mainhandleandhra);	
	  
	  
	  
//Assert.assertEquals(electryandhrapradeshresult, electryandhrapradesh);	 
	 
	 


}
}
