package com.legel;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.hew;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CIBILAPI extends mainbase {


@DataProvider(name = "DP2")
     public Object[][] createData2() throws Exception{
         Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
                 "login", "LogingmaillCbil","LogingmaillCbil");
         return(retObjArr);
     }

@Test(dataProvider="DP2")
public void CIBIL(String Suit ,String Entity ,String Director ,String empty,String exceptedreult,String actualresult,String testresult) throws   BiffException, IOException, InterruptedException{

	ExtentTestManager.startTest(" CIBIL  Suit Case Files");
	  
	
	hew cibil=new hew(driver);
	
	cibil.clickcibil(Suit, Entity, Director,exceptedreult);
	

}
}
