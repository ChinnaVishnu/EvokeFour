package com.legel;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.PropertaxAhmedabaapage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class PropertaxAhmedabadAPI extends mainbase {


	
  @DataProvider(name = "DP29")
		 public Object[][] createData29() throws Exception{
		  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
			  	                 "login", "PropertaxAhmedabadAPI","PropertaxAhmedabadAPI");
			  	         return(retObjArr);
			  	     } 
		  
		  
	  @Test(dataProvider="DP29")
	  public void PropertaxAhmedabad(String Tenement ,String Voter ,String AC  ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		
	
		 ExtentTestManager.startTest(" PropertyTax : Ahmedabad "); 
		  
		  
		  PropertaxAhmedabaapage vo=new PropertaxAhmedabaapage(driver);
		  
		  vo.clickpropAhamabad(Tenement,exceptedreult);
		
		
	  
		  
	
	
	
	
}
}