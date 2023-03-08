package com.wc.genericUtility;

import java.io.IOException;

import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.obs.genericutilityenum.PropertyKey;

public class BaseClass extends BaseClassDeclaration{


	@BeforeClass(alwaysRun=true)
	//	@BeforeTest
	public void intializationsetup() throws IOException {
		propertyUtility=new PropertyUtility(Constants.TEST_PROPERTY_FILE_PATH);
		excelUtility=new ExcelUtility(Constants.TEST_EXCEL_FILE_PATH);
		WebdriverUtility=new WebDriverUtility();
		javautility=new JavaUtility();
		dropdownUtility=new DropDownUtility();
		selectUtility=new SelectUtility();
		actionUtility=new ActionUtility();
		popupUtility = new PopupUtility();
		verification=new VerificationUtility();
		browser=propertyUtility.getPropertyData(PropertyKey.BROWSER);
		url=propertyUtility.getPropertyData(PropertyKey.URL);
		staffID = propertyUtility.getPropertyData(PropertyKey.STAFFID);
		staffPassword=propertyUtility.getPropertyData(PropertyKey.STAFFPASSWORD);
		timeunit = Long.parseLong(propertyUtility.getPropertyData(PropertyKey.TIME));
	}


	@BeforeMethod(alwaysRun=true)
	public void setup() throws IOException  {

		driver=WebdriverUtility.launchBrowser(browser);
		screenshotUtility=new ScreenshotUtility(driver);
		WebdriverUtility.launchApplication(url);
		WebdriverUtility.maximize();
		//waitutility.setImplicitWait(driver, 10);
	}





	@AfterMethod(alwaysRun=true)
	public void teardown() {

	}


	@AfterClass(alwaysRun=true)
	//@AfterTest
	public void intializationteardown() throws IOException {

		excelUtility.closeWorkBook();
		
	}


}

