package tests;

import base.BaseTest;
import org.junit.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;

public class FirstTest extends BaseTest {

    @Test
    public void testFirstTest() {
        //Open site
        HomePage homePage = openSite();
        //Proceed tot sign in page
        SignInPage signInPage = homePage.click();
        //Sign in to my account
        MyAccountPage myAccountPage = signInPage.signIn();
        //Verify presence on the right account
        myAccountPage.accountVerification();
        //Sign out
        myAccountPage.signOut();
        //Verify sign out
        signInPage.presenceOnPageVerification();

    }
}
