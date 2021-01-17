package com.selenium.web.table;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

public class Table {

    protected SelenideElement table;
    private List<TableRow> tableTableRowsList = new ArrayList<>();

    public Table(final SelenideElement table) {
        this.table = table;
        setTableRows();
    }

    public TableRow getRubyLanguageRow() {
        return tableTableRowsList.get(0);
    }

    public TableRow getJavaLanguageRow() {
        return tableTableRowsList.get(1);
    }

    public TableRow getPythonLanguageRow() {
        return tableTableRowsList.get(2);
    }

    public TableRow getCiLanguageRow() {
        return tableTableRowsList.get(3);
    }

    public TableRow getJavaScriptLanguageRow() {
        return tableTableRowsList.get(4);
    }


    public List<TableRow> getTableLanguageRowsList() {
        return tableTableRowsList;
    }

    protected void setTableRows() {
        ElementsCollection rows = table.$$x("./tr");
        rows.forEach(elem -> tableTableRowsList.add(new TableRow(elem)));
    }
}
