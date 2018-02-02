package com.captha.sources;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.banks.EPFdetailsWithLogin;
import com.banks.EpfDetailsWithoutLogin;
import com.drivinglinces.indival.FormDrivingLicenseDelhi;
import com.drivinglinces.indival.FormDrivingLicenseKerala;
import com.drivinglinces.indival.FormDrivingLicenseMadayapradesh;
import com.drivinglinces.indival.FormDrivingLicenseTelanga;
import com.drivinglinces.indival.FormPaninfo;
import com.electricity.address.ElectricityChhattisgarhAll;
import com.entity.verification.EntityVerificationAll;
import com.identity.verification.AadhaarVerificationFour;
import com.legel.proptaxlegel;
import com.voteridVerification.VoterIdUterrkhandApi;

public class AllinEvokeNon {

	public static void main(String[] args) {

		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		Class[] classes = new Class[] {

				CINVerification2.class, DINVerification.class,

				SignatoryDetails.class, ViewCompanyInformation.class, UdyogAadhaarVerification.class,

				voteridindia.class, voteridverificationdelhi.class, VoterIdVerificationGujarat.class,
				VoterIdVerificationjammuandkashmir.class, VoterIdUterrkhandApi.class,
				
				

				OtherverificationCST.class,

				OtherVerificationTDS.class,

				otherverificationefilling.class,
				otherverificationefilling2.class,
				

				ElectricityverificationTamilnadu.class,

				electricityVerificationdelhi2.class,

				ITRAcknowledgement.class,

				OTHERVERIFICATIONTAN.class,

				//Otherverificationpan.class,

				EPFdetailsWithLogin.class,

				EpfDetailsWithoutLogin.class,

				ServiceTax.class,

		};
		testng.setTestClasses(classes);
		testng.addListener(tla);
		testng.run();
	}

}
