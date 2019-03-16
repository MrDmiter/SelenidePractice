package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//div[@class='header_user_info']/descendant::span")
    private WebElement name;

    @FindBy(xpath = "//div/a[@class='logout']")
    private WebElement logoutBtn;

    public void accountVerification() {
        $(name).shouldHave(text("Dmytro Terentyev"));
    }

    public SignInPage signOut() {
        $(logoutBtn).click();
        return page(SignInPage.class);
    }

}
