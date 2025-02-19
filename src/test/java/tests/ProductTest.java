package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigReader;

public class ProductTest extends BaseTest{

    @Test(priority = 1)
    public void productSearchProcess(){
        String webSiteUrl = ConfigReader.getProperty("url");
        getAppLibrary().getFlowsLibrary().navigateToUrl(webSiteUrl);

        getAppLibrary().getPageLibrary().getMainPage().closeCookie();

        getAppLibrary().getPageLibrary().getMainPage().searchProduct();

        String actualResult = getAppLibrary().getPageLibrary().getProductListPage().searchedProductVerification();
        String expectedProductNameText = "Kol Saati";
        Assert.assertEquals(actualResult, expectedProductNameText);
    }

    @Test(priority = 2)
    public void productFilterProcess(){
        getAppLibrary().getPageLibrary().getProductListPage().productFilter();

        String actualResult = getAppLibrary().getPageLibrary().getProductListPage().searchedProductVerification();
        String expectedProductsAfterFilteringText = "Casio Erkek Saat";
        Assert.assertEquals(actualResult, expectedProductsAfterFilteringText);
    }

    @Test(priority = 3)
    public void goToProductDetail(){
        String actualResult = getAppLibrary().getPageLibrary().getProductListPage().getProductName();

        getAppLibrary().getPageLibrary().getProductListPage().goToProductDetailPage();

        getAppLibrary().getPageLibrary().getProductDetailPage().productDetailPage();
        getAppLibrary().getPageLibrary().getProductDetailPage().closePopup();

        String expectedProductName = getAppLibrary().getPageLibrary().getProductDetailPage().getFullProductDetailName();
        Assert.assertEquals(actualResult, expectedProductName);
    }

    @Test(priority = 4)
    public void addToCartProcess(){
        String actualResult = getAppLibrary().getPageLibrary().getProductDetailPage().addToCart();
        String expectedNumberOfProducts = "1";
        Assert.assertEquals(actualResult, expectedNumberOfProducts);
    }
}
