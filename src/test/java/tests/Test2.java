package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Test2 {
    @Test
    public void test2() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                options
        );
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        System.out.println("Test2");
        driver.quit();
    }
}
