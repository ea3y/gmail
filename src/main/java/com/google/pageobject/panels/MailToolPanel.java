package com.google.pageobject.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.pageobject.pages.InboxPage;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class MailToolPanel {
    @FindBy(xpath = "//div[@class='aeH']//div[contains(@class, 'nu')]")
    private static SelenideElement refreshButton;
    @FindBy(xpath = "//div[@act='10']")
    private static SelenideElement deleteBtn;

    public InboxPage clickOnRefreshButton() {
        refreshButton.waitUntil(Condition.appears, 10000).click();
        return page(InboxPage.class);
    }

    public InboxPage clickOnDeleteButton() {
        deleteBtn.waitUntil(Condition.appears, 5000).click();
        return page(InboxPage.class);
    }


}