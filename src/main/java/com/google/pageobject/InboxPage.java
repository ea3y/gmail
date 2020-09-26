package com.google.pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class InboxPage {
//    private final SelenideElement informationalTooltip = $x("//span[@id='link_vsm']");
    private final List<SelenideElement>
        inboxSendersName = $$(By.xpath("//table[@class='F cf zt']/tbody/tr/td[@class='yX xY ']"));

    public SelenideElement informationalTooltip() {
        return $x("//span[@id='link_vsm']");
    }

    public SelenideElement getConfirmationTextOfDeletedLetter() {
        return $x("//span[@class='bAq']").waitUntil(Condition.appear, 5000);
    }

    public ElementsCollection authorNamesCollection() {
        return $$x("//table[@class='F cf zt']/tbody/tr/td[@class='yX xY ']");
    }

    public ElementsCollection lettersPanelCollection() {
        return $$x("//table[@class='F cf zt']/tbody/tr");
    }

    public List<String> getNamesOfSenders() {
        $x("//div[@aria-label='Primary']").waitUntil(Condition.appears, 5000);
        List<String> text = new ArrayList<>();
        for (SelenideElement element : inboxSendersName) {
            text.add(element.getText());
        }
//        System.out.println(text);
        return text;
    }

    public InboxPage selectCheckBox() {
        $x("//div[@dir='ltr']").waitUntil(Condition.appears, 3000).click();
        return this;
    }

    public InboxPage clickOnDeleteButton() {
        $x("//div[@act='10']").waitUntil(Condition.appears, 5000).click();
        return this;
    }

    public void openMessage() {
        $x("//div[@class='yW']//span[@name='In Bloom']").click();
    }

}
