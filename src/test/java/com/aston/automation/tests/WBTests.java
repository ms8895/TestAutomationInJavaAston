package com.aston.automation.tests;

import com.aston.automation.model.ProductData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WBTests extends TestBase {

    @BeforeEach
    public void ensurePrecondition() {
        // Удаление товаров в корзине если они есть

        app.goTo().basketPage();
        if (app.basket().isEmpty(2)) {
            app.goTo().mainPage();
        } else {
            app.basket().deleteProducts();
            app.main().productData.clear();
            app.goTo().mainPage();
        }
        // Добавление товаров в корзину для тестов
        // Список товаров начинается с нуля
        app.main().addProductFromPreview(3);
        app.main().addProductFromPreview(7);
    }

    @Test
    @DisplayName("Пункт 1, 3. Проверка наименования и цены товаров при добавлении и на странице корзины")
    public void testNameAndCost() {
        List<ProductData> sortedProductsFromPreview = app.products().sortByNameAndPrice(app.main().productData);
        app.goTo().basketPage();
        List<ProductData> basketProducts = app.basket().addProductsToSortedCollection();

        assertTrue(sortedProductsFromPreview.equals(basketProducts),
                "Списки товаров при добавлении в корзину и на странице корзины не совпадают.");
    }

    @Test
    @DisplayName("Пункт 2. Проверка количества товаров в корзине после добавления.")
    public void testQuantity() {
        app.goTo().basketPage();
        System.out.println("Товары в itemsData перед сравнением " + app.main().productData);
        assertTrue(app.basket().compareQuantities(app.main().productData),
                "Количество товаров при добавлении не совпадает с количеством на странице корзины.");
    }

    @Test
    @DisplayName("Пункт 4. Сравнение общей цены товаров при добавлении и на странице корзины")
    public void testTotalPrice() {
        List<ProductData> sortedProductsFromPreview = app.products().sortByNameAndPrice(app.main().productData);
        String totalPriceProductsFromPreview = app.products().totalPriceFromPreview(sortedProductsFromPreview);

        app.goTo().basketPage();
        String totalPriceInBasket = app.basket().totalPrice(2);

        assertEquals(totalPriceProductsFromPreview, totalPriceInBasket);

    }
}
