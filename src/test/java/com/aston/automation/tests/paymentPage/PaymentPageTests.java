package com.aston.automation.tests.paymentPage;

import com.aston.automation.model.PayData;
import com.aston.automation.model.PayDescriptionData;
import com.aston.automation.tests.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class PaymentPageTests extends TestBase {
    /*2. Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
   нажать кнопку «Продолжить» и в появившемся окне
   2.1 проверить корректность отображения суммы (в том числе на кнопке),
   2.2 номера телефона,
   2.3 а также надписей в незаполненных полях для ввода реквизитов карты,
   2.4 наличие иконок платёжных систем.*/
    private PayData payData;
    private PayDescriptionData payDescriptionData;

    @BeforeEach
    public void setUp() {
        payData = new PayData("Услуги связи", "297777777", "200", "123@com.com");
        payDescriptionData = new PayDescriptionData();
        scrollPage(By.xpath(getOnlineReplenishment()));

        boolean isFormOpened = isFormOpened(payData);
        assumeTrue(isFormOpened, "Форма не открылась, тесты пропущены.");
    }

    @Test
    public void shouldDisplayCorrectSumInTitle() {
        WebElement sumTitle = findElement(By.xpath(payDescriptionData.getSumTitle()));
        String onlySum = sumTitle.getText().replaceAll("[^0-9.]", "");
        assertEquals("200.00", onlySum);
    }

    @Test
    public void shouldDisplayCorrectPhoneNumber() {
        WebElement numberTitle = findElement(By.xpath(payDescriptionData.getPayDescriptionText()));
        String onlyNumber = numberTitle.getText().replaceAll("[^0-9.]", "");
        assertEquals("375297777777", onlyNumber);
    }

    @Test
    public void shouldDisplayCorrectSumOnButton() {
        WebElement sumButton = findElement(By.xpath(payDescriptionData.getSumButton()));
        String onlySum = sumButton.getText().replaceAll("[^0-9.]", "");
        assertEquals("200.00", onlySum);
    }

    @Test
    public void shouldDisplayPlaceholderForCardNumberField() {
        WebElement cardNumber = findElement(By.xpath(payDescriptionData.getСardNumber()));
        assertEquals("Номер карты", cardNumber.getText());
    }

    @Test
    public void shouldDisplayPlaceholderForCardPeriodField() {
        WebElement cardPeriod = findElement(By.xpath(payDescriptionData.getCardPeriod()));
        assertEquals("Срок действия", cardPeriod.getText());
    }

    @Test
    public void shouldDisplayPlaceholderForCvcCodeField() {
        WebElement cvcCode = findElement(By.xpath(payDescriptionData.getCvcCode()));
        assertEquals("CVC", cvcCode.getText());
    }

    @Test
    public void shouldDisplayPlaceholderForHolderNameField() {
        WebElement holderName = findElement(By.xpath(payDescriptionData.getHolderName()));
        assertEquals("Имя держателя (как на карте)", holderName.getText());
    }

    @Test
    public void gpayButtonShouldBeClickable() {
        boolean isClickable = elementIsClickable(payDescriptionData.getButtonGpay());
        assertTrue(isClickable, "Кнопка GPay кликабельна");
    }

    @Test
    public void ypayButtonShouldBeClickable() {
        boolean isClickable = elementIsClickable(payDescriptionData.getButtonYpay());
        assertTrue(isClickable, "Кнопка ЯPay кликабельна");
    }
}
