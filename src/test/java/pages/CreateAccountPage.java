package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateAccountPage extends BasePage {
    private SelenideElement newUserNameInput = $(By.xpath("//*[@id=\"firstname\"]"));
    private SelenideElement newUserSurnameInput = $(By.xpath("//*[@id=\"lastname\"]"));
    private SelenideElement newUserEmailInput = $(By.xpath("//*[@id=\"email_address\"]"));
    private SelenideElement newUserPasswordInput = $(By.xpath("//*[@id=\"password\"]"));
    private SelenideElement newUserConfirmPasswordInput = $(By.xpath("//*[@id=\"password-confirmation\"]"));
    private SelenideElement createAccountButton = $(By.xpath("//button[@title=\"Create an Account\"]"));

    public CreateAccountPage() {
        super("//*[@id=\"password-confirmation\"]", "Create account page");
    }

    public void setNewUserNameInput(String value) {
        newUserNameInput.sendKeys(value);
    }

    public void setNewUserSurnameInput(String value) {
        newUserSurnameInput.sendKeys(value);
    }

    public void setNewUserEmailInput(String value) {
        newUserEmailInput.sendKeys(value);
    }

    public void setNewUserPasswordInput(String value) {
        newUserPasswordInput.sendKeys(value);
    }

    public void setNewUserConfirmPasswordInput(String value) {
        newUserConfirmPasswordInput.sendKeys(value);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }
}
