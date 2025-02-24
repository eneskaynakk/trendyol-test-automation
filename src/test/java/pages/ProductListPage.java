package pages;

import elements.ProductListPageElement;
import utility.Utility;

public class ProductListPage extends Utility {
    ProductListPageElement productListPageElement = new ProductListPageElement();

    public String searchedProductVerification() {
        return getTextElement(productListPageElement.productListName);
    }

    public void productFilter() {
        clickElementWithWait(productListPageElement.brandButton);
        waits(500);
        clickElementWithWait(productListPageElement.genderButton);
        waits(500);
        clickElementWithWait(productListPageElement.maleGenderButton);
        waits(500);
        scrollAndClickElement(productListPageElement.priceButton);
        waits(500);
        sendKeyToElement(productListPageElement.minPrice, "1000");
        sendKeyToElement(productListPageElement.maxPrice, "4000");
        clickElementWithWait(productListPageElement.priceSearchButton);
        waits(500);
        refreshPage();
        waits(500);
    }

    public String getProductName() {
        scrollToCenter(productListPageElement.productBrandAfterFiltering);
        return  getTextElement(productListPageElement.productBrandAfterFiltering)
                + " " + getTextElement(productListPageElement.productModelAfterFiltering)
                + " " + getTextElement(productListPageElement.productCategoryAfterFiltering);
    }

    public void goToProductDetailPage() {
        clickElementWithWait(productListPageElement.productBrandAfterFiltering);
    }
}
