package banking.onlinebankingsystem.objectrepository.elements;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitCardPage {
	@FindBy (xpath = "//li[text()='Apply Debit Card']")
	private WebElement applydebitcardbtn;

	@FindBy (name = "holder_name")
	private WebElement holdertextfield;

	@FindBy (name = "dob")
	private WebElement dobtextfield;

	@FindBy (name = "pan")
	private WebElement pantextfield;

	@FindBy (name = "mob")
	private WebElement mobtxtfield;

	@FindBy (name = "acc_no")
	private WebElement acnotxtfield;


	@FindBy (name = "dbt_crd_submit")
	private WebElement debitcard;

	public ApplyDebitCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void getdebitcarddat(Map<String, String> map) {
		holdertextfield.sendKeys(map.get("holder_name"));
		dobtextfield.click();
		 dobtextfield.sendKeys(map.get("dob"));
		 pantextfield.sendKeys(map.get("pan"));
		 mobtxtfield.sendKeys(map.get("mob"));
		 acnotxtfield.sendKeys(map.get("acc_no"));
		 debitcard.click();
	}
	public void debitcard() {
		 applydebitcardbtn.click();
		 
	}
}
