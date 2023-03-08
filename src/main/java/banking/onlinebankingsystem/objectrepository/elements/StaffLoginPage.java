package banking.onlinebankingsystem.objectrepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage{
	
	@FindBy(name="staff_id")
	    private WebElement staffId;
	
	
	@FindBy(name="password")
    private WebElement staffPassword;
	
	
	@FindBy(name="staff_login-btn")
    private WebElement loginBtn;
	
	
	public StaffLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApp(String username,String password) {
		staffId.sendKeys("username");
		staffPassword.sendKeys("password");
		loginBtn.click();
	}
	
	
	
	
	
	

}
