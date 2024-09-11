package com.aston.automation.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

public class ApplicationManager {
    private static ApplicationManager instance;
    private static WebDriver wd;
    private static JavascriptExecutor js;
    private static Browser browser;

    private SessionHelper sessionHelper;
    private MainPageHelper mainPageHelper;
    private BasketHelper basketHelper;
    private ProductsHelper productsHelper;
    private NavigationHelper navigationHelper;

    private ApplicationManager(Browser browser) {
        this.browser = browser;
    }

    // Метод для получения единственного экземпляра ApplicationManager (с потокобезопасностью)
    public static synchronized ApplicationManager getInstance(Browser browser) {
        if (instance == null) {
            instance = new ApplicationManager(browser);
        }
        return instance;
    }

    // Метод для получения драйвера
    public static synchronized WebDriver getWebDriver() {
        if (wd == null) {
            switch (browser.browserName()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    wd = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    wd = new EdgeDriver();
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    wd = new ChromeDriver();
                    break;
            }
        }
        return wd;
    }


    // Инициализация вспомогательных классов
    public void init() {
        wd = getWebDriver();

        wd.manage().window().maximize();
        js = (JavascriptExecutor) wd;

        wd.get("https://www.wildberries.ru/");

        sessionHelper = new SessionHelper();
        mainPageHelper = new MainPageHelper();
        basketHelper = new BasketHelper();
        productsHelper = new ProductsHelper();
        navigationHelper = new NavigationHelper();

        sessionHelper.disableCookies();

    }

    // Метод для остановки драйвера и очистки ресурсов
    public void stop() {
        if (wd != null) {
            wd.quit();
            wd = null;
        }
    }

    public MainPageHelper main() {
        return mainPageHelper;
    }

    public BasketHelper basket() {
        return basketHelper;
    }

    public ProductsHelper products() {
        return productsHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }
}
