package test;

import org.testng.annotations.Test;

import base.BasePage;
import pageEvents.HomePage;
import pageEvents.LoginPage;
import pageEvents.ProfilePage;
import utils.ConfigReader;
import utils.UploadFileHandler;

public class Upload_Resume extends BasePage {

	@Test
	public void test() {
		System.out.println("=====Upload Resume Test Started=====");
		LoginPage lp = new LoginPage();
		ConfigReader config = new ConfigReader();

		lp.validateLoginPage();
		lp.performLogin(config.getUsername(), config.getPassword());

		HomePage hp = new HomePage();
		hp.handelSlider();
		hp.validateSuccessLogin(config.getProfileName());

		hp.clickOnViewProfile();
		
		ProfilePage pp = new ProfilePage();
		pp.clickonUploadResumeButton();
		
		UploadFileHandler fh = new UploadFileHandler();
		fh.uploadResume();
		pp.clickOnHomePageLogo();
		
		hp.validateProfileStatus();
	
		hp.performLogout();
		lp.validateLoginPage();
		System.out.println("=====Upload Resume Test Successfully Completed=====");

	}

}
