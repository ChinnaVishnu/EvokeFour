package com.voteridVerification.practise.copy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;

public class DragandDrop {

public static void main(String[] args) throws InterruptedException {
	
	
	WebDriver driver=new FirefoxDriver();
	 
	// maximize browser
	driver.manage().window().maximize();
	 
	// Open webpage
	driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
	 
	// Add 5 seconds wait
	Thread.sleep(5000);
	 
	// Create object of actions class
	Actions act=new Actions(driver);
	 
	// find element which we need to drag
	WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));
	 
	// find element which we need to drop
	WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));
	 
	// this will drag element to destination
	act.dragAndDrop(drag, drop).build().perform();
	 
	}	
}	
	

