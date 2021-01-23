package com.google.web.table;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.web.panels.LetterContextMenuPanel;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$x;

public class LetterTableRow {

    private SelenideElement tableRow;
    private SelenideElement checkboxCell;
    private SelenideElement starCell;
    private SelenideElement senderCell;
    private SelenideElement subjectCell;
    private SelenideElement timeCell;
    private SelenideElement newLabelCell;


    public LetterTableRow(final SelenideElement tableRow) {
        setTableRow(tableRow);
        setCheckboxCell(tableRow.$x(".//ancestor::td/..//div[@role='checkbox']"));
        setStarCell(tableRow.$x(".//span[contains(@class, 'T-KT')]"));
        setSenderCell(tableRow.$x(".//td[@class='yX xY ']//div[@class='yW']"));
        setSubjectCell(tableRow.$x(".//td[@class='xY a4W']//div[@class='y6']"));
        setTimeCell(tableRow.$x(".//td[@class='xW xY ']"));
        setNewLabelCell(tableRow.$x(".//td[@class='yX xY ']//div[@class='aRI']"));
    }

    public LetterTableRow waitForAnewLetter() {
        newLabelCell.waitUntil(Condition.visible, 20000);
        return this;
    }

    public LetterTableRow setCheckBox(String status) {
        if (!Objects.equals(checkboxCell.attr("aria-checked"), status)) {
            checkboxCell.click();
        }
        return this;
    }

    public LetterTableRow setStar(String status) {
        if (!Objects.equals(starCell.attr("aria-label"), status)) {
            starCell.click();
        }
        return this;
    }

    public String getStarCellAttribute() {
        return starCell.attr("aria-label");
    }

    public String getTextOfSenderCell() {
        return senderCell.waitUntil(Condition.visible, 10000).getText();
    }

    public String getTextOfSubjectCell() {
        return subjectCell.getText();
    }

    public LetterContextMenuPanel getContextMenu() {
        tableRow.contextClick();
        return new LetterContextMenuPanel($x("//div[contains(@class, 'Ft')]"));
    }

    private void setTableRow(SelenideElement tableRow) {
        this.tableRow = tableRow;
    }

    private void setCheckboxCell(SelenideElement checkboxCell) {
        this.checkboxCell = checkboxCell;
    }

    private void setStarCell(SelenideElement starCell) {
        this.starCell = starCell;
    }

    private void setSenderCell(SelenideElement senderCell) {
        this.senderCell = senderCell;
    }

    private void setSubjectCell(SelenideElement subjectCell) {
        this.subjectCell = subjectCell;
    }

    private void setTimeCell(SelenideElement timeCell) {
        this.timeCell = timeCell;
    }

    private void setNewLabelCell(SelenideElement newLabelCell) {
        this.newLabelCell = newLabelCell;
    }
}
