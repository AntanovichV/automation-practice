//package tests.product;
//
//import io.qameta.allure.*;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import pages.CatalogPage;
//import tests.BaseTest;
//
//@Epic("Web Application Regression Testing")
//@Feature("Catalog Page Tests")
//public class ProductTest extends BaseTest {
//    @Severity(SeverityLevel.CRITICAL)
//    @Test
//    @Description("Search product in the catalog Test")
//    @Story("User is able to find product in the Catalog")
//    public void userIsAbleFindProduct() {
//        BaseTest.navigateTo("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
//        CatalogPage catalogPage = new CatalogPage();
//        catalogPage.clickRainCoatStyle()
//                .switchListView()
//                .clickSortByPrice()
//                .chooseSize()
//                .chooseColor()
//                .addToCart();
//        Assertions.assertEquals("You added Beaumont Summit Kit to your shopping cart.", catalogPage.getProductAddedMessage());
//    }
//}
