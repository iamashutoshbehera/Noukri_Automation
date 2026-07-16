package utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import base.TestContext;

public class KeyboardActions {
	
	public static void pressEcc() {
		Actions act = new Actions(TestContext.getDriver());
		act.sendKeys(Keys.ESCAPE).perform();
	}

}
