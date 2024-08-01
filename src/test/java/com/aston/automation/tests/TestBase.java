package com.aston.automation.tests;

import com.aston.automation.appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.Browser;

public class TestBase {
    // Выбор браузера CHROME, FIREFOX, EDGE
    protected static final ApplicationManager app = new ApplicationManager(Browser.CHROME);

    @BeforeAll
    static void setupTest() {
        app.init();
    }

    @AfterAll
    static void tearDown() {
        app.stop();
    }
}
