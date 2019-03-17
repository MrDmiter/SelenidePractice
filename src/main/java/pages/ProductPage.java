package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProductPage extends BasePage {
    // Web elements
    @FindBy(xpath = "//div[@class='breadcrumb clearfix']")
    private WebElement breadCrumbs;

    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckout;

    /**
     * Verify breadcrumbs
     *
     * @param expectedBreadCrumbs
     */
    public void verifyBreadCrumbs(String expectedBreadCrumbs) {
        Assert.assertEquals(expectedBreadCrumbs, $(breadCrumbs).text());
    }

    /**
     * Add product to the cart and proceed to checkout
     *
     * @return entity of the CheckoutPage
     */
    public CheckoutPage addToCartAndProceedToCheckout() {
        $(addToCart).click();
        $(proceedToCheckout).click();
        return page(CheckoutPage.class);
    }
}
