package com.wc.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JavaUtility {
	
	private SimpleDateFormat sdf;
	    private Calendar cal;
	    
	    
	/**
	 * this methpod is used to get data from alertpopup and replace it with numbers    
	 * @param alertText
	 * @return
	 */
public String getAcnoFromAlertString(String alertText) {
	String accnum=alertText.replaceAll("[^0-9]","");
	return accnum;
}



/**
 * This generic method will return current date
 * @return 
 */
public String getCurrentStringDateTime() {
      sdf=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	 cal=Calendar.getInstance();
	String date=sdf.format(cal.getTime());
	return date;
}
}
