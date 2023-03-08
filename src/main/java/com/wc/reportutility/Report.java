package com.wc.reportutility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.obs.genericutilityenum.PropertyKey;
import com.wc.genericUtility.Constants;
import com.wc.genericUtility.JavaUtility;
import com.wc.genericUtility.PropertyUtility;
import com.wc.genericUtility.UtilityInstanceTransfer;

public class Report{

		private ExtentTest test;
		private ExtentReports report;
		
		public Report() {
			
			initReport();
		}
		private void initReport(){
			PropertyUtility p=null;
			try {
				p = new PropertyUtility(Constants.TEST_PROPERTY_FILE_PATH);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String reportname=p.getPropertyData(PropertyKey.REPORTNAME);
			String title=p.getPropertyData(PropertyKey.REPORTTITLE);
			String browserName=p.getPropertyData(PropertyKey.BROWSER);
			
			String overrideOrNot = p.getPropertyData(PropertyKey.OVERRIDEREPORT);
			
			String name="";
			if(overrideOrNot.equalsIgnoreCase("no")) {
				name="_"+new JavaUtility().getCurrentStringDateTime();
			}
			ExtentSparkReporter spark=new ExtentSparkReporter(Constants.TEST_REPORT_FILE_PATH+"test_report"+name+".html");
			spark.config().setDocumentTitle(title); 
			spark.config().setReportName(reportname);
			spark.config().setTheme(Theme.DARK);
			
			report=new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("Browser",browserName);
			report.setSystemInfo("OS", System.getProperty("os.name"));
			
		}
		
		public void log(ExtentTest test, String message) {
			test.log(null, message);		
			}
		
		public void createTest(String testName) {
			test=report.createTest(testName);
			UtilityInstanceTransfer.setExtentTest(test);
		}
		
		public void pass(ExtentTest extentTest, String message) {
			test.pass(message);
			System.out.println(message);
		}
		
		public void skip(ExtentTest test,String message) {
			test.skip(message);
			System.out.println(message);
		}
		
		public void info(ExtentTest test,String message) {
			test.info(message);
			System.out.println(message);
		}
		
		public void info1(ExtentTest test,String message) {
			test.info(message);
			System.out.println(message);
		}
		public void saveReport() {
			report.flush();
		}
		
		public void fail(ExtentTest test,String message) {
			test.fail(message);
			System.out.println(message);
		}
		
		public void fail(ExtentTest test,Throwable t) {
			test.fail(t);
		}
		
		public void addAuthor(ExtentTest test,String...author) {
			test.assignAuthor(author);
		}
		
		public void addcategory(ExtentTest test,String...category) {
			test.assignCategory(category);
		}
		
		public void attachScreenshot(ExtentTest test,String base64,String title) {
			test.addScreenCaptureFromBase64String(base64, title);
		}
		

	}


