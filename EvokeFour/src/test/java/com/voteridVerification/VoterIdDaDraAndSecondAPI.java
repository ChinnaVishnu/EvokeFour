package com.voteridVerification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.VoterIdDaDraAndSecondpage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoterIdDaDraAndSecondAPI extends mainbase {

	@DataProvider(name = "DP17")
	public Object[][] createData17() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VoterIdVerificationDadraHaveli", "VoterIdVerificationDadraHaveli");
		return (retObjArr);
	}

	@Test(priority = 9, dataProvider = "DP17")
	public void VoterIdVerificationDadraHaveli(String EPIC, String Number, String AC, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("VoterId : Dadra and Haveli ");

		VoterIdDaDraAndSecondpage vo = new VoterIdDaDraAndSecondpage(driver);

		vo.click(EPIC, exceptedreult);

	}
}