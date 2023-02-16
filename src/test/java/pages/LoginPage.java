package pages;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private SelenideElement userEmailInput = $(By.xpath("//*[@id=\"email\"]"));
    private SelenideElement userPasswordInput = $(By.xpath("//*[@id=\"pass\"]"));
    private SelenideElement signInButton = $(By.xpath("//*[@id=\"send2\"]"));
    private SelenideElement incorrectAccountLabel = $(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));


    public LoginPage() {
        super("//*[@id=\"send2\"]", "Login page");
    }

    @Step("Entering email {0}")
    public LoginPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Entering password {0}")
    public LoginPage setUserPassword(String value) {
        userPasswordInput.sendKeys(value);
        return this;
    }

    @Step("Click login")
    public LoginPage clickSignIn() {
        signInButton.click();
        return this;
    }

    public boolean isLoginIncorrectMessagePresented() {
        return incorrectAccountLabel.isDisplayed();
    }

    public String getLoginIncorrectMessageText() {
        return incorrectAccountLabel.getText();
    }
}
