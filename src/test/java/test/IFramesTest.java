package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.FramesPage;

public class IFramesTest {
	FramesPage iframesPage;
	
	@BeforeSuite
	public void beforeSuite() {
		iframesPage = new FramesPage();
	}

	@Test
	public void LaunchFramesPage() {
		
		iframesPage.launchFramesPage();
	}
	
	@Test(dependsOnMethods = "LaunchFramesPage")
	public void iframeElement() {
		iframesPage.iframeElement();
	}
	
	@AfterSuite
	public void afterSuite() {

	}

}
