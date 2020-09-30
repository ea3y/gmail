package com.google.pageobject.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class NewMessagePopUp {

    private final SelenideElement toTextarea = $x("//textarea[@name='to']");
    private final SelenideElement subjectInput = $x("//input[@name='subjectbox']");
    private final SelenideElement messageTextarea = $x("//div[@aria-label='Message Body']");
    private final SelenideElement sendBtn = $x("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']");

    public NewMessagePopUp setRecipientEmail(String email) {
        toTextarea.waitUntil(Condition.appears, 10000).val(email);
        return this;
    }

    public NewMessagePopUp setSubject(String subject) {
        subjectInput.val(subject);
        return this;
    }

    public NewMessagePopUp setMessage(String message) {
        messageTextarea.val(message);
        return this;
    }

    public void clickSendButton() {
        sendBtn.click();
    }
}
