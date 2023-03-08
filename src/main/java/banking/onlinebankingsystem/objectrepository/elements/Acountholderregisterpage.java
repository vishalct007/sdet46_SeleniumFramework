package banking.onlinebankingsystem.objectrepository.elements;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Acountholderregisterpage {
	@FindBy (name = "holder_name")
	private WebElement acholdernametextfield;
	
	@FindBy (name = "accnum")
	private WebElement acountnumtextfield;
	
	@FindBy (name = "dbtcard")
	private WebElement dbtcardtextfield;
	
	@FindBy (name = "dbtpin")
	private WebElement dbtpintextfield;
	
	@FindBy (name = "mobile")
	private WebElement mobiletextfield;
	
	@FindBy (name = "pan_no")
	private WebElement pannotextfield;
	
	@FindBy (name = "dob")
	private WebElement dobtextfield;
	
	@FindBy (name = "last_trans")
	private WebElement last_transtextfield;
	
	@FindBy (name = "password")
	private WebElement passwordtextfield;
	
	@FindBy (name = "cnfrm_password")
	private WebElement cnfrm_passwordtextfield;
	
	@FindBy (name = "submit")
	private WebElement submitbtn;	
	
	public Acountholderregisterpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void registerpage(Map<String, String> map) {
		acholdernametextfield.sendKeys(map.get("holder_name"));
		acountnumtextfield.sendKeys(map.get("accnum"));
		dbtcardtextfield.sendKeys(map.get("dbtcard"));
		dbtpintextfield.sendKeys(map.get("dbtpin"));
		mobiletextfield.sendKeys(map.get("mobile"));
		pannotextfield.sendKeys(map.get("pan_no"));
		dobtextfield.click();
		dobtextfield.sendKeys(map.get("dob"));
		last_transtextfield.sendKeys(map.get("last_trans"));
		passwordtextfield.sendKeys(map.get("password"));
		cnfrm_passwordtextfield.sendKeys(map.get("cnfrm_password"));
		submitbtn.click();
		
	}
	

}
