package com.google.web.pages;

import com.google.web.panels.GmailLetterListPanel;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(xpath = "//div[@gh='tl']")
    private GmailLetterListPanel letterListPanelBaseLocator;

    public GmailLetterListPanel getLetterListPanel() {
        System.out.println("In main page class");
        return letterListPanelBaseLocator;
    }
}
