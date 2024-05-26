package com.aston.automation.tests;

import com.aston.automation.model.FormsOfPaymentData;
import com.aston.automation.model.PayData;
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

    private final String onlineReplenishment = "//section[@class='pay']//h2";


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
        WebElement cookie = findElement(By.xpath("//div[contains(@class, 'cookie__main')]/h3"));

        if (cookie.isDisplayed()) {
            click(By.xpath("//button[contains(@class, 'cookie__cancel')]"));
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

    public void selectTypeService(String service) {
        String listServices = "//button[@class='select__header']/span";
        WebElement dropdownValueElement = findElement(By.xpath(listServices));
        String currentDropdownValue = dropdownValueElement.getText().trim();

        if (!currentDropdownValue.equals(service)) {
            click(By.xpath(listServices));
            click(By.xpath("//ul[@class='select__list']//p[text()='" + service + "']"));
        }
    }

    public void fillCommunicationService(PayData payData) {
        selectTypeService(payData.getTypeService());

        type(By.id("connection-phone"), payData.getNumberPhone());
        type(By.id("connection-sum"), payData.getAmount());
        type(By.id("connection-email"), payData.getEmail());
    }

    public WebElement submitForm(PayData payData) {
        FormsOfPaymentData formsOfPaymentData = new FormsOfPaymentData();
        String formName = payData.getFormName();
        click(By.xpath(formsOfPaymentData.getButtonContinue(formName)));

        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@class='bepaid-iframe']")));
        } catch (TimeoutException e) {
            System.out.println("Время ожидания формы оплаты: " + e.getMessage());
        }

        try {
            return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='header__close-icon']")));
        } catch (TimeoutException e) {
            System.out.println("Время ожидания кнопки закрыть: " + e.getMessage());
            return null;
        }
    }

    public Result getResult(String serviceForm) {
        PayData payData = new PayData(serviceForm);

        selectTypeService(payData.getTypeService());

        FormsOfPaymentData formsOfPaymentData = new FormsOfPaymentData();

        String formName = payData.getFormName();
        WebElement element = findElement(By.xpath(formsOfPaymentData.getButtonContinue(formName)));
        boolean isClickable = element.isEnabled();
        Result result = new Result(formsOfPaymentData, isClickable);
        return result;
    }

    protected static class Result {
        public final FormsOfPaymentData formsOfPaymentData;
        public final boolean isClickable;

        public Result(FormsOfPaymentData formsOfPaymentData, boolean isClickable) {
            this.formsOfPaymentData = formsOfPaymentData;
            this.isClickable = isClickable;
        }
    }

    public boolean isFormOpened(PayData payData) {
        try {
            fillCommunicationService(payData);
            WebElement element = submitForm(payData);
            return element != null && element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Error opening form: " + e.getMessage());
            return false;
        }
    }

    public boolean elementIsClickable(String locator) {
        try {
            WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
