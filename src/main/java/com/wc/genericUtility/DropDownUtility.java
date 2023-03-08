package com.wc.genericUtility;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownUtility {
	
	/**
	 * this class contains methods for handling only dropdown by the help of visible text!
	 * @param elementaddress
	 * @param visibletext
	 */
	
	public void selectbyvisibletext(WebElement elementaddress , String visibletext) {
		Select s=new Select(elementaddress);
		List<WebElement> opt = s.getOptions();
		for(WebElement t:opt)
		{
			if(t.getText().equalsIgnoreCase(visibletext))
			{
				s.selectByVisibleText(visibletext);
			}
		}
		
	}

}
