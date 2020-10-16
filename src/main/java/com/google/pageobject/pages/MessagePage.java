package com.google.pageobject.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MessagePage {

    @FindBy(xpath = "//h2[@class='hP']")
    private SelenideElement titleOfLetter;
    @FindBy(xpath = "//span[@class='gD']")
    private SelenideElement nameOfAuthorOfLetter;
    @FindBy(xpath = "//div[@class='ii gt']")
    private SelenideElement bodyOfLetter;


    public SelenideElement getTitleOfLetter() {
        return titleOfLetter;
    }

    public SelenideElement getNameOfAuthorOfLetter() {
        return nameOfAuthorOfLetter;
    }

    public SelenideElement getTextOfLetter() {
        return bodyOfLetter;
    }
}
