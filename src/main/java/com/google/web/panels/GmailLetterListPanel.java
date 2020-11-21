package com.google.web.panels;

import com.codeborne.selenide.SelenideElement;
import com.google.web.table.LettersTable;
import org.openqa.selenium.support.FindBy;


public class GmailLetterListPanel {

    @FindBy(xpath = ".//table[@class='F cf zt']")
    private SelenideElement lettersTable;

    public LettersTable getLettersTable() {
        return new LettersTable(lettersTable);
    }

}
