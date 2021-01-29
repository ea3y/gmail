package com.google.web.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class LettersTable {

    private SelenideElement table;
    private List<LetterTableRow> tableRowsList = new ArrayList<>();

    public LettersTable(SelenideElement table) {
        this.table = table;
        setTableRows();
    }

    public LetterTableRow getTheFirstRow() {
        return tableRowsList.get(0);
    }

    public List<LetterTableRow> getTableRowsList() {
        if (tableRowsList.isEmpty()) {
            fail("There is no letters in the Inbox. FUCK!!!");
        }
        return tableRowsList;
    }

    protected void setTableRows() {
        ElementsCollection rows = table.waitUntil(Condition.visible, 5000).$$x("./tr");
        rows.forEach(elem -> tableRowsList.add(new LetterTableRow(elem)));
    }
}
