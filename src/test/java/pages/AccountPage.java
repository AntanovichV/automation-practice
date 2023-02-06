package pages;

import core.elements.Button;
import core.elements.Label;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {
    private final Button userDropDownMenuButton = new Button(By.xpath("//button[@class=\"action switch\"]"),
            "Drop down menu Button");
    private final Button signOutButton = new Button(By.xpath("//li[@class='customer-welcome active']//li[@class=\"authorization-link\"]"),
            "Sing out Button");
    private final Label passwordErrorLabel = new Label(By.xpath("//*[@id=\"password-error\"]"),
            "Password error Label");
    private final Label alertMessageLabel = new Label(By.xpath("//*[@role=\"alert\"]/div/div"),
            "Contact already exist Label");

    public AccountPage() {
        super(By.xpath("//h1"), "Account page");
    }

    public boolean isLoginSuccess() {
        return userDropDownMenuButton.isEnabled();
    }

    public void logout() {
        userDropDownMenuButton.waitForElementIsClickable();
        userDropDownMenuButton.click();
        signOutButton.click();
    }

    public String getAlertMessage() {
        return alertMessageLabel.getElement().getText();
    }

    public String getPasswordErrorLabel() {
        return passwordErrorLabel.getElement().getText();
    }
}
