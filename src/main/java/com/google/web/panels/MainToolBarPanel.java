package com.google.web.panels;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainToolBarPanel {

    SelenideElement element;

    public MainToolBarPanel(SelenideElement element) {
        this.element = element;
    }

    public GoogleAccountPanel clickOnGoogleAccountButton() {
        element.$x(".//div[contains(@class, 'gb_Oa')]").click();
        return new GoogleAccountPanel($x("//div[@aria-label='Account Information']"));
    }

}
