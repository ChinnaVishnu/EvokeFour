package com.electricity.verification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.punjablepage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





public class PunjabelectrictyApi extends mainbase {
 
	@DataProvider(name = "DP43")
	public Object[][] createData43() throws Exception{
	 Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "Logingmailpunele","Logingmailpunele");
		  	         return(retObjArr);
		  	     } 
		  
	  @Test(dataProvider="DP43")
	  public void ElectricityPunjab (String Account   ,String Ward ,String Bill,String Nature ,String exceptedreult,String actualresult,String testresult) throws   IOException, InterruptedException{		  		

		  ExtentTestManager.startTest(" Electricity : Punjab "); 
		  
		  
		  punjablepage vo=new punjablepage(driver);
		  
		  vo.clickpujejabele(Account,exceptedreult);
		
		  
		  
	  }
	  }	

