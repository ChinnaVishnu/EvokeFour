package com.electricity.verification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Madayaprdesheelepage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




import jxl.write.WriteException;

public class MadayapradeshElectrictyApi  extends mainbase{

	
	



	  
	  
	 
	  @DataProvider(name = "DP38")
		 public Object[][] createData38() throws Exception{
		  Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
			  	                 "login", "Logingmailmadayapareshele","Logingmailmadayapareshele");
			  	         return(retObjArr);
			  	     } 
		  
		  
	  @Test(dataProvider="DP38")
	  public void ElectricityMadhyaPradesh(String IVRS   ,String Numberse ,String Bill ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException,  IOException, InterruptedException{		  		

		  ExtentTestManager.startTest(" Electricity : Madhya Pradesh "); 
		  
		  
		  Madayaprdesheelepage vo=new Madayaprdesheelepage(driver);
		  
		  vo.clickmadayapradesh(IVRS,exceptedreult);
		
		  
		  
}
}