package pageEvents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestContext;
import utils.SeleniumActions;

public class ProfilePage {
	
	public ProfilePage() {
		PageFactory.initElements(TestContext.getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@value='Update resume']")
	WebElement uploadResume;
	
	@FindBy(xpath = "//i[@data-title='delete-resume']")
	WebElement deleteResumeIcon;
	
	@FindBy(xpath = "//p[@class='msg']")
	WebElement updateResumeSuccessMessage;
	
	@FindBy(xpath = "//a[@class='nI-gNb-header__logo nI-gNb-company-logo']/img")
	WebElement homePageLogo;
	
	
	public void clickonUploadResumeButton() {
		
		SeleniumActions.waitTillElementToDisplayed(uploadResume);
		SeleniumActions.performClick(uploadResume);
		System.out.println("-----Clicked on Upload Resume Button-----");
	}
	
	public void clickonDeleteResumeIcon() {
		
		SeleniumActions.waitTillElementToDisplayed(deleteResumeIcon);
		SeleniumActions.performClick(deleteResumeIcon);
		System.out.println("-----Clicked on Delete Resume Icon-----");
	}
	
	public void validateSuccessResumeUploadMessage() throws InterruptedException {
		Thread.sleep(6000);
		SeleniumActions.waitTillElementToDisplayed(updateResumeSuccessMessage);
		Assert.assertEquals(SeleniumActions.getVisibleText(updateResumeSuccessMessage), "Resume has been successfully uploaded.");
		System.out.println("-----Validated " + SeleniumActions.getVisibleText(updateResumeSuccessMessage) + " Message-----");
	}
	
	public void clickOnHomePageLogo() {
		SeleniumActions.performClick(homePageLogo);
		System.out.println("-----Clicked on Home Page Logo From Profile Page-----");
	}
}
