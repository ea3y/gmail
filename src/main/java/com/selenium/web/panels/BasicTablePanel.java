package com.selenium.web.panels;

import com.codeborne.selenide.SelenideElement;
import com.selenium.web.table.Table;
import io.qameta.allure.Step;

public class BasicTablePanel {

    private final SelenideElement container;

    public BasicTablePanel(SelenideElement container) {
        this.container = container;
    }

    @Step("get table of programming languages")
    public Table getLanguageTable() {
        return new Table(container.$x(".//tbody"));
    }
}
