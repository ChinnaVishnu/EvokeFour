package com.electricity.verification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Keralaapage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class KeralaApiele extends mainbase {

	


@DataProvider(name = "DP45")
public Object[][] createData45() throws Exception{
 Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
	  	                 "login", "Logingmailkaralaele","Logingmailkaralaele");
	  	         return(retObjArr);
	  	     } 
		  
	  @Test(dataProvider="DP45")
	  public void ElectricityKerala(String Number ,String Ward ,String Bill,String Nature ,String exceptedreult,String actualresult,String testresult) throws InterruptedException, IOException   {		  		
	
		 ExtentTestManager.startTest(" Electricity : Kerala "); 
		  
		  
		  Keralaapage vo=new Keralaapage(driver);
		  
		  vo.clikkerala(Number, Ward, Bill,exceptedreult);
		
		  
		  
		
	
}
}