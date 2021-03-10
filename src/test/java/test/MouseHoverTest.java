package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.MouseHoverPage;

public class MouseHoverTest {
	MouseHoverPage mousehoverPage;
	
	@BeforeSuite
	public void beforeSuite() {
		mousehoverPage = new MouseHoverPage();
	}

	@Test
	public void testLaunchMouseHoverPage() {
		
		mousehoverPage.launchMouseHoverPage();
	}
	
	@Test(dependsOnMethods = "testLaunchMouseHoverPage")
	public void mouseHoverElement() {
		mousehoverPage.mouseHoverElement();
	}
	
	@AfterSuite
	public void afterSuite() {

	}
}
