package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.ButtonsPage;


public class DoubleClickTest {
	
ButtonsPage buttonsPage;
	
	@BeforeSuite
	public void beforeSuite() {
		buttonsPage = new ButtonsPage();
	}

	@Test
	public void testLaunchButtonsPage() {
		
		buttonsPage.launchButtonsPage();
	}
	
	@Test(dependsOnMethods = "testLaunchButtonsPage")
	public void dblClckElement() throws InterruptedException {
		buttonsPage.doubleClickElement();
	}
	@Test(dependsOnMethods = "dblClckElement")
	public void rightClkElement() throws InterruptedException {
		buttonsPage.contextClickElement();
	}
	
	@AfterSuite
	public void afterSuite() {
		
	}

}
