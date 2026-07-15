package base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import utils.ConfigReader;

public class BasePage {
	@BeforeTest
	public void setup() {
		
		TestContext.setDriver(new ChromeDriver());
		TestContext.getDriver().manage().window().maximize();
		TestContext.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		System.out.println("-----Browser launched-----");

		ConfigReader config = new ConfigReader();
		TestContext.getDriver().get(config.getUrl());
		System.out.println("-----Navigated to the URL "+ config.getUrl() +"-----");
	}
	
	@AfterTest
	public void close() {
		
		TestContext.getDriver().close();
		System.out.println("-----Browser Closed-----");
	}
}
