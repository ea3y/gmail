package com.google.web.table;

import com.codeborne.selenide.SelenideElement;
import com.google.web.common.AbstractTable;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.page;
import static org.assertj.core.api.Assertions.assertThat;

public class LettersTable extends AbstractTable {

    private List<LetterRow> tableRows;

    public LettersTable(SelenideElement webTable) {
        super(webTable);
    }

//    public void setCheckboxOfSpecificLetter(final String subject) {
//        getTableRowWithSpecificSubject(subject).getCheckboxCell().click();
//    }

    @Override
    protected void setTableRows() {
        List<SelenideElement> rows = table.$$(By.tagName("tr"));
        tableRows = rows.stream().map(LetterRow::new).collect(Collectors.toList());
    }

    private LetterRow getTableRowWithSpecificSubject (final String subject) {
        List<LetterRow> filteredTableRows = tableRows.stream()
                .filter(r -> r.getSubjectCell().getText().equals(subject)).collect(Collectors.toList());
        assertThat(filteredTableRows.size()).isEqualTo(1);
        return filteredTableRows.get(0);
    }
}
