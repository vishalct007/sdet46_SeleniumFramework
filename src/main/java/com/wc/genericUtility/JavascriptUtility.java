package com.wc.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtility {
	/**
	 * This class contains all the reusable methods for Javascript execution
	 */
	
	JavascriptExecutor j=null;
	/**
	 * This method will initialize javascript instance 
	 * @param driver
	 */
	
	public void initializeJavascript(WebDriver driver) {
		 j=(JavascriptExecutor) driver;
	}
	
	
	
	/**
	 * this method is used to move the mouse pointer to element using help of axis
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scroll(WebDriver driver,int x,int y) {
	
	j.executeScript("window.scrollBy("+x+","+y+")");
          }
	
	
	
	/**
	 * this method is used to scroll the mouse pointer to particular webelement
	 * @param element
	 */
	public void scroll(WebElement element) {
		int y=element.getLocation().getY();
		j.executeScript("window.scrollBy(0,"+y+")");
	}
	
	
	
	/**
	 * this method is used to scroll the mouse pointer to bottom of webpage
	 */
	public void scrollBottom() {
		j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	
	
	
	/**
	 * this method is used to enter value for the disabled element
	 * @param id
	 * @param value
	 */
	public void enterValueDisabledElement(String id,String value) {
		j.executeScript("document.getElementByid("+id+").click("+value+")");
	}
	
	
	
	/**
	 * this method is used for clicking the disabled element
	 * @param id
	 */
	public void clickDisabledElement(String id) {
		j.executeScript("document.getElementByid("+id+").click()");
	}


}
