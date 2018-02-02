package com.base.pack;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	public static ExtentReports extent;

	/*
	 * final static String filePath =
	 * System.getProperty("user.dir")+"\\test-output\\ExtentScreenshot.html";
	 * 
	 * public synchronized static ExtentReports getReporter() { if (extent ==
	 * null) { extent = new ExtentReports(filePath, true); }
	 * 
	 * return extent; }
	 */

	static String dateTimeString = new SimpleDateFormat("MMddhhmmss").format(new Date());

	static String path = System.getProperty("user.dir");

	public synchronized static ExtentReports getReporter() {

		if (extent == null) {
			extent = new ExtentReports(path + "/Reports/Automation_Report " + dateTimeString + " .html", false,
					DisplayOrder.NEWEST_FIRST);

		}
		return extent;

	}
}
