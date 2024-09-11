package com.aston.automation.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class HelperBase {
    protected WebDriver wd;
    protected JavascriptExecutor js;
    protected Actions actions;
    protected Logger logger; // Добавляем переменную логгера

    public HelperBase() {
        this.wd = ApplicationManager.getInstance(null).getWebDriver();
        this.js = (JavascriptExecutor) wd;
        this.logger = LoggerFactory.getLogger(getClass()); // Инициализируем логгер для текущего класса
        this.actions = new Actions(wd);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    /**
     * Метод преобразует текстовую стоимость веб-элемента в число.
     *
     * @param priceElement веб-элемент с текстовой стоимостью
     * @return возвращает числовое значение стоимости товара
     */
    public int getPriceInt(WebElement priceElement) {
        String itemCost = priceElement.getText().trim().replace(" ", "").split("₽")[0];

        Integer itemCost1 = getInteger(itemCost);
        if (itemCost1 != null) {
            return itemCost1;
        } else {
            return 0;
        }
    }

    /**
     * Метод преобразует строку в число
     *
     * @param string строка в формате string
     * @return возвращает строку, преобразованную в число
     */
    public Integer getInteger(String string) {
        if (!string.isEmpty()) {
            try {
                return Integer.parseInt(string);
            } catch (NumberFormatException e) {
                logger.error("Ошибка преобразования строки в число: " + e.getMessage());
            }
        }
        return null;
    }

    public boolean isElementClickable(By locator, int timeoutSeconds) {
        try {
            FluentWait<WebDriver> wait = new FluentWait<>(wd)
                    .withTimeout(Duration.ofSeconds(timeoutSeconds))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class);

            wait.until(driver -> {
                WebElement element = wd.findElement(locator);
                return element != null && element.isEnabled();
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(By locator, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(seconds));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
