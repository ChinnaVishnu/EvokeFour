package com.voteridVerification.practise.copy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class AutoSuggestions {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.findElement(By.id("gbqfq")).sendKeys("selenium");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List allOptions = driver.findElements(By.xpath("//td/span[text()='selenium']"));
		
		for (int i = 0; i < allOptions.size(); i++) {
			String option = allOptions.get(i).toString();
			System.out.println(option);
		}
	}	
	
}
