package core.elements;

import core.Browser;
import core.Constants;
import core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class BaseElement {
    public static Browser browser = Browser.getInstance();
    private static final Logger LOGGER = Logger.getInstance();
    RemoteWebElement element;
    private final By LOCATOR;
    private final String name;

    public BaseElement(By LOCATOR, String elementName) {
        this.LOCATOR = LOCATOR;
        name = elementName;
    }

    public RemoteWebElement getElement() {
        waitForIsElementPresent();
        return element;
    }

    public void waitForIsElementPresent() {
        isPresent(Constants.DEFAULT_TIMEOUT);
        int count = 0;
        if (!element.isDisplayed()) {
            while (count < 3) {
                waitForIsElementPresent();
                count++;
            }
        }
        assertTrue(element.isDisplayed(), "Element is not presented");
    }

    public By getLocator() {
        return LOCATOR;
    }

    public void click() {
        waitForIsElementPresent();
        LOGGER.info(String.format("Click on %s element", name));
        element.click();
    }

    public void sendKeys(String value) {
        LOGGER.info(String.format("Send <%s> value to %s element", value, name));
        browser.getDriver()
                .findElement(LOCATOR)
                .sendKeys(value);
    }

    public void sendKeys(Keys value) {
        LOGGER.info(String.format("Send <%s> key on %s element", value.name(), name));
        browser.getDriver()
                .findElement(LOCATOR)
                .sendKeys(value);
    }

    public List<WebElement> getElements() {
        return browser.getDriver().findElements(LOCATOR);
    }

    public void waitForElementIsClickable() {
        waitForIsElementPresent();
        new WebDriverWait(browser.getDriver(), Duration.ofSeconds(Constants.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(LOCATOR));
    }

    public void waitForElementTextIsVisible(String value) {
        waitForIsElementPresent();
        new WebDriverWait(browser.getDriver(), Duration.ofSeconds(Constants.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.textToBe(LOCATOR, value));
    }

    public void waitForElementIsVisible() {
        waitForIsElementPresent();
        new WebDriverWait(browser.getDriver(), Duration.ofSeconds(Constants.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isEnabled() {
        return browser.getDriver()
                .findElement(LOCATOR)
                .isEnabled();
    }

    @Deprecated
    public boolean isPresent(int timeout) {
        WebDriverWait wait = new WebDriverWait(Browser.getInstance().getDriver(), Duration.ofSeconds(timeout));
        browser.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            wait.until((ExpectedCondition<Boolean>) driver -> {
                try {
                    assert driver != null;
                    List<WebElement> list = driver.findElements(LOCATOR);
                    for (WebElement el : list) {
                        if (el instanceof RemoteWebElement && el.isDisplayed()) {
                            element = (RemoteWebElement) el;
                            return element.isDisplayed();
                        }
                    }
                    element = (RemoteWebElement) driver.findElement(LOCATOR);
                } catch (Exception e) {
                    LOGGER.warn(String.format("Element %s is not presented", name));
                    return false;
                }
                return element.isDisplayed();
            });
        } catch (Exception e) {
            return false;
        }
        try {
            browser.getDriver().manage()
                    .timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
