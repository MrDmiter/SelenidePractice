package base;

import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BaseTest {

public HomePage openSite(){
    open("http://automationpractice.com");
    return page(HomePage.class);
}
}
