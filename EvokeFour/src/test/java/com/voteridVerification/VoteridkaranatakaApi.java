package com.voteridVerification;

import java.io.IOException;

import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.VoteridKaranatakapage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoteridkaranatakaApi extends mainbase {

	@DataProvider(name = "DP27")
	public Object[][] createData27() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VoterIdVerificationKarnataka", "VoterIdVerificationKarnataka");
		return (retObjArr);
	}

	@Test(priority = 14, dataProvider = "DP27")
	public void VoterIdVerificationKarnataka(String District, String Voter, String AC, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest("VoterId : Karnataka ");

		VoteridKaranatakapage vo = new VoteridKaranatakapage(driver);

		vo.clickvoteridkaranaka(District, Voter, exceptedreult);

	}

}
