package com.google.pageobject.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class NewMessagePopUp {

    @FindBy(xpath = "//textarea[@name='to']")
    private SelenideElement toTextarea;
    @FindBy(xpath = "//input[@name='subjectbox']")
    private SelenideElement subjectInput;
    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private SelenideElement messageTextarea;
    @FindBy(xpath = "//div[contains(@data-tooltip, 'Send')]")
    private SelenideElement sendBtn;

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
}
