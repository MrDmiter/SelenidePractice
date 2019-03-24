package pages;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MyAccountPage extends BasePage {

    //Web elements
    @FindBy(xpath = "//div[@class='header_user_info']/descendant::span")
    private WebElement name;

    @FindBy(xpath = "//div/a[@class='logout']")
    private WebElement logoutBtn;

    MyAccountPage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Check whether it is right account
     */
    public void accountVerification() {
        $(name).shouldHave(text("Dmytro Terentyev"));
    }

    /**
     * Sign out from account
     * @return SignInPage
     */
    public SignInPage signOut() {
        $(logoutBtn).click();
        return page(SignInPage.class);
    }

}
