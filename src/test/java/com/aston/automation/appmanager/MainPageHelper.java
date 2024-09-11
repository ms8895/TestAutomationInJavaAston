package com.aston.automation.appmanager;

import com.aston.automation.model.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class MainPageHelper extends HelperBase {
    String positionProductOnMainPage = ".main-page__product[data-card-index='%d']";
    String productPreviewButton = ".main-page__product[data-card-index='%d'] .product-card__fast-view";
    By productPreviewForm = By.cssSelector(".product");
    By sizesProduct = By.cssSelector(".product__sizes");
    By sizesProductList = By.xpath("//*[@class='j-size sizes-list__button']");
    By nameProduct = By.cssSelector(".product__brand-name + span");
    By costProduct = By.cssSelector(".price-block__final-price");
    By addProductToBasketButton = By.xpath("//button[contains(@class, 'btn-main') and contains(@class, 'order__button')]/..");
    By closeQuickPreviewButton = By.cssSelector("a[href='#']");

    public List<ProductData> productData = new ArrayList<>();

    public MainPageHelper() {
        super();
    }

    /**
     * Метод для добавления одного товара в корзину из быстрого просмотра.
     *
     * @param positionProduct позиция товара на главной странице
     */
    public void addProductFromPreview(int positionProduct) {
        openPreview(new ProductData(positionProduct), actions);

        clickAddToBasketOnPreview();

        ProductData productData = getProductDetails();
        if (productData != null) {
            this.productData.add(productData);
        }

        closePreview();
    }

    /**
     * Метод открывает быстрый просмотр товара на главной странице.
     *
     * @param productData позиция товара на главной странице
     * @param actions     объект Actions для наведения курсора на элемент и щелчок мышью
     */
    public void openPreview(ProductData productData, Actions actions) {
        try {
            WebElement productElement = wd.findElement(By.cssSelector(String.format(positionProductOnMainPage, productData.getPosition())));
            js.executeScript("arguments[0].scrollIntoView();", productElement);
            actions.moveToElement(productElement).perform();
            click(By.cssSelector(String.format(productPreviewButton, productData.getPosition())));
        } catch (NoSuchElementException e) {
            logger.error("Ошибка при открытии быстрого просмотра товара: " + e.getMessage());
        }
    }

    /**
     * Метод добавляет товар с выбором размера если есть в корзину.
     */
    public void clickAddToBasketOnPreview() {
        if (isElementClickable(sizesProduct, 1)) {
            click(sizesProductList);
            clickButtonAddToBasket();
        } else {
            clickButtonAddToBasket();
        }
    }

    /**
     * Метод нажимает на кнопку "Добавить в корзину" в быстром просмотре на главной странице
     */
    public void clickButtonAddToBasket() {
        click(addProductToBasketButton);
    }

    /**
     * Метод добавляет наименование товара и его стоимость в коллекцию из попапа быстрого просмотра на главной странице.
     *
     * @return список с товарами
     */
    public ProductData getProductDetails() {
        try {
            if (isElementVisible(nameProduct, 3) && isElementPresent(productPreviewForm)) {

                WebElement productNameElement = wd.findElement(nameProduct);
                String productNameToString = productNameElement.getText().trim();
                WebElement productCostElement = wd.findElement(costProduct);

                logger.info("Наименование товара с превью: " + productNameToString + "\n" + "Стоимость товара с превью: " + getPriceInt(productCostElement));
                return new ProductData(productNameToString, getPriceInt(productCostElement));
            } else {
                throw new NoSuchElementException("Элемент с наименованием товара не найден.");
            }
        } catch (NoSuchElementException e) {
            logger.error("Ошибка при получении данных о товаре: ", e);
            return null;
        }
    }

    /**
     * Метод для закрытия быстрого просмотра товара на главной странице.
     */
    private void closePreview() {
        click(closeQuickPreviewButton);
    }
}

