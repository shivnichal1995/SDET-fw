package tests;

import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.JsonUtils;
import utils.LoggerUtils;
import reporting.ReportManager;

import static drivers.DriverManager.driver;

public class TestLogin extends BaseTest {

    @Test()
    public void loginTest() {
        JsonNode data = JsonUtils.getTestData("TestLoginData", "001");

        HomePage homePage =new HomePage();
        homePage.clickOnFormAuthentication();

        LoginPage loginPage = new LoginPage();
        String username = data.get("username").asText();
        String password = data.get("password").asText();
        String testcaseId = data.get("testcaseId").asText();

        LoggerUtils.info("Running TestCase: " + testcaseId);

        loginPage.login(username, password);



    }
}