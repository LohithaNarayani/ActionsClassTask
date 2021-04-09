package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import drivers.WebDriverUtils;
import pages.FramesPage;
import utilities.ExtentReportUtil;

public class IFramesTest extends ExtentReportUtil{
	FramesPage iframesPage;
	
	@BeforeSuite
	public void beforeSuite() {
		iframesPage = new FramesPage();
	}

	@Test
	public void LaunchFramesPage() {
		iframesPage.launchFramesPage();
		reportLog("Launched Frames Page");
	}
	
	@Test(dependsOnMethods = "LaunchFramesPage")
	public void iframeElement() {
		iframesPage.iframeElement();
		reportLog("Switched to iFrame Element");
	}
	
	@AfterSuite
	public void afterSuite() {
		WebDriverUtils.close();
	}

}
