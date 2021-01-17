package com.selenium.web.panels;

import com.codeborne.selenide.SelenideElement;
import com.selenium.web.table.Table;

public class BasicTablePanel {

    private final SelenideElement container;

    public BasicTablePanel(SelenideElement container) {
        this.container = container;
    }

    public Table getLanguageTable() {
        return new Table(container.$x(".//tbody"));
    }
}
