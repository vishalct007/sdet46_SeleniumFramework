package banking.onlinebankingsystem.objectrepository.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {
	private String name="%s";
	private WebDriver driver;
	public StaffHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	private WebElement getWebelement(CommonStaffTab tab) {
		String aName=String.format(name, tab.getTab());
	return driver.findElement(By.name(aName));
	}
	
	
	public void clickOnStaffHomePage(CommonStaffTab tab) {
		getWebelement(tab).click();
	}

}
