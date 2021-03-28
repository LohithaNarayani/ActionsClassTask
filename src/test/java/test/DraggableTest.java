package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import drivers.WebDriverUtils;
import pages.DraggablePage;

public class DraggableTest {
	
	DraggablePage draggablePage;
	
	@BeforeSuite
	public void beforeSuite() {
		draggablePage = new DraggablePage();
	}

	@Test
	public void testLaunchDraggablePage() {
		
		draggablePage.launchDraggablePage();
	}
	
	@Test(dependsOnMethods = "testLaunchDraggablePage")
	public void dragElement() {
		draggablePage.dragElement();
	}
	
	@AfterSuite
	public void afterSuite() {
		WebDriverUtils.close();
	}

}
