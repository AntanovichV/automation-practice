package tests.product;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CatalogPage;
import tests.BaseTest;

public class CartTest extends BaseTest {
    @Test(description = "Check that user can find product in the catalog")
    public void userIsAbleDeleteProductFromCart() {
        BaseTest.navigateTo("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.clickRainCoatStyle()
                .switchListView()
                .clickSortByPrice()
                .chooseSize()
                .chooseColor()
                .addToCart();
        catalogPage.clickCart();

        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.isItemInCart());
        cartPage.clickDeleteButton();
        Assert.assertEquals(cartPage.getCartEmptyMessage(), "You have no items in your shopping cart.");
    }
}
