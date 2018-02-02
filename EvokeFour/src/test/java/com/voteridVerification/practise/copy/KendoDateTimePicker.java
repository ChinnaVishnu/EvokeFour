package com.voteridVerification.practise.copy;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class KendoDateTimePicker {

	private String demosite = "http://demos.telerik.com/kendo-ui/datetimepicker/index";
	WebDriver browser;
	WebDriverWait wait;
	@BeforeTest
	public void startTest() {
	// Launch the demo site to handle date time picker.
	browser = new FirefoxDriver();
	browser.manage().window().maximize();
	wait = new WebDriverWait(browser, 5);
	}
	@Test
	public void SelectDateFromKendoCalendar() throws InterruptedException {
	// Start the date time picker demo website.
	browser.navigate().to(demosite);
	// click to open the date time picker calendar.
	
	Thread.sleep(5000);
	WebElement kendodtp = browser.findElement(By
	.cssSelector(".k-icon.k-i-calendar"));
	kendodtp.click();
	// Provide the day of the month to select the date.
	HandleKendoDateTimePicker("11");
	}
	// Function to select the day of the month in the date time picker.
	public void HandleKendoDateTimePicker(String day)
	throws InterruptedException {
	wait.until(ExpectedConditions.presenceOfElementLocated(By
	.className("k-content")));
	WebElement table = browser.findElement(By.className("k-content"));
	System.out.println("Kendo Calendar");
	List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
	for (WebElement row : tableRows) {
	List<WebElement> cells = row.findElements(By.xpath("td"));
	for (WebElement cell : cells) {
	if (cell.getText().equals(day)) {
	browser.findElement(By.linkText(day)).click();
	}
	}
	}
	// Intentional pause for 2 seconds.
	Thread.sleep(2000);
	}
	@AfterTest
	public void endTest() {
	//browser.quit();
	}	
	
}
