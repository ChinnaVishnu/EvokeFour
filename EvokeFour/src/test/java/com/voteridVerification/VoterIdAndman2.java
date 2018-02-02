package com.voteridVerification;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoterIdAndman2  extends mainbase{

	public WebElement fluentWait(final By locator){
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	        .withTimeout(1, TimeUnit.SECONDS)
	        .pollingEvery(1, TimeUnit.SECONDS)
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


@DataProvider(name = "DP62")
	 public Object[][] createData62() throws Exception{
	  Object[][] retObjArr=getTableArray("D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "VoterIDVerificationAndaman","VoterIDVerificationAndaman");
		  	         return(retObjArr);
		  	     } 
	  
	  
@Test(priority=8,dataProvider="DP62")
public void voteridindia (String EPIC    ,String Service  ,String Bill ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		

	  ExtentTestManager.startTest(" VoterId : Andaman "); 
	  Thread.sleep(6000);
		driver.findElement(By.xpath("(//input[@name='inputType'])[11]")).click();
		
		  Thread.sleep(7000);
		driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[4]/a[4]")).click();

		String mainhandleandhra=driver.getWindowHandle();

		String childhandleAndhra="";

		Set<String>handlesandhra=	driver.getWindowHandles();

		for (String handle : handlesandhra) {

		if (!handle.equals(mainhandleandhra)) {
			
			childhandleAndhra=handle;
			
		}


		}

		driver.switchTo().window(childhandleAndhra);	


		driver.findElement(By.xpath(".//*[@id='gen_type3_epicNo']")).sendKeys(EPIC);
		
	
		
		
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		
		
		try {
		    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		   try {

		
		
		//Thread.sleep(95000);
		
		
		
		
		
String voteridAdmanactualresult=fluentWait(By.xpath(".//*[@id='result_div']/div")).getText();
	
String voteridAdmana=exceptedreult;



Double resPercentage = LetterPairSimilarity.compareStrings(voteridAdmanactualresult, voteridAdmana);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");






if(resPercentage> 0 && (resPercentage*100) > 80){


System.out.println("pass");


ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Andaman excepted is started"+voteridAdmana);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Andaman  actual is started"+voteridAdmanactualresult);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Andaman   Result Comparison  is "+voteridAdmana.equals(voteridAdmanactualresult));
ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : Andaman    Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
String sec=MissingJSON.difference(voteridAdmanactualresult, voteridAdmana);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 




	
}else{

System.out.println("not matching");
ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : Andaman  Result is Fail");
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Andaman excepted is started"+voteridAdmana);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Andaman  actual is started"+voteridAdmanactualresult);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : Andaman   Result Comparison  is "+voteridAdmana.equals(voteridAdmanactualresult));

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
String sec=MissingJSON.difference(voteridAdmanactualresult, voteridAdmana);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 



}


		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.ERROR, "VoterId : Andaman Request on site timed out");
			   String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			   ExtentTestManager.getTest().log(LogStatus.ERROR, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
 
			   
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }

driver.close();
driver.switchTo().window(mainhandleandhra);
//Assert.assertEquals(voteridAdmanactualresult, voteridAdmana);	

}
	
	
}
