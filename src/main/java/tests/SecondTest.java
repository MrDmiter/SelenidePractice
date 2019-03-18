package tests;

import base.BaseTest;
import org.junit.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.SignInPage;
import pages.SummerDressesPage;

public class SecondTest extends BaseTest {


    @Test
    public void testSecondTest() {
        //Open site
        HomePage homePage = openSite();
        //Proceed tot sign in page
        SignInPage signInPage = homePage.click();
        //Sign in to my account
        MyAccountPage myAccountPage = signInPage.signIn();
        //Proceed to the summer dresses page
        SummerDressesPage summerDressesPage = myAccountPage.hoverOverDressesItem();
        //Check amount of the displayed products
        summerDressesPage.verifyAmountOfProducts();
        //Click on color filter
        summerDressesPage.chooseColor();
        ////Check amount of the displayed products
        summerDressesPage.verifyAmountOfProducts();

    }

}
