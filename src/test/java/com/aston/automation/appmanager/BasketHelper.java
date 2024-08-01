package com.aston.automation.appmanager;

import com.aston.automation.model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BasketHelper extends HelperBase {
    //Общая цена товаров в корзине
    By totalPriceInBasket = By.cssSelector(".b-top__total span:nth-child(2) span:first-child");
    By amountProductBasket = By.cssSelector(".accordion__goods-count");
    By deleteProductButton = By.cssSelector(".btn__del.j-basket-item-del");
    By NameProductInBasket = By.cssSelector(".good-info__good-name");
    By costProductInBasket = By.cssSelector(".list-item__price-new");
    By amountProductsOnBasket = By.cssSelector(".navbar-pc__notify");

    public BasketHelper(WebDriver wd) {
        super(wd);
    }

    /**
     * Метод удаляет товары из корзины при их наличии
     */
    public void deleteProducts() {
        try {
            List<WebElement> allDeleteButtons = wd.findElements(deleteProductButton);

            for (WebElement oneOfDeleteButtons : allDeleteButtons) {
                actions.moveToElement(oneOfDeleteButtons).perform();
                oneOfDeleteButtons.click();
            }
        } catch (Exception e) {
            logger.error("Ошибка при удалении товаров из корзины: " + e.getMessage());
        }
    }

    /**
     * Метод сравнивает количество добавленных товаров в корзину со счетчиком товаров в корзине.
     *
     * @param productData список добавленных товаров в корзину
     * @return если количество товаров равно счетчику, метод вернет true
     */
    public boolean compareQuantities(List<ProductData> productData) {

        if (isElementVisible(amountProductBasket, 1)) {
            WebElement webElement = wd.findElement(amountProductBasket);
            String webElementText = webElement.getText().trim().split(" ")[0];

            Integer amountProductsBasketNumber = getInteger(webElementText);
            if (amountProductsBasketNumber != null) {
                return amountProductsBasketNumber == productData.size();
            }
        }
        return false;
    }

    /**
     * Метод для получения общей суммы товаров, посчитанной в корзине.
     *
     * @param waitingTime в течении скольки секунд ожидать появления общей цены
     * @return возвращает сумму из поля "Итого"
     */
    public String totalPrice(int waitingTime) {
        try {
            if (isElementVisible(totalPriceInBasket, waitingTime) && wd.getCurrentUrl().contains("/lk/basket")) {

                WebElement webTotalPrice = wd.findElement(totalPriceInBasket);
                String previousText = "";
                String currentText = webTotalPrice.getText();

                int stableCount = 0;
                int maxStableCount = 5;

                while (stableCount < maxStableCount) {
                    Thread.sleep(200);

                    webTotalPrice = wd.findElement(totalPriceInBasket);
                    previousText = currentText;
                    currentText = webTotalPrice.getText();

                    if (previousText.equals(currentText)) {
                        stableCount++;
                    } else {
                        stableCount = 0;
                    }
                }
                return Integer.toString(getPriceInt(webTotalPrice));
            }
        } catch (NoSuchElementException | InterruptedException e) {
            logger.warn("Элемент \"Общая сумма\" не найден или произошла ошибка ожидания. " + e.getMessage());
        }
        return "";
    }

    /**
     * Метод проверяет наличие суммы товаров в корзине
     *
     * @param waitingTime в течении скольки секунд ожидать появления общей цены
     */
    public boolean isEmpty(int waitingTime) {
        return totalPrice(waitingTime).isEmpty();
    }

    /**
     * Метод для создания списка товаров из корзины.
     *
     * @return возвращает отсортированную коллекцию товаров с наименованием и стоимостью
     */
    public List<ProductData> addProductsToSortedCollection() {
        try {
            if (isElementClickable(NameProductInBasket, 2)) {

                waitForPriceStability(costProductInBasket, 3);

                List<ProductData> productData = new ArrayList<>();
                List<WebElement> nameProductsInBasket = wd.findElements(NameProductInBasket);
                List<WebElement> costProductsInBasket = wd.findElements(costProductInBasket);

                for (int i = 0; i < nameProductsInBasket.size(); i++) {
                    String name = nameProductsInBasket.get(i).getText().trim();
                    productData.add(new ProductData(name, getPriceInt(costProductsInBasket.get(i))));
                }

                return productData.stream()
                        .sorted(new ProductData.NameComparator()
                                .thenComparing(new ProductData.PriceComparator()))
                        .collect(Collectors.toList());
            }
        } catch (Exception e) {
            logger.error("Ошибка, при добавлении товаров в коллекцию из корзины: " + e.getMessage());
        }
        return null;
    }

    /**
     * Метод для ожидания стабильной цены товаров.
     *
     * @param priceLocator   принимает локатор.
     * @param timeoutSeconds в течении скольки секунд ожидать стабильности цены.
     */
    public void waitForPriceStability(By priceLocator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(timeoutSeconds));
        wait.until(new ExpectedCondition<Boolean>() {
            private String lastPrice = "";

            @Override
            public Boolean apply(WebDriver driver) {
                WebElement priceElement = driver.findElement(priceLocator);
                String currentPrice = priceElement.getText();
                if (lastPrice.equals(currentPrice)) {
                    return true;
                } else {
                    lastPrice = currentPrice;
                    return false;
                }
            }
        });
    }

    /**
     * Метод для получения количества товаров отображаемое на иконке корзины.
     *
     * @return возвращает число товаров, отображаемое на иконке корзины
     */
    public int getBasketCount() {
        if (isElementPresent(amountProductsOnBasket)) {
            WebElement element = wd.findElement(amountProductsOnBasket);
            String amountProductsText = element.getText().trim();
            Integer amountProductsInteger = getInteger(amountProductsText);

            if (amountProductsInteger != null) {
                return amountProductsInteger;
            }
        }
        return 0;
    }
}
