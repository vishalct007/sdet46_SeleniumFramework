package com.wc.genericUtility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.math3.analysis.function.Constant;

public class FileUtility {

	FileInputStream fis=null;
	FileOutputStream fos=null;
	Properties p=null;
	
	
	
	public void initialize() {
		try {
			fis=new FileInputStream(Constants.TEST_PROPERTY_FILE_PATH);
			p=new Properties();
			p.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void set() {
		try {
			fos=new FileOutputStream(Constants.TEST_PROPERTY_FILE_PATH,true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getPropertyData(String key) {				
		String data=p.getProperty(key,"").trim();
		return data;
	}
	public void setPropertyData(String key,String value) {
		p.setProperty(key, value);
	       try {
			p.store(fos, " New Data Added ");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

