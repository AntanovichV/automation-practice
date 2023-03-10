//package tests.product;
//
//import io.qameta.allure.*;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import pages.CartPage;
//import pages.CatalogPage;
//import tests.BaseTest;
//
//@Epic("Web Application Regression Testing")
//@Feature("Cart Page Tests")
//public class CartTest extends BaseTest {
//    @Severity(SeverityLevel.CRITICAL)
//    @Test
//    @Description("Empty Cart Test")
//    @Story("User is able to add and delete product to the Cart")
//    public void userIsAbleDeleteProductFromCart() {
//        BaseTest.navigateTo("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
//        CatalogPage catalogPage = new CatalogPage();
//        catalogPage.clickRainCoatStyle()
//                .switchListView()
//                .clickSortByPrice()
//                .chooseSize()
//                .chooseColor()
//                .addToCart();
//        catalogPage.clickCart();
//
//        CartPage cartPage = new CartPage();
//        Assertions.assertTrue(cartPage.isItemInCart());
//        cartPage.clickDeleteButton();
//        Assertions.assertEquals("You have no items in your shopping cart.", cartPage.getCartEmptyMessage());
//    }
//}
