package com.wc.genericUtility;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility{
	/**
	 * This class contains all the generic methods of select class
	 */
	Select s=null;
	
	/**
	 * this method will initialize the select
	 * @param select
	 */
	public void initializeSelect(WebElement select) {
		s=new Select(select);
	}
	
	
	/**
	 * this method will select by value where we pass value as argument
	 * @param value
	 */
	public void selectByvalue(String value) {
		s.selectByValue(value);
	}
	
	
	
/**
 * this method will select by text where we pass text as argument
 * @param text
 */
	public void selectByVisibleText(String text) {
		s.selectByVisibleText(text);
	}


	}
