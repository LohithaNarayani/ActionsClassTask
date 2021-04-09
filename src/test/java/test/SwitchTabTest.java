package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import drivers.WebDriverUtils;
import pages.SwitchTabPage;
import utilities.ExtentReportUtil;

public class SwitchTabTest extends ExtentReportUtil{
SwitchTabPage switchTabPage;
	
	@BeforeSuite
	public void beforeSuite() {
		switchTabPage = new SwitchTabPage();
	}

	@Test
	public void testSwitchTabPage() {
		switchTabPage.launchSwitchTabPage();
		reportLog("Navigated to SwitchTab Page");
	}
	
	@Test(dependsOnMethods = "testSwitchTabPage")
	public void launchTab() throws InterruptedException {
		switchTabPage.switchTab();
		reportLog("Opened new tab in chrome browser");
	}
	
	@Test(dependsOnMethods = "launchTab")
	public void launchChildWindow() throws InterruptedException {
		switchTabPage.switchWindow();
		reportLog("opened new window and closed it successsfully");
	}
	@AfterSuite
	public void afterSuite() {
		WebDriverUtils.close();
	}



}
