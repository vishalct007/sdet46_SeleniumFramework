package com.wc.genericUtility;

import java.io.File;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class PopupUtility{
	/**
	 * This class contains all the generic methods to handle the popups
	 */
	
	
	Alert a=null;
	File f=null;
	
	
	/**
	 * This constructor will call initializeAlert()
	 * @param driver
	 */
public PopupUtility(WebDriver driver) {
	initializeAlert( driver);
}



@Deprecated
public PopupUtility() {
	
}


/**
 * This generic method will initialize the Actions class instance	
 * @param driver
 */
public void initializeAlert(WebDriver driver) {
		a=driver.switchTo().alert();	
	}


/**
 * This generic method will click on OK in the Alert popup
 */
	public void alertAccept() {

		a.accept();
	}
	
	
	/**
	 * This generic method will click on CANCEL in the Alert popup
	 */
	public void alertDismiss() {
		a.dismiss();
	}
	
	
	
	/**
	 * This generic will enter the value in the Alert popup
	 * @param value
	 */
	public void alertSendKeys(String value) {
		a.sendKeys(value);
	}
	
	
	
	/**
	 * This method will fetch the text from the Alert Popup
	 * @return
	 */
	public String getTextOfAlert() {
		return a.getText();
	}
	
	
	
	
/**
 * This  method will disable the notification in the browser
 * @param browserName
 * @return
 */
	public WebDriver disableNotification(String browserName) {
		switch(browserName)
		{
		case "chrome":
		{
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--disable notifications");
			WebDriver driver=new ChromeDriver(option);
			return driver;
		}
		case "firefox":{
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver=new FirefoxDriver(options);
			return driver;
		}

		case "edge":{
			EdgeOptions options=new EdgeOptions();
			WebDriver driver=new EdgeDriver(options); 
			return driver; 
		}
		default :return null;
		}
	}
	
	
	
	
	/**
	 * This generic method will upload the file
	 * @param path
	 * @param webelement
	 */
	public void fileUpload(String path,WebElement webelement) {
		 f=new File(path);
		webelement.sendKeys(f.getAbsolutePath());
	}
	
	
	/**
	 * This generic method will use to handle the authentication popup
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 */
	public void autheticationPopup(WebDriver driver,String url,String username,String password) {
		driver.get("https://"+username+":"+password+"@"+url.split("https://")[1]);
	}
	
	

	/**
	 * This generic method is use to handle the calender popup
	 * @param currentMonthYear
	 * @param next
	 * @param previous
	 * @param reqMonth
	 * @param reqYear
	 */
	public void calender(WebElement currentMonthYear,WebElement next,WebElement previous,String reqMonth,String reqYear) {
		int reqMonthNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqMonth).get(ChronoField.MONTH_OF_YEAR);
		int reqYearNum=Integer.parseInt(reqYear);
		String curMonthYear=currentMonthYear.getText();
		int curMonthNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(curMonthYear.split(" ")[0]).get(ChronoField.MONTH_OF_YEAR);
		int curYearNum=Integer.parseInt(curMonthYear.split(" ")[1]);
		while(reqMonthNum>curMonthNum||reqYearNum>curYearNum) {
			next.click();
			curMonthYear=currentMonthYear.getText();
			curMonthNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(curMonthYear.split(" ")[0]).get(ChronoField.MONTH_OF_YEAR);
			curYearNum=Integer.parseInt(curMonthYear.split(" ")[1]);
		}
		
		while(reqMonthNum<curMonthNum||reqYearNum<curYearNum) {
			previous.click();
			curMonthYear=currentMonthYear.getText();
			curMonthNum=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(curMonthYear.split(" ")[0]).get(ChronoField.MONTH_OF_YEAR);
			curYearNum=Integer.parseInt(curMonthYear.split(" ")[1]);
		}
		
	}
	
	

	/**
	 * This generic method will change the control to the particular child window
	 * @param driver
	 * @param childWindowTitle
	 */
	public void switchTochildWindowPopup(WebDriver driver,String childWindowTitle) {
		Set<String> windowHandles = driver.getWindowHandles();
		for(String windowHandle:windowHandles) {
			String actTitle=driver.switchTo().window(windowHandle).getTitle();
		if(actTitle.equalsIgnoreCase(childWindowTitle))
			break;
		}
	}
	
	

	/**
	 * This generic method will close the particular child window
	 * @param driver
	 * @param closeWindowTitle
	 */
		public void closeChildWindow(WebDriver driver,String closeWindowTitle) {
			Set<String> windowHandles = driver.getWindowHandles();
			for(String windowHandle:windowHandles) {
				String actTitle=driver.switchTo().window(windowHandle).getTitle();
			if(actTitle.equalsIgnoreCase(closeWindowTitle)) {
				driver.close();
				break;
			}	
		}
		
	}
		
		
	
		/**
		 * This generic method will close except the particular child window
		 * @param driver
		 * @param closeExceptWindowTitle
		 */
		public void closeExceptChildWindow(WebDriver driver,String closeExceptWindowTitle ) {
			Set<String> windowHandles = driver.getWindowHandles();
			for(String windowHandle:windowHandles) {
				String actTitle=driver.switchTo().window(windowHandle).getTitle();
			if(!(actTitle.equalsIgnoreCase(closeExceptWindowTitle))) {
				driver.close();
				break;
			}	
		}
			
}
		
}