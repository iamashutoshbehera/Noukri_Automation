package pageEvents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestContext;
import utils.KeyboardActions;
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

	@FindBy(xpath = "(//li[@class='collection-item typ-14Medium'])[2]")
	WebElement resemeHeadlineLinkLeftPanel;

	@FindBy(xpath = "(//span[@class ='edit icon'])[1]")
	WebElement resumeHeadlineEditButton;

	@FindBy(xpath = "//textarea[@id='resumeHeadlineTxt']")
	WebElement resemeHeadlineTextBox;

	@FindBy(xpath = "//div[@class='action s12']/button")
	WebElement resumeHeadlinePopUpSaveButton;

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
		Assert.assertEquals(SeleniumActions.getVisibleText(updateResumeSuccessMessage),
				"Resume has been successfully uploaded.");
		System.out.println(
				"-----Validated " + SeleniumActions.getVisibleText(updateResumeSuccessMessage) + " Message-----");
	}

	public void clickOnHomePageLogo() {
		SeleniumActions.waitTillElementToClickable(homePageLogo);
		SeleniumActions.performClick(homePageLogo);
		System.out.println("-----Clicked on Home Page Logo From Profile Page-----");
	}

	public void clickOnEditResumeHeadlineFieldLeftPanel() {
		SeleniumActions.waitTillElementToDisplayed(resemeHeadlineLinkLeftPanel);
		SeleniumActions.performClick(resemeHeadlineLinkLeftPanel);
		System.out.println("-----Clicked on Resume Headline On Left Panel-----");


	}

	public void updateResumeHeadline() {
		SeleniumActions.waitTillElementToClickable(resumeHeadlineEditButton);
		SeleniumActions.performClick(resumeHeadlineEditButton);
		System.out.println("-----Clicked on Resume Headline Edit Button-----");


		String headlineText = SeleniumActions.getVisibleText(resemeHeadlineTextBox);

		if (headlineText.contains(".")) {
			headlineText.replace(".", "");
		} else {
			headlineText = headlineText + ".";
		}
		
		SeleniumActions.waitTillElementToDisplayed(resemeHeadlineTextBox);
		SeleniumActions.enterValues(resemeHeadlineTextBox, headlineText);
		System.out.println("-----Entered Updated Resume Header into Text box-----");

		SeleniumActions.performClick(resumeHeadlinePopUpSaveButton);
		System.out.println("-----Clicked On Resume Header Text Box Save Button-----");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		KeyboardActions.pressEcc();
	}

}
