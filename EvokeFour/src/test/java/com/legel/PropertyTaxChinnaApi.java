package com.legel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Propertaxchinnapage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class PropertyTaxChinnaApi extends mainbase {




	  @DataProvider(name = "DP33")
		 public Object[][] createData33() throws Exception{
		  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
			  	                 "login", "LogingmailchennaiTax","LogingmailchennaiTax");
			  	         return(retObjArr);
			  	     } 
		  
		  
	  @Test(dataProvider="DP33")
	  public void PropertyTaxChinna(String Zone ,String Ward,String Bill,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		
	
		 ExtentTestManager.startTest("PropertyTax : Chennai "); 
		  
		  
		  Propertaxchinnapage vo=new Propertaxchinnapage(driver);
		  
		  vo.clickchinnatax(Zone, Ward, Bill,exceptedreult);
		
		
	
}
}