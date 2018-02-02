package com.electricity.verification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Rajasthanelectrpage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class Rajasthanelectrictyapi extends mainbase {




	  
	  
	  @DataProvider(name = "DP40")
		 public Object[][] createData40() throws Exception{
		  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
			  	                 "login", "LogingmailRajaele","LogingmailRajaele");
			  	         return(retObjArr);
			  	     } 
		  
		  
	  @Test(dataProvider="DP40")
	  public void ElectricityRajasthan(String Number,String Email  ,String Bill ,String Nature ,String exceptedreult,String actualresult,String testresult) throws BiffException, IOException, InterruptedException{		  		
	
		  ExtentTestManager.startTest(" Electricity : Rajasthan"); 
		  
		  
		  Rajasthanelectrpage vo=new Rajasthanelectrpage(driver);
		  
		  vo.clickrajasthanele(Number, Email,exceptedreult);
		
		  
		 
	
}
}