package com.allclasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.relevantcodes.extentreports.LogStatus;


public class FormBsnlInfopage  {

	
	
	public WebDriver driver;
	public FormBsnlInfopage(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	
public void clickFormBsnl(String IDTypeBsnl ,String Bsnlone,String bsnltwo,String exceptedreult) throws InterruptedException, IOException{
	
	Thread.sleep(7000);
	
	driver.findElement(By.xpath("//a[text()='Address Verification']")).click();
	
	Thread.sleep(7000);
	
	
	driver.findElement(By.xpath("//a[text()='Govt. Sources']")).click();
	
	Thread.sleep(7000);
	driver.findElement(By.xpath("(//input[@name='inputType'])[37]")).click();
	
	
	//driver.findElement(By.xpath("//td[text()='BSNL Landline']/input")).click();
	Thread.sleep(7000);
	
	 /*WebElement elementbsnl=driver.findElement(By.xpath(".//*[@id='idType']"));
		
		Select selectbsnl=new Select(elementbsnl);

		selectbsnl.selectByVisibleText(IDTypeBsnl);*/
		//Thread.sleep(4000);
		
		
		driver.findElement(By.xpath(".//*[@id='stdCode']")).sendKeys(Bsnlone);
		
		driver.findElement(By.xpath(".//*[@id='landlineNo']")).sendKeys(bsnltwo);
		Thread.sleep(7000);
		
		driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();
	
	

Thread.sleep(8000);
String FormBsnlLandline=exceptedreult;



String FormBsnlLandlineresult=driver.findElement(By.xpath(".//*[@id='reslut']")).getText();


driver.navigate().refresh();
Assert.assertEquals(FormBsnlLandlineresult, FormBsnlLandline);	
System.out.println(FormBsnlLandlineresult.equals(FormBsnlLandline));


if (FormBsnlLandlineresult.equals(FormBsnlLandline)) {

System.out.println("pass");





ExtentTestManager.getTest().log(LogStatus.INFO, "Form : BSNL-Info  excepted is started"+FormBsnlLandline); 
ExtentTestManager.getTest().log(LogStatus.INFO, "Form : BSNL-Info  resultactual is started"+FormBsnlLandlineresult); 
ExtentTestManager.getTest().log(LogStatus.INFO, "Form : BSNL-Info Result Comparison is "+FormBsnlLandlineresult.equals(FormBsnlLandline)); 
ExtentTestManager.getTest().log(LogStatus.PASS, "Form : BSNL-Info Result is Pass"); 







String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");


ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath)); 




}else{

System.out.println("not matching");
ExtentTestManager.getTest().log(LogStatus.FAIL, "Form : BSNL-Info Result is FAIL"); 
ExtentTestManager.getTest().log(LogStatus.INFO, "Form : BSNL-Info  excepted is started"+FormBsnlLandline); 
ExtentTestManager.getTest().log(LogStatus.INFO, "Form : BSNL-Info  resultactual is started"+FormBsnlLandlineresult); 
ExtentTestManager.getTest().log(LogStatus.INFO, "Form : BSNL-Info Result Comparison is "+FormBsnlLandlineresult.equals(FormBsnlLandline)); 






}
	
	
}
	
	
	
}
