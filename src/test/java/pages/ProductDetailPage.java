package pages;

import elements.ProductDetailPageElement;
import utility.Utility;

public class ProductDetailPage extends Utility {
    ProductDetailPageElement productDetailPageElement = new ProductDetailPageElement();

    public void productDetailPage(){
        switchToNewTab();
        clickElementWithWait(productDetailPageElement.popup);
    }

    public String getProductDetailName() {
        return getTextElement(productDetailPageElement.productDetailBrand)
                + " " + getTextElement(productDetailPageElement.productDetailModel);
    }

    public String addToCart(){
        clickElementWithWait(productDetailPageElement.addToCartButton);
        return getTextElement(productDetailPageElement.numberOfProducts);
    }
}