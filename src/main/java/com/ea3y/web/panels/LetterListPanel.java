package com.ea3y.web.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.ea3y.web.table.LettersTable;

public class LetterListPanel {

    SelenideElement element;

    public LetterListPanel(SelenideElement element) {
        this.element = element;
    }

    public LettersTable getLettersTable() {
        return new LettersTable(
                element.$x(".//div[@gh='tl']//div[@class='Cp'][2]//table/tbody").waitUntil(Condition.visible, 15000));
    }
}
