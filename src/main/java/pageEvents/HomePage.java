package pageEvents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.TestContext;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import utils.SeleniumActions;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(TestContext.getDriver(), this);
	}

	@FindBy(xpath = "//div[@class='crossIcon chatBot chatBot-ic-cross']")
	WebElement sliderPopUpCloseIcon;

	@FindBy(xpath = "//div[@class='info__heading']")
	WebElement profileNameLeftPannel;

	@FindBy(xpath = "//div[@class='nI-gNb-drawer__bars']")
	WebElement profileSliderButton;

	@FindBy(xpath = "//a[@title='Logout']")
	WebElement logoutOption;
	
	@FindBy(xpath = "//a[@href='/mnjuser/profile']")
	WebElement viewProfileButton;
	
	@FindBy(xpath = "//div[@class='other-info-wrapper']/p")
	WebElement lastUpdatedProfileStatus;

	public void handelSlider() {
		
		try {
			SeleniumActions.waitTillElementToDisplayed(sliderPopUpCloseIcon);
			SeleniumActions.performClick(sliderPopUpCloseIcon);
			System.out.println("-----Slider Pop Up Slider closed-----");
			
		} catch (Exception e) {
			System.out.println("-----No Slider Pop Up Message Displayed-----");
		}
	}

	public void validateSuccessLogin(String profileName) {
		
		Assert.assertEquals(profileName, SeleniumActions.getVisibleText(profileNameLeftPannel));
		System.out.println("-----Validated Success Login for " + SeleniumActions.getVisibleText(profileNameLeftPannel) + "-----");
	}

	public void performLogout() {
		
		SeleniumActions.waitTillElementToDisplayed(profileSliderButton);
		SeleniumActions.performClick(profileSliderButton);
		System.out.println("-----Clicked On Profile Button-----");

		SeleniumActions.waitTillElementToDisplayed(logoutOption);
		SeleniumActions.performClick(logoutOption);
		System.out.println("-----Clicked On Logout Button-----");
	}
	
	public void clickOnViewProfile() {
		
		SeleniumActions.waitTillElementToDisplayed(viewProfileButton);
		SeleniumActions.performClick(viewProfileButton);
		System.out.println("-----Clicked on View Profile Button-----");
	}
	
	public void validateProfileStatus() {
		
		SeleniumActions.waitTillElementToDisplayed(lastUpdatedProfileStatus);
		Assert.assertEquals(SeleniumActions.getVisibleText(lastUpdatedProfileStatus), "Last updated today");
		System.out.println("-----Validated Profile Status " + SeleniumActions.getVisibleText(lastUpdatedProfileStatus) + "-----");
	}
}
