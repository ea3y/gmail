package com.google.web.pages;

import com.codeborne.selenide.Condition;
import com.google.web.panels.*;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public LeftSidePanel getLeftSidePanel() {
        return new LeftSidePanel($x("//div[contains(@class, 'aeN')]").waitUntil(Condition.visible, 15000));
    }

    public MainToolBarPanel getMainToolBarPanel() {
        return new MainToolBarPanel($x("//div[contains(@class, 'w-asV')]"));
    }

    public LetterListPanel getLetterListPanel() {
        return new LetterListPanel($x("//div[contains(@class, 'BltHke') and not(contains(@style, 'display: none'))]"));
    }

    public MailToolPanel getMailToolPanel() {
        return new MailToolPanel($x("//div[@class = 'aeH']").waitUntil(Condition.visible, 15000));
    }

    public MainPage waitForMessageTooltipToDisappears() {
        $x("//div[@class='vh']").waitUntil(Condition.disappear, 30000);
        return this;
    }
}
