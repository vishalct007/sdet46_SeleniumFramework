package banking.onlinebankingsystem.objectrepository.elements;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wc.genericUtility.SelectUtility;

public class AddBeneficiaryAndAmountPage {
	@FindBy(name ="beneficiary_name" )
	private WebElement benficaryname;
	
	@FindBy(name ="beneficiary_acno" )
	private WebElement benificaryacno;
	
	@FindBy(name ="Ifsc_code" )
	private WebElement ifsccodetxt;
	
	@FindBy(name ="add_beneficiary" )
	private WebElement addbenificary;
	
	 @FindBy (xpath = "//li[text()='Fund Transfer']")
	 		private WebElement fundtransferbtn;
	 
	@FindBy(name = "beneficiary_acc_type")
	private WebElement acc_typeDd;
	
	@FindBy(name = "add_beneficiary_btn")
	private WebElement addbenificiarybtn;
	
	
public AddBeneficiaryAndAmountPage(WebDriver driver) {
	PageFactory.initElements(driver,this );
}


public void benificaryDetails(Map<String, String> map,SelectUtility selct) {
	benficaryname.sendKeys(map.get("beneficiary_name"));
	benificaryacno.sendKeys(map.get("beneficiary_acno"));
	ifsccodetxt.sendKeys(map.get("Ifsc_code"));
	selct.initializeSelect(acc_typeDd);
    selct.selectByVisibleText(map.get("beneficiary_acc_type"));
    
	
}
public void addbenificary() {
	addbenificary.click();
}

public void fundtransfer() {
	fundtransferbtn.click();
}
public void addbenificiarybtns() {
	addbenificiarybtn.click();
}

}
