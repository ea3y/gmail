package com.selenium.web.table;

import com.codeborne.selenide.SelenideElement;

public abstract class TextCell extends RowCell {

    public TextCell(SelenideElement tableCellElem) {
        super(tableCellElem);
    }

    public String getText() {
        return tableCellElem.getText();
    }
}
