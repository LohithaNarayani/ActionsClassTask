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
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
		
		extent = new ExtentReports();
        	extent.attachReporter(htmlReporter);
		htmlReporter.config().setChartVisibilityOnOpen(true);
        	htmlReporter.config().setDocumentTitle("Extent Report Demo");
        	htmlReporter.config().setReportName("Test Report");
        	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        	htmlReporter.config().setTheme(Theme.STANDARD);
        	htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	}
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest("Test");
	}


	public void onTestFailure(ITestResult result) {
	    test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
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
	    test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	}
	
	
	public void onFinish(ITestContext result) {
		report.endTest(test);
		report.flush();
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
