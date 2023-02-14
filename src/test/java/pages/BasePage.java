package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

abstract class BasePage {
    private final String locator;
    private final String name;

    BasePage(String locator, String name) {
        this.locator = locator;
        this.name = name;
        isPageOpen();
    }

    private void isPageOpen() {
        SelenideElement element = $(By.xpath(locator));
        try {
            element.shouldBe(Condition.visible);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
