package com.ea3y.web.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class StarredPage {

    @FindBy(xpath = "//td[@class='TC']")
    private SelenideElement informationalText;

    public SelenideElement getInformationalText() {
        return informationalText;
    }
}
