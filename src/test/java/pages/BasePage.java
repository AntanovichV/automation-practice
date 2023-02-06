package pages;

import core.elements.Label;
import org.openqa.selenium.By;

abstract class BasePage {
    private final By locator;
    private final String name;

    BasePage(By locator, String name) {
        this.locator = locator;
        this.name = name;
        isPageOpen();
    }

    private void isPageOpen() {
        Label elem = new Label(locator, name);
        try {
            elem.waitForIsElementPresent();
        } catch (Throwable e) {
            System.err.println("Page was not opened");
        }
    }
}
