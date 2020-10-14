package com.google.pageobject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage {

    @FindBy(name = "password") private SelenideElement passwordInput;
    @FindBy(id = "passwordNext") private SelenideElement nextBtn;

    public WelcomePage setPassword(String password) {
        passwordInput.waitUntil(Condition.appears, 5000).setValue(password);
        return this;
    }

    public void clickNextButton() {
        nextBtn.waitUntil(Condition.appears, 5000).click();
    }
}
