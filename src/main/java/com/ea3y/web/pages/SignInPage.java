package com.ea3y.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.ea3y.user.UserName;
import com.ea3y.utils.PropertyReader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SignInPage {

    public static SignInPage open() {
        return Selenide.open("/signin/v2/identifier?service=mail", SignInPage.class);
    }

    public MainPage signInAs(UserName userName) {
        PropertyReader property = new PropertyReader("user.properties");
        switch (userName) {
            case JAVISTA ->
                    setCredentials(property.getValue("javista.email"), property.getValue("javista.password"));
            case AUTOMATION -> setCredentials(
                    property.getValue("automation.email"), property.getValue("automation.password"));
        }
        return clickSignInButton();
    }

    private void setCredentials(String emailOrPhone, String password) {
        $x("//input[@name='identifier']").waitUntil(Condition.visible, 25000).setValue(emailOrPhone);
        $("#identifierNext").click();
        $(By.name("password")).waitUntil(Condition.appears, 5000).setValue(password);
    }

    private MainPage clickSignInButton() {
        $("#passwordNext").waitUntil(Condition.appears, 5000).click();
        return Selenide.page(MainPage.class);
    }
}
