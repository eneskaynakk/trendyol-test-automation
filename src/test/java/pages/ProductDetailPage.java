package pages;

import elements.ProductDetailPageElement;
import utility.Utility;

public class ProductDetailPage extends Utility {
    ProductDetailPageElement productDetailPageElement = new ProductDetailPageElement();

    public void productDetailPage(){
        switchToNewTab();
    }

    public void closePopup(){
        clickElementWithWait(productDetailPageElement.popup);
    }

    public String getFullProductDetailName() {
        return getTextElement(productDetailPageElement.productListProductBrand)
                + " " + getTextElement(productDetailPageElement.productListProductModel);
    }

    public String addToCart(){
        clickElementWithWait(productDetailPageElement.addToCartButton);
        return getTextElement(productDetailPageElement.numberOfProducts);
    }
}