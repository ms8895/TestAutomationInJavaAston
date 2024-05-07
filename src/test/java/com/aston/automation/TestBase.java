package com.aston.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestBase {
    private WebDriver wd;
    private final String urlMTS = "https://www.mts.by/";

    private final String onlineReplenishment = "//h2[contains(text(),'Онлайн пополнение')]";

    public String getOnlineReplenishment() {
        return onlineReplenishment;
    }

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setupTest() {
        wd = new ChromeDriver();
        wd.get(urlMTS);
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        disableCookie();
    }

    @AfterEach
    void teardown() {
        wd.quit();
    }

    public void scrollPage(By locator) {
        WebElement element = findElement(locator);
        ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void disableCookie() {
        WebElement cookie = findElement(By.xpath("//h3[text()='Обработка файлов cookie']"));

        if (cookie.isDisplayed()) {
            click(By.xpath("//button[contains(text(),'Отклонить')]"));
        }
    }

    public WebElement findElement(By locator) {
        return wd.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return wd.findElements(locator);
    }

    public String getPageTitle() {
        return wd.getTitle();
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingTest = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingTest)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public void selectTypeServiceInList(PayData payData) {
        WebElement dropdownValueElement = findElement(By.xpath("//div[@class='pay__form']//button[@class='select__header']/span[@class='select__now']"));
        String currentDropdownValue = dropdownValueElement.getText().trim();

        if (!currentDropdownValue.equals(payData.getTypeService())) {
            click(By.xpath("//div[@class='pay__form']//button[@class='select__header']"));

            click(By.xpath("//div[@class='pay__form']//ul[@class='select__list']//p[text()='" + payData.getTypeService() + "']"));
        }
    }

    public void fillOnlineBlock(PayData payData) {
        selectTypeServiceInList(payData);

        type(By.id("connection-phone"), payData.getNumberPhone());
        type(By.id("connection-sum"), payData.getReplenishmentAmount());
        type(By.id("connection-email"), payData.getEmail());
    }

    public WebElement submitData(PayData payData) {
        fillOnlineBlock(payData);
        click(By.xpath("//*[@id='pay-connection']/button"));

        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@class='bepaid-iframe']")));
        } catch (TimeoutException e) {
            System.out.println(e);
        }
        return wd.findElement(By.xpath("//*[@aria-label='Google Pay']"));
    }
}
