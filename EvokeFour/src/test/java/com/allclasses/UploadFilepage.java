package com.allclasses;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.LogStatus;


public class UploadFilepage  {

	
	
	WebDriver driver;
	public UploadFilepage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	
public void clickUploadfile(String Password,String exceptedreult ) throws IOException, InterruptedException{
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//a[text()='Identity Verification']")).click();
	
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//input[@name='inputType'])[6]")).click();
	

	Thread.sleep(5000);
	//driver.findElement(By.xpath("//td[@width='50%']//div[@style='float:left; width:50%;']//table[@id='SOURCESTAB0E']//tbody/tr[7]//input")).click();
	
	//driver.findElement(By.xpath("//div[@id='uploadVerification']/table/tbody/tr/td[2]/img")).click();
	
	
 String mainhandle=driver.getWindowHandle();

	String childhandle="";

	Set<String>handles=	driver.getWindowHandles();

	for (String handle : handles) {

	if (!handle.equals(mainhandle)) {
		
		childhandle=handle;
		
	}


	}

	driver.switchTo().window(childhandle);	

	driver.findElement(By.xpath("//input[@id='UploadFileButton']")).click();
	
	
	ProcessBuilder bulidersecond =new ProcessBuilder("D:\\Autoit\\batch12_upload.exe");
	bulidersecond.start();

	
	driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(Password);
	
	Thread.sleep(3000);
	
	driver.findElement(By.xpath(".//*[@id='upload']")).click();
	
	
	 
	
	Thread.sleep(25000);
	String uploadresult=exceptedreult; 
	
	


String uploadresultact=driver.findElement(By.xpath(".//*[@id='result']")).getText();

Double resPercentage = LetterPairSimilarity.compareStrings(uploadresultact, uploadresult);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");

if(resPercentage> 0 && (resPercentage*100) > 80){
System.out.println("pass");


ExtentTestManager.getTest().log(LogStatus.INFO, " Upload Aadhar  File  excepted is started"+uploadresultact);
ExtentTestManager.getTest().log(LogStatus.INFO, " Upload Aadhar  File actual is started"+uploadresultact);
ExtentTestManager.getTest().log(LogStatus.INFO, " Upload Aadhar  File Result Comparison  is "+uploadresultact.equals(uploadresult));
ExtentTestManager.getTest().log(LogStatus.PASS, " Upload Aadhar  File  Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));



}else{

System.out.println("not matching");
ExtentTestManager.getTest().log(LogStatus.FAIL, "Upload Aadhar  File  Result is Fail");

ExtentTestManager.getTest().log(LogStatus.INFO, " Upload Aadhar  File  excepted is started"+uploadresultact);
ExtentTestManager.getTest().log(LogStatus.INFO, " Upload Aadhar  File actual is started"+uploadresultact);
ExtentTestManager.getTest().log(LogStatus.INFO, " Upload Aadhar  File Result Comparison  is "+uploadresultact.equals(uploadresult));
String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));




}
 
	
	
	
	driver.close();
	driver.switchTo().window(mainhandle);
	
 
 

	 //Assert.assertEquals(uploadresultact, uploadresult);	


}
}
