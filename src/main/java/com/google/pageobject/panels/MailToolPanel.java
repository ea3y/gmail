package com.google.pageobject.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.pageobject.pages.InboxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MailToolPanel {
    @FindBy(xpath = "//div[@class='aeH']//div[contains(@class, 'nu')]")
    private static SelenideElement refreshButton;
    @FindBy(xpath = "//div[@act='10']")
    private static SelenideElement deleteButton;
    @FindBy(xpath = "//div[@data-tooltip='Move to']")
    private SelenideElement moveToButton;
    @FindBy(xpath = "//div[@class='Bn']")
    private SelenideElement discardDraftsButton;

    public InboxPage clickOnRefreshButton() {
        refreshButton.waitUntil(Condition.appears, 10000).click();
        $(By.xpath("//div[@class='vh']//span[text()='Loading...']")).waitUntil(Condition.disappears, 10000);
        return page(InboxPage.class);
    }

    public InboxPage clickOnDeleteButton() {
        deleteButton.waitUntil(Condition.appears, 5000).click();
        return page(InboxPage.class);
    }

    public InboxPage clickOnMoveToButton() {
        moveToButton.waitUntil(Condition.appears, 5000).click();
        return page(InboxPage.class);
    }

    public void clickOnDiscardDraftsButton() {
        discardDraftsButton.waitUntil(Condition.appears, 5000).click();
    }

}
