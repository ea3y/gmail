package com.google.pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateAccountPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement usernameInput = $("#username");
    private final SelenideElement passwordInput = $x("//input[@name='Passwd']");
    private final SelenideElement confirmPasswordInput = $x("//input[@name='ConfirmPasswd']");
    private final SelenideElement nextBtn = $("#accountDetailsNext");

    public void setFirstName(String name) {
        firstNameInput.val(name);
    }

    public CreateAccountPage setLastName(String lastName) {
        lastNameInput.val(lastName);
        return this;
    }

    public CreateAccountPage setUsername(String username) {
        usernameInput.val(username);
        return this;
    }

    public CreateAccountPage setPassword(String password) {
        passwordInput.val(password);
        return this;
    }

    public CreateAccountPage setConfirmPassword(String confirmPassword) {
        confirmPasswordInput.val(confirmPassword);
        return this;
    }

    public void clickNextButton() {

    }
}
