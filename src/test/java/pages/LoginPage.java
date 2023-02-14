package pages;


import com.codeborne.selenide.SelenideElement;
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

    public LoginPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public LoginPage setUserPassword(String value) {
        userPasswordInput.sendKeys(value);
        return this;
    }

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
