//package tests.account;
//
//import com.codeborne.selenide.WebDriverRunner;
//import core.Constants;
//import io.qameta.allure.*;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import tests.BaseTest;
//import pages.AccountPage;
//import pages.LoginPage;
//import pages.MainPage;
//
//import java.io.*;
//import java.util.Properties;
//import java.util.logging.LogManager;
//import java.util.logging.Logger;
//
//@Epic("Web Application Regression Testing")
//@Feature("Login Page Tests")
//public class LoginTest extends BaseTest {
//    @Severity(SeverityLevel.MINOR)
//    @Test
//    @Description("Login Test with valid credentials")
//    @Story("Successful Login to Application")
//    public void userIsAbleLoginRightCredentials() throws IOException {
//        try {
//            FileInputStream fis =  new FileInputStream("src/test/resources/log.properties");
//            LogManager.getLogManager().readConfiguration(fis);
//            fis.close();
//
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//        Logger logger = Logger.getLogger(LoginTest.class.getName());
//        logger.info("It was easy!");
//        logger.warning("Test starting");
//        FileReader reader = new FileReader("C:\\Projects\\presentation\\git\\automation-practice\\src\\test\\resources\\cred.properties");
//        Properties props = new Properties();
//        props.load(reader);
//        MainPage mainPage = new MainPage();
//        mainPage.clickLogin();
//        LoginPage loginPage = new LoginPage();
//        loginPage.setUserEmail(props.getProperty("user.email"));
//        loginPage.setUserPassword(props.getProperty("user.password"));
//        loginPage.clickSignIn();
//        AccountPage accountPage = new AccountPage();
//        Assertions.assertTrue(accountPage.isLoginSuccess());
//        accountPage.logout();
//    }
//
//    @Severity(SeverityLevel.NORMAL)
//    @Test
//    @Description("Logout Test")
//    @Story("Successful Logout from Application")
//    public void userIsAbleLogout() throws IOException {
//        FileReader reader = new FileReader("C:\\Projects\\presentation\\git\\automation-practice\\src\\test\\resources\\cred.properties");
//        Properties props = new Properties();
//        props.load(reader);
//
//        BaseTest.navigateTo(Constants.BASE_URL);
//
//        MainPage mainPage = new MainPage();
//        mainPage.clickLogin();
//
//        LoginPage loginPage = new LoginPage();
//        loginPage.setUserEmail(props.getProperty("user.email"));
//        loginPage.setUserPassword(props.getProperty("user.password"));
//        loginPage.clickSignIn();
//
//        AccountPage accountPage = new AccountPage();
//        accountPage.logout();
//        Assertions.assertEquals("https://magento.softwaretestingboard.com/customer/account/logoutSuccess/", WebDriverRunner.getWebDriver().getCurrentUrl());
//    }
//
//    @Severity(SeverityLevel.NORMAL)
//    @Test
//    @Description("Login Test with invalid credentials")
//    @Story("Unsuccessful Login to Application")
//    public void userIsNotAbleLoginWrongCredentials() throws IOException {
//        FileReader reader = new FileReader("C:\\Projects\\presentation\\git\\automation-practice\\src\\test\\resources\\cred.properties");
//        Properties props = new Properties();
//        props.load(reader);
//
//        BaseTest.navigateTo(Constants.BASE_URL);
//
//        MainPage mainPage = new MainPage();
//        mainPage.clickLogin();
//
//        LoginPage loginPage = new LoginPage();
//        loginPage.setUserEmail(props.getProperty("user.wrong.email"));
//        loginPage.setUserPassword(props.getProperty("user.password"));
//        loginPage.clickSignIn();
//        Assertions.assertTrue(loginPage.isLoginIncorrectMessagePresented());
//        Assertions.assertEquals("Incorrect CAPTCHA", loginPage.getLoginIncorrectMessageText());
//    }
//}
