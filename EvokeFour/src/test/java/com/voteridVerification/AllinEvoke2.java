package com.voteridVerification;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.banks.AndhraBank;
import com.banks.AxisBank;
import com.banks.AxisBank2;
import com.banks.CanaraBank;
import com.banks.EpfDetailsWithoutLogin;
import com.banks.Form16Upload;
import com.banks.HDFCCurrentAcc;
import com.banks.IDBIBank;
import com.banks.INDUSINDBank;
import com.banks.INGBank;
import com.banks.IciciBank;
import com.banks.KOTAKBank;
import com.banks.StandardCharteredBank;
import com.banks.StateBankofIndia;
import com.banks.YesBank;
import com.banks.punjabnationalbank;
import com.drivinglinces.indival.AadharUploadFile;
import com.drivinglinces.indival.FormDrivingLicenseDelhi;
import com.drivinglinces.indival.FormDrivingLicenseKerala;
import com.drivinglinces.indival.FormDrivingLicenseMadayapradesh;
import com.drivinglinces.indival.FormDrivingLicenseTelanga;
import com.drivinglinces.indival.FormPaninfo;
import com.drivinglinces.indival.UploadFileApi;
import com.electricity.address.ElectricityChhattisgarhAll;
import com.entity.verification.EntityVerificationAll;
import com.identity.verification.AadhaarVerificationFour;
import com.identity.verification.AadhaarVerificationFour2;
import com.international.verification.CompanyByCompanyNo;
import com.international.verification.CompanyByName;
import com.international.verification.CompanyofficersList;
import com.international.verification.FillingHistory;
import com.international.verification.OfficersAppointmentList;
import com.international.verification.PersonsWithSignificant;
import com.international.verification.RegisteredofficeAddress;
import com.latest.ITRuploads.ITR12014Version;
import com.latest.ITRuploads.ITR12015Version;
import com.latest.ITRuploads.ITR22014Version;
import com.latest.ITRuploads.ITR22015Version;
import com.latest.ITRuploads.ITR52014DefectiveVersion;
import com.latest.ITRuploads.ITRAck2015Version;
import com.latest.ITRuploads.ITRAck2016Version;
import com.legel.CourtVerificationSecond;
import com.legel.CourtverificationApi2;
import com.legel.CourtverificationApi3;
import com.legel.proptaxlegel;
import com.legel.Tax.CstKaranakata;
import com.legel.Tax.CstTamilnadu;
import com.legel.Tax.DinCaptchaHandleing;
import com.legel.Tax.ITRUpload;
import com.legel.Tax.TIN;
import com.membershipverification.MembershipCostAccountant;
import com.membershipverification.MembershipCostCouncilArchitecture;
import com.social.screening.AdverseNews;
import com.social.screening.FormEmailApi;
import com.social.screening.LinkdinVerificationEvoke;
import com.social.screening.ListMAtchingApi;
import com.social.screening.VechileRegistration;


public class AllinEvoke2 {

	public static void main(String[] args) {
		

	 TestListenerAdapter tla = new TestListenerAdapter();
	    TestNG testng = new TestNG();
	     Class[] classes = new Class[]{
	    		 
	    		 
	    		// AadhaarVerificationFour2.class,
	    		 
	    		
	    		 /*FormPaninfo.class,
	    		 FormDrivingLicenseDelhi.class,
	    		 FormDrivingLicenseKerala.class,
	    		 FormDrivingLicenseMadayapradesh.class,
	    		 FormDrivingLicenseTelanga.class,
	    		 
//..........................VoteridSources...............................................................................//	    		 
	    		 
	    		 VoteridAndhraPradeshApi.class,
	    		 VoterIdAndman.class,
	    		 VoterIdDaDraAndSecondAPI.class,
	    		 VoteridGoa.class,
	    		 VoteridHarayanaApi.class,
	    		 voteridHimachalPradeshApi.class,
	    		 VoteridJharkahandApi.class,
	    		 VoteridkaranatakaApi.class,
	    		 VoteridLakshaweepApi.class,
	    		 VoterIdOdishApi.class,
	    		 
	    		 
	    		 VoterIdPunDucherryApi.class,
	    		 VoterIdSikkmApi.class,
	    		 VoterIdTamilNadu.class,
	    		 VoteridTelangaApi.class,
	    		 VoterIdTripuraApi.class,*/
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	    		// EntityVerificationAll.class,
	    		 
	    		 
	    		// ElectricityChhattisgarhAll.class,
	    		 
	    		 
	    		 
	    		 //proptaxlegel.class,
	    		 
	    		// CourtverificationApi2.class,
	    		 //CourtverificationApi3.class,
	    		 
	    		 
	    		
	    		 
	    		 
	    		 
	    		 
	    		 
	    	  /*   AdverseNews.class,
	    		 FormEmailApi.class,
	    		 ListMAtchingApi.class,
	    		 VechileRegistration.class,*/
	    		 
	    		 
	    		 
	    		/* CstKaranakata.class,
	    	     CstTamilnadu.class,
	    		 */
	    		
	    	    // AadharUploadFile.class,
	    
	    		
	  
	    	     
	   //......................ITR Uploads......................................................................................// 	     
	    		 /*ITR12014Version.class,
	    		 ITR12015Version.class,
	    		 ITR22014Version.class,
	    		 ITR22015Version.class,
	    		 ITR52014DefectiveVersion.class,
	    		 ITRAck2015Version.class,
	    		 ITRAck2016Version.class,*/
	    		 
	    		 
	    		 
	    		 
	     
	  //................................Banks Verification.......................................................................//  		 
	    	 
	    		/* AxisBank2.class,
	    		 AndhraBank.class, 
	    		 CanaraBank.class,
	    		 HDFCCurrentAcc.class,
	    		 IciciBank.class,
	    		 IDBIBank.class,
	    		 INDUSINDBank.class,
	    		 INGBank.class,
	    		 KOTAKBank.class,
	    		 punjabnationalbank.class,
	    		 StandardCharteredBank.class,
	    		 StateBankofIndia.class,
	    		 YesBank.class,*/
	    		 
	    		 
	    	
	    		 
	    	/*	 DinCaptchaHandleing.class,
	    		 
	    		 Form16Upload.class,
	    		 
	    		
	    		 
	
//......................................International Verification................................................................//	    		 
	    	
	    		 CompanyByName.class,
	    		 CompanyByCompanyNo.class,
	    		 CompanyofficersList.class,
	    		 
	    		 
	    		 
	    		 RegisteredofficeAddress.class,
	    		 FillingHistory.class,
	    		 OfficersAppointmentList.class,
	    		 PersonsWithSignificant.class,
	    		 
	    		 
	    		 
	    		 TIN.class,*/
	    		 
	    		 MembershipCostAccountant.class,
	    		 MembershipCostCouncilArchitecture.class,
	    		 DoctorVerification.class

	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	    		 
	           
	             };
	     testng.setTestClasses(classes);
	     testng.addListener(tla);
	     testng.run();
	    }	
	
}
