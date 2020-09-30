package com.google.pageobject.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class LeftSidePanel {

//    private final SelenideElement composeBtn = $x(".//div[@class='T-I T-I-KE L3']");
    private final SelenideElement sentLink = $x("//div[@data-tooltip='Sent']");


    public SelenideElement getComposeBtn() {
        return $x(".//div[@class='T-I T-I-KE L3']");
    }

    private final List<SelenideElement> mainMenuItems = $$x("//div[@class='byl']//div[contains(@class, 'aim')]");

//    public void clickComposeButton() {
//        composeBtn.waitUntil(Condition.appears, 5000).click();
//    }

    public void clickSentLink() {
        sentLink.waitUntil(Condition.appears, 5000).click();
    }
}
