package com.selenium.web.table;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class Table {

    protected SelenideElement table;
    private List<TableRow> tableTableRowsList = new ArrayList<>();

    public Table(final SelenideElement table) {
        this.table = table;
        setTableRows();
    }

    @Step("Get row of 'Ruby' language")
    public TableRow getRubyLanguageRow() {
        return tableTableRowsList.get(0);
    }

    @Step("Get row of 'Java' language")
    public TableRow getJavaLanguageRow() {
        return tableTableRowsList.get(1);
    }

    @Step("Get row of 'Python' language")
    public TableRow getPythonLanguageRow() {
        return tableTableRowsList.get(2);
    }

    @Step("Get row of 'C#' language")
    public TableRow getCiLanguageRow() {
        return tableTableRowsList.get(3);
    }

    @Step("Get row of 'JS' language")
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
