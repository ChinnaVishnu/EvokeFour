package com.legel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Propertaxhyderabadpage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class HyderabadTaxApi extends mainbase {
	

	


	  @DataProvider(name = "DP31")
		 public Object[][] createData31() throws Exception{
		  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
			  	                 "login", "Logingmailhyderabad","Logingmailhyderabad");
			  	         return(retObjArr);
			  	     } 
		  
		  
	  @Test(dataProvider="DP31")
	  public void PropertyTaxHyderabad(String Circle ,String Number,String AC     ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		
	
		  ExtentTestManager.startTest(" PropertyTax : Hyderabad "); 
		  
		  
		  Propertaxhyderabadpage vo=new Propertaxhyderabadpage(driver);
		  
		  vo.clickproperrtaxhyderbad(Circle, Number,exceptedreult);
		
		  
	  
	
	

}
}