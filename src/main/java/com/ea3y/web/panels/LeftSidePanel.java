package com.ea3y.web.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.ea3y.web.pages.MainPage;

import static com.codeborne.selenide.Selenide.page;

public class LeftSidePanel {

    protected SelenideElement element;

    public LeftSidePanel(SelenideElement element) {
        this.element = element;
    }

    public void clickComposeButton() {
        element.$x(".//div[@jscontroller='eIu7Db']").waitUntil(Condition.visible, 15000).click();
    }

    public void clickSentButton() {
        element.$x(".//div[@data-tooltip='Sent']").waitUntil(Condition.visible, 15000).click();
    }

    public MainPage clickStarredButton() {
        element.$x(".//div[@data-tooltip='Starred']").waitUntil(Condition.visible, 15000).click();
        return page(MainPage.class);
    }

    public void clickDraftButton() {
        element.$x(".//div[@data-tooltip='Drafts']").waitUntil(Condition.visible, 15000).click();
    }
}
