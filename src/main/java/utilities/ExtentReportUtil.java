package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import drivers.WebDriverUtils;

public class ExtentReportUtil implements ITestListener{
	
	WebDriver driver;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	//String filePath = "C:\\Users\\miniganti.lohit\\ProjectObjectModel\\Screenshots";
	
	public void onStart(ITestContext result) {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport/testReport.html");
		
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Test Report");
		htmlReporter.config().setReportName("Test Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		//set environment details
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
		
	}


	public void onTestFailure(ITestResult result) {
		driver = new WebDriverUtils().getDriver("chrome");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
		if(result.getStatus()==ITestResult.FAILURE) {
			 try {  
		            test.log(Status.FAIL, "Failed Case is: " + result.getName());
		            test.addScreenCaptureFromPath(ExtentReportUtil.getScreenshot(driver, result.getName()));
		         // to add error/exception in report	
		            test.log(Status.FAIL, result.getName()+" FAIL with error " + result.getThrowable());
		                    
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }	
		}
	}

	public static String getScreenshot(WebDriver driver,String screenshtName) throws NullPointerException,IOException {
		String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+ "/FailedTestsScreenshots/" + screenshtName + date + ".png";
		File finalDest = new File(destination);
		FileUtils.copyFile(src, finalDest);
		return destination;
	}
	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	}
	
	
	public void onFinish(ITestContext result) {
		//test.endTest(test);
		extent.flush();	
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
