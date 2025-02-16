package utility.library;

import pages.*;

public class PageLibrary{
    LoginPage loginPage;
    MainPage mainPage;
    ProductListPage productListPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    public PageLibrary() {
        loginPage = new LoginPage();
        mainPage = new MainPage();
        productListPage = new ProductListPage();
        productDetailPage = new ProductDetailPage();
        cartPage = new CartPage();
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

    public CartPage getCartPage() {
        return cartPage;
    }
}
