package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import drivers.WebDriverUtils;
import pages.HomePage;
import utilities.ExcelUtils;

public class HomePageTest {

	HomePage homePage;
	ExcelUtils eu;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("In testLaunchHomePage");
		homePage = new HomePage();
		eu = new ExcelUtils();
	}

	@Test
	public void testLaunchHomePage() {
		
		try {
			eu.getExcelData("PolicyNumber",3);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

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
		WebDriverUtils.close();
	}
}