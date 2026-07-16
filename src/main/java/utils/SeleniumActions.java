package utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestContext;

public class SeleniumActions {

	public static void waitTillElementToDisplayed(WebElement element) {
		ConfigReader config = new ConfigReader();
		WebDriverWait wait = new WebDriverWait(TestContext.getDriver(), Duration.ofSeconds(config.getDefaultPageLoadTime()));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitTillElementToClickable(WebElement element) {
		ConfigReader config = new ConfigReader();
		WebDriverWait wait = new WebDriverWait(TestContext.getDriver(), Duration.ofSeconds(config.getDefaultPageLoadTime()));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void performClick(WebElement elemenet) {
		elemenet.click();
	}
	
	public static void enterValues(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public static String getVisibleText(WebElement element) {
		return element.getText();
	}
	
}
