package com.allclasses;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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


public class Propertaxpuneapage  {

	
	WebDriver driver;
	public Propertaxpuneapage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	
	
	public void clickpune(String Property ,String Section ,String Peth,String Account,String exceptedreult) throws InterruptedException, IOException{
		
		//Thread.sleep(6000);
		//driver.findElement(By.xpath("//a[text()='  Financial/Tax/Legal']")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[text()='Legal']")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[text()='  PropertyTax Verification']/input")).click();
		
		Thread.sleep(6000);

		
		driver.findElement(By.xpath(".//*[@id='TaxIdDetails']/div[2]/a[1]")).click();

		
		 String mainhandlepune=driver.getWindowHandle();

		 String childhandlepune="";

		 Set<String>handlespune=driver.getWindowHandles();

		 for (String handle : handlespune) {

		 if (!handle.equals(mainhandlepune)) {
		 	
		 	childhandlepune=handle;
		 	
		 }


		 }

		 driver.switchTo().window(childhandlepune);	
		  



		     
		     
		     
		 WebElement elementpune=  driver.findElement(By.xpath("//select[@id='pune_property_type']"));
		     
		 Select selectpune=new Select(elementpune);

		 selectpune.selectByVisibleText(Property);


		 //....................................Section id...............................................................................//


		 driver.findElement(By.xpath("//input[@id='pune_sectionId']")).sendKeys(Section);



		 //.........................................Peth ID........................................................//


		 driver.findElement(By.xpath("//input[@id='pune_pethId']")).sendKeys(Peth);

		 //...........................................Account No.......................................................................//



		 driver.findElement(By.xpath("//input[@id='pune_accountNo']")).sendKeys(Account);



		 //.............................................Submit...............................................................................//


		 driver.findElement(By.xpath(".//*[@id='submit']")).click();

		 try {
			    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			   try {
				
		 
		 Thread.sleep(19000);
		 
		 String prppuneTax=exceptedreult; 


		 
		 
		 

			String prppuneTaxresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

			

			 Double resPercentage = LetterPairSimilarity.compareStrings(prppuneTaxresult, prppuneTax);

				System.out.println("resPercentage "+resPercentage*100);
				String total=Double.toString(resPercentage*100);

				ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
				


				if(resPercentage> 0 && (resPercentage*100) > 80){
			System.out.println("pass");
			



ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Pune excepted is started"+prppuneTax);
ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Pune actual is started"+prppuneTaxresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Pune Result Comparison  is "+prppuneTaxresult.equals(prppuneTax));

ExtentTestManager.getTest().log(LogStatus.PASS, " PropertyTax : Pune Result is pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
String sec=MissingJSON.difference(prppuneTaxresult, prppuneTax);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		




			}else{

			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, " PropertyTax : Pune Result is Fail");
			
			ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Pune excepted is started"+prppuneTax);
			ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Pune actual is started"+prppuneTaxresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Pune Result Comparison  is "+prppuneTaxresult.equals(prppuneTax));

			 String sec=MissingJSON.difference(prppuneTaxresult, prppuneTax);


			   System.out.println(sec);

			   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 			
			
			}

		 
		 

				 
			   } catch (Exception e) {
				   ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Pune Request on site timed out");
				   
					String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


				   
			   }

			} catch(Exception e) {
			      System.out.println("no page");
			      System.out.println(e);
			  }
				 




		 Thread.sleep(3000);
		 
		 
		 driver.close();
		 
		 
		 driver.switchTo().window(mainhandlepune);
		
	  
	
		 //Assert.assertEquals(prppuneTaxresult, prppuneTax);

}
}
