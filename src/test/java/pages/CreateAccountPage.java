package pages;

import core.elements.Button;
import core.elements.TextField;
import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage {
    private final TextField newUserNameInput = new TextField(By.xpath("//*[@id=\"firstname\"]"), "New user first name Input");
    private final TextField newUserSurnameInput = new TextField(By.xpath("//*[@id=\"lastname\"]"), "New user last name Input");
    private final TextField newUserEmailInput = new TextField(By.xpath("//*[@id=\"email_address\"]"), "New user email Input");
    private final TextField newUserPasswordInput = new TextField(By.xpath("//*[@id=\"password\"]"), "New user password Input");
    private final TextField newUserConfirmPasswordInput = new TextField(By.xpath("//*[@id=\"password-confirmation\"]"), "New user password confirmation Input");
    private final Button createAccountButton = new Button(By.xpath("//button[@title=\"Create an Account\"]"), "Create account Button");

    public CreateAccountPage() {
        super(By.xpath("//*[@id=\"password-confirmation\"]"), "Create account page");
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
