package com.google.web.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.core.Url;
import com.google.web.common.AbstractPage;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

@Url("https://accounts.google.com/signin/v2/identifier?service=mail")
public class SignInPage extends AbstractPage {
    @FindBy(id = "identifierId")
    private SelenideElement emailOrPhoneInput;
    @FindBy(id = "identifierNext")
    private SelenideElement nextBtn;
    @FindBy(name = "password")
    private SelenideElement passwordInput;
    @FindBy(id = "passwordNext")
    private SelenideElement signInBtn;

//    public void setEmailTwo(String emailOrPhone) {
//        emailOrPhoneInput.setValue(emailOrPhone);
//        nextBtn.waitUntil(Condition.appears, 5000).click();
//    }

    public MainPage setCredentialsAndSignIn(String email, String password) {
        setEmail(email);
        setPassword(password);
        return clickSignInButton();
    }

    public void setEmail(String emailOrPhone) {
        emailOrPhoneInput.setValue(emailOrPhone);
        nextBtn.click();
    }

    public void setPassword(String password) {
        passwordInput.waitUntil(Condition.appears, 5000).setValue(password);
    }

    public MainPage clickSignInButton() {
        signInBtn.waitUntil(Condition.appears, 5000).click();
        return page(MainPage.class);
    }
}
