package com.allclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.relevantcodes.extentreports.LogStatus;


public class ListMatchingpage {

	
	WebDriver driver;
	public ListMatchingpage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

public void clickListMatching(String Name ,String exceptedreult) throws InterruptedException{
	
	
Thread.sleep(12000);
	
	
	
	//driver.findElement(By.xpath("//div[4]/div")).click();
	//Thread.sleep(4000);
	driver.findElement(By.xpath("//a[text()='Screening']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//div[text()='  List Matching']/input")).click();
	

Thread.sleep(6000);
driver.findElement(By.xpath(".//*[@id='list_name']")).sendKeys(Name);


driver.findElement(By.xpath(".//*[@id='listmatchview']/input")).click();




Thread.sleep(9000);
String ListMatchingresult=driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

String ListMatchingexcepted=exceptedreult;




Double resPercentage = LetterPairSimilarity.compareStrings(ListMatchingresult, ListMatchingexcepted);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");






if(resPercentage> 0 && (resPercentage*100) > 80){




	ExtentTestManager.getTest().log(LogStatus.INFO, "List Matching is started"+ListMatchingexcepted);
	ExtentTestManager.getTest().log(LogStatus.INFO, "List Matching actual is started"+ListMatchingresult);
	//ExtentTestManager.getTest().log(LogStatus.INFO, "List Matching Result Comparison is "+ListMatchingresult.contains(ListMatchingexcepted));
	ExtentTestManager.getTest().log(LogStatus.PASS, "List Matching  Result is Pass");
	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath)); 


	String sec=MissingJSON.difference(ListMatchingresult, ListMatchingexcepted);


	System.out.println(sec);

	ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);


		
	
	
	
	
}else{
	
	System.out.println("not matching");
	
	ExtentTestManager.getTest().log(LogStatus.FAIL, "List Matching  Result is Fail");
	
	ExtentTestManager.getTest().log(LogStatus.INFO, "List Matching is started"+ListMatchingexcepted);
	ExtentTestManager.getTest().log(LogStatus.INFO, "List Matching actual is started"+ListMatchingresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, "List Matching Result Comparison is "+ListMatchingresult.contains(ListMatchingexcepted));
	
	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath)); 


	String sec=MissingJSON.difference(ListMatchingresult, ListMatchingexcepted);


	System.out.println(sec);

	ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);


}




	
}
	
	
	
}
