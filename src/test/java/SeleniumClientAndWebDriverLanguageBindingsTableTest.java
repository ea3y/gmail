import com.codeborne.selenide.Selenide;
import com.selenium.web.pages.MainPage;
import com.selenium.web.panels.BasicTablePanel;
import com.selenium.web.table.Table;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumClientAndWebDriverLanguageBindingsTableTest {

//    @BeforeAll
//    static void beforeTests() {
//    }

    @Test
    public void checkTable() throws InterruptedException {
        MainPage mainPage = open("https://www.selenium.dev/downloads/", MainPage.class);
        BasicTablePanel basicTablePanel = mainPage.getTablePanel();
        Table table = basicTablePanel.getLanguageTable();

        assertAll(
                () -> assertEquals("Ruby", table.getRubyLanguageRow().getLanguageCell()),
                () -> assertEquals("3.142.6", table.getRubyLanguageRow().getStableVersionCell()),
                () -> assertEquals("October 04, 2019", table.getRubyLanguageRow().getReleaseDateCell()),
                () -> assertEquals("4.0.0alpha7", table.getRubyLanguageRow().getAlphaVersionCell()),
                () -> assertEquals("November 10, 2020", table.getRubyLanguageRow().getAlphaReleaseDateCell()),

                () -> assertEquals("Java", table.getJavaLanguageRow().getLanguageCell()),
                () -> assertEquals("3.141.59", table.getJavaLanguageRow().getStableVersionCell()),
                () -> assertEquals("November 14, 2018", table.getJavaLanguageRow().getReleaseDateCell()),
                () -> assertEquals("4.0.0-alpha-7", table.getJavaLanguageRow().getAlphaVersionCell()),
                () -> assertEquals("November 10, 2020", table.getJavaLanguageRow().getAlphaReleaseDateCell()),

                () -> assertEquals("Python", table.getPythonLanguageRow().getLanguageCell()),
                () -> assertEquals("3.141.0", table.getPythonLanguageRow().getStableVersionCell()),
                () -> assertEquals("November 01, 2018", table.getPythonLanguageRow().getReleaseDateCell()),
                () -> assertEquals("4.0.0.a7", table.getPythonLanguageRow().getAlphaVersionCell()),
                () -> assertEquals("November 10, 2020", table.getPythonLanguageRow().getAlphaReleaseDateCell()),

                () -> assertEquals("C#", table.getCiLanguageRow().getLanguageCell()),
                () -> assertEquals("3.14.0", table.getCiLanguageRow().getStableVersionCell()),
                () -> assertEquals("August 02, 2018", table.getCiLanguageRow().getReleaseDateCell()),
                () -> assertEquals("4.0.0-alpha07", table.getCiLanguageRow().getAlphaVersionCell()),
                () -> assertEquals("November 10, 2020", table.getCiLanguageRow().getAlphaReleaseDateCell()),

                () -> assertEquals("JavaScript", table.getJavaScriptLanguageRow().getLanguageCell()),
                () -> assertEquals("3.6.0", table.getJavaScriptLanguageRow().getStableVersionCell()),
                () -> assertEquals("October 06, 2017", table.getJavaScriptLanguageRow().getReleaseDateCell()),
                () -> assertEquals("4.0.0-alpha.8", table.getJavaScriptLanguageRow().getAlphaVersionCell()),
                () -> assertEquals("December 04, 2020", table.getJavaScriptLanguageRow().getAlphaReleaseDateCell())
        );
        table.getRubyLanguageRow().getLinksCell().getDownloadLink().click();
        assertThat(Selenide.title()).as("Ruby title")
                .contains("selenium-webdriver | RubyGems.org | your community gem host");
    }
}
