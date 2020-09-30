package com.google.pageobject.core.base;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.pageobject.panels.LeftSidePanel;
import com.google.pageobject.panels.NewMessagePopUp;

import static com.codeborne.selenide.Selenide.$x;

public abstract class AbstractPage {

    public LeftSidePanel getLeftSidePanel() {
        return new LeftSidePanel();
    }

    public NewMessagePopUp getNewMessagePopUp() {
        return new NewMessagePopUp();
    }

    public SelenideElement informationalTooltip() {
        return $x("//span[@id='link_vsm']").waitUntil(Condition.text("View message"), 5000);
    }
}
