package utility.library;

import pages.*;

public class PageLibrary{
    LoginPage loginPage;
    MainPage mainPage;
    ProductListPage productListPage;
    ProductDetailPage productDetailPage;

    public PageLibrary() {
        loginPage = new LoginPage();
        mainPage = new MainPage();
        productListPage = new ProductListPage();
        productDetailPage = new ProductDetailPage();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public MainPage getMainPage() {
        return  mainPage;
    }

    public ProductListPage getProductListPage() {
        return productListPage;
    }

    public ProductDetailPage getProductDetailPage() {
        return productDetailPage;
    }
}
