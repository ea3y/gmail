package com.selenium.web.table;

import com.codeborne.selenide.SelenideElement;

public class TableRow {

    private SelenideElement tableRow;
    private SelenideElement languageCell;
    private SelenideElement stableVersionCell;
    private SelenideElement releaseDateCell;
    private SelenideElement alphaVersionCell;
    private SelenideElement alphaReleaseDateCell;
    private SelenideElement linksCell;

    public TableRow(final SelenideElement tableRow) {
        this.tableRow = tableRow;
        setLanguageCell(tableRow.$x(".//td[@data-label = 'Language']"));
        setStableVersionCell(tableRow.$x(".//td[@data-label = 'Stable Version']"));
        setReleaseDateCell(tableRow.$x(".//td[@data-label = 'Release Date']"));
        setAlphaVersionCell(tableRow.$x(".//td[@data-label = 'Alpha Version']"));
        setAlphaReleaseDateCell(tableRow.$x(".//td[@data-label = 'Alpha Release Date']"));
        setLinksCell(tableRow.$x(".//td[@data-label = 'Links']"));
    }

    public void setLanguageCell(SelenideElement languageCell) {
        this.languageCell = languageCell;
    }

    public void setStableVersionCell(SelenideElement stableVersionCell) {
        this.stableVersionCell = stableVersionCell;
    }

    public void setReleaseDateCell(SelenideElement releaseDateCell) {
        this.releaseDateCell = releaseDateCell;
    }

    public void setAlphaVersionCell(SelenideElement alphaVersionCell) {
        this.alphaVersionCell = alphaVersionCell;
    }

    public void setAlphaReleaseDateCell(SelenideElement alphaReleaseDateCell) {
        this.alphaReleaseDateCell = alphaReleaseDateCell;
    }

    protected void setLinksCell(SelenideElement linksCell) {
        this.linksCell = linksCell;
    }

    public LinkCell getLinksCell() {
        return new LinkCell(linksCell);
    }

    public String getLanguageCell() {
        return languageCell.getText();
    }

    public String getStableVersionCell() {
        return stableVersionCell.getText();
    }

    public String getReleaseDateCell() {
        return releaseDateCell.getText();
    }

    public String getAlphaVersionCell() {
        return alphaVersionCell.getText();
    }

    public String getAlphaReleaseDateCell() {
        return alphaReleaseDateCell.getText();
    }
}
