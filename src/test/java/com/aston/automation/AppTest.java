package com.aston.automation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest extends TestBase {

    @BeforeEach
    public void scrollPage() {
        scrollPage(By.xpath(getOnlineReplenishment()));
    }

    //1. Проверить название указанного блока;
    @Test
    public void CheckNameOnlineBlockTest() {
        WebElement blockOnline = findElement(By.xpath(getOnlineReplenishment()));
        String blockOnlineText = blockOnline.getText().replace("\n", " ");

        assertThat(blockOnlineText).contains("Онлайн пополнение без комиссии");
    }

    //2. Проверить наличие логотипов платёжных систем;
    @Test
    public void CheckPresencePaymentSystemLogos() {
        List<WebElement> payPartners = findElements(By.cssSelector("[class='pay__partners'] li img"));

        ArrayList<String> expectedPartners = new ArrayList<>(Arrays.asList("Visa", "Verified By Visa", "MasterCard",
                "MasterCard Secure Code", "Белкарт", "МИР"));

        ArrayList<String> actualPartners = new ArrayList<>();

        for (WebElement payPartner : payPartners) {
            String name = payPartner.getAttribute("alt");
            assertTrue(payPartner.isDisplayed(), "Партнер " + name + " не отображается");

            actualPartners.add(name);
        }
        assertEquals(expectedPartners, actualPartners, "Партнеры не совпадают");
    }

    //3. Проверить работу ссылки «Подробнее о сервисе»;
    @Test
    public void CheckMoreDetailsAboutTheServiceTest() {
        WebElement linkService = findElement(By.cssSelector("a[href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));

        if (linkService.isDisplayed()) {
            linkService.click();
        }
        assertTrue(getPageTitle().contains("Порядок оплаты и безопасность интернет платежей"));


    }

    // 4. Заполнить поля и проверить работу кнопки
    //   «Продолжить» (проверяем только вариант «Услуги
    //   связи», номер для теста 297777777)
    @Test
    public void typeFieldsAndCheckButtonTest() {
        PayData payData = new PayData("Услуги связи", "297777777", "200", "123@com.com");

        assertTrue(submitData(payData).isDisplayed());
    }
}