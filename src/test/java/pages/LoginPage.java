package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class LoginPage extends BasePage {
    private final SelenideElement userEmailInput = $(By.xpath("//*[@id=\"email\"]"));
    private final SelenideElement userPasswordInput = $(By.xpath("//*[@id=\"pass\"]"));
    private final SelenideElement signInButton = $(By.xpath("//*[@id=\"send2\"]"));
    private final SelenideElement incorrectAccountLabel = $(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));


    public LoginPage() {
        super("//*[@id=\"send2\"]", "Login page");
    }

    public void setUserEmail(String value) {
        step("Entering email: " + value, () -> {
            userEmailInput.setValue(value);
        });
    }

    public void setUserPassword(String value) {
        step("Entering password: " + value, () -> {
            userPasswordInput.sendKeys(value);
        });
    }

    public void clickSignIn() {
        step("Click login", () -> {
            signInButton.click();
        });
    }

    public boolean isLoginIncorrectMessagePresented() {
        return incorrectAccountLabel.isDisplayed();
    }

    public String getLoginIncorrectMessageText() {
        return incorrectAccountLabel.getText();
    }
}
