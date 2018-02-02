package com.voteridVerification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.VoteridPundcherypage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoterIdPunDucherryApi extends mainbase {

	@DataProvider(name = "DP21")
	public Object[][] createData21() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VoterIdVerificationPuducherry", "VoterIdVerificationPuducherry");
		return (retObjArr);
	}

	@Test(priority = 17, dataProvider = "DP21")
	public void VoterIdVerificationPuducherry(String EPIC, String District, String ACFormTel, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" VoterId : Puducherry ");

		VoteridPundcherypage vo = new VoteridPundcherypage(driver);

		vo.clickvoteridpundchery(EPIC, exceptedreult);

	}
}