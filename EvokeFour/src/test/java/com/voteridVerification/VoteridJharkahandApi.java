package com.voteridVerification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.voteridJarkhandpage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoteridJharkahandApi extends mainbase {

	@DataProvider(name = "DP15")
	public Object[][] createData15() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VoterIdVerificationJharkhand", "VoterIdVerificationJharkhand");
		return (retObjArr);
	}

	@Test(priority = 13, dataProvider = "DP15")
	public void VoterIdVerificationJharkhand(String Photo, String District, String AC, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("VoterId : Jharkhand ");

		voteridJarkhandpage voter = new voteridJarkhandpage(driver);

		voter.clickjharajkanad(Photo, District, AC, exceptedreult);

	}
}