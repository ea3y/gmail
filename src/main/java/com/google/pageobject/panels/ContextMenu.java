package com.google.pageobject.panels;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ContextMenu {

    @FindBy(xpath = "//div[@role='menu' and contains(@class, 'Ft')]")
    private static SelenideElement contexMenu;

    //div[@role='menu' and contains(@class, 'Ft')]/following-sibling::div[@class='J-M J-M-ayU']//div[text()='Social']

    public ContextMenu clickOnMenuItem(String menuItemName) {
        contexMenu.find(By.xpath(".//div[text() = '" + menuItemName + "']")).click();
        return this;
    }

    public void clickOnReplySubMenuByName() {

    }
}
