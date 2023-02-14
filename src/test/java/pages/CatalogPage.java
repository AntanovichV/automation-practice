//package pages;
//
//
//public class CatalogPage extends BasePage {
//    private final Label jacketStyleLabel = new Label(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[1]"),
//            "Style jacket Label");
//    private final Label rainCoatStyleLabel = new Label(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[6]/a"),
//            "Rain coat style jacket Label");
//    private final Button listViewButton = new Button(By.xpath("//*[@id=\"mode-list\"]"), "List view Button");
//    private final Label sortByPriceLabel = new Label(By.xpath("//*[@id=\"sorter\"]/option[3]"), "Sort by price Label");
//    private final Button firstItemSizeButton = new Button(By.xpath("//*[@id=\"option-label-size-143-item-168\"]"),
//            "First item size Button");
//    private final Button firstItemColorButton = new Button(By.xpath("//*[@id=\"option-label-color-93-item-58\"]"),
//            "First item color Button");
//    private final Button addToCartButton = new Button(By.xpath("//*[@title=\"Add to Cart\"]"),
//            "Add to cart Button");
//    private final Label productAddedMessageLabel = new Label(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div"),
//            "Success product added Label");
//    private final Label productCartNumberLabel = new Label(By.xpath("//span[@class='counter qty']"),
//            "Number of products in cart Label");
//    private final Button cartLabel = new Button(By.xpath("//a[@class='action showcart']"),
//            "Cart Button");
//    private final Label editCartLabel = new Label(By.xpath("//a[@class='action viewcart']"),
//            "Edit cart Label");
//
//    public CatalogPage() {
//        super(By.xpath("//header//img"), "Catalog page");
//    }
//
//    public CatalogPage clickRainCoatStyle() {
//        jacketStyleLabel.waitForElementIsClickable();
//        jacketStyleLabel.click();
//        rainCoatStyleLabel.click();
//        return this;
//    }
//
//    public CatalogPage switchListView() {
//        listViewButton.click();
//        return this;
//    }
//
//    public CatalogPage clickSortByPrice() {
//        sortByPriceLabel.click();
//        return this;
//    }
//
//    public CatalogPage chooseSize() {
//        firstItemSizeButton.click();
//        return this;
//    }
//
//    public CatalogPage chooseColor() {
//        firstItemColorButton.click();
//        return this;
//    }
//
//    public void addToCart() {
//        addToCartButton.isEnabled();
//        addToCartButton.waitForElementIsClickable();
//        addToCartButton.click();
//    }
//
//    public String getProductAddedMessage() {
//        return productAddedMessageLabel.getElement().getText();
//    }
//
//    public void clickCart() {
//        productCartNumberLabel.waitForIsElementPresent();
//        cartLabel.click();
//        editCartLabel.click();
//    }
//}
