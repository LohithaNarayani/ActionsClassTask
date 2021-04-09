package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import drivers.WebDriverUtils;
import pages.HomePage;
import utilities.ExcelUtils;
import utilities.ExtentReportUtil;

public class HomePageTest extends ExtentReportUtil{

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
		reportLog("Launched Home Page");
		try {
			eu.getExcelData("PolicyNumber",3);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		homePage.launchHomePage();
		reportLog("Fetched the data from excel sheet and printed on Console");
	}

	@Test(dependsOnMethods = "testLaunchHomePage")
	public void launchInteractions() {
		homePage.launchInteractions();
		reportLog("Launched Interactions Page");
	}
	
	@Test(dependsOnMethods = "launchInteractions")
	public void moveToElement() {
		homePage.moveToElementTest();
		reportLog("Performed MoveToElement Action");
	}

	@AfterSuite
	public void afterSuite() {
		WebDriverUtils.close();
	}
}