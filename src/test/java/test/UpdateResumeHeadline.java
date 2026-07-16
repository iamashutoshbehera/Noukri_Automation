package test;

import org.testng.annotations.Test;

import base.BasePage;
import pageEvents.HomePage;
import pageEvents.LoginPage;
import pageEvents.ProfilePage;
import utils.ConfigReader;

public class UpdateResumeHeadline extends BasePage {

	@Test
	public void updateResumeHeadline() {
		System.out.println("=====Upload Resume Headline Test Started=====");
		LoginPage lp = new LoginPage();
		ConfigReader config = new ConfigReader();

		lp.validateLoginPage();
		lp.performLogin(config.getUsername(), config.getPassword());

		HomePage hp = new HomePage();
		hp.handelSlider();
		hp.validateSuccessLogin(config.getProfileName());

		hp.clickOnViewProfile();

		ProfilePage pp = new ProfilePage();
		pp.clickOnEditResumeHeadlineFieldLeftPanel();
		pp.updateResumeHeadline();
		
		pp.clickOnHomePageLogo();

		hp.validateProfileStatus();

		hp.performLogout();
		lp.validateLoginPage();
		System.out.println("=====Upload Resume Headline Test Successfully Completed=====");
	}
}
