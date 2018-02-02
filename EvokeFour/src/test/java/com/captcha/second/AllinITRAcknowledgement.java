package com.captcha.second;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.banks.EPFdetailsWithLogin;
import com.captha.sources.ITRAcknowledgement;
import com.drivinglinces.indival.FormDrivingLicenseDelhi;
import com.drivinglinces.indival.FormDrivingLicenseKerala;
import com.drivinglinces.indival.FormDrivingLicenseMadayapradesh;
import com.drivinglinces.indival.FormDrivingLicenseTelanga;
import com.drivinglinces.indival.FormPaninfo;
import com.electricity.address.ElectricityChhattisgarhAll;
import com.entity.verification.EntityVerificationAll;
import com.identity.verification.AadhaarVerificationFour;
import com.legel.proptaxlegel;


public class AllinITRAcknowledgement {

	public static void main(String[] args) {
		

	 TestListenerAdapter tla = new TestListenerAdapter();
	    TestNG testng = new TestNG();
	     Class[] classes = new Class[]{
	    		 
	    		 
	    		 ITRAcknowledgement.class
	    		 
	    		 
	    		 
	    		 
	    		
	    		 
	           
	             };
	     testng.setTestClasses(classes);
	     testng.addListener(tla);
	     testng.run();
	    }	
	
}
