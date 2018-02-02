package com.Evoke.New;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EvokeElect {

	
	 public static void main(String[] args) throws InterruptedException {
	    	
	    	WebDriver driver = new FirefoxDriver();
	       
	    	 driver.get("https://evoke-staging.jocatagrid.in/EvokeClient/webservices.jsp?key=M2YwMTNiZTQtMWQzOS00ZWQ4LWJkNTMtYzgwNTRiODg1YjE0#");
	
	    	driver.findElement(By.xpath(".//*[@id='panel-1']/div[1]/div[4]/div[1]")).click();
	    	
	
	    	Thread.sleep(5000);
	        driver.findElement(By.xpath(".//*[@id='panel3-1']/div[2]/input")).click();	
	        Thread.sleep(5000);
	    	
	        driver.findElement(By.xpath(".//*[@id='electricityDetails']/div[2]/a[4]")).click();
	        
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
		        
		    	Thread.sleep(3000);

		    	WebElement element =driver.findElement(By.xpath("//select[@onchange='selectPowerDistribution()']"));

		    	
		    		Select select=new Select(element);
		    		
		    		select.selectByVisibleText("Southern Power Distribution");
		    		 Thread.sleep(5000);
		 	    	
		    		
		    		driver.findElement(By.xpath(".//*[@id='electricityNo2']")).sendKeys("AAAA");
		    		
		        
		    String Tee=		driver.findElement(By.xpath("//img[@id='captchasouth']")).getText();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath(".//*[@id='captchaCodeSouth']")).sendKeys(Tee);
		        
		    
		    driver.findElement(By.xpath(".//*[@id='electricitySouthernDiv']/div/span[1]/input")).click();
		        
	
}
}
