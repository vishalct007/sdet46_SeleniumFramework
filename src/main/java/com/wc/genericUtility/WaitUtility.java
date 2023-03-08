package com.wc.genericUtility;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * this class contains generic methods of synchronisation
 *
 */
public class WaitUtility {

	public void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will set the implicit wait
	 * 
	 * @throws IOException
	 */
	public void setImplicitWait(WebDriver driver, long timeout) throws IOException {

		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	/**
	 * This method will set the explicit wait
	 * 
	 * @param driver
	 * @return
	 * @throws IOException
	 */
	public WebDriverWait setExplicitWait(WebDriver driver, long timeout) throws IOException {

		return new WebDriverWait(driver, timeout);
	}

}


