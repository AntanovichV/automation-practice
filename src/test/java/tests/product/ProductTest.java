//package tests.product;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import pages.CatalogPage;
//import tests.BaseTest;
//
//public class ProductTest extends BaseTest {
//    @Test
//    public void userIsAbleFindProduct() {
//        BaseTest.navigateTo("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
//        CatalogPage catalogPage = new CatalogPage();
//        catalogPage.clickRainCoatStyle()
//                .switchListView()
//                .clickSortByPrice()
//                .chooseSize()
//                .chooseColor()
//                .addToCart();
//        Assertions.assertEquals(catalogPage.getProductAddedMessage(), "You added Beaumont Summit Kit to your shopping cart.");
//    }
//}
