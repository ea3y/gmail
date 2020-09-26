import com.codeborne.selenide.Condition;
import com.google.pageobject.*;
import com.google.pageobject.panels.LeftSidePanel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public class SendEmailTest {

    private final SignInPage signIn = new SignInPage();
    private final WelcomePage welcomePage = new WelcomePage();
    private final NewMessagePopUp newMessagePopUp = new NewMessagePopUp();
    private final InboxPage inboxPage = new InboxPage();
    private final LeftSidePanel leftSidePanel = new LeftSidePanel();
    private final SentPage sentPage = new SentPage();
    private final MessagePage messagePage = new MessagePage();

    @BeforeTest
    void beforeTests() {
        open("https://accounts.google.com/signin/v2/identifier?service=mail");
        signIn.setEmail("automation192020").clickNextButton();
        welcomePage.setPassword("gfhjkzytn123").clickNextButton();
    }

    @Test
    void sendEmail() {
        leftSidePanel.clickComposeButton();
        newMessagePopUp.newMessagePopup().waitUntil(Condition.appears, 10000);
        newMessagePopUp.setRecipientEmail("automation192020@gmail.com")
                .setSubject("Test subj")
                .setMessage("Lorem ipsum dolor sit amet")
                .clickSendButton();
        inboxPage.informationalTooltip().waitUntil(Condition.text("View message"), 10000);
        inboxPage.informationalTooltip()
                .waitUntil(Condition.appears, 5000)
                .shouldHave(Condition.exactText("View message"));
    }

    @Test
    void checkTheMessageHasCorrectInformation() {
        inboxPage.openMessage();
        messagePage.getTitleOfMessage().shouldHave(Condition.text("Test subj"));

    }

    @Test
    void inboxShouldHaveSendersName() {
        assertTrue(inboxPage.getNamesOfSenders().get(0).contains("me"));
//        inboxPage.elemCollection().filterBy(Condition.text("me")).shouldHave(CollectionCondition.texts("me", "me", "me"));
    }

    @Test
    void sentShouldHaveRecipientsName() {
        leftSidePanel.clickSentLink();
        assertTrue(sentPage.getNamesOfSenders().get(0).contains("me"));
    }

    @Test
    void deleteReceivedMessage() {
        inboxPage.selectCheckBox()
                .clickOnDeleteButton()
                .getConfirmationTextOfDeletedLetter()
                .shouldHave(Condition.text("Conversation moved to Bin"))
                .waitUntil(Condition.disappear, 10000);
//        inboxPage.elemCollection().filterBy(Condition.text("me")).shouldHave(CollectionCondition.size(0));
    }

    @Test
    void deleteLetterOfSpecificAuthor() {
        inboxPage.lettersPanelCollection().filterBy(Condition.text("In Bloom")).first();
//        inboxPage.clickOnDeleteButton();
//        inboxPage.lettersPanelCollection().

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}