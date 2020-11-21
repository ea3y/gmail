package com.google.web.common;

import com.codeborne.selenide.SelenideElement;

public abstract class AbstractTable {

    protected SelenideElement table;

    protected AbstractTable(final SelenideElement webTable) {
        setWebTable(webTable);
        setTableRows();
    }

    public SelenideElement getTable() {
        return table;
    }

    protected void setWebTable(SelenideElement webTable) {
        this.table = webTable;
    }

    protected abstract void setTableRows();
}
