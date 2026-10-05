package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class ListenersImplementation implements ITestListener {
	
	JavaUtility jutil = new JavaUtility();
	String datetimestamp = jutil.getCalenderDetails("dd-MM-YY hh-mm-ss");
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-- On Test Start executed");
		
		//Create a field into the report for every @Test method name
				test =reports.createTest(methodName);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-- On Test Sucess executed");
		
		//log the status as pass
		test.log(Status.PASS,methodName+"-successfully executed");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-- On Test Failure executed");
		
		//log the status as fail and throwable message
		test.log(Status.FAIL,methodName+"-failed");
		test.log(Status.INFO,result.getThrowable());
		
		
		//Screenshot of Webpage
		JavaUtility jutil = new JavaUtility();
		String dateTimeStamp = jutil.getCalenderDetails("dd-MM-YYYY hh-mm-ss");
		String screenshotName = methodName+"-"+dateTimeStamp;
		SeleniumUtility sutil= new SeleniumUtility();
		try {
			String path = sutil.takeWebPageScreenshot(BaseClass.sDriver, screenshotName);
			test.addScreenCaptureFromPath(path);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-- On Test Skipped executed");
		
		//LOG the details as Skip
		test.log(Status.SKIP, methodName+"-skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-- On Test FailedButWithSucessPercntage executed");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-- On Test TestFailedWithTimeout executed");
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("On Test Start executed");
		
		//configuration of Extent Reports
		ExtentSparkReporter reporter = new ExtentSparkReporter(".\\ExtentReports\\report-"+datetimestamp+".html");
		reporter.config().setDocumentTitle("Extent Reports");
		reporter.config().setReportName("VTiger Report");
		reporter.config().setTheme(Theme.STANDARD);
		
		//Generate an Empty report
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Base URL", "http://localhost:8888/");
		reports.setSystemInfo("Base OS", "Windows");
		reports.setSystemInfo("Base Browser", "Chrome");
		reports.setSystemInfo("Test Engineer", "Manish");
	}
	

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("On Finish executed");
		
		//Flush the report
				reports.flush();
	}
}

	
 


