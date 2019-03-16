package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.*;

public class SignInPage extends BasePage {

    // Web Elements
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passTextField;

    @FindBy(xpath = "//button[@id='SubmitLogin']/span")
    private WebElement signInBtn;


    public MyAccountPage signIn() {
        $(emailTextField).setValue("gavuyabavu@digitalmail.info");
        $(passTextField).setValue("12345");
        $(signInBtn).click();
        return page(MyAccountPage.class);
    }

    public void presenceOnPageVerification() {
        Assert.assertEquals("Login - My Store", title());
    }

}