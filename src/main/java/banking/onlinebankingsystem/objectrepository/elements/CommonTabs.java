package banking.onlinebankingsystem.objectrepository.elements;

public enum CommonTabs {
	OPEN_ACCOUNT("Open Account"),APPLY_DEBIT_CARD("Apply Debit Card"),FUND_TRANSFER("Fund Transfer"); 
	
	private String tabName;
		private CommonTabs(String tabName) {
		 this.tabName=tabName;
	 }
		public String getTab() {
			return tabName;
		}

}
