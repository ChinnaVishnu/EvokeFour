package com.voteridVerification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.VoterIdLakshdeweeppage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoteridLakshaweepApi extends mainbase {

	@DataProvider(name = "DP20")
	public Object[][] createData20() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VoterIdVerificationLakshadweep", "VoterIdVerificationLakshadweep");
		return (retObjArr);
	}

	@Test(priority = 15, dataProvider = "DP20")
	public void VoterIdVerificationLakshadweep(String EPIC, String District, String ACFormTel, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("VoterId : Lakshadweep ");

		VoterIdLakshdeweeppage vo = new VoterIdLakshdeweeppage(driver);

		vo.clickvoterlakshdeep(EPIC, exceptedreult);

	}
}