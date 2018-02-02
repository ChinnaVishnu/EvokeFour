package com.captha.sources;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class voteridindia2  extends mainbase{


@DataProvider(name = "DP14")
	 public Object[][] createData14() throws Exception{
	  Object[][] retObjArr=getTableArray("D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "voteridindia","voteridindia");
		  	         return(retObjArr);
		  	     } 
	  
	  
@Test(priority=6,dataProvider="DP14")
public void voteridindia (String EPIC ,String Service  ,String Bill ,String Nature ,String exceptedreult,String actualresult,String testresult) throws   BiffException, IOException, InterruptedException{		  		

	  ExtentTestManager.startTest(" VoterId : India "); 
	  Thread.sleep(8000);
	  
	  driver.findElement(By.xpath("//a[text()='Individual Verification']")).click();
	  
	  
	  Thread.sleep(6000);
			driver.findElement(By.xpath("(//input[@name='inputType'])[11]")).click();
		
		  Thread.sleep(7000);
		driver.findElement(By.xpath(".//*[@id='voterIdDetails']/div[1]/a[1]")).click();

		Thread.sleep(7000);
		String mainhandleandhra=driver.getWindowHandle();

		String childhandleAndhra="";

		Set<String>handlesandhra=	driver.getWindowHandles();

		for (String handle : handlesandhra) {

		if (!handle.equals(mainhandleandhra)) {
			
			childhandleAndhra=handle;
			
		}


		}

		driver.switchTo().window(childhandleAndhra);	


		driver.findElement(By.xpath(".//*[@id='allindia_epicNo']")).sendKeys(EPIC);
		
		Thread.sleep(25000);
		
		
		driver.findElement(By.xpath(".//*[@id='submit']")).click();
		
		Thread.sleep(35000);
		
		
		
		
		
String voteridindiaactualresult=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
	
String voteridindia=exceptedreult;



//System.out.println(voteridindia.equals(voteridindiaactualresult));

Double resPercentage = LetterPairSimilarity.compareStrings(voteridindiaactualresult, voteridindia);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"percentage of actual and expected :: "+total);



if(resPercentage> 0 && (resPercentage*100) > 80){
	


ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : India    resultexcepted is started"+voteridindia);
ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : India    resultactual is started"+voteridindiaactualresult);
//ExtentTestManager.getTest().log(LogStatus.INFO, "VoterId : India    resultcomparison is "+voteridindia.equals(voteridindiaactualresult));
ExtentTestManager.getTest().log(LogStatus.PASS, "VoterId : India    verification Result is Pass");

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screen short below :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

	
}else{

System.out.println("not matching");
ExtentTestManager.getTest().log(LogStatus.FAIL, " VoterId : India   Result is Fail");
}

driver.close();
driver.switchTo().window(mainhandleandhra);
//Assert.assertEquals(voteridindiaactualresult, voteridindia);	

}


}
