package com.google.web.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LeftSidePanel {

    @FindBy(xpath = "//div[@jscontroller='eIu7Db']")
    private SelenideElement composeBtn;
    @FindBy(xpath = "//div[@data-tooltip='Sent']")
    private SelenideElement sentButton;
    @FindBy(xpath = "//div[@data-tooltip='Starred']")
    private SelenideElement starredButton;
    @FindBy(xpath = "//div[@data-tooltip='Drafts']")
    private SelenideElement draftButton;

    public void composeButtonClick() {
        composeBtn.waitUntil(Condition.appears, 5000).click();
    }

    public void clickSentButton() {
        sentButton.waitUntil(Condition.appears, 5000).click();
    }

    public void clickStarredButton() {
        starredButton.waitUntil(Condition.appears, 5000).click();
    }

    public void clickDraftButton() {
        draftButton.waitUntil(Condition.appears, 5000).click();
    }
}
