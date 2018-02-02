package com.address.govt;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class FormPinCodeInforamtion extends mainbase {

	

@DataProvider(name = "DP60")
public Object[][] createData60() throws Exception{
 Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
	  	                 "login", "FormPincodenInformation","FormPincodenInformation");
	  	         return(retObjArr);
	  	     } 
 


 
@Test(dataProvider="DP60")
public void FormPincodenInformation(String Type    ,String Number   ,String empty ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		

 ExtentTestManager.startTest(" Form : PinCode-Info  "); 

 Thread.sleep(9000);
	driver.findElement(By.xpath("//td[text()='Pincode Verification']/input")).click();

	Thread.sleep(3000);

	/*WebElement elementpin =driver.findElement(By.xpath(".//*[@id='idType']"));

		Select selectpin=new Select(elementpin);
		
		//selectpin.selectByIndex(10);
		
		selectpin.selectByVisibleText(Type);*/
		
		
	
 driver.findElement(By.xpath(".//*[@id='pincode']")).sendKeys(Number);
		
	Thread.sleep(2000);
 driver.findElement(By.xpath(".//*[@id='json']/div[11]/table/tbody/tr/td[2]/div/input")).click();
	

Thread.sleep(9000);
String FormpininfoApi=exceptedreult;



String FORMpinbillinfo=driver.findElement(By.xpath(".//*[@id='reslut']")).getText();


driver.navigate().refresh();


Assert.assertEquals(FORMpinbillinfo, FormpininfoApi);	
System.out.println(FORMpinbillinfo.equals(FormpininfoApi));


if (FORMpinbillinfo.contains(FormpininfoApi)) {

System.out.println("pass");




ExtentTestManager.getTest().log(LogStatus.INFO, "Form : PinCode-Info excepted is started"+FormpininfoApi);
ExtentTestManager.getTest().log(LogStatus.INFO, "Form : PinCode-Info actual is started"+FORMpinbillinfo);
ExtentTestManager.getTest().log(LogStatus.INFO, "Form : PinCode-Info Result Comparison  is "+FORMpinbillinfo.equals(FormpininfoApi));
ExtentTestManager.getTest().log(LogStatus.PASS, "Form : PinCode-Info Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));






}else{

System.out.println("not matching");
ExtentTestManager.getTest().log(LogStatus.FAIL, "Form : PinCode-Info  Result is Fail");
}
}
	
}
