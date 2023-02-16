package tests.account;

import core.Constants;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CreateAccountPage;
import tests.BaseTest;
import pages.AccountPage;
import pages.MainPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

@Epic("Web Application Regression Testing")
@Feature("Create Account Page Tests")
public class CreateAccountTest extends BaseTest {
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("Create Account Test")
    @Story("Successful Account Creation")
    public void userIsAbleToCreateAccount() throws IOException {
        BaseTest.navigateTo(Constants.BASE_URL);
        FileReader reader = new FileReader("C:\\Projects\\automation-practice\\src\\test\\" +
                "resources\\cred.properties");
        Properties props = new Properties();
        props.load(reader);
        Random random = new Random();

        String generatedString = random.ints(97, 123)
                .limit(4)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        MainPage mainPage = new MainPage();
        mainPage.clickCreateAccount();

        CreateAccountPage createAccountPage = new CreateAccountPage();
        createAccountPage.setNewUserNameInput(props.getProperty("new.user.name"));
        createAccountPage.setNewUserSurnameInput(props.getProperty("new.user.surname"));
        createAccountPage.setNewUserEmailInput(generatedString + props.getProperty("new.user.email"));
        createAccountPage.setNewUserPasswordInput(props.getProperty("new.user.password"));
        createAccountPage.setNewUserConfirmPasswordInput(props.getProperty("new.user.password"));
        createAccountPage.clickCreateAccountButton();

        AccountPage accountPage = new AccountPage();
        Assertions.assertEquals("Thank you for registering with Fake Online Clothing Store.",
                accountPage.getAlertMessage());
        accountPage.logout();
    }

    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("Creating Account with existing email Test")
    @Story("Unsuccessful Account Creation(email)")
    public void userIsNotAbleToCreateAccountWithExistingEmail() throws IOException {
        FileReader reader = new FileReader("C:\\Projects\\automation-practice\\src\\test\\" +
                "resources\\cred.properties");
        Properties props = new Properties();
        props.load(reader);

        BaseTest.navigateTo(Constants.BASE_URL);

        MainPage mainPage = new MainPage();
        mainPage.clickCreateAccount();

        CreateAccountPage createAccountPage = new CreateAccountPage();
        createAccountPage.setNewUserNameInput(props.getProperty("new.user.name"));
        createAccountPage.setNewUserSurnameInput(props.getProperty("new.user.surname"));
        createAccountPage.setNewUserEmailInput(props.getProperty("new.user.email"));
        createAccountPage.setNewUserPasswordInput(props.getProperty("new.user.password"));
        createAccountPage.setNewUserConfirmPasswordInput(props.getProperty("new.user.password"));
        createAccountPage.clickCreateAccountButton();

        AccountPage accountPage = new AccountPage();
        Assertions.assertEquals(
                "There is already an account with this email address. If you are sure that it " +
                        "is your email address, click here to get your password and access your account.",
                accountPage.getAlertMessage());
    }

    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("Creating Account with not valid password Test")
    @Story("Unsuccessful Account Creation(password)")
    public void userIsNotAbleToCreateAccountWithNotValidPassword() throws IOException {
        FileReader reader = new FileReader("C:\\Projects\\automation-practice\\src\\test\\" +
                "resources\\cred.properties");
        Properties props = new Properties();
        props.load(reader);

        BaseTest.navigateTo(Constants.BASE_URL);

        MainPage mainPage = new MainPage();
        mainPage.clickCreateAccount();

        CreateAccountPage createAccountPage = new CreateAccountPage();
        createAccountPage.setNewUserNameInput(props.getProperty("new.user.name"));
        createAccountPage.setNewUserSurnameInput(props.getProperty("new.user.surname"));
        createAccountPage.setNewUserEmailInput(props.getProperty("new.user.email"));
        createAccountPage.setNewUserPasswordInput(props.getProperty("user.not.valid.password"));
        createAccountPage.setNewUserConfirmPasswordInput(props.getProperty("user.not.valid.password"));
        createAccountPage.clickCreateAccountButton();

        AccountPage accountPage = new AccountPage();
        Assertions.assertEquals(
                "Minimum length of this field must be equal or greater than 8 symbols. " +
                        "Leading and trailing spaces will be ignored.", accountPage.getPasswordErrorLabel());
    }
}
