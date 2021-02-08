package com.ea3y.web.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.ea3y.user.User;

import static com.codeborne.selenide.Selenide.$x;

public class NewMessagePopUp {

    private final SelenideElement toRecipientTextarea;
    private final SelenideElement subjectInput;
    private final SelenideElement messageTextarea;
    private final SelenideElement sendBtn;

    public static class Builder {
        private final SelenideElement toRecipientTextarea = $x("//textarea[@name='to']");
        private final SelenideElement subjectInput = $x("//input[@name='subjectbox']");
        private final SelenideElement messageTextarea = $x("//div[@aria-label='Message Body']");
        private final SelenideElement sendBtn = $x("//div[contains(@data-tooltip, 'Send')]");

        public Builder setRecipient(String recipient) {
            toRecipientTextarea.waitUntil(Condition.appears, 5000).setValue(recipient);
            return this;
        }

        public Builder setSubject(String subject) {
            subjectInput.waitUntil(Condition.appears, 5000).setValue(subject);
            return this;
        }

        public Builder setMessage(String message) {
            messageTextarea.waitUntil(Condition.appears, 5000).setValue(message);
            return this;
        }

        public NewMessagePopUp send() {
            sendBtn.waitUntil(Condition.appears, 5000).click();
            return new NewMessagePopUp(this);
        }
    }

    public NewMessagePopUp(Builder builder) {
        toRecipientTextarea = builder.toRecipientTextarea;
        subjectInput = builder.subjectInput;
        messageTextarea = builder.messageTextarea;
        sendBtn = builder.sendBtn;
    }
}
