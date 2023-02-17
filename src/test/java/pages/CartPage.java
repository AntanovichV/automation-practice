package pages;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage {
    private final SelenideElement itemInCartDetailsLabel = $(By.xpath("//td[@data-th='Item']"));
    private final SelenideElement deleteItemCartButton = $(By.xpath("//a[@class='action action-delete']"));
    private final SelenideElement emptyCartMessageLabel = $(By.xpath("//div[@class='cart-empty']/p[1]"));

    public CartPage() {
        super("//h1", "Cart page");
    }

    public boolean isItemInCart() {
        return itemInCartDetailsLabel.isDisplayed();
    }

    @Step("Click delete product from the cart")
    public void clickDeleteButton() {
        deleteItemCartButton.click();
    }

    public String getCartEmptyMessage() {
        return emptyCartMessageLabel.getText();
    }
}
