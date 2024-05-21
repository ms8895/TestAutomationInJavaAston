package com.aston.automation.tests.emptyFieldForms;

import com.aston.automation.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class DebtFieldsTests extends TestBase {
    // 1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг:
    private Result result;

    @BeforeEach
    public void setUp() {
        scrollPage(By.xpath(getOnlineReplenishment()));
        result = getResult("Задолженность");
        assumeTrue(result.isClickable, "Форма не кликабельна, тесты пропущены.");
    }

    @Test
    public void checkAccountNumberFieldTest() {
        WebElement accountNumberField = findElement(By.xpath(result.formsOfPaymentData.getAccountNumberD()));
        String placeHolderAccountNumber = accountNumberField.getAttribute("placeholder").trim();
        assertEquals("Номер счета на 2073", placeHolderAccountNumber);
    }

    @Test
    public void checkSumFieldTest() {
        WebElement sumField = findElement(By.xpath(result.formsOfPaymentData.getSumD()));
        String placeHolderSum = sumField.getAttribute("placeholder").trim();
        assertEquals("Сумма", placeHolderSum);
    }

    @Test
    public void checkEmailFieldTest() {
        WebElement emailField = findElement(By.xpath(result.formsOfPaymentData.getEmailD()));
        String placeHolderEmail = emailField.getAttribute("placeholder").trim();
        assertEquals("E-mail для отправки чека", placeHolderEmail);
    }
}
