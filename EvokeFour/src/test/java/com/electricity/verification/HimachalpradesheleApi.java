package com.electricity.verification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Himachalpradeshele;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class HimachalpradesheleApi extends mainbase {


@DataProvider(name = "DP42")
public Object[][] createData42() throws Exception{
 Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
	  	                 "login", "LogingmailHimele","LogingmailHimele");
	  	         return(retObjArr);
	  	     } 
 
	



	  @Test(dataProvider="DP42")
	  public void ElectricityHimachal(String Number  ,String Ward ,String Bill,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		
	
		  ExtentTestManager.startTest(" Electricity : Himachal Pradesh "); 
		  
		  
		  Himachalpradeshele vo=new Himachalpradeshele(driver);
		  
		  vo.clickHimachalpradesh(Number,exceptedreult);
		
		  
			
		}  	  		
			
}
