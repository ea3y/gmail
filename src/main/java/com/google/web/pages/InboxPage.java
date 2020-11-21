package com.google.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.web.panels.ContextMenu;
import com.google.web.panels.MailToolPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class InboxPage {

    @FindBy(xpath = "//div[contains(@class, 'aeN')]")
    private SelenideElement leftSidePanel;
    @FindBys(@FindBy(xpath = "//td[@class='yX xY ']"))
    private ElementsCollection inboxSendersName;
    @FindBys(@FindBy(xpath = "//div[@role='main']//span[@class='bog']"))
    private ElementsCollection inboxTitlesOfSubjects;
    @FindBy(xpath = "//span[@class='bAq']")
    private SelenideElement confirmationToolTip;
    @FindBys(@FindBy(xpath = "//table[@class='F cf zt']/tbody/tr"))
    private ElementsCollection lettersPanels;
    @FindBy(xpath = "//div[@dir='ltr']")
    private SelenideElement letterCheckbox;
    @FindBy(xpath = "//header[@id='gb']//div[contains(@class, 'gb_Wa')]")
    private SelenideElement googleAccountButton;
    @FindBy (xpath = "//div[@class='vh']")
    private SelenideElement confirmationalToolTip;

    public InboxPage checkConfirmationTooltipText(String expectedText) {
        confirmationalToolTip.waitUntil(Condition.appears, 7000)
                .shouldHave(Condition.text(expectedText));
        return this;
    }

    public void waitForConfirmationTooltipToDisappears() {
        confirmationalToolTip.waitUntil(Condition.disappear, 20000);
    }

//    public SelenideElement informationalTooltip() {
//        return $(By.xpath("//span[@id='link_vsm']")).waitUntil(Condition.text("View message"), 10000);
//    }

    public SelenideElement getConfirmationToolTip() {
        return confirmationToolTip.waitUntil(Condition.appears, 10000);
    }

    public void checkNameOfSender(String name) {
        inboxSendersName
                .filter(Condition.text(name)).first()
                .waitUntil(Condition.appears, 10000)
                .shouldHave(Condition.text(name));
    }

    public ContextMenu contextClickByLetterSubject(String subject) {
        inboxTitlesOfSubjects.filter(Condition.text(subject)).first()
                .waitUntil(Condition.appears, 10000).contextClick();
        return page(ContextMenu.class);
    }

    public ElementsCollection getSubjects() {
        return inboxTitlesOfSubjects;
    }

    public InboxPage openLetterBySubject(String title) {
        inboxTitlesOfSubjects.filter(Condition.text(title)).first()
                .waitUntil(Condition.appears, 15000).click();
        return this;
    }

    public MailToolPanel setCheckboxByLetterSubject(String title, boolean status) {
        if(status) {
            if (Objects.equals(inboxTitlesOfSubjects.filter(Condition.text(title)).first()
                    .waitUntil(Condition.appears, 10000)
                    .find(By.xpath("./ancestor::td/..//div[@aria-checked='false']"))
                    .attr("aria-checked"), "false")) {
                inboxTitlesOfSubjects.filter(Condition.text(title)).first()
                        .waitUntil(Condition.appears, 10000)
                        .find(By.xpath("./ancestor::td/..//div[@aria-checked='false']")).click();
            }
        } else {
            if (Objects.equals(inboxTitlesOfSubjects.filter(Condition.text(title)).first()
                    .waitUntil(Condition.appears, 10000)
                    .find(By.xpath("./ancestor::td/..//div[@aria-checked='true']"))
                    .attr("aria-checked"), "true")) {
                inboxTitlesOfSubjects.filter(Condition.text(title)).first()
                        .waitUntil(Condition.appears, 10000)
                        .find(By.xpath("./ancestor::td/..//div[@aria-checked='true']")).click();
            }
        }
        return page(MailToolPanel.class);
    }

    public SelenideElement getLetterByItsSubject(String subject) {
        return inboxTitlesOfSubjects.filter(Condition.text(subject)).first()
                .waitUntil(Condition.appears, 15000);
    }

    public InboxPage clickOnGoogleAccountButton() {
        googleAccountButton.waitUntil(Condition.appears, 5000).click();
        return this;
    }

    public MailToolPanel setStarByLetterSubject(String title, boolean status) {
        if(status) {
            if (Objects.equals(inboxTitlesOfSubjects.filter(Condition.text(title)).first()
                    .waitUntil(Condition.appears, 10000)
                    .find(By.xpath("./ancestor::td/..//span[@aria-label='Not starred']"))
                    .attr("aria-label"), "Not starred")) {
                inboxTitlesOfSubjects.filter(Condition.text(title)).first()
                        .waitUntil(Condition.appears, 10000)
                        .find(By.xpath("./ancestor::td/..//span[@aria-label='Not starred']")).click();
            }
        } else {
            if (Objects.equals(inboxTitlesOfSubjects.filter(Condition.text(title)).first()
                    .waitUntil(Condition.appears, 10000)
                    .find(By.xpath("./ancestor::td/..//span[@aria-label='Starred']"))
                    .attr("aria-label"), "Starred")) {
                inboxTitlesOfSubjects.filter(Condition.text(title)).first()
                        .waitUntil(Condition.appears, 10000)
                        .find(By.xpath("./ancestor::td/..//span[@aria-label='Starred']")).click();
            }
        }
        return new MailToolPanel();
    }

    public SelenideElement getLabelOfThePanelByItsSubject(String subject) {
        return inboxTitlesOfSubjects.filter(Condition.text(subject)).first()
                .waitUntil(Condition.appears, 10000)
                .find(By.xpath("./ancestor::td/..//td[@class='yX xY ']"));
    }

    public void clickOnInboxSettingsLink() {
        $(By.xpath("//span[@class='aRq']")).waitUntil(Condition.appears, 10000).click();
    }

}
