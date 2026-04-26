package base;

import config.ConfigManager;
import drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverManager.initDriver(ConfigManager.get("browser"));
        DriverManager.getDriver().get(ConfigManager.get("base.url"));
    }

    @AfterMethod
    public void teardown() {
        DriverManager.quitDriver();
    }
}