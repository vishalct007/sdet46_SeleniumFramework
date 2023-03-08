package banking.onlinebankingsystem.objectrepository.elements;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wc.genericUtility.SelectUtility;

public class TransferAmountPage {
	@FindBy (name = "beneficiary")
	private WebElement benficiaryname;
	
	@FindBy (name = "trnsf_amount")
	private WebElement transferamount;
	
	
	@FindBy (name = "fnd_trns_btn")
	private WebElement fndtransferbtn;
	
	@FindBy (id = "logout")
	private WebElement logoutbtn;
	
	
	 public TransferAmountPage(WebDriver driver) {
		 PageFactory.initElements(driver,this);
	 }
          
	 public void transfermoney(Map<String, String> map,SelectUtility selct){
		 transferamount.sendKeys(map.get("trnsf_amount")); 
		   selct.initializeSelect(benficiaryname);
           selct.selectByvalue(map.get("beneficiary_acno"));
           fndtransferbtn.click();
   		
           logoutbtn.click();
	 }
	
	

}
