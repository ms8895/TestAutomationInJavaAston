package com.aston.automation.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    By headerForProductsOnBasket = By.xpath("//h1[@class='basket-section__header basket-section__header--main active']");
    By headerWithoutProductsOnBasket = By.xpath("//h1[@class='section-header basket-empty__title']");
    By orderProductsButton = By.name("ConfirmOrderByRegisteredUser");
    By mainPageAdditionalButton = By.xpath("//*[@class='basket-empty__btn btn-main']");
    By basketButton = By.cssSelector("a[href='/lk/basket']");
    By productsOnMainPage = By.cssSelector(".main-page__content");
    By headerSignInForm = By.xpath("//*[@id='spaAuthForm']/h2");
    By signInButton = By.xpath("//*[@data-wba-header-name='Login']");
    By headerMainPageButton = By.cssSelector("a[data-wba-header-name=Main]");

    /**
     * Метод открывает корзину.
     *
     * @return вернет true если корзина открыта
     */
    public boolean basketPage() {

        if ((isElementVisible(headerForProductsOnBasket, 1) && isElementPresent(orderProductsButton))
                || (isElementVisible(headerWithoutProductsOnBasket, 1) && isElementVisible(mainPageAdditionalButton, 1))) {
            logger.info("Корзина открыта.");
            return true;
        } else {
            logger.info("Корзина не открыта, нажать на кнопку корзины.");
            click(basketButton);
            return false;

        }
    }

    /**
     * Метод открывает главную страницу.
     */
    public void mainPage() {
        if (!isElementPresent(productsOnMainPage)) {
            return;
        }
        click(headerMainPageButton);
    }

    /**
     * Метод открывает страницу авторизации.
     */
    public void signPage() {
        if (isElementPresent(headerSignInForm)) {
            return;
        } else {
            click(signInButton);
        }
    }
}
