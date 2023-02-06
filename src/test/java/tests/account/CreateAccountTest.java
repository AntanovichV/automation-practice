package tests.account;

import core.Constants;
import org.testng.Assert;
import pages.CreateAccountPage;
import tests.BaseTest;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainPage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class CreateAccountTest extends BaseTest {
    @Test(description = "Check that new user can create new account")
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
        Assert.assertEquals(accountPage.getAlertMessage(),
                "Thank you for registering with Fake Online Clothing Store.");
        accountPage.logout();
    }

    @Test(description = "Check that new user can't create new account with existing email")
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
        Assert.assertEquals(accountPage.getAlertMessage(),
                "There is already an account with this email address. If you are sure that it " +
                        "is your email address, click here to get your password and access your account.");
    }

    @Test(description = "Check that new user can't create new account with not valid password")
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
        Assert.assertEquals(accountPage.getPasswordErrorLabel(),
                "Minimum length of this field must be equal or greater than 8 symbols. " +
                        "Leading and trailing spaces will be ignored.");
    }
}
