package com.voteridVerification.practise.copy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class MultiDateDateTimePicker {

	
	private String demosite = "http://jqueryui.com/resources/demos/datepicker/other-months.html";
	WebDriver browser;
	WebDriverWait wait;
	@BeforeTest
	public void startTest() {
	// Launch the demo site to handle date time picker.
	browser = new FirefoxDriver();
	browser.manage().window().maximize();
	browser.navigate().to(demosite);
	}
	@Test
	public void jQueryCalendarMultipleMonths() throws InterruptedException {
	// Start the date time picker demo website.
	browser.navigate().to(demosite);
	// click to open the date time picker calendar.
	
	Thread.sleep(5000);
	WebElement calElement = browser.findElement(By.id("datepicker"));
	calElement.click();
	// Provide the day of the month to select the date.
	SelectDayFromMultiDateCalendar("11");
	}
	// Function to select the day of month in the date picker.
	public void SelectDayFromMultiDateCalendar(String day)
	throws InterruptedException {
	// We are using a special XPath style to select the day of current
	// month.
	// It will ignore the previous or next month day and pick the correct
	// one.
	By calendarXpath = By
	.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"
	+ day + "']");
	browser.findElement(calendarXpath).click();
	// Intentional pause for 2 seconds.
	Thread.sleep(2000);
	}
	@AfterTest
	public void endTest() {
	//browser.quit();
	}	
	
}
