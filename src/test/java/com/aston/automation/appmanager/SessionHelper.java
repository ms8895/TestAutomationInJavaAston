package com.aston.automation.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class SessionHelper extends HelperBase {

    public SessionHelper() {
        super();
    }

    /**
     * Метод отключает cookies.
     */
    public void disableCookies() {
        try {
            WebElement cookiesElement = wd.findElement(By.cssSelector(".cookies"));
            ((JavascriptExecutor) wd).executeScript("arguments[0].style.display='none';", cookiesElement);
        } catch (NoSuchElementException e) {
            logger.info("Элемент cookies не найден, продолжаем выполнение теста.");
        }
    }
}
