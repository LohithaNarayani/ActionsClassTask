package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.SwitchTabPage;

public class SwitchTabTest {
SwitchTabPage switchTabPage;
	
	@BeforeSuite
	public void beforeSuite() {
		switchTabPage = new SwitchTabPage();
	}

	@Test
	public void testSwitchTabPage() {
		
		switchTabPage.launchSwitchTabPage();
	}
	
	@Test(dependsOnMethods = "testSwitchTabPage")
	public void launchTab() throws InterruptedException {

		switchTabPage.switchTab();
	}
	
	@Test(dependsOnMethods = "launchTab")
	public void launchChildWindow() throws InterruptedException {

		switchTabPage.switchWindow();
	}
	@AfterSuite
	public void afterSuite() {

	}



}
