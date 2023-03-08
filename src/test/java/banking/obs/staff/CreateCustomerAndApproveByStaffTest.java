package banking.obs.staff;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obs.genericutilityenum.PropertyKey;
import com.wc.genericUtility.BaseClass;
import com.wc.genericUtility.Constants;
import com.wc.genericUtility.DropDownUtility;
import com.wc.genericUtility.EncryptedDecryptedUtility;
import com.wc.genericUtility.ExcelUtility;
import com.wc.genericUtility.JavaUtility;
import com.wc.genericUtility.PopupUtility;
import com.wc.genericUtility.PropertyUtility;
import com.wc.genericUtility.SelectUtility;
import com.wc.genericUtility.VerificationUtility;
import com.wc.genericUtility.WebDriverUtility;
import com.wc.utility.annotation.ReportAnnotation;

import banking.onlinebankingsystem.objectrepository.elements.CommonStaffTab;
import banking.onlinebankingsystem.objectrepository.elements.CommonTabs;
import banking.onlinebankingsystem.objectrepository.elements.CustomerDetailsPage;
import banking.onlinebankingsystem.objectrepository.elements.HomePage;
import banking.onlinebankingsystem.objectrepository.elements.PendingCustomersPage;
import banking.onlinebankingsystem.objectrepository.elements.RegisterationFormPage;
import banking.onlinebankingsystem.objectrepository.elements.StaffHomePage;
import banking.onlinebankingsystem.objectrepository.elements.StaffLoginPage;
import banking.onlinebankingsystem.objectrepository.elements.StaffPage;

public class CreateCustomerAndApproveByStaffTest extends BaseClass{

	@ReportAnnotation(author="Vishal",categories = "Smoke")
		@Test(groups="smoke testscript")
		public  void createCustomerAccountAndApprove() throws IOException {
			Map<String, String> map = excelUtility.getExcelData("CreateCustomerAndApproveByStaffTest","Banking");
	        System.out.println(map);

     //creating object of pom classes
      HomePage homePage=new HomePage(driver);
      RegisterationFormPage rfp= new RegisterationFormPage(driver);
      StaffPage staffPage=new StaffPage(driver);
      StaffHomePage staffhomePage=new StaffHomePage(driver);
      PendingCustomersPage pendingCustomerPage=new PendingCustomersPage(driver);
      CustomerDetailsPage customerDetailspage=new CustomerDetailsPage(driver);
      
      
      //clicking action on open account tab and verifying page with help of hardassert
      homePage.getFundTransferOrOpenAccntOrApplyDebitCard(CommonTabs.OPEN_ACCOUNT);
      String actualrp=driver.getTitle();
      String expectedrp="Registration Form";
      Assert.assertEquals(actualrp, expectedrp);
      
      //fetching the values of textfields from excel
      rfp.registerAccount(map);
      
      //storing dropdowns in reference variables and fetching data from excel
      WebElement gender =rfp.genderAction();
      selectUtility.initializeSelect(gender);
      selectUtility.selectByvalue(map.get("gender"));
      WebElement state =rfp.stateAction();
      selectUtility.initializeSelect(state);
      selectUtility.selectByVisibleText(map.get("state"));
      WebElement city = rfp.cityAction();
      selectUtility.initializeSelect(city);
      selectUtility.selectByVisibleText(map.get("city"));
      WebElement accountype = rfp.accTypeAction();
      selectUtility.initializeSelect(accountype);
      selectUtility.selectByVisibleText(map.get("acctype"));
      
      
      //clicking on dob textfield and getting data from excel
      rfp.dobAction().click();
	  rfp.dobAction().sendKeys(map.get("dob"));

	
	
	 //clicking on submit button after entering all valid details   
	        rfp.submitAction();
	        rfp.confirmAction();
	           
	        
	 //handling alertpopup and printing application number on console
	       popupUtility.initializeAlert(driver);
		 String txtmsg=popupUtility.getTextOfAlert();
		String Appnum = javautility.getAcnoFromAlertString(txtmsg);
		System.out.println("Application number is "+Appnum);
		 popupUtility.alertAccept();
		 
		 
		  //clicking on stafflogin link and verifying staff page by hard assert 
	     homePage.getStafflogin();
	       String actualsp= driver.getTitle();
	       String expectedsp = "Staff Page";
	       Assert.assertEquals(actualsp, expectedsp);
					                       
		  //calling method from pom page for stafflogin action			                       
	       staffPage.setStaffLogin(propertyUtility);
					                   	
					                      		                      
		  //clicking on approve pending acc tab and verifying the page		                     
		   staffhomePage.clickOnStaffHomePage(CommonStaffTab.APPROVE_PENDING_ACC);
			String actualpc=driver.getTitle();
			String expectedpc="Pending Customers";
			Assert.assertEquals(actualpc, expectedpc);
					                      
					                       
		   //calling method from pom page for entering details action
             pendingCustomerPage.enterDetails(Appnum);
					                      
					                      
			//handling alertpopup and printing account number on console		                      
		     String txt = popupUtility.getTextOfAlert();
	        String Accnum = javautility.getAcnoFromAlertString(txt);
		     System.out.println("Account number is "+Accnum);
	        popupUtility.alertAccept();
					                 
			////clicking on homepage tab and verifying the page		                      
			 homePage.getHomePage();
		    String actualHp=driver.getTitle();
		    String expectedHp="Online Banking System";
		     Assert.assertEquals(actualHp, expectedHp);      
		     homePage.getStafflogin();
					                   
		   //clicking on view customer by account number tab and verifying page
		    staffhomePage.clickOnStaffHomePage(CommonStaffTab.VIEW_CUSTOMER_BY_AC);
			String actualcp = driver.getTitle();
			String expectedcp = "Customer Details";
			Assert.assertEquals(actualcp, expectedcp);
			customerDetailspage.getCustomerDetails(Accnum);
			
			//closing the browser
			homePage.close();
					     
					
				}

}


