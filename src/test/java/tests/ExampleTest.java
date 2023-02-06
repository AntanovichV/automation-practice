package tests;

import core.BaseEntity;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExampleTest extends BaseTest {
    @Test
    public void verifyTitle() {
        BaseTest.navigateTo("https://www.google.com");
        WebDriver driver = BaseEntity.browser.getDriver();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

//        Assert

        // Call assertEquals() method to verify the comparison between actual title and expected title.
        Assert.assertEquals(actualTitle, "Google");
    }

    @Test
    public void verifyTitleFail() {
        BaseTest.navigateTo("https://www.google.com");
        WebDriver driver = BaseEntity.browser.getDriver();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        // Call assertEquals() method to verify the comparison between actual title and expected title.
        Assert.assertEquals(actualTitle, "Gooooooogle", "Match not found");
    }

    @Test
    public void compareNumeric() {
        Assert.assertTrue(5 > 2);
        System.out.println("5 is greater than 2");
    }

    @Test
    public void compareString() {
        Assert.assertTrue("Java".equals("Java"), "Not matched"); // true
        Assert.assertTrue("Selenium".equals("Java"), "Not matched"); // false
    }

    @Test
    public void compareNumericFalse() {
        Assert.assertFalse(5 > 2); // Here, condition is true. So, test case will be marked as failed and the next statement will not be executed.
    }

    @Test
    public void compareStringFalse() {
        Assert.assertFalse("Selenium" == "Java", "Matched"); // Here, condition is false. So, test case will be passed by assertion.
    }

    @Test
    public void testCaseFails() {
        Assert.fail("test purpose"); // Here, test case will be marked as failed and the next statement will not be executed.
    }

    private static Object emptyObject;
    @Test
    public void testNull() {
        Assert.assertNull(emptyObject);
    }

    @Test
    public void testNotNullDriver() {
        WebDriver driver = BaseEntity.browser.getDriver();
        Assert.assertNotNull(driver);
    }

    @Test
    public void testSameString() {
        String str1 = "Hello";
        String str2 = "Hello";

        Assert.assertSame(str1, str2, "Address of both string objects is the same");
    }

    @Test
    public void testEqual() {
        String s1 = "Java";
        String s2 = new String("Java");

        Assert.assertEquals(s1, s2, "Contents are same");
    }

    @Test
    public void testSame() {
        String s1 = "Java";
        String s2 = new String("Java");

        Assert.assertSame(s1, s2, "Address of both string objects are not same");
    }

    @Test
    public void testNotSameString() {
        String str1 = "Hello";
        String str2 = "Hello";

        Assert.assertNotSame(str1, str2, "Address of both string objects is the same");
    }

    @Test
    public void testNotSameStringObject() {
        String s1 = "Java";
        String s2 = new String("Java");
        Assert.assertNotSame(s1, s2, "Address of both string objects are not same");
    }

    @Test
    public void softAssert() {
        SoftAssert sa = new SoftAssert();
        System.out.println("Soft assertion started from here");

        sa.assertTrue(false); // Test case failed here but next statement will be executed.
        System.out.println("Soft assertion ended here");
    }

    @Test
    public void hardAssert() {
        System.out.println("Hard assertion started from here");
        Assert.assertTrue(false); // Test case failed here and next statement will not be executed.
        System.out.println("Hard assertion ended here");
    }
}
