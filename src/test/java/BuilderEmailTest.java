import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.ea3y.user.UserFactory;
import com.ea3y.user.UserName;
import com.ea3y.web.pages.MainPage;
import com.ea3y.web.pages.SignInPage;
import com.ea3y.web.panels.NewMessagePopUp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderEmailTest {

    final Faker faker = new Faker();

    @BeforeAll
    static void beforeTests() {
        Configuration.baseUrl = "https://accounts.google.com";
    }

    @Test
    void sendEmail() {
        String letterSubject = faker.book().title();
        String letterBody = faker.shakespeare().asYouLikeItQuote();
//Open login page and login ass user JAVISTA
        MainPage mainPage = SignInPage
                .open()
                .signInAs(UserFactory.getUser(UserName.JAVISTA));
        mainPage.getLeftSidePanel().clickComposeButton();
//Send a message to user AUTOMATION
        new NewMessagePopUp.Builder()
                .setRecipient("automation192020@gmail.com")
                .setSubject(letterSubject)
                .setMessage(letterBody)
                .send();
//Login ass user AUTOMATION
        mainPage.waitForMessageTooltipToDisappears()
                .getMainToolBarPanel()
                .clickOnGoogleAccountButton()
                .clickOnAddAnotherAccountButton()
                .signInAs(UserFactory.getUser(UserName.AUTOMATION));

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
                .signInAs(UserFactory.getUser(UserName.JAVISTA));
        mainPage.getLeftSidePanel().clickComposeButton();
        new NewMessagePopUp.Builder()
                .setRecipient("automation192020@gmail.com")
                .setSubject(letterSubject)
                .setMessage(letterBody)
                .send();
        mainPage.waitForMessageTooltipToDisappears()
                .getMainToolBarPanel()
                .clickOnGoogleAccountButton()
                .clickOnAddAnotherAccountButton()
                .signInAs(UserFactory.getUser(UserName.AUTOMATION))
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