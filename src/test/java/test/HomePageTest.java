package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomePageTest {

	HomePage homePage;

	@BeforeSuite
	public void beforeSuite() {
		homePage = new HomePage();
	}

	@Test
	public void testLaunchHomePage() {

		homePage.launchHomePage();
	}

	@Test(dependsOnMethods = "testLaunchHomePage")
	public void launchInteractions() {

		homePage.launchInteractions();
	}
	
	@Test(dependsOnMethods = "launchInteractions")
	public void moveToElement() {
		homePage.moveToElementTest();
	}

	@AfterSuite
	public void afterSuite() {

	}
}