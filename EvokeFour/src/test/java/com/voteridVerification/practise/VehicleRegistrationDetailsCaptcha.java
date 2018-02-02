package com.voteridVerification.practise;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.base.pack.mainbase;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;

public class VehicleRegistrationDetailsCaptcha  extends mainbase{

WebElement waitElement = null;

	
	
	public WebElement fluentWait(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(950, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		
		

		
		
		return foo;
	};
	
	
	
	@DataProvider(name = "DP7")
	public Object[][] createData7() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"VehicleRegistrationDetails", "VehicleRegistrationDetails");
		return (retObjArr);
	}

	@Test(priority = 99, dataProvider = "DP7")
	public void FormCstKaranataka(String RegistrationNumberFrist, String RegistrationNumberSecond, String MobileNumber, String empty,
			String exceptedreult, String actualresult, String testresult) throws IOException, InterruptedException {

		ExtentTestManager.startTest(" Vehicle Registration Details : Captcha Sources ");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='Others']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()=' Vehicle Registration Details']/input")).click();
		Thread.sleep(3000);

		String mainhandleAndhra=driver.getWindowHandle();

		String childhandleAndhra="";

		Set<String>handlesAndhra=driver.getWindowHandles();

		for (String handle : handlesAndhra) {

		if (!handle.equals(mainhandleAndhra)) {

		childhandleAndhra=handle;

		}


		}

		driver.switchTo().window(childhandleAndhra);	
		
		
		try {
		    driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
		   try {

			   Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='reNo']")).sendKeys(RegistrationNumberFrist);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='reNo1']")).sendKeys(RegistrationNumberSecond);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='moNo']")).sendKeys(MobileNumber);
		
		
		
		
	
		Thread.sleep(22000);

		try{
		driver.findElement(By.xpath("//input[@value='Get OTP']")).click();
		
		Thread.sleep(42000);
		driver.findElement(By.xpath("//input[@value='Verify OTP']")).click();
		
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		
		String voteridAndharpradesh=exceptedreult;


		Thread.sleep(42000);

		String   voteridAndharpradeshresult=driver.findElement(By.xpath(".//*[@id='result']")).getText();

		
		
		Double resPercentage = LetterPairSimilarity.compareStrings(voteridAndharpradeshresult, voteridAndharpradesh);

		System.out.println("resPercentage "+resPercentage*100);
		String total=Double.toString(resPercentage*100);

		ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");
		


		if(resPercentage> 0 && (resPercentage*100) > 80){

		  System.out.println("pass");
		  
		  
		 ExtentTestManager.getTest().log(LogStatus.PASS, "VehicleRegistrationDetails Result is Pass");
		  
		ExtentTestManager.getTest().log(LogStatus.INFO,  "VehicleRegistrationDetails excepted is started"+voteridAndharpradesh);
		ExtentTestManager.getTest().log(LogStatus.INFO, " VehicleRegistrationDetails actual is started"+voteridAndharpradeshresult);
		//ExtentTestManager.getTest().log(LogStatus.INFO, " VoterId : AndhraPradesh Result Comparison  is "+voteridAndharpradeshresult.equals(voteridAndharpradesh));


		String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

		ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		String sec=MissingJSON.difference(voteridAndharpradeshresult, voteridAndharpradesh);


		   System.out.println(sec);

		   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
		  
		  
		  
		  
		  
		  }else{

		  System.out.println("not matching");
		  ExtentTestManager.getTest().log(LogStatus.FAIL,    "VehicleRegistrationDetails  Result is Fail");
		  
		  
			ExtentTestManager.getTest().log(LogStatus.INFO, " VehicleRegistrationDetails excepted is started"+voteridAndharpradesh);
			ExtentTestManager.getTest().log(LogStatus.INFO, " VehicleRegistrationDetails actual is started"+voteridAndharpradeshresult);
			ExtentTestManager.getTest().log(LogStatus.INFO, " VehicleRegistrationDetails Result Comparison  is "+voteridAndharpradeshresult.equals(voteridAndharpradesh));


			String sec=MissingJSON.difference(voteridAndharpradeshresult, voteridAndharpradesh);


			   System.out.println(sec);

			   ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec); 
				String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

		  
		  
		  
		  }


		   } catch (Exception e) {
			   ExtentTestManager.getTest().log(LogStatus.INFO, "VehicleRegistrationDetails Verification Code does not match !!");
				String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


			   
		   }

		} catch(Exception e) {
		      System.out.println("no page");
		      System.out.println(e);
		  }



		driver.close();


		driver.switchTo().window(mainhandleAndhra);

	
	
}
}
