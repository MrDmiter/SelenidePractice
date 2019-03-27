package pages;

import base.BaseTest;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage extends BasePage {

    public HomePage(BaseTest testClass) {
        super(testClass);
    }

    /**
     * Click on Sign in button
     * @return SignInPage
     */
    public SignInPage click() {
        $(By.xpath("//div/a[@class='login']")).click();
        return new SignInPage(testClass);
    }

}
