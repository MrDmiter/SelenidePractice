package tests;

import base.BaseTest;
import org.junit.Test;
import pages.*;

public class ThirdTest extends BaseTest {
    @Test
    public void testThirdTest() {
        //Open site
        HomePage homePage = openSite();
        //Click on sign in button
        SignInPage signInPage = homePage.click();
        //Sign in to account
        MyAccountPage myAccountPage = signInPage.signIn();
        //Click on t-shirts button
        TShirtsPage tShirtsPage = myAccountPage.clickOnTShirts();
        //Click on the product by name
        ProductPage productPage = tShirtsPage.clickOnProduct("Faded Short Sleeve T-shirts");
        //Verify breadcrumbs
        productPage.verifyBreadCrumbs("> Women>Tops>T-shirts>Faded Short Sleeve T-shirts");
        //Add product to cart and proceed to checkout
        CheckoutPage checkoutPage = productPage.addToCartAndProceedToCheckout();
        //Verify total price of the product in the cart
        checkoutPage.verifyTotalPriceDependingOnTheAmountOfProductInTheCart(3);
        //Empty cart
        checkoutPage.removeFromCart();
        //Verify that cart is empty
        checkoutPage.verifyCartIsEmpty();
    }
}
