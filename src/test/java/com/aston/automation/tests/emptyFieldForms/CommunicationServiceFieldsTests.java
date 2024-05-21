package com.aston.automation.tests.emptyFieldForms;

import com.aston.automation.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class CommunicationServiceFieldsTests extends TestBase {
    // 1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг:
    private Result result;

    @BeforeEach
    public void setUp() {
        scrollPage(By.xpath(getOnlineReplenishment()));
        result = getResult("Услуги связи");
        assumeTrue(result.isClickable, "Форма не кликабельна, тесты пропущены.");
    }

    @Test
    public void checkPhoneFieldTest() {
        WebElement phoneField = findElement(By.xpath(result.formsOfPaymentData.getPhoneNumberCS()));
        String placeHolderPhone = phoneField.getAttribute("placeholder").trim();
        assertEquals("Номер телефона", placeHolderPhone);
    }

    @Test
    public void checkSumFieldTest() {
        WebElement sumField = findElement(By.xpath(result.formsOfPaymentData.getSumCS()));
        String placeHolderSum = sumField.getAttribute("placeholder").trim();
        assertEquals("Сумма", placeHolderSum);
    }

    @Test
    public void checkEmailFieldTest() {
        WebElement emailField = findElement(By.xpath(result.formsOfPaymentData.getEmailCS()));
        String placeHolderEmail = emailField.getAttribute("placeholder").trim();
        assertEquals("E-mail для отправки чека", placeHolderEmail);
    }
}
