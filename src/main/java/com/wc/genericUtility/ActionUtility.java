package com.wc.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionUtility{
	Actions a=null;

	/**
	 * This constructor is used to initialize the MouseActions object
	 * 
	 * @param driver
	 */
	public void initializeAction(WebDriver driver) {
		a = new Actions(driver);
	}
	
	
	
	

	/**
	 * This method is used to perform the mouseHover action on given WebElement
	 * 
	 * @param target
	 */
	public void mouseHover(WebElement target) {

		a.moveToElement(target).perform();
	}
	
	
	

	/**
	 * This method is used to perform the rightClick action on given WebElement
	 * 
	 * @param target
	 */
	public void rightClick(WebElement target) {

		a.contextClick(target).perform();
	}

	public void rightClick() {

		a.contextClick().perform();
	}
	
	
	
	
	/**
	 * This method is used to perform the doubleClick action on given WebElement
	 * 
	 * @param target
	 */
	public void doubleClick(WebElement target) {

		a.doubleClick(target).perform();
	}

	/**
	 * 
	 */
	public void doubleClick() {

		a.doubleClick().perform();
	}

	/**
	 * This method is used to perform the drag and Drop action on given WebElements
	 * 
	 * @param src
	 * @param target
	 */
	public void dragnDrop(WebElement src, WebElement target) {

		a.dragAndDrop(src, target).perform();
	}
	
	

	/**
	 * 
	 */
	public void enter() {
		a.keyDown(Keys.ENTER).perform();
	}
}