package pages;

import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtils;
import utils.WaitUtils;

public class LoginPage {

    private WebDriver driver;

    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.id("errorMsg");

    public LoginPage() {
        this.driver = DriverManager.getDriver();
    }

    public void enterUsername(String username) {
        WaitUtils.waitForVisibility(usernameInput).clear();
        WaitUtils.waitForVisibility(usernameInput).sendKeys(username);
        LoggerUtils.info("Entered username: " + username);
    }

    public void enterPassword(String password) {
        WaitUtils.waitForVisibility(passwordInput).clear();
        WaitUtils.waitForVisibility(passwordInput).sendKeys(password);
        LoggerUtils.info("Entered password: " + password);
    }

    public void clickLogin() {
        WaitUtils.waitForClickable(loginButton).click();
        LoggerUtils.info("Clicked login button");
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return WaitUtils.waitForVisibility(errorMessage).getText();
    }
}