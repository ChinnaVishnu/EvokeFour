package com.legel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Propertaxpuneapage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class PropertyPuneTaxapi  extends mainbase
{


	


@DataProvider(name = "DP30")
public Object[][] createData30() throws Exception{
Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "LogingmailpuneTax","LogingmailpuneTax");
return(retObjArr);
		  	     } 
	   
		  
		  
	  @Test(dataProvider="DP30")
	  public void PropertyTaxPune(String Property,String Section ,String Peth,String Account,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		
	
		 ExtentTestManager.startTest(" PropertyTax : Pune "); 
		  
		  
		  Propertaxpuneapage vo=new Propertaxpuneapage(driver);
		  
		  vo.clickpune(Property, Section, Peth, Account,exceptedreult);
		
	
	
}
}