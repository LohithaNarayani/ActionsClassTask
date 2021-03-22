package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import drivers.WebDriverUtils;

public class ExtentReportUtil implements ITestListener{
	
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	

//	public ExtentReportUtil(WebDriver driver) {
//		this.driver = driver;
//	}

	public void onStart(ITestContext result) {
		WebDriverUtils wd = new WebDriverUtils();
		String browser = System.getProperty("browser");
		System.out.println("Browser: "+browser);
		driver = wd.getDriver(browser);
		
		report = new ExtentReports(System.getProperty("user.dir") + "ExtentReport1.html");	
	}
	
	public void onTestStart(ITestResult result) {
		test = report.startTest("ExtentReportDemo");
		
	}


	public void onTestFailure(ITestResult result) {
		try {
			test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
		} catch (IOException e) {
			e.printStackTrace();
		}	
		test.log(LogStatus.FAIL, "Takes the Screen shot of failed testcase");
	}

	private String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../BStackImages/" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		
	}

	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		driver.get("https://www.google.com/");
		if(driver.getTitle().equals("Gogle"))
		{
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		}
	}
	
	
	public void onFinish(ITestContext result) {
		report.endTest(test);
		report.flush();	
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
