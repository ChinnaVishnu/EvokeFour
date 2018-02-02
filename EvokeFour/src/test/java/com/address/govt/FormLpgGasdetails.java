package com.address.govt;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.mainbase;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class FormLpgGasdetails  extends mainbase{

	




@DataProvider(name = "DP61")
public Object[][] createData61() throws Exception{
 Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
	  	                 "login", "FormLPGDetails","FormLPGDetails");
	  	         return(retObjArr);
	  	     } 
 


 
@Test(dataProvider="DP61")
public void FormLPGDetails(String IDType ,String Number,String empty ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		

 ExtentTestManager.startTest(" Form : LPG-Info "); 

 Thread.sleep(7000);
	driver.findElement(By.xpath("//td[text()='LPG Details']/input")).click();

	Thread.sleep(3000);

	/*WebElement elementlpg =driver.findElement(By.xpath(".//*[@id='idType']"));

		Select selectlpgin=new Select(elementlpg);
		
		selectlpgin.selectByVisibleText(IDType );*/
	
		
		
 driver.findElement(By.xpath(".//*[@id='voterId']")).sendKeys(Number);
		
	Thread.sleep(2000);
 driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();
	
 
 
Thread.sleep(92000);

//driver.navigate().refresh();




String FormLPGresult=exceptedreult;



String FORMLPGactRe=driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

driver.navigate().refresh();

Assert.assertEquals(FORMLPGactRe, FormLPGresult);	
System.out.println(FORMLPGactRe.equals(FORMLPGactRe));
//driver.navigate().refresh();

if (FORMLPGactRe.contains(FormLPGresult)) {

System.out.println("pass");



ExtentTestManager.getTest().log(LogStatus.INFO, "Form : LPG-Info  excepted is started"+FormLPGresult);
ExtentTestManager.getTest().log(LogStatus.INFO, "Form : LPG-Info  actual is started"+FORMLPGactRe);
ExtentTestManager.getTest().log(LogStatus.INFO, "Form : LPG-Info  Result Comparison  is "+FormLPGresult.equals(FORMLPGactRe));
ExtentTestManager.getTest().log(LogStatus.PASS, "Form : LPG-Info   Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));






}else{

System.out.println("not matching");
ExtentTestManager.getTest().log(LogStatus.FAIL, "Form : LPG-Info   Result is Fail");
}
}	
	

}
