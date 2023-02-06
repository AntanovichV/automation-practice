package tests.account;

import core.BaseEntity;
import core.Constants;
import core.TestExecutionListener;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import tests.BaseTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.MainPage;

import java.io.*;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("Web Application Regression Testing")
@Feature("Login Page Tests")
@Listeners(TestExecutionListener.class)
public class LoginTest extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Login with valid username and password")
    @Description("Login Test with valid credentials")
    @Story("Successful Login to Application")
    public void userIsAbleLoginRightCredentials() throws IOException {
        FileReader reader = new FileReader("C:\\Projects\\automation-practice\\src\\test\\resources\\cred.properties");
        Properties props = new Properties();
        props.load(reader);

        BaseTest.navigateTo(Constants.BASE_URL);

        MainPage mainPage = new MainPage();
        mainPage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.setUserEmail(props.getProperty("user.email"));
        loginPage.setUserPassword(props.getProperty("user.password"));
        loginPage.clickSignIn();

        AccountPage accountPage = new AccountPage();
        assertTrue(accountPage.isLoginSuccess());
        accountPage.logout();
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 1, description = "Logout")
    @Description("Logout Test")
    @Story("Successful Logout from Application")
    public void userIsAbleLogout() throws IOException {
        FileReader reader = new FileReader("C:\\Projects\\automation-practice\\src\\test\\resources\\cred.properties");
        Properties props = new Properties();
        props.load(reader);

        BaseTest.navigateTo(Constants.BASE_URL);

        MainPage mainPage = new MainPage();
        mainPage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.setUserEmail(props.getProperty("user.email"));
        loginPage.setUserPassword(props.getProperty("user.password"));
        loginPage.clickSignIn();

        AccountPage accountPage = new AccountPage();
        accountPage.logout();
        assertEquals(BaseEntity.browser.getDriver().getCurrentUrl(), "https://magento.softwaretestingboard.com/customer/account/logoutSuccess/");
    }

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2, description = "Login with invalid username and password")
    @Description("Login Test with invalid credentials")
    @Story("Unsuccessful Login to Application")
    public void userIsNotAbleLoginWrongCredentials() throws IOException {
        FileReader reader = new FileReader("C:\\Projects\\automation-practice\\src\\test\\resources\\cred.properties");
        Properties props = new Properties();
        props.load(reader);

        BaseTest.navigateTo(Constants.BASE_URL);

        MainPage mainPage = new MainPage();
        mainPage.clickLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.setUserEmail(props.getProperty("user.wrong.email"));
        loginPage.setUserPassword(props.getProperty("user.password"));
        loginPage.clickSignIn();
        assertTrue(loginPage.isLoginIncorrectMessagePresented());
        assertEquals(loginPage.getLoginIncorrectMessageText(), "Incorrect CAPTCHA");
    }
}
