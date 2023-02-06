package tests.product;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CatalogPage;
import tests.BaseTest;

public class ProductTest extends BaseTest {
    @Test(description = "Check that user can find product in the catalog")
    public void userIsAbleFindProduct() {
        BaseTest.navigateTo("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.clickRainCoatStyle()
                .switchListView()
                .clickSortByPrice()
                .chooseSize()
                .chooseColor()
                .addToCart();
        Assert.assertEquals(catalogPage.getProductAddedMessage(), "You added Beaumont Summit Kit to your shopping cart.");
    }
}
