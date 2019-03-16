package tests;

import base.BaseTest;
import com.codeborne.selenide.Configuration;
import org.junit.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;

public class FirstTest extends BaseTest {

    @Test
    public void testFirstTest() {
        Configuration.startMaximized = true;
        HomePage homePage = openSite();
        SignInPage signInPage = homePage.click();
        MyAccountPage myAccountPage = signInPage.signIn();
        myAccountPage.accountVerification();
        myAccountPage.signOut();
        signInPage.presenceOnPageVerification();
        
    }
}
