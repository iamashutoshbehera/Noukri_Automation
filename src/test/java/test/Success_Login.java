package test;

import org.testng.annotations.Test;

import base.BasePage;
import pageEvents.HomePage;
import pageEvents.LoginPage;
import utils.ConfigReader;

public class Success_Login extends BasePage {

	@Test
	public void test() {
		
		System.out.println("=====Success Login Test Started=====");
		LoginPage lp = new LoginPage();
		ConfigReader config = new ConfigReader();

		lp.validateLoginPage();
		lp.performLogin(config.getUsername(), config.getPassword());

		HomePage hp = new HomePage();
		hp.handelSlider();
		hp.validateSuccessLogin(config.getProfileName());

		hp.performLogout();
		lp.validateLoginPage();
		System.out.println("=====Success Login Test Successfully Completed=====");
	}

}
