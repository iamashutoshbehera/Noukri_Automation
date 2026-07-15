package pageEvents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestContext;
import utils.ConfigReader;
import utils.SeleniumActions;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(TestContext.getDriver(), this);
	}

	@FindBy(id = "login_Layer")
	WebElement loginPageButton;

	@FindBy(xpath = "//input[@placeholder='Enter your active Email ID / Username']")
	WebElement usernameTextBox;

	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	WebElement passwordTextBox;

	@FindBy(xpath = "//button[@class='btn-primary loginButton']")
	WebElement loginButton;
	
	public void validateLoginPage() {
		
		ConfigReader config = new ConfigReader();
		SeleniumActions.waitTillElementToDisplayed(loginPageButton);
		Assert.assertEquals(TestContext.getDriver().getTitle().trim(), config.getLoginPageTitle().trim());
		System.out.println("-----Login Page Validated-----");

	}

	public void performLogin(String username, String password) {

		SeleniumActions.waitTillElementToDisplayed(loginPageButton);
		SeleniumActions.performClick(loginPageButton);
		System.out.println("-----Clicked on Login Page Button-----");

		SeleniumActions.waitTillElementToDisplayed(loginButton);
		SeleniumActions.enterValues(usernameTextBox, username);
		System.out.println("-----Username Entered-----");

		SeleniumActions.enterValues(passwordTextBox, password);
		System.out.println("-----Password Entered -----");
		SeleniumActions.performClick(loginButton);
		System.out.println("-----Clicked on Login Button -----");

	}
}
