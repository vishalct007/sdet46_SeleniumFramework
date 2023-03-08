package banking.onlinebankingsystem.objectrepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obs.genericutilityenum.PropertyKey;
import com.wc.genericUtility.PropertyUtility;

public class StaffPage {
	@FindBy(name = "staff_id")
	private WebElement staffIdTextField;
	@FindBy(name="password")
	private WebElement passwordTextBox;
	@FindBy(name="staff_login-btn")
	private WebElement staffLoginBtn;
	public StaffPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public void setStaffLogin(PropertyUtility p) {
		staffIdTextField.sendKeys(p.getPropertyData(PropertyKey.STAFFID));
		passwordTextBox.sendKeys(p.getPropertyData(PropertyKey.STAFFPASSWORD));
		staffLoginBtn.click();
	}

}
