package com.electricity.verification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.karanatakaelectpage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;






public class KaranatakelectApi  extends mainbase{

	



	  

@DataProvider(name = "DP36")
	 public Object[][] createData36() throws Exception{
	  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "Logingmailkaranataele","Logingmailkaranataele");
		  	         return(retObjArr);
		  	     } 
		  
		  
	  @Test(dataProvider="DP36")
	  public void ElectricityKarnataka(String Account ,String Number ,String Bill ,String Nature ,String exceptedreult,String actualresult,String testresult) throws InterruptedException, IOException {		  		

 ExtentTestManager.startTest("Electricity: Karnataka "); 
		  
		  
		  karanatakaelectpage vo=new karanatakaelectpage(driver);
		  
		  vo.clickkarantaka(Account,exceptedreult);
		
		  
		
	
}
}