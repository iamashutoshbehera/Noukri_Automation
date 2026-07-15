package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestContext {
	
	private static WebDriver driver;
	
	public static void setDriver(WebDriver localDriver) {
		if(driver == null) {
			driver = localDriver;
		}
	}
	
	public static WebDriver getDriver() {
		if(driver == null) {
			return driver = new ChromeDriver();
		} else {
			return driver;
		}
	}
}
