package com.selenium.web.pages;

import com.codeborne.selenide.SelenideElement;
import com.selenium.web.panels.BasicTablePanel;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement languageListPanelBaseLocator
            = $x("//table[@class='data-list']");

    @Step("get panel")
    public BasicTablePanel getTablePanel() {
        return new BasicTablePanel(languageListPanelBaseLocator);
    }
}
