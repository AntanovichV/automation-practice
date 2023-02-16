package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage extends BasePage {
    private SelenideElement jacketStyleLabel = $(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"));
    private SelenideElement rainCoatStyleLabel = $(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[6]/a"));
    private SelenideElement listViewButton = $(By.xpath("//*[@id=\"mode-list\"]"));
    private SelenideElement sortByPriceLabel = $(By.xpath("//*[@id=\"sorter\"]/option[3]"));
    private SelenideElement firstItemSizeButton = $(By.xpath("//*[@id=\"option-label-size-143-item-168\"]"));
    private SelenideElement firstItemColorButton = $(By.xpath("//*[@id=\"option-label-color-93-item-58\"]"));
    private SelenideElement addToCartButton = $(By.xpath("//*[@title=\"Add to Cart\"]"));
    private SelenideElement productAddedMessageLabel = $(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"));
    private SelenideElement productCartNumberLabel = $(By.xpath("//span[@class='counter qty']"));
    private SelenideElement cartLabel = $(By.xpath("//a[@class='action showcart']"));
    private SelenideElement editCartLabel = $(By.xpath("//a[@class='action viewcart']"));

    public CatalogPage() {
        super("//header//img", "Catalog page");
    }

    public CatalogPage clickRainCoatStyle() {
        jacketStyleLabel.shouldBe(Condition.appear);
        jacketStyleLabel.click();
        rainCoatStyleLabel.click();
        return this;
    }

    public CatalogPage switchListView() {
        listViewButton.click();
        return this;
    }

    public CatalogPage clickSortByPrice() {
        sortByPriceLabel.click();
        return this;
    }

    public CatalogPage chooseSize() {
        firstItemSizeButton.click();
        return this;
    }

    public CatalogPage chooseColor() {
        firstItemColorButton.click();
        return this;
    }

    public void addToCart() {
        addToCartButton.isEnabled();
        addToCartButton.shouldBe(Condition.visible);
        addToCartButton.click();
    }

    public String getProductAddedMessage() {
        return productAddedMessageLabel.getText();
    }

    public void clickCart() {
        productCartNumberLabel.shouldBe(Condition.visible);
        cartLabel.click();
        editCartLabel.click();
    }
}
