package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class CreateAccountPage extends BasePage {
    private final SelenideElement newUserNameInput = $(By.xpath("//*[@id=\"firstname\"]"));
    private final SelenideElement newUserSurnameInput = $(By.xpath("//*[@id=\"lastname\"]"));
    private final SelenideElement newUserEmailInput = $(By.xpath("//*[@id=\"email_address\"]"));
    private final SelenideElement newUserPasswordInput = $(By.xpath("//*[@id=\"password\"]"));
    private final SelenideElement newUserConfirmPasswordInput = $(By.xpath("//*[@id=\"password-confirmation\"]"));
    private final SelenideElement createAccountButton = $(By.xpath("//button[@title=\"Create an Account\"]"));

    public CreateAccountPage() {
        super("//*[@id=\"password-confirmation\"]", "Create account page");
    }

    public void setNewUserNameInput(String value) {
        step("Entering name: " + value, () -> {
            newUserNameInput.sendKeys(value);
        });
    }

    public void setNewUserSurnameInput(String value) {
        step("Entering surname: " + value, () -> {
            newUserSurnameInput.sendKeys(value);
        });
    }

    public void setNewUserEmailInput(String value) {
        step("Entering email: " + value, () -> {
            newUserEmailInput.sendKeys(value);
        });
    }

    public void setNewUserPasswordInput(String value) {
        step("Entering password: " + value, () -> {
            newUserPasswordInput.sendKeys(value);
        });
    }

    public void setNewUserConfirmPasswordInput(String value) {
        step("Confirming password: " + value, () -> {
            newUserConfirmPasswordInput.sendKeys(value);
        });
    }

    public void clickCreateAccountButton() {
        step("Click create account", () -> {
            createAccountButton.click();
        });
    }
}
