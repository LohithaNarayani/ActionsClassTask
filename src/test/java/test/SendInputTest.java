package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import drivers.WebDriverUtils;
import pages.SendInputTextPage;
import utilities.ExtentReportUtil;

public class SendInputTest extends ExtentReportUtil{
	
SendInputTextPage sendInputTextPage;
	
	@BeforeSuite
	public void beforeSuite() {
		sendInputTextPage = new SendInputTextPage();
	}

	@Test
	public void testLaunchTextPage() {
		sendInputTextPage.launchSendInputPage();
		reportLog("Navigated to TextBox Page");
	}
	
	@Test(dependsOnMethods = "testLaunchTextPage")
	public void sendInputElementTest() throws InterruptedException {
		sendInputTextPage.sendInputElement();
		reportLog("Entered Text in fullName Text box");
	}
	@AfterSuite
	public void afterSuite() {
		WebDriverUtils.close();
	}


}
