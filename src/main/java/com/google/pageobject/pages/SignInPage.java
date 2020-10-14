package com.google.pageobject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
    @FindBy(id = "identifierId") private SelenideElement emailOrPhoneInput;
    @FindBy(id = "identifierNext") private SelenideElement nextBtn;

    public SignInPage setEmail(String emailOrPhone) {
        emailOrPhoneInput.setValue(emailOrPhone);
        return this;
    }

    public void clickNextButton() {
        nextBtn.waitUntil(Condition.appears, 5000).click();
    }
}
