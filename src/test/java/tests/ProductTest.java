package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ConfigReader;

public class ProductTest extends BaseTest {

    @Test(priority = 1, groups = "regression", description = "Search for a product and verify the correct product is found.")
    public void productSearchTest() {
        testCaseId = "7";
        String webSiteUrl = ConfigReader.getProperty("url");
        getAppLibrary().getFlowsLibrary().navigateToUrl(webSiteUrl);
        getAppLibrary().getPageLibrary().getMainPage().closeCookie();

        getAppLibrary().getPageLibrary().getMainPage().searchProduct();

        String actualResult = getAppLibrary().getPageLibrary().getProductListPage().searchedProductVerification();
        String expectedProductNameText = "Kol Saati";
        Assert.assertEquals(actualResult, expectedProductNameText);
    }

    @Test(priority = 2, groups = "regression", description = "Apply product filters and verify the filtering result.")
    public void productFilteringTest() {
        testCaseId = "8";
        getAppLibrary().getPageLibrary().getProductListPage().productFilter();

        String actualResult = getAppLibrary().getPageLibrary().getProductListPage().searchedProductVerification();
        String expectedProductsAfterFilteringText = "Casio Erkek Saat";
        Assert.assertEquals(actualResult, expectedProductsAfterFilteringText);
    }

    @Test(priority = 3, groups = "regression", description = "Navigate to the product detail page and verify the product name.")
    public void productDetailsVerificationTest() {
        testCaseId = "9";
        String actualResult = getAppLibrary().getPageLibrary().getProductListPage().getProductName();

        getAppLibrary().getPageLibrary().getProductListPage().goToProductDetailPage();

        getAppLibrary().getPageLibrary().getProductDetailPage().productDetailPage();

        String expectedProductName = getAppLibrary().getPageLibrary().getProductDetailPage().getProductDetailName();
        Assert.assertEquals(actualResult, expectedProductName);
    }

    @Test(priority = 4, groups = "regression", description = "Add product to cart and verify it is added successfully.")
    public void addToCartTest() {
        testCaseId = "10";
        String actualResult = getAppLibrary().getPageLibrary().getProductDetailPage().addToCart();
        String expectedNumberOfProducts = "1";
        Assert.assertEquals(actualResult, expectedNumberOfProducts);
    }
}