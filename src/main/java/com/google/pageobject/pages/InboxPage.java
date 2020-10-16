package com.google.pageobject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;

public class InboxPage {

    @FindBy(xpath = "//div[contains(@class, 'aeN')]")
    private SelenideElement leftSidePanel;
    @FindBys(@FindBy(xpath = "//td[@class='yX xY ']"))
    private ElementsCollection inboxSendersName;
    @FindBys(@FindBy(xpath = "//span[@class='bog']"))
    private ElementsCollection inboxTitleOfLetter;
    @FindBy(xpath = "//span[@class='bAq']")
    private SelenideElement confirmationTextOfDeletedLetter;
    @FindBys(@FindBy(xpath = "//td[contains(@class, 'yX xY')]"))
    private ElementsCollection sendersNames;
    @FindBys(@FindBy(xpath = "//table[@class='F cf zt']/tbody/tr"))
    private ElementsCollection lettersPanels;
    @FindBy(xpath = "//div[@dir='ltr']")
    private SelenideElement letterCheckbox;
    @FindBy(xpath = "//div[@act='10']")
    private SelenideElement deleteBtn;

    public SelenideElement getConfirmationTextOfDeletedLetter() {
        return confirmationTextOfDeletedLetter.waitUntil(Condition.appears, 10000);
    }

    public ElementsCollection getSendersNames() {
        return sendersNames;
    }

    public ElementsCollection getLettersPanels() {
        return lettersPanels;
    }

    public ElementsCollection getNamesOfSenders() {
        $(By.xpath("//div[@aria-label='Primary']")).waitUntil(Condition.appears, 5000);
        return inboxSendersName;
    }

    public ElementsCollection getInboxTitleOfLetter() {
        return inboxTitleOfLetter;
    }

    public InboxPage selectLetterCheckbox(boolean status) {
        if(status) {
            if (Objects.equals(letterCheckbox.attr("aria-checked"), "false")) {
                clickOnCheckbox();
            }
        } else {
            if (Objects.equals(letterCheckbox.attr("aria-checked"), "true")) {
                clickOnCheckbox();
            }
        }
        return this;
    }

    public InboxPage clickOnDeleteButton() {
        deleteBtn.waitUntil(Condition.appears, 5000).click();
        return this;
    }

    public InboxPage openMessageByAuthorName(String name) {
        $(By.xpath("//div[@class='yW']//span[@name='" + name + "']")).click();
        return this;
    }

    public SelenideElement informationalTooltip() {
        return $(By.xpath("//span[@id='link_vsm']")).waitUntil(Condition.text("View message"), 10000);
    }

    private void clickOnCheckbox() {
        letterCheckbox.waitUntil(Condition.appears, 5000).click();
    }

}