package com.google.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class WelcomePage {
    private final SelenideElement passwordInput = $x("//input[@name='password']");
    private final SelenideElement nextBtn = $("#passwordNext");

    public WelcomePage setPassword(String password) {
        passwordInput.val(password);
        return this;
    }

    public void clickNextButton() {
        nextBtn.click();
    }
}
