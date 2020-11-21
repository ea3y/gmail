package com.google.web.common;

import com.codeborne.selenide.SelenideElement;

public abstract class AbstractTableRow {

    protected SelenideElement checkboxCell;
    protected SelenideElement starCell;
    protected SelenideElement senderCell;
    protected SelenideElement subjectCell;
    protected SelenideElement timeCell;

    public SelenideElement getCheckboxCell() {
        return checkboxCell;
    }

    public void setCheckboxCell(SelenideElement checkboxCell) {
        this.checkboxCell = checkboxCell;
    }

    public SelenideElement getStarCell() {
        return starCell;
    }

    public abstract void setStarCell(SelenideElement starCell);

    public SelenideElement getSenderCell() {
        return senderCell;
    }

    public abstract void setSenderCell(SelenideElement senderCell);

    public SelenideElement getSubjectCell() {
        return subjectCell;
    }

    public abstract void setSubjectCell(SelenideElement subjectCell);

    public SelenideElement getTimeCell() {
        return timeCell;
    }

    public abstract void setTimeCell(SelenideElement timeCell);
}
