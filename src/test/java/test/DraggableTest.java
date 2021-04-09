package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import drivers.WebDriverUtils;
import pages.DraggablePage;
import utilities.ExtentReportUtil;

public class DraggableTest extends ExtentReportUtil{
	
	DraggablePage draggablePage;
	
	@BeforeSuite
	public void beforeSuite() {
		draggablePage = new DraggablePage();	
	}

	@Test
	public void testLaunchDraggablePage() {
		draggablePage.launchDraggablePage();
		reportLog("Launched Draggable Page");
	}
	
	@Test(dependsOnMethods = "testLaunchDraggablePage")
	public void dragElement() {
		draggablePage.dragElement();
		reportLog("Dragged the box and dropped in other box");
	}
	
	@AfterSuite
	public void afterSuite() {
		WebDriverUtils.close();
	}

}
