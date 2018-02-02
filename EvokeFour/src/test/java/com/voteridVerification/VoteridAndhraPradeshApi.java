package com.voteridVerification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.VoteridAndhrapradeshpage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoteridAndhraPradeshApi extends mainbase {

	@DataProvider(name = "DP26")
	public Object[][] createData26() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VoterIdVerificationAndhraPradesh", "VoterIdVerificationAndhraPradesh");
		return (retObjArr);
	}

	@Test(priority = 7, dataProvider = "DP26")

	public void VoterIdVerificationAndhraPradesh(String Photo, String District, String AC, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {
		ExtentTestManager.startTest(" VoterId : AndhraPradesh ");

		VoteridAndhrapradeshpage vo = new VoteridAndhrapradeshpage(driver);

		vo.clickvoteridAndhar(Photo, District, AC, exceptedreult);

	}

}
