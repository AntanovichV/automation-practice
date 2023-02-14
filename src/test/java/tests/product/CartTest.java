//package tests.product;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import pages.CartPage;
//import pages.CatalogPage;
//import tests.BaseTest;
//
//public class CartTest extends BaseTest {
//    @Test
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
//        Assertions.assertEquals(cartPage.getCartEmptyMessage(), "You have no items in your shopping cart.");
//    }
//}
