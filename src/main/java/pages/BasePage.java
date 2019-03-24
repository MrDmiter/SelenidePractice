package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public abstract class BasePage {
    //Web Elements
    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[@title='Dresses']")
    private WebElement dressesTab;

    @FindBy(xpath = "//li[@class='sfHover']//a[@title='Summer Dresses'][contains(text(),'Summer Dresses')]")
    private WebElement summerDressesTab;

    @FindBy(
            xpath =
                    "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[@title='T-shirts']")
    private WebElement tShirts;

    protected BaseTest testClass;


    //Constructor
    BasePage(BaseTest testClass) {
        page(this);
        this.testClass = testClass;

    }



    /**
     * Click on summer dresses tab
     *
     * @return SummerDressesPage
     */
    public SummerDressesPage hoverOverDressesItem() {
        $(dressesTab).hover();
        $(summerDressesTab).click();
        return page(SummerDressesPage.class);
    }

    /**
     * Click on T-Shirts tab
     *
     * @return TShirtsPage
     */
    public TShirtsPage clickOnTShirts() {
        $(tShirts).click();
        return page(TShirtsPage.class);
    }

}
