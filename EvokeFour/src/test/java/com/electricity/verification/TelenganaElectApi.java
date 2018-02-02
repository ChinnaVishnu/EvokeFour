package com.electricity.verification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Telanganaelepage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class TelenganaElectApi extends mainbase {

	  
	  



@DataProvider(name = "DP37")
	 public Object[][] createData37() throws Exception{
	  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "LogingmailTelanele","LogingmailTelanele");
		  	         return(retObjArr);
		  	     } 
	  
		  
		  
	  @Test(dataProvider="DP37")
	  public void ElectricityTelangana(String Number  ,String Numberse ,String Bill ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		
	
		  ExtentTestManager.startTest("Electricity : Telangana "); 
		  
		  
		  Telanganaelepage vo=new Telanganaelepage(driver);
		  
		  vo.clicktelangana(Number,exceptedreult);
		
		  
		  
				
}
}
