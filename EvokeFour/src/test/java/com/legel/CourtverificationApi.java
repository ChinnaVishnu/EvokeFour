package com.legel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Courtverifiactionpage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class CourtverificationApi  extends mainbase{


	  @DataProvider(name = "DP49")
		 public Object[][] createData49() throws Exception{
		  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
			  	                 "login", "Logingmailcourt","Logingmailcourt");
			  	         return(retObjArr);
			  	     } 
		  
		  
	  @Test(dataProvider="DP49")
	  public void Courtverification(String Enter    ,String Ward ,String Bill,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		
	
		  ExtentTestManager.startTest(" Court verification  "); 
		  
		  
		  Courtverifiactionpage vo=new Courtverifiactionpage(driver);
		  
		  vo.clickcourtvrification(Enter,exceptedreult);
		
		  
		  
			
			
	  		
						
	
	
	
	
	  }
	
}
