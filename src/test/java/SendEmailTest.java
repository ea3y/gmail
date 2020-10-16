import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.google.pageobject.pages.*;
import com.google.pageobject.panels.LeftSidePanel;
import com.google.pageobject.panels.NewMessagePopUp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SendEmailTest {

    @BeforeAll
    static void beforeTests() {

        open("https://accounts.google.com/signin/v2/identifier?service=mail");
        final SignInPage signIn = page(SignInPage.class);
        final WelcomePage welcomePage = page(WelcomePage.class);

        signIn.setEmail("automation192020").clickNextButton();
        welcomePage.setPassword("gfhjkzytn123").clickNextButton();
    }

    @Test
    void sendEmail() {
        final InboxPage inboxPage = page(InboxPage.class);
        final LeftSidePanel leftSidePanel = page(LeftSidePanel.class);
        final NewMessagePopUp newMessagePopUp = page(NewMessagePopUp.class);

        leftSidePanel.composeButtonClick();
        newMessagePopUp
                .setRecipientEmail("automation192020@gmail.com")
                .setSubject("Test subj")
                .setMessage("Lorem ipsum dolor sit amet")
                .clickSendButton();
        inboxPage.informationalTooltip().shouldHave(Condition.exactText("View message"));
        inboxPage.getNamesOfSenders().shouldHave(CollectionCondition.texts("me"));
        inboxPage.selectLetterCheckbox(true)
                .clickOnDeleteButton()
                .getConfirmationTextOfDeletedLetter()
                .shouldHave(Condition.text("Conversation moved to Bin"))
                .waitUntil(Condition.disappear, 15000);
    }
}