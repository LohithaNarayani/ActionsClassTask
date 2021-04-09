package test;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;

import drivers.WebDriverUtils;
import pages.ButtonsPage;
import utilities.ExtentReportUtil;

public class DoubleClickTest extends ExtentReportUtil{
	
ButtonsPage buttonsPage;
public static ExtentTest test;
	
	@BeforeSuite
	public void beforeSuite() {
		
		buttonsPage = new ButtonsPage();
	}

	@Test
	public void testLaunchButtonsPage() {
		buttonsPage.launchButtonsPage();
		reportLog("Launched Button Page");
		
	}
	
	@Test(dependsOnMethods = "testLaunchButtonsPage")
	public void dblClckElement() throws InterruptedException {
		buttonsPage.doubleClickElement();
		reportLog("Successfully clicked double click button");
		
	}
	@Test(dependsOnMethods = "dblClckElement")
	public void rightClkElement() throws InterruptedException {
		buttonsPage.contextClickElement();
		reportLog("Successfully clicked right click button");
	}
	
	@AfterSuite
	public void afterSuite() {
		WebDriverUtils.close();
	}

}
