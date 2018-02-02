package com.electricity.verification;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class ElectricityGoA  extends mainbase{

	

	@DataProvider(name = "DP3")
	public Object[][] createData58() throws Exception{
	 Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "electricitygoa","electricitygoa");
		  	         return(retObjArr);
		  	     } 
	 
	

	 
	@Test(dataProvider="DP3")
	public void ElectricityGoA(String ConsumerNumber  ,String BU ,String Number ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		

	 ExtentTestManager.startTest(" Electricity : GoA "); 

	 Thread.sleep(5000);
	  
	  
	 driver.findElement(By.xpath("//a[text()='Address Verification']")).click();	  
	 	  
	 
	 	   
	 
	 Thread.sleep(9000);
	 driver.findElement(By.xpath("(//input[@name='inputType'])[38]")).click();


	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Goa']")).click();

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
		
		
		 Thread.sleep(3000);
		 
		 

	 driver.findElement(By.xpath(".//*[@id='consumerID_GA']")).sendKeys(ConsumerNumber);
	 
	 
	 
	 
	 
	 Thread.sleep(3000);
	 
	 
	 driver.findElement(By.xpath(".//*[@id='submit']")).click();
	 
	 

	 //Thread.sleep(13000);
	 
	 
	 try {
		    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		   try {

			   
			   Thread.sleep(30000);

	 
	 
	 
	 

	String elegoaexcepted=exceptedreult; 

	String elegoaactualresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();


		
	System.out.println(elegoaactualresult.equals(elegoaexcepted));


	if (elegoaactualresult.equals(elegoaexcepted)) {

	System.out.println("pass");

	ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : GoA excepted is started"+elegoaexcepted);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : GoA actual is started"+elegoaactualresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : GoA Result Comparison  is "+elegoaactualresult.equals(elegoaexcepted));
	ExtentTestManager.getTest().log(LogStatus.PASS, "Electricity : GoA Result is Pass");

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	}else{

	System.out.println("not matching");

	ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : GoA excepted is started"+elegoaexcepted);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : GoA actual is started"+elegoaactualresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : GoA Result Comparison  is "+elegoaactualresult.equals(elegoaexcepted));

	ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : GoA Result is Fail");






	}
		  



		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.ERROR, "Electricity : GoA  Request on site timed out");
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }


	driver.close();

	driver.switchTo().window(mainhandle);
	//Assert.assertEquals(elegoaactualresult, elegoaexcepted);

	}	
	
		
	
}
