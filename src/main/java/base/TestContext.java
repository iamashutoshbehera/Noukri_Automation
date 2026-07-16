package base;

import org.openqa.selenium.WebDriver;

public class TestContext {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void unload() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}