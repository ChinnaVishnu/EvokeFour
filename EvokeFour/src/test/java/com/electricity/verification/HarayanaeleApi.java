package com.electricity.verification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Harayanapage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class HarayanaeleApi extends mainbase {



@DataProvider(name = "DP44")
	 public Object[][] createData44() throws Exception{
	  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "Logingmailharayanaele","Logingmailharayanaele");
		  	         return(retObjArr);
		  	     } 
	  
		  
	  @Test(dataProvider="DP44")
	  public void ElectricityHaryana(String Number ,String Ward ,String Bill,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		
	
		  ExtentTestManager.startTest(" Electricity : Haryana "); 
		  
		  
		  Harayanapage vo=new Harayanapage(driver);
		  
		  vo.clickonHarayana(Number,exceptedreult);
		
		  
		  
		  
			
		}  	  		
				

	
	
}
