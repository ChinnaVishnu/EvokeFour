package com.social.screening;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

public class LinkdinVerificationEvoke extends mainbase {

	@DataProvider(name = "DP52")
	public Object[][] createData52() throws Exception{
	 Object[][] retObjArr=getTableArray("D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "LogingmailSocial","LogingmailSocial");
		  	         return(retObjArr);
		  	     } 
	 
	 
	@Test(priority=81,dataProvider="DP52")
	public void SocialVerification(String Email,String Password ,String Bill,String Nature ,String exceptedreult,String actualresult,String testresult) throws   IOException, InterruptedException{		  		

		ExtentTestManager.startTest(" Social Verification : LinkedIn "); 
	 Thread.sleep(4000);
	 
	 
	 driver.findElement(By.xpath("//div[4]/div")).click();
	 
	 Thread.sleep(4000);
	 
	 driver.findElement(By.xpath("//a[text()='Social']")).click();
	 Thread.sleep(4000);
	 driver.findElement(By.xpath("(//input[@name='inputType'])[44]")).click();
	 
	 Thread.sleep(4000);
	// driver.findElement(By.xpath("//td[text()='LinkedIn Verification']/input")).click();
	 
	 //driver.findElement(By.xpath("//div[@id='social']/table/tbody/tr/td[2]/img")).click();
	 
		String mainhandle=driver.getWindowHandle();

		String childhandle="";

		Set<String>handles=	driver.getWindowHandles();

		for (String handle : handles) {

		if (!handle.equals(mainhandle)) {
			
			childhandle=handle;
			
		}


		}

		driver.switchTo().window(childhandle);	

		driver.manage().window().maximize();

		try
	    {
		Thread.sleep(20000);


		if(driver.findElement(By.xpath(".//*[@id='session_key-oauthAuthorizeForm']")).isDisplayed()){
		
	//if(driver.findElement(By.xpath(".//*[@id='session_key-oauthAuthorizeForm']")).isDisplayed()){
		driver.findElement(By.xpath(".//*[@id='session_key-oauthAuthorizeForm']")).sendKeys(Email);


		
		
		
	 //driver.findElement(By.xpath(".//*[@id='session_key-oauthAuthorizeForm']")).sendKeys( Email);
	 
	 driver.findElement(By.xpath(".//*[@id='session_password-oauthAuthorizeForm']")).sendKeys(Password);
	 
	driver.findElement(By.xpath("//div[@id='body']/div/form/div[2]/ul/li[1]/input")).click();
	 


	Thread.sleep(19000);

	String socialverificationresult=exceptedreult; 

	String socialverificationresultact=driver.findElement(By.xpath(".//*[@id='result']")).getText();

	System.out.println(socialverificationresultact);

	System.out.println(socialverificationresultact.equals(socialverificationresult));

	Double resPercentage = LetterPairSimilarity.compareStrings(socialverificationresultact, socialverificationresult);

	System.out.println("resPercentage "+resPercentage*100);
	String total=Double.toString(resPercentage*100);

	ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");



	if(resPercentage> 0 && (resPercentage*100) > 80){

		ExtentTestManager.getTest().log(LogStatus.INFO, "Social Verification : LinkedIn  Expected:"+socialverificationresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Social Verification : LinkedIn  Actual:"+socialverificationresultact);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Social Verification : LinkedIn  Result Comparison  is "+socialverificationresult.equals(socialverificationresultact));
	ExtentTestManager.getTest().log(LogStatus.PASS, "Social Verification : LinkedIn  Result is Pass");

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	
	
	 //MissingJSON m=new MissingJSON();
	   String sec=MissingJSON.difference(socialverificationresultact, socialverificationresult);


	   System.out.println(sec);

	   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	
	

	}else{

	System.out.println("not matching");
	ExtentTestManager.getTest().log(LogStatus.FAIL, "Social Verification : LinkedIn  Result is Pass");
	ExtentTestManager.getTest().log(LogStatus.INFO, "Social Verification : LinkedIn  Expected:"+socialverificationresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Social Verification : LinkedIn  Actual:"+socialverificationresultact);
	ExtentTestManager.getTest().log(LogStatus.INFO, "Social Verification : LinkedIn  Result Comparison  is "+socialverificationresult.equals(socialverificationresultact));
	//ExtentTestManager.getTest().log(LogStatus.FAIL, "Error in identifying page1 :"+test.addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));




	}
		  
		}else{



			
			 System.out.println("no element");
			 
			 ExtentTestManager.getTest().log(LogStatus.FAIL, "Social Verification : LinkedIn Source site is Busy please Try Later ");
	        	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	        	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


			 //Assert.assertEquals(socialverificationresultact, socialverificationresult);	
			 

				}
			
			
		        }catch (NoSuchElementException e){
		        	
		        	ExtentTestManager.getTest().log(LogStatus.SKIP, "Social Verification : LinkedIn Source site is Busy please Try Later ");
                    
		        	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		        	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		        	
		        	
		        	
		        }




	 driver.close();
	 
	 
	 driver.switchTo().window(mainhandle);
	 

	 //Assert.assertEquals(socialverificationresultact, socialverificationresult);	
	 
	}	
	
}
