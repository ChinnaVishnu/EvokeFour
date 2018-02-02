package com.voteridVerification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.allclasses.Voteridsikkmpage;
import com.base.pack.ExtentTestManager;
import com.base.pack.mainbase;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class VoterIdSikkmApi extends mainbase {

	@DataProvider(name = "DP22")
	public Object[][] createData22() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VoterIdVerificationSikkim", "VoterIdVerificationSikkim");
		return (retObjArr);
	}

	@Test(priority = 18, dataProvider = "DP22")
	public void VoterIdVerificationSikkim(String District, String Voter, String ACFormTel, String Nature,
			String exceptedreult, String actualresult, String testresult)
					throws WriteException, BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" VoterId : Sikkim ");

		Voteridsikkmpage vo = new Voteridsikkmpage(driver);

		vo.clickvoteridsikkmpage(District, Voter, exceptedreult);

	}
}