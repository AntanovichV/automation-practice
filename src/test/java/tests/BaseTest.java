package tests;

import core.BaseEntity;
import core.Constants;
import io.qameta.allure.Step;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest extends BaseEntity {
    @Step("Start the test")
    @BeforeTest
    public void beforeTest() {
        browser.navigate(Constants.BASE_URL);
        logger.logTestName(this.getClass().getName());
    }

    public static void navigateTo(String url) {
        browser.navigate(url);
    }

    @Step("Stop the test")
    @AfterTest
    public void afterTest() {
        logger.logTestEnd(this.getClass().getName());
    }
}
