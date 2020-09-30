package com.google.pageobject.core.pageObject.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    private final SelenideElement emailOrPhoneInput = $("#identifierId");
    private final SelenideElement nextBtn = $("#identifierNext");

    public SignInPage setEmail(String emailOrPhone) {
        emailOrPhoneInput.val(emailOrPhone);
        return this;
    }

    public void clickNextButton() {
        nextBtn.click();
    }
}
