package reporting;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import drivers.DriverManager;

public class ReportManager {

    // Capture screenshot for Allure
    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[] captureScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    // You can extend methods for ReportPortal logs here
    @Attachment(value = "Log Message", type = "text/plain")
    public static String log(String message) {
        return message;
    }
}