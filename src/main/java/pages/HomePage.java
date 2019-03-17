package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HomePage extends BasePage {

    /**
     * Click on Sign in button
     * @return SignInPage
     */
    public SignInPage click() {
        $(By.xpath("//div/a[@class='login']")).click();
        return page(SignInPage.class);
    }

}
