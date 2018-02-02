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



public class VoteridAndhrapradeshpage {


	
	
	WebDriver driver;
	public VoteridAndhrapradeshpage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}
	
public void clickvoteridAndhar(String Photo ,String District ,String AC,String exceptedreult) throws InterruptedException, IOException{
	
	
	/*Thread.sleep(6000);
	
	driver.findElement(By.xpath("//td[text()='VoterId Verification']/input")).click();*/
	
	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//div[text()='  VoterId Verification']/input[@value='fetchVoterId']")).click();

	Thread.sleep(6000);
	
	driver.findElement(By.xpath("//div[@id='voterIdDetails']//a[text()='Andhra Pradesh']")).click();
	
	//driver.findElement(By.xpath(".//*[@id='voterIdDetails']/table/tbody/tr[3]/td[2]/a")).click();

	String mainhandleAndhra=driver.getWindowHandle();

	String childhandleAndhra="";

	Set<String>handlesAndhra=driver.getWindowHandles();

	for (String handle : handlesAndhra) {

	if (!handle.equals(mainhandleAndhra)) {

	childhandleAndhra=handle;

	}


	}

	driver.switchTo().window(childhandleAndhra);	


	driver.findElement(By.xpath(".//*[@id='gen_type2_epicNo']")).sendKeys(Photo);




	WebElement elementandhra=driver.findElement(By.xpath(".//*[@id='gen_type2_district']"));



	Select selectandhra=new Select(elementandhra);

	selectandhra.selectByVisibleText(District);


	WebElement elementacname= driver.findElement(By.xpath(".//*[@id='gen_type2_voting_town']"));

	Select selectac=new Select(elementacname);

	selectac.selectByVisibleText(AC);



	driver.findElement(By.xpath(".//*[@id='submit']")).click();


	try {
	    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
	   try {

	Thread.sleep(14000);



	String voteridAndharpradesh=exceptedreult;




	String   voteridAndharpradeshresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
		
	Double resPercentage = LetterPairSimilarity.compareStrings(voteridAndharpradeshresult, voteridAndharpradesh);

	System.out.println("resPercentage "+resPercentage*100);
	String total=Double.toString(resPercentage*100);

	ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
	


	if(resPercentage> 0 && (resPercentage*100) > 80){

	  System.out.println("pass");
	  
	  
	  ExtentTestManager.getTest().log(LogStatus.PASS, " VoterId : AndhraPradesh Result is Pass");
	  
	ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : AndhraPradesh excepted is started"+voteridAndharpradesh);
	ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : AndhraPradesh actual is started"+voteridAndharpradeshresult);
	//ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : AndhraPradesh Result Comparison  is "+voteridAndharpradeshresult.equals(voteridAndharpradesh));


	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	String sec=MissingJSON.difference(voteridAndharpradeshresult, voteridAndharpradesh);


	   System.out.println(sec);

	   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	  
	  
	  
	  
	  
	  }else{

	  System.out.println("not matching");
	  ExtentTestManager.getTest().log(LogStatus.FAIL, "VoterId : AndhraPradesh  Result is Fail");
	  
	  
		ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : AndhraPradesh excepted is started"+voteridAndharpradesh);
		ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : AndhraPradesh actual is started"+voteridAndharpradeshresult);
		ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : AndhraPradesh Result Comparison  is "+voteridAndharpradeshresult.equals(voteridAndharpradesh));


		String sec=MissingJSON.difference(voteridAndharpradeshresult, voteridAndharpradesh);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		  
	  
	  
	  
	  
	  }


	   } catch (Exception e) {
		   ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : AndhraPradesh Request on site timed out");
			String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


		   
	   }

	} catch(Exception e) {
	      System.out.println("no page");
	      System.out.println(e);
	  }



	driver.close();


	driver.switchTo().window(mainhandleAndhra);

	//Assert.assertEquals(voteridAndharpradeshresult, voteridAndharpradesh);
	 
}
}
