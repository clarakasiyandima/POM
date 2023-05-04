package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
public class LoginTest{
	WebDriver driver;
	String userName="demo@techfios.com";
    String password= "abc123";
    
    @Test
	
	public void ValiduserShouldBeAbleToLogin() {
		//by name of the class
		driver = BrowserFactory.init();
		LoginPage loginPage1 = new LoginPage(driver);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUsername(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSigninButton();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		BrowserFactory.tearDown();
	}

}
