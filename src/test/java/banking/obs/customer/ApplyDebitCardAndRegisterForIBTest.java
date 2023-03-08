package banking.obs.customer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.obs.genericutilityenum.PropertyKey;
import com.wc.genericUtility.ActionUtility;
import com.wc.genericUtility.BaseClass;
import com.wc.genericUtility.Constants;
import com.wc.genericUtility.ExcelUtility;
import com.wc.genericUtility.JavaUtility;
import com.wc.genericUtility.PopupUtility;
import com.wc.genericUtility.PropertyUtility;
import com.wc.genericUtility.VerificationUtility;
import com.wc.genericUtility.WebDriverUtility;
import com.wc.utility.annotation.ReportAnnotation;

import banking.onlinebankingsystem.objectrepository.elements.Acountholderregisterpage;
import banking.onlinebankingsystem.objectrepository.elements.ApplyDebitCardPage;
import banking.onlinebankingsystem.objectrepository.elements.CustomerLoginPage;
import banking.onlinebankingsystem.objectrepository.elements.HomePage;
import banking.onlinebankingsystem.objectrepository.elements.StaffLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyDebitCardAndRegisterForIBTest extends BaseClass {
	@ReportAnnotation(author="Vishal",categories = "Smoke")
	@Test(groups={"smoke testscript","Regression testscript"})
	public void AplyDebitcardAndRegd()
	{
		Map<String,String> map=excelUtility.getExcelData("ApplyDebitCardAndRegisterForIBTest", "Banking");
		System.out.println(map);

		//creating object of pom classes
		ApplyDebitCardPage applydebitcard =new ApplyDebitCardPage(driver);
		HomePage homepage=new HomePage(driver);
		Acountholderregisterpage regdpage = new Acountholderregisterpage(driver);
		CustomerLoginPage customerlogin =new CustomerLoginPage(driver);

		//applying for debitcard by taking necessary details from pom page and methods
		applydebitcard.debitcard();
		applydebitcard.getdebitcarddat(map);

		//handling the alertpopup
		popupUtility.initializeAlert(driver);
		popupUtility.alertAccept();
 
		//clicking on homebutton to navigate to homepage
		homepage.homebtn();

		//clicking on internetbanking tab and perfrorming action by registering 
		homepage.getInternetBanking(actionUtility);
		homepage.getibReg();
		regdpage.registerpage(map);

		popupUtility.initializeAlert(driver);
		popupUtility.getTextOfAlert();
		popupUtility.alertAccept();

		homepage.homebtn();
		homepage.getInternetBanking(actionUtility);

		homepage.getiLogin();

		customerlogin.customerloginmet(map);
		customerlogin.statement();
		customerlogin.logout();

		driver.close();
	}



}


