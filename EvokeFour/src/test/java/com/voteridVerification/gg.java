package com.voteridVerification;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.util.PDFTextStripperByArea;

public class gg {

	public static void main(String[] args) {
		try{
	    PDDocument document = null;
	    document = PDDocument.load(new File("D:\\AUTOMATION REQUIRED DOCS\\AadharUpload\\l1_user_Benchmark_Run_Report_100717_061955_1499690995956_182686.pdf"));
	    document.getClass();
	    if (!document.isEncrypted()) {
	        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	        stripper.setSortByPosition(true);
	        PDFTextStripper Tstripper = new PDFTextStripper();
	        String st = Tstripper.getText(document);
	        System.out.println("Text:" + st);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}

		
	}
	
}
