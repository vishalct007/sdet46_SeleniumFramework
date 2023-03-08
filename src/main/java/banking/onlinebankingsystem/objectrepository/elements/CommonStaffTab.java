package banking.onlinebankingsystem.objectrepository.elements;

public enum CommonStaffTab {
	
	VIEW_ACTIVE_CUSTOMER("viewdet"),VIEW_CUSTOMER_BY_AC("view_cust_by_ac"),APPROVE_PENDING_ACC("apprvac"),DELETE_CUSTOMER_AC("del_cust"),CREDIT_CUSTOMER("credit_cust_ac");
	String key;
	private CommonStaffTab(String key) {
		this.key=key;
	}
		public String getTab() {
			return key;
		}

}
