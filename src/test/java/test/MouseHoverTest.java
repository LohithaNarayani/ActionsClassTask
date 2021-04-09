package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import drivers.WebDriverUtils;
import pages.MouseHoverPage;
import utilities.ExtentReportUtil;

public class MouseHoverTest extends ExtentReportUtil{
	MouseHoverPage mousehoverPage;
	
	@BeforeSuite
	public void beforeSuite() {
		mousehoverPage = new MouseHoverPage();
	}

	@Test
	public void testLaunchMouseHoverPage() {
		mousehoverPage.launchMouseHoverPage();
		reportLog("Launched MouseHover Page");
	}
	
	@Test(dependsOnMethods = "testLaunchMouseHoverPage")
	public void mouseHoverElement() {
		mousehoverPage.mouseHoverElement();
		reportLog("Performed mouseHover action");
	}
	
	@AfterSuite
	public void afterSuite() {
		WebDriverUtils.close();
	}
}
