package pages;

import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage extends BasePage {
    // Web elements
    @FindBy(xpath = "//i[@class='icon-plus']")
    private WebElement increaseNumberOfProducts;

    @FindBy(xpath = "//td[@class='cart_total']/span[@class='price']")
    private WebElement totalPriceForOneItem;

    @FindBy(xpath = "//tr[@class='cart_total_price']/td[@id='total_product']")
    private WebElement totalPriceForAllProducts;

    @FindBy(xpath = "//i[@class='icon-trash']")
    private WebElement trashIcon;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement cartIsEmptyMessage;

    //Locator which represent window with quantity of the products in the cart
    private static final String PRODUCT_QUANTITY =
            "//td[@class='cart_quantity text-center']/input[@type='text']";

    /**
     * Verify total price depending on the amount of the added product to the cart
     *
     * @param amountOfProducts
     */
    public void verifyTotalPriceDependingOnTheAmountOfProductInTheCart(int amountOfProducts) {
        double priceForOneProduct =
                Double.parseDouble(totalPriceForOneItem.getText().replaceAll("\\$", ""));
        for (int i = 0; i < amountOfProducts; i++) {
            $(increaseNumberOfProducts).click();
        }
        $(By.xpath("//td[@class='cart_quantity text-center']/input[@type='text']")).shouldBe(Condition.exactValue("4"));
        //testClass.waitTillTextToBePresentInElementValue(PRODUCT_QUANTITY, 4);
        Assert.assertEquals(
                Double.parseDouble(totalPriceForAllProducts.getText().replaceAll("\\$", "")),
                priceForOneProduct * (amountOfProducts + 1),
                0.0);
    }


    /**
     * Remove from cart
     */
    public void removeFromCart() {
        $(trashIcon).click();
    }

    /**
     * Verify that cart is empty
     */
    public void verifyCartIsEmpty() {
        $(cartIsEmptyMessage).text().equals("Your shopping cart is empty.");
    }
}
