package banking.onlinebankingsystem.objectrepository.elements;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {
	@FindBy(name = "customer_id")
	private WebElement customeridtextbox;
	
	@FindBy (name = "password")
	private WebElement pswrdtxtfield;
	
	@FindBy(name ="login-btn" )
	private WebElement loginbtn;
	
	@FindBy (xpath = "//li[text()='Statement']")
	private WebElement statementbtn;
	
	@FindBy(id = "logout")
	private WebElement lgbtn;

public CustomerLoginPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public void customerloginmet(Map<String, String> map) {
	customeridtextbox.sendKeys(map.get("customer_id"));
	pswrdtxtfield.sendKeys(map.get("password"));
	loginbtn.click();
	
}
public void statement() {
	statementbtn.click();
}
public void logout() {
	lgbtn.click();
	
}
}
