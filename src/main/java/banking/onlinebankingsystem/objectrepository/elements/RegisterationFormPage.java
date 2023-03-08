package banking.onlinebankingsystem.objectrepository.elements;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.wc.genericUtility.DropDownUtility;
import com.wc.genericUtility.SelectUtility;

public class RegisterationFormPage{


	private WebDriver driver;
	//declaration
	private String txBoxPartialXpath = "//input[@name='%s']";
//	private String txBoxNameAttr = " ";
	@FindBy (xpath = "//select[@name='gender']") private WebElement gender;
	@FindBy (name = "dob") private WebElement dob;
	@FindBy (xpath = "//select[@name='state']") private WebElement state;
	@FindBy (name = "city") private WebElement city;
	@FindBy (name = "acctype") private WebElement acctype;
	@FindBy (xpath = "//input[@type='submit']") private WebElement submit;
	@FindBy (xpath = "//input[@value='Confirm']") private WebElement confirm;
	@FindBy (name = "staff_id") private WebElement staffid;
	@FindBy (name = "password") private WebElement passwrd;
    @FindBy(name = "application_no") private WebElement applicationno;
	@FindBy(name = "search_application") private WebElement searchapplication;
	@FindBy(xpath = "//li[text()='Open Account']") private WebElement openacntxpath;
	
/**
 * This method is used to convert partialXpath  String to WebElement
 * @param partialXpath
 * @param replaceData
 * @return
 */
private WebElement convertToWebElement(String partialXpath, String replaceData) {
	String xpath = String.format(partialXpath, replaceData);
	return driver.findElement(By.xpath(xpath));
}

/*private WebElement convertToWebElementByName(String nameAttr, String replaceData) {
	String xpath = String.format(nameAttr, replaceData);
	return driver.findElement(By.name(name));
}*/


//Initialisation
public RegisterationFormPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	//Business Logic 
	public void sendValue(CreateAccAttr name, String data) {
		convertToWebElement(txBoxPartialXpath, name.getname()).sendKeys(data);;
	}

	/*public WebElement returnValue(CreateAccAttr name) {
		return convertToWebElementByName(txBoxNameAttr, name.getName());
	}*/

	
	public WebElement genderAction() {
		return gender;
	}

	public WebElement dobAction() {
		return dob;
	}

	public WebElement stateAction() {
		return state;
	}

	public WebElement cityAction() {
		return city;
	}

	public WebElement accTypeAction() {
		return acctype;
	}

	public void submitAction() {
		submit.click();
	}
	
	
	public void confirmAction() {
		confirm.click();
	}
	
	
	public void registerAccount(Map<String,String>map) {
	     sendValue(CreateAccAttr.NAME, map.get("name"));
         sendValue(CreateAccAttr.MOBILE, map.get("mobile"));
		 sendValue(CreateAccAttr.EMAIL,map.get("email") );
		 sendValue(CreateAccAttr.LANDLINE,map.get("landline") );
	     sendValue(CreateAccAttr.PANNO, map.get("pan_no"));
	     sendValue(CreateAccAttr.CITZENSHIP, map.get("citizenship"));
		 sendValue(CreateAccAttr.HOMEADDRESS, map.get("homeaddrs"));
		 sendValue(CreateAccAttr.OFFICEADDRESS, map.get("officeaddrs"));
		 sendValue(CreateAccAttr.PIN, map.get("pin"));
		 sendValue(CreateAccAttr.AREALOC, map.get("arealoc"));
		 sendValue(CreateAccAttr.NOMINEENAME,map.get("nominee_name") );
		 sendValue(CreateAccAttr.NOMINEEACNO, map.get("nominee_ac_no"));

	}
}














