package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {
    private SelenideElement loginButton = $(By.xpath("//ul[@class='header links']/li[2]/a"));
    private SelenideElement createAccountButton = $(By.xpath("//ul[@class='header links']/li[3]/a"));

    public MainPage() {
        super("//h1", "Main Page");
    }

    @Step("Go to login page")
    public void clickLogin() {
        loginButton.click();
    }

    @Step("Go to create account page")
    public void clickCreateAccount() {
        createAccountButton.click();
    }
}
