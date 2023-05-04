package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	WebDriver driver;
	//Test mock data
	String userName="demo@techfios.com";
    String password= "abc123";
    String fullName= "selenium417";
     String company ="Techfios";
     String phone = "8622141799";
    String email  = "demo@techfios.com";
    String country = "Afghanistan";
  
    @Test	
	public void userShouldBeAbleToAddCustomer()  {
		driver= BrowserFactory.init();
		LoginPage loginPage1 = new LoginPage(driver);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUsername(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		DashboardPage dashboardPage= PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		dashboardPage.clickOnCustomerMenu();
		dashboardPage.clickOnAddCustomerMenuElement();
		
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		//addCustomerPage.validateAddCustomerPage();
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyName(company);
		addCustomerPage.insertPhoneNum(phone);
		addCustomerPage.unsertEmail(email);
		addCustomerPage.selectCountryName(country);
	}

}
