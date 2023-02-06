package pages;

import core.elements.Button;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    private final Button loginButton = new Button(By.xpath("//ul[@class='header links']/li[2]/a"),
            "Login Button");
    private final Button createAccountButton = new Button(By.xpath("//ul[@class='header links']/li[3]/a"),
            "Create Account Button");

    public MainPage() {
        super(By.xpath("//h2"), "Main page");
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }
}
