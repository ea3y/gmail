package com.google.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MessagePage {

    public SelenideElement getTitleOfMessage() {
        return $x("//h2[@class='hP']");
    }

    public SelenideElement getNameOfAuthorOfMessage() {
        return $x("//span[@class='gD']");
    }

    public SelenideElement getTextOfMessage() {
        return $x("//div[@class='ii gt']//div[@dir='ltr']");
    }
}
