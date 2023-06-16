package flightSearchAutomationPages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGen implements ITestListener {
	ExtentSparkReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	public void onStart(ITestContext context) {
	String date = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss-ms").format(new Date());
    reporter=new ExtentSparkReporter("C:\\Users\\NehaKuSingh\\Desktop\\ProjectReport");
    extent = new ExtentReports();
	extent.attachReporter(reporter);
	reporter.config().setDocumentTitle("Flight Serach Automation");
	reporter.config().setReportName("Flight Search Tests+ TestNG testcases report + java");
	reporter.config().setTheme(Theme.DARK);
	extent.setSystemInfo("Environment", "Selenium+TestNG");
	extent.setSystemInfo("Author", "Neha");
}
	public void onTestStart(ITestResult result) {
		logger = extent.createTest("Test created for" + result.getName());
	}
	public void onTestSuccess(ITestResult result) {
		logger.log(Status.PASS, "the test id passed" + result.getName());
	}
	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL, "the test id failed" + result.getName());
	}
	public void onTestSkipped(ITestResult result) {
		logger.log(Status.SKIP, "the test id skipped" + result.getName());

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		logger.log(Status.FAIL, "the test id failed with timeout" + result.getName());

	}

	public void onFinish(ITestContext context) {
				extent.flush();
	}
}


