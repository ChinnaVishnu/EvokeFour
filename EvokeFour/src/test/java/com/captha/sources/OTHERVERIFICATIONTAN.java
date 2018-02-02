package com.captha.sources;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.pack.ExtentTestManager;
import com.base.pack.GetScreenshort;
import com.base.pack.LetterPairSimilarity;
import com.base.pack.mainbase;
import com.relevantcodes.extentreports.LogStatus;

import jxl.read.biff.BiffException;

public class OTHERVERIFICATIONTAN extends mainbase {

	@DataProvider(name = "DP10")
	public Object[][] createData10() throws Exception {
		Object[][] retObjArr = getTableArray(
				"D:\\AUTOMATION REQUIRED DOCS\\EVOKEAPIWEBSERVICES\\EvokeApiAutoamtion.xls", "login",
				"OtherVerificationtan", "OtherVerificationtan");
		return (retObjArr);
	}

	@Test(priority = 18, dataProvider = "DP10")
	public void OtherVerificationefiling(String Enter, String Category, String State, String empty,
			String exceptedreult, String actualresult, String testresult)
					throws BiffException, IOException, InterruptedException {

		ExtentTestManager.startTest(" Other Verification : TAN ");

		Thread.sleep(7000);

		driver.findElement(By.xpath("//a[text()='Tax']")).click();

		Thread.sleep(7000);

		driver.findElement(By.xpath("//div[text()='  TAN']/input")).click();

		// driver.findElement(By.xpath(".//*[@id='itrv']/table/tbody/tr/td[3]/img")).click();

		String mainhandleandhra = driver.getWindowHandle();

		String childhandleAndhra = "";

		Set<String> handlesandhra = driver.getWindowHandles();

		for (String handle : handlesandhra) {

			if (!handle.equals(mainhandleandhra)) {

				childhandleAndhra = handle;

			}

		}

		driver.switchTo().window(childhandleAndhra);

		driver.manage().window().maximize();

		try {
			driver.manage().timeouts().pageLoadTimeout(65000, TimeUnit.MILLISECONDS);
			try {

				Thread.sleep(13000);

				driver.findElement(By.xpath(".//*[@id='tanNo']")).sendKeys(Enter);

				WebElement elemenetan = driver.findElement(By.xpath(".//*[@id='tanCategory']"));
				Select selecttan = new Select(elemenetan);
				selecttan.selectByVisibleText(Category);

				Thread.sleep(7000);

				WebElement elemenetansecond = driver.findElement(By.xpath(".//*[@id='tanState']"));
				Select selecttansecond = new Select(elemenetansecond);
				selecttansecond.selectByVisibleText(State);

				// Thread.sleep(20000);
				driver.findElement(By.xpath(".//*[@id='tanDiv']/div/span[1]/input")).click();
				Thread.sleep(30000);

				String othertannactualresult = driver.findElement(By.xpath(".//*[@id='result']")).getText();

				String othertanres = exceptedreult;

				// System.out.println(othertanres.equals(othertannactualresult));
				Double resPercentage = LetterPairSimilarity.compareStrings(othertannactualresult, othertanres);

				System.out.println("resPercentage " + resPercentage * 100);
				String total = Double.toString(resPercentage * 100);

				ExtentTestManager.getTest().log(LogStatus.INFO, "percentage of actual and expected :: " + total);

				if (resPercentage > 0 && (resPercentage * 100) > 80) {

					System.out.println(" PASS    ");

					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Other Verification : TAN   resultexcepted is started" + othertanres);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Other Verification : TAN   resultactual is started" + othertannactualresult);
					// ExtentTestManager.getTest().log(LogStatus.INFO, "Other
					// Verification : TAN resultcomparison is
					// "+othertanres.equals(othertannactualresult));
					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Other Verification : TAN   verification Result is Pass");

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				} else {

					System.out.println("not matching");
					ExtentTestManager.getTest().log(LogStatus.FAIL, "OTHERVERIFICATIONTAN  Result is Fail");
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Other Verification : TAN   resultexcepted is started" + othertanres);
					ExtentTestManager.getTest().log(LogStatus.INFO,
							"Other Verification : TAN   resultactual is started" + othertannactualresult);
					ExtentTestManager.getTest().log(LogStatus.INFO, "Other Verification : TAN   resultcomparison is "
							+ othertanres.equals(othertannactualresult));

					String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

					ExtentTestManager.getTest().log(LogStatus.PASS,
							"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

				}
			} catch (Exception e) {
				ExtentTestManager.getTest().log(LogStatus.SKIP, "Other Verification :TAN   Window is Not Showing ");
				String screenshortpath = GetScreenshort.capture(driver, "ScreenshortForExtentReport");

				ExtentTestManager.getTest().log(LogStatus.SKIP,
						"Screen short below :" + ExtentTestManager.getTest().addScreenCapture(screenshortpath));

			}

		} catch (Exception e) {
			System.out.println("no page");
			System.out.println(e);
		}

		driver.close();
		driver.switchTo().window(mainhandleandhra);
		// Assert.assertEquals(electricitytamilnaduactualresult,
		// electricitytamilnadu);

	}

	// driver.close();
	// driver.switchTo().window(mainhandleandhra);
	// Assert.assertEquals(othertannactualresult, othertanres);

	// }

}
