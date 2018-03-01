package utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import java.util.concurrent.TimeUnit

class DriverFactory {

    private static WebDriver driver;

    public DriverFactory() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver")
        initialize()
    }

    public static void initialize() {
        if (driver == null) createNewDriverInstance()
    }

    private static void createNewDriverInstance() {
        driver = new ChromeDriver()
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        driver
    }

    public static void destroyDriver() {
        driver.quit()
        driver = null
    }
}
