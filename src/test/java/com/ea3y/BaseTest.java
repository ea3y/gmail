package com.ea3y;

import com.codeborne.selenide.Configuration;
import com.selenium.web.common.ScreenAllureExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({ScreenAllureExtension.class})
public abstract class BaseTest {

    @BeforeAll
    static void beforeTests() {
        Configuration.baseUrl = "https://accounts.google.com";
    }
}
