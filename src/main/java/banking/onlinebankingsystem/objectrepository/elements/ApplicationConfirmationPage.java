package banking.onlinebankingsystem.objectrepository.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationConfirmationPage {
	
	@FindBy(name="cnfrm-submit")
    private WebElement confirmBtn;
	
	
	public ApplicationConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void appConfirmationPage() {
		confirmBtn.click();
	}

}
