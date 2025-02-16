package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class ProductPageElement {

    public ProductPageElement() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css="div[class='dscrptn dscrptn-V2'] > h1")
    public WebElement firstPartProductMameText;

    @FindBy(css="div[class='dscrptn dscrptn-V2'] > h2")
    public WebElement secondPartProductMameText;

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
}
