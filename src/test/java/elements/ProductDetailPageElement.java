package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class ProductDetailPageElement {

    public ProductDetailPageElement() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//aside//button[contains(text(), 'Anladım')]")
    public WebElement popup;

    @FindBy(css="[class='product-brand-name-with-link']")
    public WebElement productDetailBrand;

    @FindBy(css="h1[class='pr-new-br'] > span")
    public WebElement productDetailModel;

    @FindBy(css="[class='add-to-basket-button-text']")
    public WebElement addToCartButton;

    @FindBy(css="[class='basket-item-count-container visible']")
    public WebElement numberOfProducts;
}
