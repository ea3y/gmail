package com.selenium.web.table;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

public class LinkCell extends RowCell {

    private List<SelenideElement> cellLinks = new ArrayList<>();

    public LinkCell(SelenideElement tableCellElem) {
        super(tableCellElem);
        setLinksCell();
    }

    public SelenideElement getDownloadLink() {
        return cellLinks.get(0);
    }

    public SelenideElement getAlphaDownloadLink() {
        return cellLinks.get(1);
    }

    public SelenideElement getChangeLogLink() {
        return cellLinks.get(2);
    }

    public SelenideElement getApiDocsLink() {
        return cellLinks.get(3);
    }

    protected void setLinksCell() {
        ElementsCollection links = tableCellElem.$$x("./a");
        links.forEach(elem -> cellLinks.add(elem));
    }

}
