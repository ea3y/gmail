package com.google.web.table;

import com.codeborne.selenide.SelenideElement;
import com.google.web.common.AbstractTableRow;
import org.openqa.selenium.By;

public class LetterRow extends AbstractTableRow {

    private SelenideElement tableRow;

    public LetterRow(final SelenideElement tableRow) {
        setTableRow(tableRow);
        setCheckboxCell(tableRow.$(By.xpath("./ancestor::td/..//div[@aria-checked='false']")));
        setStarCell(tableRow.$(By.xpath(".//td[@class='apU xY']")));
        setSenderCell(tableRow.$(By.xpath(".//td[@class='yX xY']")));
        setSubjectCell(tableRow.$(By.xpath(".//td[@class='xY a4W']")));
        setTimeCell(tableRow.$(By.xpath(".//td[@class='xW xY ']")));
    }

    public void setTableRow(SelenideElement tableRow) {
        this.tableRow = tableRow;
    }

    @Override
    public void setCheckboxCell(SelenideElement checkboxCell) {
        this.checkboxCell = checkboxCell;
    }

    @Override
    public void setStarCell(SelenideElement starCell) {
        this.starCell = starCell;
    }

    @Override
    public void setSenderCell(SelenideElement senderCell) {
        this.senderCell = senderCell;
    }

    @Override
    public void setSubjectCell(SelenideElement subjectCell) {
        this.subjectCell = subjectCell;
    }

    @Override
    public void setTimeCell(SelenideElement timeCell) {
        this.timeCell = timeCell;
    }
}
