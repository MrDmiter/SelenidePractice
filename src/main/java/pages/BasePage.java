package pages;

import static com.codeborne.selenide.Selenide.page;

public abstract class BasePage {


    BasePage(){
        page(this);
    }



}
