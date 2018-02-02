package com.allclasses;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenshort2 {
	public  static String capture(WebDriver driver,String screenshotName) throws IOException
	{

		TakesScreenshot ts=(TakesScreenshot)driver;

		File source=ts.getScreenshotAs(OutputType.FILE);
		
		
		Date date=new Date();

		String dest=System.getProperty("user.dir")+"/ErrorScreenshot/"+screenshotName+System.currentTimeMillis()+".png";
		
		//String dest="..\\ErrorScreenshot\\"+screenshotName+".png";
		
		File destination=new File(dest);
		
		FileUtils.copyFile(source, destination);
		
		return dest;
	    
		
	     	
	}

}
