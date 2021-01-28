import com.codeborne.selenide.Selenide;
import com.selenium.web.common.Listener;
import com.selenium.web.pages.MainPage;
import com.selenium.web.panels.BasicTablePanel;
import com.selenium.web.table.Table;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({Listener.class})
public class SeleniumClientAndWebDriverLanguageBindingsTableTest {

    @Test
    public void checkTable() {
        MainPage mainPage = open("https://www.selenium.dev/downloads/", MainPage.class);
        BasicTablePanel basicTablePanel = mainPage.getTablePanel();
        Table table = basicTablePanel.getLanguageTable();

        assertAll(
                () -> assertEquals("Rubys", table.getRubyLanguageRow().getTextOfLanguageCell()),
                () -> assertEquals("3.142.6", table.getRubyLanguageRow().getTextOfStableVersionCell()),
                () -> assertEquals("October 04, 2019", table.getRubyLanguageRow().getTextOfReleaseDateCell()),
                () -> assertEquals("4.0.0alpha7", table.getRubyLanguageRow().getTextOfAlphaVersionCell()),
                () -> assertEquals("November 10, 2020", table.getRubyLanguageRow().getTextOfAlphaReleaseDateCell())

//                () -> assertEquals("Java", table.getJavaLanguageRow().getTextOfLanguageCell()),
//                () -> assertEquals("3.141.59", table.getJavaLanguageRow().getTextOfStableVersionCell()),
//                () -> assertEquals("November 14, 2018", table.getJavaLanguageRow().getTextOfReleaseDateCell()),
//                () -> assertEquals("4.0.0-alpha-7", table.getJavaLanguageRow().getTextOfAlphaVersionCell()),
//                () -> assertEquals("November 10, 2020", table.getJavaLanguageRow().getTextOfAlphaReleaseDateCell()),
//
//                () -> assertEquals("Python", table.getPythonLanguageRow().getTextOfLanguageCell()),
//                () -> assertEquals("3.141.0", table.getPythonLanguageRow().getTextOfStableVersionCell()),
//                () -> assertEquals("November 01, 2018", table.getPythonLanguageRow().getTextOfReleaseDateCell()),
//                () -> assertEquals("4.0.0.a7", table.getPythonLanguageRow().getTextOfAlphaVersionCell()),
//                () -> assertEquals("November 10, 2020", table.getPythonLanguageRow().getTextOfAlphaReleaseDateCell()),
//
//                () -> assertEquals("C#", table.getCiLanguageRow().getTextOfLanguageCell()),
//                () -> assertEquals("3.14.0", table.getCiLanguageRow().getTextOfStableVersionCell()),
//                () -> assertEquals("August 02, 2018", table.getCiLanguageRow().getTextOfReleaseDateCell()),
//                () -> assertEquals("4.0.0-alpha07", table.getCiLanguageRow().getTextOfAlphaVersionCell()),
//                () -> assertEquals("November 10, 2020", table.getCiLanguageRow().getTextOfAlphaReleaseDateCell()),
//
//                () -> assertEquals("JavaScript", table.getJavaScriptLanguageRow().getTextOfLanguageCell()),
//                () -> assertEquals("3.6.0", table.getJavaScriptLanguageRow().getTextOfStableVersionCell()),
//                () -> assertEquals("October 06, 2017", table.getJavaScriptLanguageRow().getTextOfReleaseDateCell()),
//                () -> assertEquals("4.0.0-alpha.8", table.getJavaScriptLanguageRow().getTextOfAlphaVersionCell()),
//                () -> assertEquals("December 04, 2020", table.getJavaScriptLanguageRow().getTextOfAlphaReleaseDateCell())
        );
        table.getRubyLanguageRow().getLinksCell().getDownloadLink().click();
        assertThat(Selenide.title()).as("Ruby titles")
                .contains("selenium-webdriver | RubyGems.org | your community gem host");
    }
}
