package com.google.pageobject.core.pageObject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class SentPage {
    private final List<SelenideElement>
            sentRecipientsName = $$(By.xpath("//div[contains(text(), 'To:')]/span"));

    public List<String> getNamesOfSenders() {
        $x("//div[@aria-label='Primary']").waitUntil(Condition.disappears, 5000);
        List<String> text = new ArrayList<>();
        for (SelenideElement element : sentRecipientsName) {
            text.add(element.getText());
        }
//        System.out.println(text);
        return text;
    }

}
