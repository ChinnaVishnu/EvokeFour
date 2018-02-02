package com.voteridVerification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.VoteridTripurapage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoterIdTripuraApi extends mainbase {

	@DataProvider(name = "DP24")
	public Object[][] createData24() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VoterIdVerificationTripura", "VoterIdVerificationTripura");
		return (retObjArr);
	}

	@Test(priority = 21, dataProvider = "DP24")
	public void VoterIdVerificationTripura(String EPIC, String Voter, String ACFormTel, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" VoterId : Tripura ");

		VoteridTripurapage vo = new VoteridTripurapage(driver);

		vo.clickonvoteridtripura(EPIC, exceptedreult);

	}
}