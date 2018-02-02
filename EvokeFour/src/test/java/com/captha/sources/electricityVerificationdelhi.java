package com.captha.sources;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class electricityVerificationdelhi extends mainbase {


      @DataProvider(name = "DP2")
	 public Object[][] createData2() throws Exception{
	  Object[][] retObjArr=getTableArray("D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "ElectricityverificationDelhi","ElectricityverificationDelhi");
		  	         return(retObjArr);
		  	     } 
	  
	  
@Test(priority=14,dataProvider="DP2")
public void ElectricityDelhi(String CANumber ,String Number ,String Bill ,String Nature ,String exceptedreult,String actualresult,String testresult) throws   BiffException, IOException, InterruptedException{		  		

	  ExtentTestManager.startTest("Electricity : Delhi "); 
	  Thread.sleep(9000);
	  
	  
	  driver.findElement(By.xpath("//a[text()='Govt. Sources']")).click();
	  Thread.sleep(7000);
	  
	  driver.findElement(By.xpath("(//input[@name='inputType'])[39]")).click();
	  Thread.sleep(7000);
	  driver.findElement(By.xpath(".//*[@id='electricityDetails']/div[1]/a[2]")).click();
	  
	  
		/*driver.findElement(By.xpath("//td[text()='Electricity Verification']/input")).click();
		
		  Thread.sleep(7000);
		driver.findElement(By.xpath(".//*[@id='electricityDetails']/table/tbody/tr[1]/td[3]/a")).click();*/

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

	  
	  driver.findElement(By.xpath(".//*[@id='txtCA_Number']")).sendKeys(CANumber);
	  
	  Thread.sleep(20000);
	  
	  driver.findElement(By.xpath(".//*[@id='submit']")).click();
	  
	
	  try {
		   
		  
		   
		   // Check the presence of alert
		   Alert alert = driver.switchTo().alert();
		   // Alert present; set the flag
		   ExtentTestManager.getTest().log(LogStatus.ERROR, "Electricity : Delhi  please  Enter the  current captcha  ");
		   Thread.sleep(4000);
		   // if present consume the alert
		   alert.accept();
		   
		  //foundAlert = true; 
		   
		   
	 } catch (NoAlertPresentException ex) {
		 ex.printStackTrace();
		 System.out.println("no alert");
		//foundAlert = false;
		 
		 Thread.sleep(21000);
	  
	  
	  
String electrcitydelhiact =	driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();

String electricityresult=exceptedreult;



//System.out.println(electricityresult.equals(electrcitydelhiact));


Double resPercentage = LetterPairSimilarity.compareStrings(electrcitydelhiact, electricityresult);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"percentage of actual and expected :: "+total);



if(resPercentage> 0 && (resPercentage*100) > 80){
	
	
	
	System.out.println(" PASS    ");


ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : Delhi  resultexcepted is started"+electricityresult);
ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : Delhi  resultactual is started"+electrcitydelhiact);
ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : Delhi  resultcomparison is "+electricityresult.equals(electrcitydelhiact));
ExtentTestManager.getTest().log(LogStatus.PASS, "Electricity : Delhi   Result is Pass");

//String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

//ExtentTestManager.getTest().log(LogStatus.PASS, "Screen short below :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


//test.log(LogStatus.INFO, "Screenshortbelow :"+test.addScreenCapture(GetScreenshort2.capture(driver, "ScreenshortForExtentReport")));

ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));
	


}else{

System.out.println("not matching");
ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : Delhi  Result is Fail");
ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : Delhi  resultexcepted is started"+electricityresult);
ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : Delhi  resultactual is started"+electrcitydelhiact);
ExtentTestManager.getTest().log(LogStatus.INFO, "Electricity : Delhi  resultcomparison is "+electricityresult.equals(electrcitydelhiact));
ExtentTestManager.getTest().log(LogStatus.INFO, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(GetScreenshort.capture(driver, "ScreenshortForExtentReport")));




}


		
//test.log(LogStatus.WARNING, "Electricity : Delhi  Result is source site busy please try later");
		
driver.close();
driver.switchTo().window(mainhandleandhra);
//Assert.assertEquals(electrcitydelhiact, electricityresult);	

}
}
}
