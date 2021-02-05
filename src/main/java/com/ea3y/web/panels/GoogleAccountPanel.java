package com.ea3y.web.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.ea3y.web.pages.SignInPage;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class GoogleAccountPanel {

    SelenideElement element;

    public GoogleAccountPanel(SelenideElement element) {
        this.element = element;
    }

    public SignInPage clickOnAddAnotherAccountButton() {
        element.$x("./div[@class='gb_Rb']")
                .waitUntil(Condition.appears, 5000).click();
        switchTo().window("Gmail");
        return new SignInPage();
    }

    public void selectAccountByEmail(String email) {
        $$x("//div[contains(@class, 'gb_Rb')]/a").filter(Condition.text(email)).first()
                .waitUntil(Condition.appears, 10000).click();
    }

}
