package tests;

import com.codeborne.selenide.Selenide;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class ExampleTest {
    @Test
    public void verifyTitle() {
        Selenide.open("https://www.google.com");
        String actualTitle = Selenide.title();
        System.out.println(actualTitle);


        // Call assertEquals() method to verify the comparison between actual title and expected title.
        Assertions.assertEquals(actualTitle, "Google");
    }

    @Test
    public void verifyTitleFail() {
        Selenide.open("https://www.google.com");
        String actualTitle = Selenide.title();
        System.out.println(actualTitle);

        // Call assertEquals() method to verify the comparison between actual title and expected title.
        Assertions.assertEquals(actualTitle, "Google", "Match not found");
    }

    @Test
    public void compareNumeric() {
        Assertions.assertTrue(5 > 2);
        System.out.println("5 is greater than 2");
    }

    @Test
    public void compareString() {
        Assertions.assertTrue("Java".equals("Java"), "Not matched"); // true
//        Assertions.assertTrue("Selenium".equals("Java"), "Not matched"); // false
    }

    @Test
    public void compareNumericFalse() {
        Assertions.assertFalse(5 > 8); // Here, condition is true. So, test case will be marked as failed and the next statement will not be executed.
    }

    @Test
    public void compareStringFalse() {
        Assertions.assertFalse("Selenium" == "Java", "Matched"); // Here, condition is false. So, test case will be passed by assertion.
    }

//    @Test
//    public void testCaseFails() {
//        Assertions.fail("test purpose"); // Here, test case will be marked as failed and the next statement will not be executed.
//    }

    private static Object emptyObject;

    @Test
    public void testNull() {
        Assertions.assertNull(emptyObject);
    }

    @Test
    public void testNotNullDriver() {
        Assertions.assertNotNull(Selenide.title());
    }

    @Test
    public void testSameString() {
        String str1 = "Hello";
        String str2 = "Hello";

        Assertions.assertSame(str1, str2, "Address of both string objects is the same");
    }

    @Test
    public void testEqual() {
        String s1 = "Java";
        String s2 = new String("Java");

        Assertions.assertEquals(s1, s2, "Contents are same");
    }

    @Test
    public void testSame() {
        String s1 = "Java";
        String s2 = new String("Java");

        Assertions.assertNotSame(s1, s2, "Address of both string objects are not same");
    }

    @Test
    public void testNotSameString() {
        String str1 = "Hello";
        String str2 = "Hello1";

        Assertions.assertNotSame(str1, str2, "Address of both string objects is the same");
    }

    @Test
    public void testNotSameStringObject() {
        String s1 = "Java";
        String s2 = new String("Java");

        Assertions.assertNotSame(s1, s2, "Address of both string objects are not same");
    }

    @Test
    void testTimeout() {
        //This will pass
        Assertions.assertTimeout(Duration.ofMinutes(1), () -> {
            return "result";
        });

        //This will fail
//        Assertions.assertTimeout(Duration.ofMillis(100), () -> {
//            Thread.sleep(200);
//            return "result";
//        });

        //This will fail
//        Assertions.assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
//            Thread.sleep(200);
//            return "result";
//        });
    }

    @Test
    public void testAssertions() {
        //test data:
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";
        int val1 = 5;
        int val2 = 6;
        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};

        //Check that two objects are equal str1, str2
        Assertions.assertEquals(str1, str2);
        // Check that a condition is true val1 < val2;
        Assertions.assertTrue(val1 < val2);
        // Check that a condition is false val1 > val2;
        Assertions.assertFalse(val1 > val2);
        // Check that an object isn't null str1;
        Assertions.assertNotNull(str1);
        // Check  that  an  object  is  null str3;
        Assertions.assertNull(str3);
        // Check if two object references point to the same object str4, str5;

        // Check if two object references not point to the same object str1, str3;
    }

    @Test
    public void hardAssert() {
        System.out.println("Hard assertion started from here");
        Assertions.assertTrue(true); // Test case failed here and next statement will not be executed.
        System.out.println("Hard assertion ended here");
    }

    @Test
    public void softAssert() {
        SoftAssertions sa = new SoftAssertions();
        System.out.println("Soft assertion started from here");
        sa.assertThat(true).isEqualTo(false); // Test case failed here but next statement will be executed.
        System.out.println("Soft assertion ended here");
    }


//    @Test
//    public void host_dinner_party_where_nobody_dies_hard() {
//        Mansion mansion = new Mansion();
//        mansion.hostPotentiallyMurderousDinnerParty();
//        Assertions.assertEquals(mansion.guests, 7);
//        Assertions.assertEquals(mansion.kitchen, "clean");
//        Assertions.assertEquals(mansion.library, "clean");
//        Assertions.assertEquals(mansion.revolverAmmo, 6);
//        Assertions.assertEquals(mansion.candlestick, "pristine");
//        Assertions.assertEquals(mansion.colonel, "well-kept");
//        Assertions.assertEquals(mansion.professor, "well-kept");
//    }
//
//    @Test
//    public void host_dinner_party_where_nobody_dies_group() {
//        Mansion mansion = new Mansion();
//        mansion.hostPotentiallyMurderousDinnerParty();
//        Assertions.assertAll("What happend: ",
//                () -> Assertions.assertEquals(mansion.guests, 7),
//                () -> Assertions.assertEquals(mansion.kitchen, "clean"),
//                () -> Assertions.assertEquals(mansion.library, "clean"),
//                () -> Assertions.assertEquals(mansion.revolverAmmo, 6),
//                () -> Assertions.assertEquals(mansion.candlestick, "pristine"),
//                () -> Assertions.assertEquals(mansion.colonel, "well-kept"),
//                () -> Assertions.assertEquals(mansion.professor, "well-kept"));
//    }


    public class Mansion {
        public int guests;
        public String kitchen;
        public String library;
        public int revolverAmmo;
        public String candlestick;
        public String colonel;
        public String professor;

        public Mansion() {
            this.guests = 6;
            this.revolverAmmo = 6;
            this.kitchen = "clean";
            this.library = "messy";
            this.candlestick = "bent";
            this.colonel = "well-kept";
            this.professor = "bloodied and disheveled";
        }

        public void hostPotentiallyMurderousDinnerParty() {
        }
    }

}
