package pages;

import elements.ProductPageElement;
import utility.Utility;

public class ProductListPage extends Utility {
    ProductPageElement productPageElement = new ProductPageElement();

    public String[] searchedProductVerification(){
        String actualResultFirstPart = getTextElement(productPageElement.firstPartProductMameText);
        String actualResultSecondPart = getTextElement(productPageElement.secondPartProductMameText);
        return new String[] {actualResultFirstPart, actualResultSecondPart};
    }

    public void productFilter(){
        clickElementWithWait(productPageElement.brandButton);
        clickElementWithWait(productPageElement.genderButton);
        clickElementWithWait(productPageElement.maleGenderButton);
        scrollAndClickElement(productPageElement.priceButton);
        sendKeyToElement(productPageElement.minPrice, "1000");
        sendKeyToElement(productPageElement.maxPrice, "4000");
        clickElementWithWait(productPageElement.priceSearchButton);
        refreshPage();
        waits(1);
    }
}
