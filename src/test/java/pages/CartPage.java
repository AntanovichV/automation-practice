//package pages;
//
//
//public class CartPage extends BasePage {
//    private final Label itemInCartDetailsLabel = new Label(By.xpath("//td[@data-th='Item']"),
//            "Item in cart details Label");
//    private final Button deleteItemCartButton = new Button(By.xpath("//a[@class='action action-delete']"),
//            "Delete item Button");
//    private final Label emptyCartMessageLabel = new Label(By.xpath("//div[@class='cart-empty']/p[1]"),
//            "Empty cart message Label");
//
//    public CartPage() {
//        super(By.xpath("//h1"), "Cart page");
//    }
//
//    public boolean isItemInCart() {
//        return itemInCartDetailsLabel.getElement().isDisplayed();
//    }
//
//    public void clickDeleteButton() {
//        deleteItemCartButton.click();
//    }
//
//    public String getCartEmptyMessage() {
//        return emptyCartMessageLabel.getElement().getText();
//    }
//}
