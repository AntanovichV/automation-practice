package pages;

import core.elements.Button;
import core.elements.Label;
import core.elements.TextField;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final TextField userEmailInput = new TextField(By.xpath("//*[@id=\"email\"]"),
            "Existing user name Input");
    private final TextField userPasswordInput = new TextField(By.xpath("//*[@id=\"pass\"]"),
            "Existing user password Input");
    private final Button signInButton = new Button(By.xpath("//*[@id=\"send2\"]"),
            "Sign in Button");
    private final Label incorrectAccountLabel = new Label(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"),
            "Incorrect account message Label");


    public LoginPage() {
        super(By.xpath("//*[@id=\"send2\"]"), "Login page");
    }

    @Step("Enter username")
    public void setUserEmail(String value) {
        userEmailInput.sendKeys(value);
    }

    @Step("Enter password")
    public void setUserPassword(String value) {
        userPasswordInput.sendKeys(value);
    }

    @Step("Click on login button")
    public void clickSignIn() {
        signInButton.click();
    }

    public boolean isLoginIncorrectMessagePresented() {
        return incorrectAccountLabel.isEnabled();
    }

    @Step("Verify error message when invalid credential is provided")
    public String getLoginIncorrectMessageText() {
        return incorrectAccountLabel.getElement().getText();
    }
}
