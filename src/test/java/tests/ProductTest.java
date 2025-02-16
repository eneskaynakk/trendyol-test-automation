package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.ConfigReader;

public class ProductTest extends BaseTest{

    @BeforeMethod
    public void productSearchProcess(){
        String webSiteUrl = ConfigReader.getProperty("url");
        getAppLibrary().getFlowsLibrary().navigateToUrl(webSiteUrl);

        getAppLibrary().getPageLibrary().getMainPage().closeCookie();

        getAppLibrary().getPageLibrary().getMainPage().searchProduct();

        String[] actualResult = getAppLibrary().getPageLibrary().getProductListPage().searchedProductVerification();
        String expectedProductNameText = "Kol Saati araması için 100.000+ sonuç listeleniyor";
        Assert.assertEquals(actualResult[0] + " " + actualResult[1], expectedProductNameText);
    }

    @Test
    public void productFilterProcess(){
        getAppLibrary().getPageLibrary().getProductListPage().productFilter();

        String[] actualResult = getAppLibrary().getPageLibrary().getProductListPage().searchedProductVerification();
        String expectedNumberProductsAfterFiltering = "Casio Erkek Saat";
        Assert.assertEquals(actualResult[0], expectedNumberProductsAfterFiltering);
    }
}
