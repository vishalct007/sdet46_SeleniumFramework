package banking.onlinebankingsystem.objectrepository.elements;

public enum CreateAccAttr {
	
	NAME("name"),
	MOBILE("mobile"),
	EMAIL("email"),
	LANDLINE("landline"),
	PANNO("pan_no"),
	CITZENSHIP("citizenship"),
	HOMEADDRESS("homeaddrs"),
	OFFICEADDRESS("officeaddrs"),
	PIN("pin"),
	AREALOC("arealoc"),
	NOMINEENAME("nominee_name"),
	NOMINEEACNO("nominee_ac_no"),
	STAFFID	("staff_id"),
	PASSWORD("password"),
	APPLICATIONNO("application_no"),
		SEARCHAPPLICATION("search_application"),
		OPENACCOUNTXPATH("//li[text()='Open Account']");
		private String name_;
		private CreateAccAttr(String name_) {
			this.name_=name_;
			
		}
		
		
	public String getname() {
		return name_;
	}
	}


