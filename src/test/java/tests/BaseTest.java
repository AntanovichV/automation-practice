package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import core.Constants;
import core.Logger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
        protected static Logger logger = Logger.getInstance();

    @BeforeAll
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void beforeTest() {
        Selenide.open(Constants.BASE_URL);
        logger.logTestName(this.getClass().getName());
    }

    public static void navigateTo(String url) {
        Selenide.open(url);
    }

    @AfterEach
    public void afterTest() {
        logger.logTestEnd(this.getClass().getName());
    }

    @AfterAll
    public void tearDown() {
        SelenideLogger.removeListener("allure");
    }
}
