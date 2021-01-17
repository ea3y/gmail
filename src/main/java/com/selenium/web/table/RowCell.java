package com.selenium.web.table;

import com.codeborne.selenide.SelenideElement;

public abstract class RowCell {

    protected SelenideElement tableCellElem;

    public RowCell(SelenideElement tableCellElem) {
        this.tableCellElem = tableCellElem;
    }
}
