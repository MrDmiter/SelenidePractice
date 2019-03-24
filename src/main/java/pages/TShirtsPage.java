package pages;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TShirtsPage extends BasePage {
    // Web elements
    @FindBy(xpath = "//div[@class='button-container']/a/span[contains(text(),'More')]")
    private WebElement product;

    @FindBy(xpath = "//div[@class='product-container']")
    private WebElement productContainer;


    private String PRODUCT_DETAILS_XPATH = "//h5[@itemprop='name']/a[contains(., '%s')]";

    TShirtsPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Click on product by name
     *
     * @param nameOfProduct
     * @return ProductPage
     */
    public ProductPage clickOnProduct(String nameOfProduct) {
        $(By.xpath(String.format(PRODUCT_DETAILS_XPATH, nameOfProduct))).click();
        return page(ProductPage.class);
    }


}
