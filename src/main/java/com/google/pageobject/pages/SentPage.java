package com.google.pageobject.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SentPage {

    @FindBys(@FindBy(xpath = "//div[contains(text(), 'To:')]/span")) private ElementsCollection recipientsName;

    public List<String> getNamesOfSenders() {
        $(By.xpath("//div[@aria-label='Primary']")).waitUntil(Condition.disappears, 5000);
        List<String> text = new ArrayList<>();
        for (SelenideElement element : recipientsName) {
            text.add(element.getText());
        }
        return text;
    }

}
