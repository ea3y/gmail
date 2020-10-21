package com.google.pageobject.panels;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.Objects;

public class SelectTabToEnablePopup {

    @FindBy(xpath = "//div[contains(@class, 'aJ7')]")
    private SelenideElement selectTabsPopup;
    @FindBy(xpath = "//td[@class='C6']")
    private ElementsCollection tabNames;
    @FindBy(xpath = "//button[@name='save']")
    private SelenideElement saveButton;
    @FindBys(@FindBy(xpath = "//tr[contains(@class, 'J-KU-Jg-K9')]/td[@role='heading']"))
    private ElementsCollection tabsCollection;

    public SelectTabToEnablePopup setCheckboxByTabName(String name, boolean status) {
        if(status) {
            if (Objects.equals(tabNames.filter(Condition.text(name)).first()
                    .waitUntil(Condition.appears, 10000)
                    .find(By.xpath("./..//td/span"))
                    .attr("aria-checked"), "false")) {
                tabNames.filter(Condition.text(name)).first()
                        .waitUntil(Condition.appears, 10000)
                        .find(By.xpath("./..//td/span")).click();
            }
        } else {
            if (Objects.equals(tabNames.filter(Condition.text(name)).first()
                    .waitUntil(Condition.appears, 10000)
                    .find(By.xpath("./..//td/span"))
                    .attr("aria-checked"), "true")) {
                tabNames.filter(Condition.text(name)).first()
                        .waitUntil(Condition.appears, 10000)
                        .find(By.xpath("./..//td/span")).click();
            }
        }
        return new SelectTabToEnablePopup();
    }

    public void clickSaveButton() {
        saveButton.waitUntil(Condition.appears, 5000).click();
    }

    public ElementsCollection getTabs() {
        return tabsCollection;
    }
}
