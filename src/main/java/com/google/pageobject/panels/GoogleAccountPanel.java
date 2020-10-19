package com.google.pageobject.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class GoogleAccountPanel {
    @FindBy(xpath = "//div[@aria-label='Account Information']/div[@class='gb_Vb']")
    private SelenideElement addAnotherAccountButton;
    @FindBy(id = "gb_71")
    private SelenideElement signOutButton;
    @FindBys(@FindBy(xpath = "//div[contains(@class, 'gb_Rb')]/a"))
    private ElementsCollection accounts;

    public void clickOnAddAnotherAccountButton() {
        addAnotherAccountButton.waitUntil(Condition.appears, 5000).click();
    }

    public void clickOnAccountByEmail(String email) {
        accounts.filter(Condition.text(email)).first()
                .waitUntil(Condition.appears, 10000).click();
    }

}
