package tests.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import pages.AccountPage;
import pages.LoginPage;
import pages.MainPage;

import java.io.*;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoginTest extends BaseTest {
    @Test
    public void userIsAbleLoginRightCredentials() throws IOException {
        try {
            FileInputStream fis =  new FileInputStream("src/test/resources/log.properties");
            LogManager.getLogManager().readConfiguration(fis);
            fis.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
        Logger logger = Logger.getLogger(LoginTest.class.getName());
        logger.info("It was easy!");
        logger.info("Test starting");
        FileReader reader = new FileReader("C:\\Projects\\automation-practice\\src\\test\\resources\\cred.properties");
        Properties props = new Properties();
        props.load(reader);
        logger.warning("Start Main page");
        MainPage mainPage = new MainPage();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage();
        loginPage.setUserEmail(props.getProperty("user.email"));
        loginPage.setUserPassword(props.getProperty("user.password"));
        logger.warning("Starting open Account page");


        loginPage.clickSignIn();
        AccountPage accountPage = new AccountPage();
        Assertions.assertTrue(accountPage.isLoginSuccess());
        accountPage.logout();
        logger.info("Test finished");
    }
}
