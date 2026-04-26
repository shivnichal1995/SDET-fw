package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By formAuthentication = By.xpath("//a[text()='Form Authentication']");

    public void clickOnFormAuthentication() {
        click(formAuthentication);
    }

}