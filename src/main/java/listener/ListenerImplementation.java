package listener;

import java.io.IOException;

import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.Configuration;

import com.obs.genericutilityenum.PropertyKey;
import com.wc.genericUtility.BaseClass;
import com.wc.genericUtility.Constants;
import com.wc.genericUtility.PropertyUtility;
import com.wc.genericUtility.UtilityInstanceTransfer;
import com.wc.reportutility.Report;
import com.wc.utility.annotation.ReportAnnotation;

public class ListenerImplementation implements ITestListener,IClassListener,ISuiteListener {
	private Report report;
	public static Report sreport;
	@Override
	public void onBeforeClass(ITestClass testClass) {
		System.out.println("onBeforeClass");
	}

	@Override
	public void onAfterClass(ITestClass testClass) {
		System.out.println("onAfterClass");

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		ReportAnnotation reportAnnotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(ReportAnnotation.class);
        report.addAuthor(UtilityInstanceTransfer.getExtentTest(),reportAnnotation.author());
        report.addcategory(UtilityInstanceTransfer.getExtentTest(),reportAnnotation.categories());
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		report.pass(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+" is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//	Object c=result.getMethod().getInstance();
		//	Configuration.class.cast(c).screenshotUtility.getScreenshot(null, null);
		//	
		//		Configuration.class.cast(result.getMethod().getInstance()).screenshotUtility
		//		.getScreenshot(result.getMethod().getRealClass().getSimpleName(),
		//				Configuration.class.cast(result.getMethod().getInstance()).javaUtility);
		//		System.out.println("onTestFailure");
		report.fail(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+" is fail");
		report.fail(UtilityInstanceTransfer.getExtentTest(),result.getThrowable());
		String path=BaseClass.class.cast(result.getMethod().getInstance()).screenshotUtility.getScreenshot();
		report.attachScreenshot(UtilityInstanceTransfer.getExtentTest(),path, result.getMethod().getMethodName()); 

	}


	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		report.fail(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName()+" is skip");
		report.fail(UtilityInstanceTransfer.getExtentTest(),result.getThrowable());
		String path=BaseClass.class.cast(result.getMethod().getInstance()).screenshotUtility.getScreenshot();
		report.attachScreenshot(UtilityInstanceTransfer.getExtentTest(),path, result.getMethod().getMethodName()); 
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");

	}

	@Override
	public void onStart(ITestContext context) {
		

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinishTest");
		report.saveReport();
	}


	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStartSuite");
		report=new Report();
		sreport=report;
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinishSuite");
	}


	

}
