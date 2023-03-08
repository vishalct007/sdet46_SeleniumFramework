package banking.onlinebankingsystem.objectrepository.elements;

import java.awt.Desktop.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wc.genericUtility.ActionUtility;

public class HomePage {
	private String pxpath="//li[text()='%s']";
	@FindBy(partialLinkText = "Internet Banking")
	private WebElement internetBanking;


	@FindBy(xpath="//li[contains(text(),'Register')]")
	private WebElement internetBankingReg;

	@FindBy(xpath="//li[contains(text(),'Login')]")
	private WebElement internetBankingLogin;

	@FindBy(xpath = "//li[text()='Fund Transfer']")
	private WebElement fundtransfer;


	@FindBy (linkText ="Home")
	private WebElement homebtn;


	@FindBy(partialLinkText = "Staff Login")
	private WebElement staffLoginBtn;
	@FindBy(linkText = "Home")
	private WebElement homeBtn;
	private WebDriver driver;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	private WebElement getFundTransferOrOpenAccntOrApplyDebitCardWebelement(CommonTabs tab) {
		String xpath=String.format(pxpath,tab.getTab());
		return driver.findElement(By.xpath(xpath));
	}
	public void getFundTransferOrOpenAccntOrApplyDebitCard(CommonTabs tab) {
		getFundTransferOrOpenAccntOrApplyDebitCardWebelement(tab).click();
		
	}
	public void getInternetBanking(ActionUtility a) {
		 a.initializeAction(driver);
		  a.mouseHover(internetBanking);
		 
	}
	
	public void getStafflogin() {
		staffLoginBtn.click();
	}
	public void getHomePage() {
		homeBtn.click();
	}

	public void getibReg() {
		internetBankingReg.click();
	}

	public void getiLogin() {
		internetBankingLogin.click();
	}

	public  void  fundtransfer() {
		fundtransfer.click();
	}

	public void homebtn() {
		homebtn.click();
	}
	
	
	public void close() {
		driver.close();
	}


}
