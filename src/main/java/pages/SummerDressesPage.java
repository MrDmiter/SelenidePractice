package pages;

import base.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SummerDressesPage extends BasePage {

    //Web elements
    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement headingCounter;

    @FindBy(xpath = "//*[@id='layered_id_attribute_group_8']")
    private WebElement whiteColorIcon;

    @FindBy(xpath = "//ul[@class='product_list grid row']/p/img")
    private WebElement loader;

    SummerDressesPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Check displayed amount of the products and compare with counter
     */
    public void verifyAmountOfProducts() {
        int amountShownByCounter = Integer.parseInt(headingCounter.getText().replaceAll("\\D", ""));
        //Get list of the available products on the page
        ElementsCollection productsOnPage = $$(By.xpath("//span[@class='available-now']"));
        //Check loader presence
        if ($(loader).isDisplayed()) {
            System.out.println("Haven`t uploaded the page");
        } else {
            //Compare counter value with amount of the displayed products
            Assert.assertEquals(amountShownByCounter, productsOnPage.size());
            System.out.println("amountShownByCounter " + amountShownByCounter + " " + "products displayed on the page " + productsOnPage.size());
        }


    }

    //Choose color filter
    public void chooseColor() {
        $(whiteColorIcon).click();
    }


}
