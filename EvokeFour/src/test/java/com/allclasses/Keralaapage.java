package com.allclasses;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.LogStatus;



public class Keralaapage  {

	
	WebDriver driver;
	public Keralaapage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

public void clikkerala(String Number ,String Ward ,String Bill,String exceptedreult) throws InterruptedException, IOException{
	

	 Thread.sleep(3000);
	  
	 //driver.findElement(By.xpath("//a[text()='Address Verification']")).click();	  
	 	  
	 Thread.sleep(9000);
	 driver.findElement(By.xpath("//div[text()='  Electricity Verification']/input")).click();


	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Kerala']")).click();

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




	 WebElement elementkerala=driver.findElement(By.xpath(".//*[@id='sectionCode']"));
	 Select selectkeralas=new Select(elementkerala);

	 selectkeralas.selectByVisibleText(Number);


	 driver.findElement(By.xpath(".//*[@id='ConsumerNo']")).sendKeys(Ward);

	 driver.findElement(By.xpath(".//*[@id='billNo']")).sendKeys(Bill);

	 driver.findElement(By.xpath(".//*[@id='submit']")).click();


		try {
		    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		   try {

	 Thread.sleep(30000);
	 String keralayaresult=exceptedreult; 
	 
	 

	String keralayaresultact=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

	Double resPercentage = LetterPairSimilarity.compareStrings(keralayaresultact, keralayaresult);

	System.out.println("resPercentage "+resPercentage*100);
	String total=Double.toString(resPercentage*100);

	ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



	if(resPercentage> 0 && (resPercentage*100) > 80){

	System.out.println("pass");

	System.out.println("pass");


	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Kerala  Result excepted is started"+keralayaresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Kerala  Result actual is started"+keralayaresultact);
	//ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Kerala  Result  Comparison  is "+keralayaresult.equals(keralayaresultact));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Electricity : Kerala  Result is Pass");

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
	String sec=MissingJSON.difference(keralayaresultact, keralayaresult);


	System.out.println(sec);

	ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);


	}else{

	System.out.println("not matching");
	ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : Kerala Result is Fail");
	

	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Kerala  Result excepted is started"+keralayaresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Kerala  Result actual is started"+keralayaresultact);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Kerala  Result  Comparison  is "+keralayaresult.equals(keralayaresultact));
	
	
	
	String sec=MissingJSON.difference(keralayaresultact, keralayaresult);


	System.out.println(sec);

	ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);
	}
	 
	
	
		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : Kerala Request on site timed out");
			   
				String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


			   
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  } 

	
	 
	 driver.close();
	 driver.switchTo().window(mainhandle);
	 
	 

	 //Assert.assertEquals(keralayaresultact, keralayaresult);	  


	}

	
}
