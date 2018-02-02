package com.voteridVerification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.VoteridUterrkahandpage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoterIdUterrkhandApi extends  mainbase

  {



	@DataProvider(name = "DP25")
	public Object[][] createData25() throws Exception{
	 Object[][] retObjArr=getTableArray("D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
		  	                 "login", "VoterIdVerificationUttarakhand","VoterIdVerificationUttarakhand");
		  	         return(retObjArr);
		  	     } 
		  
	  @Test(priority=10,dataProvider="DP25")
	  public void VoterIdVerificationUttarakhand(String District    ,String Voter   ,String ACFormTel    ,String Nature ,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{		  		
	
		 ExtentTestManager.startTest(" VoterId : Uttarakhand "); 
		  
		  
		  VoteridUterrkahandpage vo=new VoteridUterrkahandpage(driver);
		  
		  vo.clickvoteriduterrekhand(District, Voter,exceptedreult);
		
	
	  }
}
