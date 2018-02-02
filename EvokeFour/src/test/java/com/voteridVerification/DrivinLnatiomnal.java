package com.voteridVerification;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DrivinLnatiomnal {

	 public static void main(String[] args) throws InterruptedException {
	    	
	    	WebDriver driver = new FirefoxDriver();
	       
	    	 driver.get("https://evoke-staging.jocatagrid.in/EvokeClient/webservices.jsp?key=M2YwMTNiZTQtMWQzOS00ZWQ4LWJkNTMtYzgwNTRiODg1YjE0#");
	
	    	driver.findElement(By.xpath(".//*[@id='panel1-1']/div[4]/input[2]")).click();
	    	
	
	    	
	    	  String handle= driver.getWindowHandle();
	    	  
		        System.out.println(handle);
	 
		        // Click on the Button "New Message Window"
	 
		       
	 
		        // Store and Print the name of all the windows open	              
	 
		        Set handles = driver.getWindowHandles();
	 
		        System.out.println(handles);
	 
		        // Pass a window handle to the other window
	 
		        for (String handle1 : driver.getWindowHandles()) {
	 
		        	System.out.println(handle1);
	 
		        	driver.switchTo().window(handle1);
	 
		        	}	
		        
		        driver.findElement(By.xpath(".//*[@id='licenceNumber']")).sendKeys("MH1220160049197");
		        
		        driver.findElement(By.xpath(".//*[@id='moNo']")).sendKeys("8374209585");
		        
		      //  driver.findElement(By.xpath(".//*[@id='captcha']")).sendKeys(keysToSend);
		        Thread.sleep(7000);
		        
		        driver.findElement(By.xpath(".//*[@id='DrivingLicenseDiv']/div[2]/span[1]/input")).click();
		        Thread.sleep(67000);
		        
		        driver.findElement(By.xpath(".//*[@id='DrivingLicenseDiv']/div[4]/div[2]/span[1]/input")).click();
		        
		        driver.close();
	    	
}
}