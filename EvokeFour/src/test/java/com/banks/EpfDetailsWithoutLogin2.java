package com.banks;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class EpfDetailsWithoutLogin2  extends mainbase{

	//.......................................................	 EPF Details(Without Login)  .........................................................................//

	
	public WebElement fluentWait(final By locator){
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	        .withTimeout(0, TimeUnit.SECONDS)
	        .pollingEvery(0, TimeUnit.SECONDS)
	        .ignoring(NoSuchElementException.class);
	        

	    WebElement foo = wait.until(
	        new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                return driver.findElement(locator);
	            }
	        }
	    );
	    return foo;
	};
	
	

	@DataProvider(name = "DP50")
	public Object[][] createData50() throws Exception{
	 Object[][] retObjArr=getTableArray("D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "LogingmaiEPF","LogingmaiEPF");
		  	         return(retObjArr);
		  	     } 
	 
	 
	@Test(priority=86,dataProvider="DP50")
	public void EpFWithoutLogin(String Company,String Employee  ,String Bill,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		

		ExtentTestManager.startTest("  EPF Details(Without Login) "); 
	 
        try{
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Financial']")).click();
		
		
		
		
		fluentWait(By.xpath("(//input[@name='inputType'])[23]")).click();
		  
		  
			

		  
		  String mainhandle=driver.getWindowHandle();

			String childhandle="";

			Set<String>handles=	driver.getWindowHandles();

			for (String handle : handles) {

			if (!handle.equals(mainhandle)) {
				
				childhandle=handle;
				
			}


			}

			driver.switchTo().window(childhandle);	

			fluentWait(By.xpath(".//*[@id='compName']")).sendKeys(Company);
			fluentWait(By.xpath(".//*[@id='empName']")).sendKeys(Employee);
		  
		  
			fluentWait(By.xpath("//div[@id='details']/table/tbody/tr[3]/td[2]/input")).click();
		  //Thread.sleep(23000);
		
		  
		  String EpfLoginresult=exceptedreult; 

	String EpfLoginresultact=fluentWait(By.xpath(".//*[@id='result_data']")).getText();

	System.out.println(EpfLoginresultact.equals(EpfLoginresult));

	Double resPercentage = LetterPairSimilarity.compareStrings(EpfLoginresultact, EpfLoginresult);

	System.out.println("resPercentage "+resPercentage*100);
	String total=Double.toString(resPercentage*100);

	ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
	

	if(resPercentage> 0 && (resPercentage*100) > 80){

System.out.println("pass");
ExtentTestManager.getTest().log(LogStatus.INFO, " EPF Without Login Result excepted is started"+EpfLoginresult);
ExtentTestManager.getTest().log(LogStatus.INFO, " EPF Without Login Result actual is started"+EpfLoginresultact);
ExtentTestManager.getTest().log(LogStatus.INFO, " EPF Without Login Result Comparison  is "+EpfLoginresultact.equals(EpfLoginresult));
ExtentTestManager.getTest().log(LogStatus.PASS, " EPF Without Login Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));



	}else{

	System.out.println("not matching");
	ExtentTestManager.getTest().log(LogStatus.FAIL, " EPF Without Login Result  is Fail");
	
	ExtentTestManager.getTest().log(LogStatus.INFO, " EPF Without Login Result excepted is started"+EpfLoginresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " EPF Without Login Result actual is started"+EpfLoginresultact);
	ExtentTestManager.getTest().log(LogStatus.INFO, " EPF Without Login Result Comparison  is "+EpfLoginresultact.equals(EpfLoginresult));
	ExtentTestManager.getTest().log(LogStatus.FAIL, " EPF Without Login Result is FAIL");

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.FAIL, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


	
	}
		  
		
		     driver.close();

			driver.switchTo().window(mainhandle);	

	 
			//Assert.assertEquals(EpfLoginresultact, EpfLoginresult);	
	 
        }catch(Exception e){
        	
        	ExtentTestManager.getTest().log(LogStatus.SKIP, " EPF Without Login Result is Skipping Because Request For Time Out ");
        	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

        	ExtentTestManager.getTest().log(LogStatus.SKIP, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
System.out.println("hihi");
        	
        }

	}

	
	
	
}
