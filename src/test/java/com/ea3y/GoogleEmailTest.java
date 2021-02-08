package com.ea3y;

import com.ea3y.user.UserName;
import com.ea3y.web.pages.MainPage;
import com.ea3y.web.pages.SignInPage;
import com.ea3y.web.panels.NewMessagePopUp;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.ea3y.Configuration.getRecipientEmail;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleEmailTest extends BaseTest {

    final Faker faker = new Faker();

    @Test
    void sendEmail() {
        String letterSubject = faker.book().title();
        String letterBody = faker.shakespeare().asYouLikeItQuote();
//Open email page and email ass user JAVISTA
        MainPage mainPage = SignInPage
                .open()
                .signInAs(UserName.JAVISTA);
        mainPage.getLeftSidePanel().clickComposeButton();
//Send a message to user AUTOMATION
        new NewMessagePopUp.Builder()
                .setRecipient(getRecipientEmail())
                .setSubject(letterSubject)
                .setMessage(letterBody)
                .send();
//Login ass user AUTOMATION
        mainPage.waitForMessageTooltipToDisappears()
                .getMainToolBarPanel()
                .clickOnGoogleAccountButton()
                .clickOnAddAnotherAccountButton()
                .signInAs(UserName.AUTOMATION);

        assertAll(
                () -> assertEquals(
                        "Ja Vista",
                        mainPage.getLetterListPanel().getLettersTable().getTheFirstRow().getTextOfSenderCell()),
                () -> assertEquals(
                        letterSubject,
                        mainPage.getLetterListPanel().getLettersTable().getTheFirstRow().getTextOfSubjectCell())
        );
    }

    @Test
    void markLetterAsStarred() {
        String letterSubject = faker.book().title();
        String letterBody = faker.shakespeare().asYouLikeItQuote();

        MainPage mainPage = SignInPage
                .open()
                .signInAs(UserName.JAVISTA);
        mainPage.getLeftSidePanel().clickComposeButton();
        new NewMessagePopUp.Builder()
                .setRecipient(getRecipientEmail())
                .setSubject(letterSubject)
                .setMessage(letterBody)
                .send();
        mainPage.waitForMessageTooltipToDisappears()
                .getMainToolBarPanel()
                .clickOnGoogleAccountButton()
                .clickOnAddAnotherAccountButton()
                .signInAs(UserName.AUTOMATION)
                .getLetterListPanel()
                .getLettersTable()
                .getTheFirstRow()
                .setStar("Starred");
        mainPage.getLeftSidePanel().clickStarredButton();

        assertAll(
                () -> assertEquals(
                        letterSubject,
                        mainPage.getLetterListPanel().getLettersTable().getTheFirstRow().getTextOfSubjectCell()),
                () -> assertEquals(
                        "Starred",
                        mainPage.getLetterListPanel().getLettersTable().getTheFirstRow().getStarCellAttribute())
        );
    }
}