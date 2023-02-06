package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {

    private static Browser instance;
    private static RemoteWebDriver driver;

    public static Browser getInstance() {
        if (instance == null) {
            try {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();

            } catch (Exception e) {
                e.printStackTrace();
            }
            instance = new Browser();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }

    public void navigate(String url) {
        driver.get(url);
    }

    public void exit() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
    }

    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        try {
            wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
                public Boolean apply(final WebDriver d) {
                    if (!(d instanceof JavascriptExecutor)) {
                        return true;
                    }
                    Object result = ((JavascriptExecutor) d)
                            .executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
                    if (result instanceof Boolean && (Boolean) result) {
                        return true;
                    }
                    return false;
                }
            });
        } catch (Exception e) {
            System.err.println("Page is not loaded");
        }
    }

    public boolean isBrowserAlive() {
        return instance != null;
    }
}
