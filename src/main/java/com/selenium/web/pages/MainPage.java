package com.selenium.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.selenium.web.panels.BasicTablePanel;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement languageListPanelBaseLocator
            = $x("//table[@class='data-list']");

    public BasicTablePanel getTablePanel() {
        return new BasicTablePanel(languageListPanelBaseLocator);
    }
}
