//package com.google.web.pages;
//
//import com.codeborne.selenide.Condition;
//import com.codeborne.selenide.SelenideElement;
//import org.openqa.selenium.support.FindBy;
//
//import static com.codeborne.selenide.Selenide.page;
//
//public class WelcomePage {
//
//    @FindBy(name = "password")
//    private SelenideElement passwordInput;
//    @FindBy(id = "passwordNext")
//    private SelenideElement nextBtn;
//
//    public MainPage setPassword(String password) {
//        passwordInput.waitUntil(Condition.appears, 5000).setValue(password);
//        nextBtn.waitUntil(Condition.appears, 5000).click();
//        return page(MainPage.class);
//    }

//    public void clickNextButton() {
//        nextBtn.waitUntil(Condition.appears, 5000).click();
//    }
//}
