package com.aston.automation.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

public class ApplicationManager {
    private Browser browser;
    WebDriver wd;
    JavascriptExecutor js;

    private SessionHelper sessionHelper;
    private MainPageHelper mainPageHelper;
    private BasketHelper basketHelper;
    private ProductsHelper productsHelper;
    private NavigationHelper navigationHelper;

    public ApplicationManager(Browser browser) {
        this.browser = browser;
    }

    public void init() {

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

        //wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wd.manage().window().maximize();
        js = (JavascriptExecutor) wd;

        wd.get("https://www.wildberries.ru/");

        sessionHelper = new SessionHelper(wd);
        mainPageHelper = new MainPageHelper(wd);
        basketHelper = new BasketHelper(wd);
        productsHelper = new ProductsHelper(wd);
        navigationHelper = new NavigationHelper(wd);

        sessionHelper.disableCookies();
    }

    public void stop() {
        wd.quit();
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
