package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage {
    private SelenideElement userDropDownMenuButton = $(By.xpath("//button[@class=\"action switch\"]"));
    private SelenideElement signOutButton = $(By.xpath("//li[@class='customer-welcome active']//li[@class=\"authorization-link\"]"));
    private SelenideElement passwordErrorLabel = $(By.xpath("//*[@id=\"password-error\"]"));
    private SelenideElement alertMessageLabel = $(By.xpath("//*[@role=\"alert\"]/div/div"));

    public AccountPage() {
        super("//h1", "Account page");
    }

    public boolean isLoginSuccess() {
        return userDropDownMenuButton.isEnabled();
    }

    public void logout() {
        userDropDownMenuButton.shouldBe(Condition.visible);
        userDropDownMenuButton.click();
        signOutButton.click();
    }

    public String getAlertMessage() {
        return alertMessageLabel.getText();
    }

    public String getPasswordErrorLabel() {
        return passwordErrorLabel.getText();
    }
}
