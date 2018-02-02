package com.allclasses;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.MissingJSON;
import com.relevantcodes.extentreports.LogStatus;

public class hew  {
	
	
	public WebDriver driver;
	public hew(WebDriver driver) {
		super();
		this.driver=driver;
		
	}

public void clickcibil(String Suit,String Entity ,String Director ,String exceptedreult ) throws InterruptedException{
	
	
	Thread.sleep(12000);
driver.findElement(By.xpath("//td[text()='CIBIL Suit Filed Cases ']/input")).click();


Thread.sleep(2000);
//.....................................Suit Filed Accounts of...............................................................//
WebElement elementSuit =driver.findElement(By.xpath("//select[@id='suit_filed_accounts']"));
	
Select selectSuit=new Select(elementSuit);

selectSuit.selectByVisibleText(Suit);

Thread.sleep(2000);

//........................................Entity Name......................................................................//

driver.findElement(By.xpath(".//*[@id='entityName']")).sendKeys(Entity);
Thread.sleep(2000);
//..........................................Director Name.................................................................//
driver.findElement(By.xpath(".//*[@id='directorName']")).sendKeys(Director);

Thread.sleep(2000);
driver.findElement(By.xpath("//div[@id='cibilSuitFiles']/table/tbody/tr[4]/td[2]/input")).click();
Thread.sleep(9000);


//String actual=driver.findElement(By.tagName("pre")).getText();
//System.out.println(actual);
	




Thread.sleep(14000);

String Cbilresult=driver.findElement(By.xpath(".//*[@id='reslut']")).getText();

String Cbilactreult=exceptedreult;

driver.navigate().refresh();


////Assert.assertEquals(Cbilresult, Cbilactreult);	
//System.out.println(Cbilresult.equals(Cbilactreult));


Double resPercentage = LetterPairSimilarity.compareStrings(Cbilresult, Cbilactreult);

System.out.println("resPercentage "+resPercentage*100);
String total=Double.toString(resPercentage*100);

ExtentTestManager.getTest().log(LogStatus.INFO,"<b>" +"Expected VS Actual (%) :"+total+ "</b>\n");






if(resPercentage> 0 && (resPercentage*100) > 80){


ExtentTestManager.getTest().log(LogStatus.INFO, "CIBIL Suit Filed Cases excepted is started"+Cbilactreult); 
ExtentTestManager.getTest().log(LogStatus.INFO, "CIBIL Suit Filed Cases actual is started"+Cbilresult); 
ExtentTestManager.getTest().log(LogStatus.INFO, "CIBIL Suit Filed Cases Result Comparison  is  "+Cbilresult.equals(Cbilactreult)); 
ExtentTestManager.getTest().log(LogStatus.PASS, "CIBIL Suit Filed Cases Result is Pass"); 

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));


String sec=MissingJSON.difference(Cbilresult, Cbilactreult);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);

/*

String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

test.log(LogStatus.PASS, "Screenshortbelow :"+test.addScreenCapture(screenshortpath));



*/


}else{

System.out.println("not matching");
//test.log(LogStatus.FAIL, "CIBIL Suit Filed Cases  result is fail");
ExtentTestManager.getTest().log(LogStatus.FAIL, "CIBIL Suit Filed Cases Result is FAIL"); 
ExtentTestManager.getTest().log(LogStatus.INFO, "CIBIL Suit Filed Cases excepted is started"+Cbilactreult); 
ExtentTestManager.getTest().log(LogStatus.INFO, "CIBIL Suit Filed Cases actual is started"+Cbilresult); 
ExtentTestManager.getTest().log(LogStatus.INFO, "CIBIL Suit Filed Cases Result Comparison  is  "+Cbilresult.equals(Cbilactreult)); 
String screenshortpath=GetScreenshort.capture(driver, "ScreenshortForExtentReport");

ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshortbelow :"+ExtentTestManager.getTest().addScreenCapture(screenshortpath));

String sec=MissingJSON.difference(Cbilresult, Cbilactreult);


System.out.println(sec);

ExtentTestManager.getTest().log(LogStatus.UNKNOWN, " Missing JSON Match : "+sec);


}
}














}
	
