package base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class BasePage {

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        // Create a new browser for every test
        TestContext.setDriver(new ChromeDriver());

        TestContext.getDriver().manage().window().maximize();
        TestContext.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        TestContext.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("----- Browser launched -----");

        ConfigReader config = new ConfigReader();
        TestContext.getDriver().get(config.getUrl());

        System.out.println("----- Navigated to URL : " + config.getUrl() + " -----");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        TestContext.unload();

        System.out.println("----- Browser Closed -----");
    }
}