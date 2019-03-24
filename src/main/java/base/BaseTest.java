package base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.After;
import org.junit.Rule;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    //Web Element
    @FindBy(xpath = "//div/a[@class='logout']")
    WebElement logout;

    //Constructor
    public BaseTest() {
        Configuration.startMaximized = true;

    }

    /**
     * Open site
     *
     * @return HomePage instance
     */
    public HomePage openSite() {
        open("http://automationpractice.com");
        return page(HomePage.class);
    }

    /**
     * To make screenshot each time when test is success(just for practice)
     */
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();

    /**
     * Logout from account if needed
     */
    @After
    public void tearDown() {
        page(this);
        if($(logout).is(Condition.visible)){
            $(logout).click();
        }
   }
}


