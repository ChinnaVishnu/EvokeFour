package com.allclasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.relevantcodes.extentreports.LogStatus;


public class FormEmailApipage  {

	
	public WebDriver driver;
	public FormEmailApipage(WebDriver driver) {
		super();
		
		this.driver=driver;
	}

	
	public void clickonEmail(String Type  ,String Email,String exceptedreult ) throws InterruptedException, IOException{
		
		
		Thread.sleep(6000);
		
		
		//driver.findElement(By.xpath("//div[4]/div")).click();
		
		
		//Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Screening']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[text()='  Email']/input")).click();
		
		
		Thread.sleep(6000);
	 
		driver.findElement(By.xpath(".//*[@id='emailId']")).sendKeys(Email);
		
		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();
		

		
		
		
		


Thread.sleep(38000);
String FORMEmailresult=exceptedreult;



String FORMEmailinforesult=driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

//driver.navigate().refresh();

Double resPercentage = LetterPairSimilarity.compareStrings(FORMEmailinforesult, FORMEmailresult);

	System.out.println("resPercentage "+resPercentage*100);
	String total=Double.toString(resPercentage*100);

	ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
	
	




	if(resPercentage> 0 && (resPercentage*100) > 80){
  


	
	 ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Email  excepted is started"+FORMEmailresult); 
	 ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Email  resultactual is started"+FORMEmailinforesult); 
	 //ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Email  Result Comparison is "+FORMEmailinforesult.equals(FORMEmailresult)); 
	 ExtentTestManager.getTest().log(LogStatus.PASS, "FORM : Email Result is Pass"); 
	
String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath)); 


String sec=MissingJSON.difference(FORMEmailinforesult, FORMEmailresult);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);






}else{

System.out.println("not matching");


ExtentTestManager.getTest().log(LogStatus.FAIL, "FORM : Email Result is Fail"); 
ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Email  excepted is started"+FORMEmailresult); 
ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Email  resultactual is started"+FORMEmailinforesult); 
ExtentTestManager.getTest().log(LogStatus.INFO, "FORM : Email  Result Comparison is "+FORMEmailinforesult.equals(FORMEmailresult)); 

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath)); 


String sec=MissingJSON.difference(FORMEmailinforesult, FORMEmailresult);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);





}
		
	}
	
	
	
	
}
