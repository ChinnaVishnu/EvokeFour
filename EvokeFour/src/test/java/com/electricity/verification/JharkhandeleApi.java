package com.electricity.verification;

import java.io.IOException;

import org.apache.commons.io.filefilter.MagicNumberFileFilter;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Jharkhandelepage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class JharkhandeleApi extends mainbase {





@DataProvider(name = "DP41")
	 public Object[][] createData41() throws Exception{
	  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "LogingmaJharkhandele","LogingmaJharkhandele");
		  	         return(retObjArr);
		  	     } 
	  
	  

		  
		  
	  @Test(dataProvider="DP41")
	  public void ElectricityJharkhand(String Number,String Email  ,String Bill ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		
	
		  ExtentTestManager.startTest(" Electricity : Jharkhand "); 
		  
		  
		  Jharkhandelepage vo=new Jharkhandelepage(driver);
		  
		  vo.Jharkhandelepage(Number,exceptedreult);
		
		  
		
		
	  }
}
