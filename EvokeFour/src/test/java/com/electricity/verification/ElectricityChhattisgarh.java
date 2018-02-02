package com.electricity.verification;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class ElectricityChhattisgarh  extends mainbase{

	

@DataProvider(name = "DP39")
	 public Object[][] createData39() throws Exception{
	  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "LogingmailChhattisgarh","LogingmailChhattisgarh");
		  	         return(retObjArr);
		  	     } 
	  
	  
@Test(dataProvider="DP39")
public void ElectricityChhattisgarh(String Account,String Numberse ,String Bill ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		

	 ExtentTestManager.startTest(" Electricity : Chhattisgarh "); 
	  
	  Thread.sleep(5000);
	  
	  
driver.findElement(By.xpath("//a[text()='Address Verification']")).click();	  
	  
Thread.sleep(9000);
driver.findElement(By.xpath("(//input[@name='inputType'])[38]")).click();


Thread.sleep(3000);
driver.findElement(By.xpath("//div[@id='electricityDetails']//a[text()='Chhattisgarh']")).click();

Thread.sleep(9000);

/*Thread.sleep(3000); Thread.sleep(9000);
	  
	  driver.findElement(By.xpath("//td[text()='Electricity Verification']/input")).click();		
	  Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='electricityDetails']/table/tbody/tr[1]/td[4]/a")).click();*/

		String mainhandleChhattisgarch=driver.getWindowHandle();

		String childhandleChhattisgarch="";

		Set<String>handlesChhattisgarch= driver.getWindowHandles();

		for (String handle : handlesChhattisgarch) {

		if (!handle.equals(mainhandleChhattisgarch)) {
			
			childhandleChhattisgarch=handle;
			
		}


		}

		driver.switchTo().window(childhandleChhattisgarch);	

		driver.findElement(By.xpath(".//*[@id='ctl00_maincontent_txtBillpayment']")).sendKeys(Account);


		driver.findElement(By.xpath(".//*[@id='submit']")).click();


		


		 try {
			    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			   try {
				   

		
		


	Thread.sleep(7000);

driver.manage().window().maximize();
	
Thread.sleep(2000);
	 String Chhattisgareleresult=exceptedreult; 
	 
	 

		String  Chhattisgareleresultact=driver.findElement(By.xpath(".//*[@id='result_div']/div")).getText();
			

		Double resPercentage = LetterPairSimilarity.compareStrings(Chhattisgareleresultact, Chhattisgareleresult);

		System.out.println("resPercentage "+resPercentage*100);
		String total=Double.toString(resPercentage*100);

		ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
		


		if(resPercentage> 0 && (resPercentage*100) > 80){
			
			System.out.println("pass");
			
			
			ExtentTestManager.getTest().log(LogStatus.PASS, " Electricity : Chhattisgarh Result is Pass");

			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Chhattisgarh Result excepted is started"+Chhattisgareleresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Chhattisgarh Result actual is started"+Chhattisgareleresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Chhattisgarh Result Comparison  is "+Chhattisgareleresult.equals(Chhattisgareleresultact));
			

			String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

			ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));
			
			 String sec=MissingJSON.difference(Chhattisgareleresultact, Chhattisgareleresult);


			   System.out.println(sec);

			   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
			
			
		}else{
			
			System.out.println("not matching");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Electricity : Chhattisgarh Result is Fail");
			
			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Chhattisgarh Result excepted is started"+Chhattisgareleresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Chhattisgarh Result actual is started"+Chhattisgareleresultact);
			ExtentTestManager.getTest().log(LogStatus.INFO, " Electricity : Chhattisgarh Result Comparison  is "+Chhattisgareleresult.equals(Chhattisgareleresultact));

			
			 String sec=MissingJSON.difference(Chhattisgareleresultact, Chhattisgareleresult);


			   System.out.println(sec);

			   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
			
		}
	 
	 
	 
			   } catch (Exception e) {
				   ExtentTestManager.getTest().log(LogStatus.ERROR, "Electricity : Chhattisgarh Source website is busy! Please try after some time");
			   }

			} catch(Exception e) {
			      System.out.println("no page");
			      System.out.println(e);
			  }
	 
	 
		driver.close();
		driver.switchTo().window(mainhandleChhattisgarch);;	
	
	  
		//Assert.assertEquals(Chhattisgareleresultact, Chhattisgareleresult);	
	  
	 


}

	
	
}
