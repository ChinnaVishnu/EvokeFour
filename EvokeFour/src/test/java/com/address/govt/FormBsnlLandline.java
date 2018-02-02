package com.address.govt;

import java.io.File;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.FormBsnlInfopage;
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
import jxl.write.WriteException;

public class FormBsnlLandline extends mainbase {


	

@DataProvider(name = "DP6")
     public Object[][] createData6() throws Exception{
         Object[][] retObjArr=getTableArray("D:\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls",
                 "login", "LogingmaillBsnlInfo","LogingmaillBsnlInfo");
         return(retObjArr);
     }


		
@Test(dataProvider="DP6")
public void FormBsnlLandlineInfo(String IDType ,String Bsnlone,String bsnltwo,String Gender,String exceptedreult,String actualresult,String testresult) throws  WriteException, BiffException, IOException, InterruptedException{
	
	ExtentTestManager.startTest(" FORM : BSNL Landline-info ");

	FormBsnlInfopage form=new FormBsnlInfopage(driver);
	
	form.clickFormBsnl(IDType, Bsnlone, bsnltwo,exceptedreult);
	
}

}
