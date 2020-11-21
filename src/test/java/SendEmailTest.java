import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import com.google.web.pages.*;
import com.google.web.panels.*;
import com.google.web.table.LettersTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.google.web.common.AbstractPage.openPageAt;

public class SendEmailTest {

    final Faker faker = new Faker();

//    @BeforeAll
//    static void beforeTests() {
//
//        open("https://accounts.google.com/signin/v2/identifier?service=mail");
//        final SignInPage signIn = page(SignInPage.class);

//        signIn.setCredentialsAndSignIn("vistaja20@gmail.com", "gfhjkzytn123");
//        signIn.setCredentialsAndSignIn("automation192020", "gfhjkzytn123");
//    }

    @Test
    void sendEmail() {
        final SignInPage signIn = page(SignInPage.class);
        final InboxPage inboxPage = page(InboxPage.class);
        final LeftSidePanel leftSidePanel = page(LeftSidePanel.class);
        final NewMessagePopUp newMessagePopUp = page(NewMessagePopUp.class);
        final MailToolPanel mailToolPanel = page(MailToolPanel.class);
        final GoogleAccountPanel googleAccountPanel = page(GoogleAccountPanel.class);

        String letterSubject = faker.book().title();
        String letterBody = faker.shakespeare().asYouLikeItQuote();
        leftSidePanel.composeButtonClick();
        newMessagePopUp.sentMessage("vistaja20@gmail.com", letterSubject, letterBody);
        inboxPage.checkConfirmationTooltipText("Message sent.");
        inboxPage.clickOnGoogleAccountButton();
        googleAccountPanel.clickOnAddAnotherAccountButton();
        switchTo().window("Gmail");
        signIn.setCredentialsAndSignIn("vistaja20@gmail.com", "gfhjkzytn123");
        mailToolPanel.clickOnRefreshButton();
        inboxPage.checkNameOfSender("Autom Ation");
        inboxPage.setCheckboxByLetterSubject(letterSubject,true).clickOnDeleteButton()
                .checkConfirmationTooltipText("Conversation moved to Bin")
                .waitForConfirmationTooltipToDisappears();
    }




    @Test
    void sendEmailV2() {
//        GmailLetterListPanel letterListPanel = page(GmailLetterListPanel.class);
//        letterListPanel.getLettersTable();

        SignInPage signInPage = (SignInPage) openPageAt(SignInPage.class);
        MainPage mainPage = signInPage.setCredentialsAndSignIn("vistaja20@gmail.com", "gfhjkzytn123");

        LettersTable lettersTable = mainPage
                .getLetterListPanel()
                .getLettersTable();
    }





    @Test
    void replyToLetter() {
        final SignInPage signIn = page(SignInPage.class);
        final InboxPage inboxPage = page(InboxPage.class);
        final LeftSidePanel leftSidePanel = page(LeftSidePanel.class);
        final NewMessagePopUp newMessagePopUp = page(NewMessagePopUp.class);
        final ContextMenu contexMenu = page(ContextMenu.class);
        final GoogleAccountPanel googleAccountPanel = page(GoogleAccountPanel.class);
        final MailToolPanel mailToolPanel = page(MailToolPanel.class);
        final MessagePage messagePage = page(MessagePage.class);

        String letterSubject = faker.book().title();
        String letterBody = faker.shakespeare().asYouLikeItQuote();
        String replyLetterBody = faker.chuckNorris().fact();
        leftSidePanel.composeButtonClick();
        newMessagePopUp.sentMessage("vistaja20@gmail.com", letterSubject, letterBody);
        inboxPage.checkConfirmationTooltipText("Sending...");
        inboxPage.clickOnGoogleAccountButton();
        googleAccountPanel.clickOnAddAnotherAccountButton();
        switchTo().window("Gmail");
        signIn.setCredentialsAndSignIn("vistaja20@gmail.com", "gfhjkzytn123");
        mailToolPanel
                .clickOnRefreshButton()
                .contextClickByLetterSubject(letterSubject)
                .clickOnMenuItem("Reply");
        newMessagePopUp
                .setMessage(replyLetterBody)
                .clickSendButton();
        inboxPage.checkConfirmationTooltipText("Message sent.");    //getConfirmationToolTip().shouldHave(Condition.exactText("Message sent."));
        inboxPage.clickOnGoogleAccountButton();
        googleAccountPanel.selectAccountByEmail("automation192020@gmail.com");
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
        final LeftSidePanel leftSidePanel = page(LeftSidePanel.class);
        final NewMessagePopUp newMessagePopUp = page(NewMessagePopUp.class);
        final StarredPage starredPage = page(StarredPage.class);
        final GoogleAccountPanel googleAccountPanel = page(GoogleAccountPanel.class);
        final MailToolPanel mailToolPanel = page(MailToolPanel.class);

        String letterSubject = faker.book().title();
        String letterBody = faker.shakespeare().asYouLikeItQuote();
        leftSidePanel.composeButtonClick();
        newMessagePopUp.sentMessage("vistaja20@gmail.com", letterSubject, letterBody);
        inboxPage.clickOnGoogleAccountButton();
        googleAccountPanel.clickOnAddAnotherAccountButton();
        switchTo().window(1);
        signIn.setCredentialsAndSignIn("vistaja20@gmail.com", "gfhjkzytn123");
        mailToolPanel.clickOnRefreshButton()
                .setStarByLetterSubject(letterSubject, true);
        leftSidePanel.clickStarredButton();

        inboxPage.getSubjects().shouldHave(CollectionCondition.texts(letterSubject));
        inboxPage.setStarByLetterSubject(letterSubject, false);
        starredPage.getInformationalText().shouldHave(Condition.exactText("No starred messages. " +
                "Stars let you give messages a special status to make them easier to find. " +
                "To star a message, click on the star outline beside any message or conversation."));

    }

    @Test
    void moveLetterToAnotherFolder() {
        final LeftSidePanel leftSidePanel = page(LeftSidePanel.class);
        final NewMessagePopUp newMessagePopUp = page(NewMessagePopUp.class);

        leftSidePanel.composeButtonClick();
        newMessagePopUp.clickSendButton();
        newMessagePopUp.getErrorPopup().shouldBe(Condition.visible);
        newMessagePopUp.getTextOfErrorPopup().shouldHave(Condition.text("Please specify at least one recipient."));
    }

    @Test
    void saveUnsendedLetterToDraft() {
        final InboxPage inboxPage = page(InboxPage.class);
        final LeftSidePanel leftSidePanel = page(LeftSidePanel.class);
        final NewMessagePopUp newMessagePopUp = page(NewMessagePopUp.class);
        final MailToolPanel mailToolPanel = page(MailToolPanel.class);
        final DraftPage draftPage = page(DraftPage.class);

        String letterSubject = faker.book().title();
        String letterBody = faker.shakespeare().asYouLikeItQuote();
        leftSidePanel.composeButtonClick();
        newMessagePopUp
                .setRecipientEmail("vistaja20@gmail.com")
                .setSubject(letterSubject)
                .setMessage(letterBody).getTextOfPanel()
                .shouldBe(Condition.text("Draft saved"));
        newMessagePopUp.clickOnClosePopupButton();
        leftSidePanel.clickDraftButton();
        inboxPage.getLabelOfThePanelByItsSubject(letterSubject).shouldBe(Condition.text("Draft"));
        inboxPage.setCheckboxByLetterSubject(letterSubject, true);
        mailToolPanel.clickOnDiscardDraftsButton();
        draftPage.getInformationalText()
                .shouldBe(Condition.text("You don't have any saved drafts.\n" +
                "Saving a draft allows you to keep a message you aren't ready to send yet."));

    }

    @Test
    void addAndRemoveUpdatesTab() {
        final InboxPage inboxPage = page(InboxPage.class);
        final SelectTabToEnablePopup tabSettingsPopup = page(SelectTabToEnablePopup.class);

        inboxPage.clickOnInboxSettingsLink();
        tabSettingsPopup.setCheckboxByTabName("Updates", true).clickSaveButton();
        tabSettingsPopup.getTabs().shouldHave(CollectionCondition.texts("Primary", "Social", "Promotions", "Updates"));
        inboxPage.clickOnInboxSettingsLink();
        tabSettingsPopup.setCheckboxByTabName("Updates", false).clickSaveButton();
        tabSettingsPopup.getTabs().shouldHave(CollectionCondition.texts("Primary", "Social", "Promotions"));
    }
}