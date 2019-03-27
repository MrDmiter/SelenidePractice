package base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.After;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    //Web Element
    @FindBy(xpath = "//div/a[@class='logout']")
    WebElement logout;

    private WebDriver driver;

    //Constructor
    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        Configuration.startMaximized = true;
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Open site
     *
     * @return HomePage instance
     */
    public HomePage openSite() {
        open("http://automationpractice.com");
        return new HomePage(this);
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


