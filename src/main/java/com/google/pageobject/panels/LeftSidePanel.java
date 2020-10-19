package com.google.pageobject.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LeftSidePanel {

    @FindBy(xpath = "//div[@jscontroller='eIu7Db']")
    private SelenideElement composeBtn;
    @FindBy(xpath = "//div[@data-tooltip='Sent']")
    private SelenideElement sentButton;
    @FindBy(xpath = "//div[@data-tooltip='Starred']")
    private SelenideElement starredButton;
    @FindBys(@FindBy(xpath = "//div[@class='byl']//div[contains(@class, 'aim')]"))
    private ElementsCollection mainMenuItems;


    public void composeButtonClick() {
        composeBtn.waitUntil(Condition.appears, 5000).click();
    }

    public void clickSentButton() {
        sentButton.waitUntil(Condition.appears, 5000).click();
    }

    public void clickStarredButton() {
        starredButton.waitUntil(Condition.appears, 5000).click();
    }
}
