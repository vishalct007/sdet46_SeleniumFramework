package banking.onlinebankingsystem.objectrepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendingCustomersPage {
	@FindBy(name="application_no")
    private WebElement applicationNumTextField;
	
	
	@FindBy(name="search_application")
	private WebElement searchAppBtn;
	
	@FindBy(xpath="//input[@name='approve_cust']")
	private WebElement approveBtn;
	
	
	public PendingCustomersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterDetails(String applicationNum) {
		applicationNumTextField.sendKeys(applicationNum);
		searchAppBtn.click();
		approveBtn.click();
		
	}
}
