package com.google.pageobject.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class LeftSidePanel {

    @FindBy(xpath = "//div[@data-tooltip='Sent']") private SelenideElement sentLink;
    @FindBy(xpath = "//div[@class='T-I T-I-KE L3']") private SelenideElement composeBtn;
    @FindBys(@FindBy(xpath = "//div[@class='byl']//div[contains(@class, 'aim')]"))
    private ElementsCollection mainMenuItems;


    public void composeButtonClick() {
        composeBtn.waitUntil(Condition.appears, 5000).click();
    }

    public void clickSentLink() {
        sentLink.waitUntil(Condition.appears, 5000).click();
    }
}
