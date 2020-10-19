import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import com.google.pageobject.pages.*;
import com.google.pageobject.panels.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SendEmailTest {

    @BeforeAll
    static void beforeTests() {

        open("https://accounts.google.com/signin/v2/identifier?service=mail");
        final SignInPage signIn = page(SignInPage.class);
        final WelcomePage welcomePage = page(WelcomePage.class);

        signIn.setEmail("automation192020").clickNextButton(); // new mail vistaja20@gmail.com
        welcomePage.setPassword("gfhjkzytn123").clickNextButton();
    }

    @Test
    void sendEmail() {
        final InboxPage inboxPage = page(InboxPage.class);
        final LeftSidePanel leftSidePanel = page(LeftSidePanel.class);
        final NewMessagePopUp newMessagePopUp = page(NewMessagePopUp.class);
        final ContextMenu contexMenu = page(ContextMenu.class);
        final MailToolPanel mailToolPanel = page(MailToolPanel.class);
        final Faker faker = new Faker();

        String letterSubject = faker.book().title();
        String letterBody = faker.shakespeare().asYouLikeItQuote();
        leftSidePanel.composeButtonClick();
        newMessagePopUp
                .setRecipientEmail("automation192020@gmail.com")
                .setSubject(letterSubject)
                .setMessage(letterBody)
                .clickSendButton();
        inboxPage.informationalTooltip().shouldHave(Condition.exactText("View message"));
        inboxPage.getNamesOfSenders().shouldHave(CollectionCondition.texts("me"));
        inboxPage.selectLetterCheckbox(true)
                .clickOnDeleteButton()
                .getConfirmationToolTip()
                .shouldHave(Condition.text("Conversation moved to Bin"))
                .waitUntil(Condition.disappear, 15000);
    }

    @Test
    void replyToLetter() {
        final SignInPage signIn = page(SignInPage.class);
        final WelcomePage welcomePage = page(WelcomePage.class);
        final InboxPage inboxPage = page(InboxPage.class);
        final LeftSidePanel leftSidePanel = page(LeftSidePanel.class);
        final NewMessagePopUp newMessagePopUp = page(NewMessagePopUp.class);
        final ContextMenu contexMenu = page(ContextMenu.class);
        final GoogleAccountPanel googleAccountPanel = page(GoogleAccountPanel.class);
        final MailToolPanel mailToolPanel = page(MailToolPanel.class);
        final MessagePage messagePage = page(MessagePage.class);
        final Faker faker = new Faker();

        String letterSubject = faker.book().title();
        String letterBody = faker.shakespeare().asYouLikeItQuote();
        String replyLetterBody = faker.chuckNorris().fact();
        leftSidePanel.composeButtonClick();
        newMessagePopUp.sentMessage("vistaja20@gmail.com", letterSubject, letterBody);
        inboxPage.informationalTooltip().shouldHave(Condition.exactText("View message"));
        inboxPage.clickOnGoogleAccountButton();
        googleAccountPanel.clickOnAddAnotherAccountButton();
        switchTo().window("Gmail");
        signIn.setEmail("vistaja20@gmail.com").clickNextButton();
        welcomePage.setPassword("gfhjkzytn123").clickNextButton();
        mailToolPanel
                .clickOnRefreshButton()
                .contextClickByLetterSubject(letterSubject)
                .clickOnMenuItem("Reply");
        newMessagePopUp
                .setMessage(replyLetterBody)
                .clickSendButton();
        inboxPage.getConfirmationToolTip().shouldHave(Condition.exactText("Message sent."));
        inboxPage.clickOnGoogleAccountButton();
        googleAccountPanel.clickOnAccountByEmail("automation192020@gmail.com");
        switchTo().window(2);
        mailToolPanel
                .clickOnRefreshButton()
                .openLetterBySubject(letterSubject);
        messagePage.getMessagePanels()
                .shouldHave(CollectionCondition.texts(letterBody, replyLetterBody));
    }

    @Test
    void markLetterAsStarred() {
        final InboxPage inboxPage = page(InboxPage.class);
        final SignInPage signIn = page(SignInPage.class);
        final WelcomePage welcomePage = page(WelcomePage.class);
        final LeftSidePanel leftSidePanel = page(LeftSidePanel.class);
        final NewMessagePopUp newMessagePopUp = page(NewMessagePopUp.class);
        final StarredPage starredPage = page(StarredPage.class);
        final GoogleAccountPanel googleAccountPanel = page(GoogleAccountPanel.class);
        final MailToolPanel mailToolPanel = page(MailToolPanel.class);

        final Faker faker = new Faker();

        String letterSubject = faker.book().title();
        String letterBody = faker.shakespeare().asYouLikeItQuote();
        leftSidePanel.composeButtonClick();
        newMessagePopUp
                .setRecipientEmail("vistaja20@gmail.com")
                .setSubject(letterSubject)
                .setMessage(letterBody)
                .clickSendButton();
        inboxPage.clickOnGoogleAccountButton();
        googleAccountPanel.clickOnAddAnotherAccountButton();
        switchTo().window(1);
        signIn.setEmail("vistaja20@gmail.com").clickNextButton();
        welcomePage.setPassword("gfhjkzytn123").clickNextButton();
        mailToolPanel.clickOnRefreshButton()
                .setStarByLetterSubject(letterSubject, true);
        leftSidePanel.clickStarredButton();
        inboxPage.getSubjects().shouldHave(CollectionCondition.texts(letterSubject));
        inboxPage.setStarByLetterSubject(letterSubject, false);
        starredPage.getInformationalText().shouldHave(Condition.exactText("No starred messages. " +
                "Stars let you give messages a special status to make them easier to find. " +
                "To star a message, click on the star outline beside any message or conversation."));

    }
}