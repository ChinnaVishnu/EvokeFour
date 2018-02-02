package com.legel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.PropertaxBangolrepage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class BangolreTaxapi extends mainbase {

	

	@DataProvider(name = "DP32")
	public Object[][] createData32() throws Exception{
	 Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "Logingmailbnagolre","Logingmailbnagolre");
		  	         return(retObjArr);
		  	     } 
	 
		  
		  
	  @Test(dataProvider="DP32")
	  public void PropertyTaxBangalore(String SAS,String Name,String AC     ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		
	
		 ExtentTestManager.startTest("PropertyTax : Bangalore  "); 
		  
		  
		  PropertaxBangolrepage vo=new PropertaxBangolrepage(driver);
		  
		  vo.clickbangolre(SAS, Name,exceptedreult);
		
		 
}
}