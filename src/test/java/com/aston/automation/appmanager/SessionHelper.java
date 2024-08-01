package com.aston.automation.appmanager;

import org.openqa.selenium.*;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    /**
     * Метод отключает cookies.
     */
    public void disableCookies() {
        try {
            WebElement cookiesElement = wd.findElement(By.cssSelector(".cookies"));
            ((JavascriptExecutor) wd).executeScript("arguments[0].style.display='none';", cookiesElement);
        } catch (NoSuchElementException e) {
            System.out.println("Элемент cookies не найден, продолжаем выполнение теста.");
        }
    }
}
