package com.wc.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.obs.genericutilityenum.PropertyKey;


public class PropertyUtility{
	/**
	 * This class contains reusable methods to handle propertyfile
	 */
	private Properties prop;

	public PropertyUtility() {
	}

	/**
	 * This constructor will initialize the property file
	 * @param filePath
	 * @throws IOException
	 */
	public PropertyUtility(String filePath) throws IOException {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	

	/**
	 * This method will initialize the property file
	 * @deprecated new FetchDataFromPropertyFile(String filePath)
	 * @param filePath
	 * @throws IOException
	 */
	@Deprecated
	public void initializePropertyFile(String filePath) throws IOException {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method will fetch the data from property file based on given key
	 * @param time
	 * @return
	 */
	public String getPropertyData(PropertyKey time) {
		String key=time.name().toLowerCase();
		return prop.getProperty(key, "").trim();
	}

	
	
	/**
	 * this method is used to clear the data
	 */
	public void clear() {
		prop.clear();
	}

}