package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class ProductListPageElement {

    public ProductListPageElement() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css="div[class='dscrptn dscrptn-V2'] > h1")
    public WebElement productListName;

    @FindBy(xpath="(//div[@class='chckbox'])[1]")
    public WebElement brandButton;

    @FindBy(xpath="(//div[@class='fltr-cntnr-ttl'])[4]")
    public WebElement genderButton;

    @FindBy(xpath="((//div[@class='fltrs'])[4]//div[@class='chckbox'])[2]")
    public WebElement maleGenderButton;

    @FindBy(xpath="(//div[@class='fltr-cntnr-ttl'])[6]")
    public WebElement priceButton;

    @FindBy(css="[class='fltr-srch-prc-rng-input min']")
    public WebElement minPrice;

    @FindBy(css="[class='fltr-srch-prc-rng-input max']")
    public WebElement maxPrice;

    @FindBy(css="[class='fltr-srch-prc-rng-srch']")
    public WebElement priceSearchButton;

    @FindBy(xpath="(//span[@class='prdct-desc-cntnr-ttl'])[6]")
    public WebElement productBrandAfterFiltering;

    @FindBy(xpath="((//h3[@class=\"prdct-desc-cntnr-ttl-w\"])[6]//span)[2]")
    public WebElement productModelAfterFiltering;

    @FindBy(xpath="(//div[@class=\"product-desc-sub-container\"])[6]//div")
    public WebElement productCategoryAfterFiltering;

}
