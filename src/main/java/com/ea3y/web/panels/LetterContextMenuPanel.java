package com.ea3y.web.panels;

import com.codeborne.selenide.SelenideElement;

public class LetterContextMenuPanel {

    private final SelenideElement element;

    public LetterContextMenuPanel(SelenideElement element) {
        this.element = element;
    }

    public void clickReplayMenuItem() {
        element.$x(".//div[contains(@class, 'BS')]").click();
    }
}
