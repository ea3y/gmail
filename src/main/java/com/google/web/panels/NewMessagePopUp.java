package com.google.web.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class NewMessagePopUp {

    @FindBy(xpath = "//textarea[@name='to']")
    private SelenideElement toTextarea;
    @FindBy(xpath = "//input[@name='subjectbox']")
    private SelenideElement subjectInput;
    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private SelenideElement messageTextarea;
    @FindBy(xpath = "//div[contains(@data-tooltip, 'Send')]")
    private SelenideElement sendBtn;
    @FindBy(xpath = "//td[@class='Hm']")
    private SelenideElement popupControlsPanel;

    @FindBy(xpath = "//div[@class='Kj-JD' and @role='alertdialog']")
    private SelenideElement errorPopup;

    public void sentMessage(String email, String subject, String message) {
        setRecipientEmail(email)
                .setSubject(subject)
                .setMessage(message)
                .clickSendButton();
    }


    public NewMessagePopUp setRecipientEmail(String email) {
        toTextarea.waitUntil(Condition.appears, 10000).setValue(email);
        return this;
    }

    public NewMessagePopUp setSubject(String subject) {
        subjectInput
                .waitUntil(Condition.appears, 5000)
                .setValue(subject);
        return this;
    }

    public NewMessagePopUp setMessage(String message) {
        messageTextarea
                .waitUntil(Condition.appears, 5000)
                .setValue(message);
        return this;
    }

    public void clickSendButton() {
        sendBtn.waitUntil(Condition.appears, 5000).click();
    }

    public SelenideElement getErrorPopup() {
        return errorPopup;
    }

    public SelenideElement getTextOfErrorPopup() {
        return getErrorPopup().find(By.xpath("./div[@class='Kj-JD-Jz']"));
    }

    public void clickOnClosePopupButton() {
        popupControlsPanel.find(By.xpath("./img[@class='Ha']"))
                .waitUntil(Condition.appears, 5000).click();
    }

    public SelenideElement getTextOfPanel() {
        return $(By.xpath("//div[@class='aYF']")).waitUntil(Condition.appears, 10000);
    }
}
