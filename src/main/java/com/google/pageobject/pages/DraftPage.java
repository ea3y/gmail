package com.google.pageobject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class DraftPage {

    @FindBy(xpath = "//td[@class='TC']")
    private SelenideElement informationalText;

    public SelenideElement getInformationalText() {
        return informationalText.waitUntil(Condition.appears, 10000);
    }
}
