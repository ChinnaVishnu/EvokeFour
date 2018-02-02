package com.voteridVerification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Voteridhimachalaprdeshpage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class voteridHimachalPradeshApi extends mainbase {

	@DataProvider(name = "DP13")
	public Object[][] createData13() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VoterIdVerificationHimachalPradesh", "VoterIdVerificationHimachalPradesh");
		return (retObjArr);
	}

	@Test(priority = 12, dataProvider = "DP13")
	public void VoterIdVerificationHimachalPradesh(String District, String Voter, String Locality, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("  VoterId : HimachalPradesh ");

		Voteridhimachalaprdeshpage voter = new Voteridhimachalaprdeshpage(driver);

		voter.clickvoteridhimachal(District, Voter, exceptedreult);

	}
}