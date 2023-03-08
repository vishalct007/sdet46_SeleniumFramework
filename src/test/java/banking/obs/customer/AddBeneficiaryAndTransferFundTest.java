package banking.obs.customer;

import java.awt.Desktop.Action;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obs.genericutilityenum.PropertyKey;
import com.wc.genericUtility.ActionUtility;
import com.wc.genericUtility.BaseClass;
import com.wc.genericUtility.Constants;
import com.wc.genericUtility.ExcelUtility;
import com.wc.genericUtility.JavaUtility;
import com.wc.genericUtility.PopupUtility;
import com.wc.genericUtility.PropertyUtility;
import com.wc.genericUtility.SelectUtility;
import com.wc.genericUtility.VerificationUtility;
import com.wc.genericUtility.WebDriverUtility;
import com.wc.utility.annotation.ReportAnnotation;

import banking.onlinebankingsystem.objectrepository.elements.AddBeneficiaryAndAmountPage;
import banking.onlinebankingsystem.objectrepository.elements.CustomerLoginPage;
import banking.onlinebankingsystem.objectrepository.elements.HomePage;
import banking.onlinebankingsystem.objectrepository.elements.TransferAmountPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddBeneficiaryAndTransferFundTest extends BaseClass {
	@ReportAnnotation(author="Vishal",categories = "Smoke")
	@Test(groups="smoke testscript")
	public void addBenificaryTransferTheAmount() {
	     Map<String, String> map = excelUtility.getExcelData("AddBeneficiaryAndTransferFundTest","Banking");
		System.out.println(map);


		//creating object of pom classes
		 HomePage homepage= new HomePage(driver);
		 CustomerLoginPage customerLogin=new CustomerLoginPage(driver);
		 AddBeneficiaryAndAmountPage abamt=new AddBeneficiaryAndAmountPage(driver) ;
		 TransferAmountPage tansferamount=new TransferAmountPage(driver);
		 
		 //creating object of soft assert
		 SoftAssert s =new SoftAssert();
		 
		  //clicking on internetbanking tab and performing login actions
	       homepage.getInternetBanking(actionUtility);
		         homepage.getiLogin();
		        
		  //verifying login page by soft assert reference variable
			  String actualTitle= driver.getTitle();
			  String expectedTitle="Login Page";
			  s.assertEquals(actualTitle, expectedTitle);
			  
	
		//performing action by entering customer credentials
				customerLogin.customerloginmet(map);
		          
				
		//verifying my profile page by soft assert reference variable	
				String actualTitleMP= driver.getTitle();
				String expectedTitleMP="My Profile";
				s.assertEquals(actualTitleMP, expectedTitleMP);
		     
				
				
			//clicking on fundtransfer tab	
				homepage.fundtransfer();
		       
			
				//add beneficiary and enter valid details
				abamt.addbenificary();
				abamt.benificaryDetails(map,selectUtility);
				abamt.addbenificiarybtns();
				
				///handling alertpopup
					popupUtility.initializeAlert(driver);
					popupUtility.alertAccept();
	                     abamt.fundtransfer();
	              
	            //transfering the money and closing browser
	              tansferamount.transfermoney(map, selectUtility);   
	                  driver.close();
	                  s.assertAll();

		}


	}

