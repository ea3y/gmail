package com.google.web.panels;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ContextMenu {

    @FindBy(xpath = "//div[@role='menu' and contains(@class, 'Ft')]")
    private static SelenideElement contexMenu;

    public ContextMenu clickOnMenuItem(String menuItemName) {
        contexMenu.find(By.xpath(".//div[text() = '" + menuItemName + "']")).click();
        return this;
    }

    public void clickOnReplySubMenuByName() {

    }
}
