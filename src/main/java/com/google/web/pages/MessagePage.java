package com.google.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class MessagePage {

    @FindBy(xpath = "//h2[@class='hP']")
    private SelenideElement titleOfLetter;
    @FindBy(xpath = "//span[@class='gD']")
    private SelenideElement nameOfAuthorOfLetter;
    @FindBy(xpath = "//div[@class='ii gt']")
    private SelenideElement bodyOfLetter;
    @FindBys(@FindBy(xpath = "//div[contains(@class, 'gs')]/parent::div[contains(@class, 'ads')]"))
    private ElementsCollection messagePanels;


    public SelenideElement getTitleOfLetter() {
        return titleOfLetter;
    }

    public SelenideElement getNameOfAuthorOfLetter() {
        return nameOfAuthorOfLetter;
    }

    public SelenideElement getTextOfLetter() {
        return bodyOfLetter;
    }

    public ElementsCollection getMessagePanels() {
        return messagePanels.filter(Condition.appears);
    }
}
