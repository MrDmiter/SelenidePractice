package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.After;
import org.junit.Rule;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import pages.MyAccountPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

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
     * Doesn`t work, can`t understand why????????
     */
    @After
    public void tearDown() {
//        if($(logout).is(Condition.visible)){
//            $(logout).click();
//        }
   }
}


