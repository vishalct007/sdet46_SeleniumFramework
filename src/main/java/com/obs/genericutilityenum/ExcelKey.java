package com.obs.genericutilityenum;

public enum ExcelKey {
	/**
	 *  This enum contains method to get the sheetName
	 */
	
	BANKING("Banking");
	private String key;

	private ExcelKey(String key) {
		this.key=key;
	}
	
	/**
	 * This method returns sheetName
	 * @return
	 */
	
	public String getSheetName() {
		return key;
	}

}
