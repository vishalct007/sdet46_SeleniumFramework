package com.wc.genericUtility;
public class VerificationUtility{
	/**
	 * this class contains method for verification
	 * @param actual
	 * @param expected
	 * @param strategy
	 */

	
	
	/**
	 * this method is used to do exact verification depending on testcase and pages
	 * @param actual
	 * @param expected
	 * @param strategy
	 */
	public void exactVerify(String actual, String expected,String strategy) {
	if(strategy.equalsIgnoreCase("tc"))	{
		if (actual.equals(expected)) {
			System.out.println("TC is pass");
		} else {
			System.out.println("TC is fail");
		}
	}
	else if(strategy.equalsIgnoreCase("page")) {
		if (actual.equals(expected)) {
			System.out.println(expected+" page is displayed");
		} else {
			System.out.println(expected+" page is not displayed");
		}
	}
	
	}
	
	
	
	/**
	 * this method is used to do partial verification
	 * @param actual
	 * @param expected
	 * @param strategy
	 */
	
	public void partialVerify(String actual, String expected,String strategy) {
		if(strategy.equalsIgnoreCase("tc"))	{
			if (actual.contains(expected)) {
				System.out.println("TC is pass");
			} else {
				System.out.println("TC is fail");
			}
		}
		else if(strategy.equalsIgnoreCase("page")) {
			if (actual.contains(expected)) {
				System.out.println(expected+" page is displayed");
			} else {
				System.out.println(expected+" page is not displayed");
			}
		}
		
	}
}