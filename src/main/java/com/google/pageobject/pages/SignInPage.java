package com.google.pageobject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class SignInPage {
    @FindBy(id = "identifierId")
    private SelenideElement emailOrPhoneInput;
    @FindBy(id = "identifierNext")
    private SelenideElement nextBtn;

    public void setEmailTwo(String emailOrPhone) {
        emailOrPhoneInput.setValue(emailOrPhone);
        nextBtn.waitUntil(Condition.appears, 5000).click();
    }

    public WelcomePage setEmail(String emailOrPhone) {
        emailOrPhoneInput.setValue(emailOrPhone);
        nextBtn.waitUntil(Condition.appears, 5000).click();
        return page(WelcomePage.class);
    }

//    public void clickNextButton() {
//        nextBtn.waitUntil(Condition.appears, 5000).click();
//    }
}
