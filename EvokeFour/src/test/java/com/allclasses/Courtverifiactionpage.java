package com.allclasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.relevantcodes.extentreports.LogStatus;


public class Courtverifiactionpage {

	
	static WebDriver driver;
	public Courtverifiactionpage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

public  static void clickcourtvrification(String Enter,String exceptedreult) throws InterruptedException, IOException{
	Thread.sleep(6000);
	
driver.findElement(By.xpath("//td[text()='Court Verification']/input")).click();


//........................................................ Get details  ......................................................................//

driver.findElement(By.xpath(".//*[@id='courtverification']/table[1]/tbody/tr/td[2]/input")).click();	

driver.findElement(By.xpath(".//*[@id='c_verifyId']")).sendKeys(Enter);
	
driver.findElement(By.xpath(".//*[@id='get_court_div']/table/tbody/tr[3]/td[2]/input")).click();

Thread.sleep(1000);


String courtverresult=exceptedreult; 


	String courtverresultact=driver.findElement(By.xpath(".//*[@id='reslut']")).getText();
	
	
	driver.navigate().refresh();


	
//Assert.assertEquals(courtverresultact, courtverresult);	
//System.out.println(courtverresultact.equals(courtverresult));


if (courtverresultact.equals(courtverresult)) {
	
	System.out.println("pass");
	
	ExtentTestManager.getTest().log(LogStatus.INFO, " Court Verification excepted is started"+courtverresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Court Verification actual is started"+courtverresultact);
	ExtentTestManager.getTest().log(LogStatus.INFO, " Court Verification Result Comparison  is "+courtverresultact.equals(courtverresult));
	ExtentTestManager.getTest().log(LogStatus.PASS, " Court Verification    Result is Pass");

	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
	
	
	
	
}else{
	
	System.out.println("not matching");
	ExtentTestManager.getTest().log(LogStatus.FAIL, "Court Verification  Result is Fail");







	
}
	
}
}
	
	

