package com.google.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.google.user.User;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SignInPage {

    public static SignInPage open() {
        return Selenide.open("/signin/v2/identifier?service=mail", SignInPage.class);
    }

    public MainPage signInAs(User user) {
        setEmail(user.login());
        setPassword(user.password());
        return clickSignInButton();
    }

    private void setEmail(String emailOrPhone) {
        $x("//input[@name='identifier']").waitUntil(Condition.visible, 25000).setValue(emailOrPhone);
        $("#identifierNext").click();
    }

    private void setPassword(String password) {
        $(By.name("password")).waitUntil(Condition.appears, 5000).setValue(password);
    }

    private MainPage clickSignInButton() {
        $("#passwordNext").waitUntil(Condition.appears, 5000).click();
        return page(MainPage.class);
    }
}
