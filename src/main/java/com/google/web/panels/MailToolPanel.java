package com.google.web.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MailToolPanel {

    SelenideElement element;

    public MailToolPanel(SelenideElement element) {
        this.element = element;
    }

    public void clickOnRefreshButton() {
        element.$x(".//div[contains(@class, 'nu')]").waitUntil(Condition.appears, 10000).click();
        $x("//div[@class='vh']//span[text()='Loading...']").waitUntil(Condition.disappears, 10000);
    }

    public MailToolPanel clickDeleteButton() {
        element.$x(".//div[@act='10']").waitUntil(Condition.appears, 5000).click();
        return this;
    }

    public MailToolPanel setCheckBox() {
        element.$x(".//span[@dir='ltr']").waitUntil(Condition.appears, 5000).click();
        return this;
    }

}
