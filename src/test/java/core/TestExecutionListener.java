package core;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class TestExecutionListener implements ITestListener {

    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog (String message) {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(BaseTest.browser.getDriver());
        saveTextLog(result.getTestName());
    }

}
