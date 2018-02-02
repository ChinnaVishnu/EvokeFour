package com.allclasses;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.relevantcodes.extentreports.LogStatus;



public class Propertaxhyderabadpage  {

	
	WebDriver driver;
	public Propertaxhyderabadpage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

public void clickproperrtaxhyderbad(String Circle ,String Number ,String exceptedreult) throws InterruptedException{
	
	//Thread.sleep(6000);
	//driver.findElement(By.xpath("//a[text()='  Financial/Tax/Legal']")).click();
	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//a[text()='Legal']")).click();
	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//div[text()='  PropertyTax Verification']/input")).click();
	
	Thread.sleep(6000);

	
	driver.findElement(By.xpath(".//*[@id='TaxIdDetails']/div[1]/a[2]")).click();

	 //...............................
	 String mainhandlehyderabad=driver.getWindowHandle();

	 String childhandlehyderabad="";

	 Set<String>handleshyderabad=driver.getWindowHandles();

	 for (String handle : handleshyderabad) {

	 if (!handle.equals(mainhandlehyderabad)) {
	 	
	 	childhandlehyderabad=handle;
	 	
	 }


	 }

	 driver.switchTo().window(childhandlehyderabad);	





	 WebElement elementcircle=driver.findElement(By.xpath("//select[@id='hyd_circle']"));

	 Select selectpunecicle=new Select(elementcircle);

	 selectpunecicle.selectByVisibleText(Circle);



	 driver.findElement(By.xpath("//input[@id='hyd_assessmentNumber']")).sendKeys(Number);


	 driver.findElement(By.xpath(".//*[@id='submit']")).click();


	 
	
	 

	try {
		    driver.manage().timeouts().pageLoadTimeout(75000, TimeUnit.MILLISECONDS);
		   try {

			   

	Thread.sleep(55000);


	 String prphyderabad=exceptedreult; 

		String prphyderabadresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

		


		 Double resPercentage = LetterPairSimilarity.compareStrings(prphyderabadresult, prphyderabad);

			System.out.println("resPercentage "+resPercentage*100);
			String total=Double.toString(resPercentage*100);

			ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
			


			if(resPercentage> 0 && (resPercentage*100) > 80){
		System.out.println("pass");
		
		

	ExtentTestManager.getTest().log(LogStatus.PASS, " PropertyTax : Hyderabad Result is pass");

	ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Hyderabad  excepted is started"+prphyderabad);
	ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Hyderabad actual is started"+prphyderabadresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Hyderabad  Result Comparison  is "+prphyderabadresult.equals(prphyderabad));


	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	 String sec=MissingJSON.difference(prphyderabadresult, prphyderabad);


	   System.out.println(sec);

	   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		
		
		
		
		
		}else{

		System.out.println("not matching");
		ExtentTestManager.getTest().log(LogStatus.FAIL, " PropertyTax : Hyderabad  Verification Result is Fail");
		

		ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Hyderabad  excepted is started"+prphyderabad);
		ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Hyderabad actual is started"+prphyderabadresult);
		ExtentTestManager.getTest().log(LogStatus.INFO, " PropertyTax : Hyderabad  Result Comparison  is "+prphyderabadresult.equals(prphyderabad));

		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		 String sec=MissingJSON.difference(prphyderabadresult, prphyderabad);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		
		
		}


		

		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.INFO, "PropertyTax :Hyderabad Request on site timed out");
				String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


			   
			   
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }


		
	 
	 driver.close();
	 driver.switchTo().window(mainhandlehyderabad);		

	 
	 //Assert.assertEquals(prphyderabadresult, prphyderabad);


	}

	
	
	
	
	
}
