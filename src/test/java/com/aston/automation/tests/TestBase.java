package com.aston.automation.tests;

import com.aston.automation.appmanager.ApplicationManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.Browser;

public class TestBase {
    protected static ApplicationManager app;

    @BeforeAll
    static void setupTest() {
        // Выбор браузера CHROME, FIREFOX, EDGE
        app = ApplicationManager.getInstance(Browser.CHROME);
        app.init();
    }

    @AfterAll
    static void tearDown() {
        app.stop();
    }
}
