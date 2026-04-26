package listeners;

import base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.ReportManager;
import utils.LoggerUtils;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        LoggerUtils.info("Starting Test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LoggerUtils.info("Test Passed: " + result.getName());
        ReportManager.captureScreenshot(); // optional
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerUtils.error("Test Failed: " + result.getName(), result.getThrowable());
        ReportManager.captureScreenshot(); // attach screenshot to Allure
        ReportManager.log(result.getThrowable().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LoggerUtils.warn("Test Skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        LoggerUtils.info("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        LoggerUtils.info("Test Suite Finished: " + context.getName());
    }
}