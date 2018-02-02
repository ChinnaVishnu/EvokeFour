package com.voteridVerification;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

public class GSMAAPI extends mainbase{

	
	
	@DataProvider(name = "DP4")
    public Object[][] createData4() throws Exception{
        Object[][] retObjArr=getTableArray("D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
                "login", "GSMAAPI","GSMAAPI");
        return(retObjArr);
    }

@Test(priority=84,dataProvider="DP4")
public void adveseSecondGSMA(String Adverse,String Entity ,String Director ,String empty,String exceptedreult,String actualresult,String testresult) throws InterruptedException {

	
	ExtentTestManager.startTest("  GSMA API ");	
	
	
	Thread.sleep(4000);

	
	driver.findElement(By.xpath("//div[2]/div/div")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[text()='Individual Verification']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//input[@name='inputType'])[9]")).click();
	
	
	String mainhandleAndhra=driver.getWindowHandle();

	String childhandleAndhra="";

	Set<String>handlesAndhra=driver.getWindowHandles();

	for (String handle : handlesAndhra) {

	if (!handle.equals(mainhandleAndhra)) {

	childhandleAndhra=handle;

	}


	}

	driver.switchTo().window(childhandleAndhra);	

	driver.manage().window().maximize();
	
	driver.findElement(By.xpath(".//*[@id='mobile']")).sendKeys(Adverse);
	
	driver.findElement(By.xpath(".//*[@id='button']")).click();
	
	
	Thread.sleep(42000);
	
	String    GSMAAPIexceptedresult=exceptedreult;
	
	String   GSMAAPIactualresult=driver.findElement(By.xpath(".//*[@id='result_data']")).getText();


	Double resPercentage = LetterPairSimilarity.compareStrings(GSMAAPIactualresult, GSMAAPIexceptedresult);

	System.out.println("resPercentage "+resPercentage*100);
	String total=Double.toString(resPercentage*100);

	ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
	


	if(resPercentage> 0 && (resPercentage*100) > 80){

	  System.out.println("pass");
	  
	  
	  ExtentTestManager.getTest().log(LogStatus.PASS, " GSMA API Result is Pass");
	  
	ExtentTestManager.getTest().log(LogStatus.INFO, "  GSMA API excepted is started"+GSMAAPIexceptedresult);
	ExtentTestManager.getTest().log(LogStatus.INFO, "  GSMA API actual is started"+GSMAAPIactualresult);
	//ExtentTestManager.getTest().log(LogStatus.INFO, "  GSMA APIResult Comparison  is "+GSMAAPIactualresult.equals(GSMAAPIexceptedresult));


	String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

	ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	String sec=MissingJSON.difference(GSMAAPIactualresult, GSMAAPIexceptedresult);


	   System.out.println(sec);

	   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
	  
	  
	  
	  
	  
	  }else{

	  System.out.println("not matching");
	  ExtentTestManager.getTest().log(LogStatus.FAIL, " GSMA API Result is Fail");
	  
	  
	  ExtentTestManager.getTest().log(LogStatus.INFO, "GSMA API excepted is started"+GSMAAPIexceptedresult);
		ExtentTestManager.getTest().log(LogStatus.INFO, " GSMA API actual is started"+GSMAAPIactualresult);
		ExtentTestManager.getTest().log(LogStatus.INFO, " GSMA APIResult Comparison  is "+GSMAAPIactualresult.equals(GSMAAPIexceptedresult));


		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		String sec=MissingJSON.difference(GSMAAPIactualresult, GSMAAPIexceptedresult);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		  
		  
	  
	  
	  
	  
	  }



	driver.close();


	driver.switchTo().window(mainhandleAndhra);

	
	 
}
	
	
	
}
