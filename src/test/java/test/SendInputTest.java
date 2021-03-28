package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import drivers.WebDriverUtils;
import pages.SendInputTextPage;

public class SendInputTest {
	
SendInputTextPage sendInputTextPage;
	
	@BeforeSuite
	public void beforeSuite() {
		sendInputTextPage = new SendInputTextPage();
	}

	@Test
	public void testLaunchTextPage() {
		
		sendInputTextPage.launchSendInputPage();
	}
	
	@Test(dependsOnMethods = "testLaunchTextPage")
	public void sendInputElementTest() throws InterruptedException {
		sendInputTextPage.sendInputElement();
	}
	@AfterSuite
	public void afterSuite() {
		WebDriverUtils.close();
	}


}
