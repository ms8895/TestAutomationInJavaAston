package com.aston.automation.appmanager;

import com.aston.automation.model.ProductData;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsHelper extends HelperBase {
    public ProductsHelper() {
        super();
    }

    /**
     * Метод складывает суммы товаров добавленных с быстрого просмотра.
     *
     * @param productsData список добавленных товаров в корзину
     * @return возвращает итоговую сумму товаров
     */
    public String totalPriceFromPreview(List<ProductData> productsData) {
        int total = 0;

        for (ProductData oneOfProductData : productsData) {
            total += oneOfProductData.getPrice();
        }
        return Integer.toString(total);
    }

    /**
     * Метод сортирует список товаров
     *
     * @return возвращает отсортированный список
     */
    public List<ProductData> sortByNameAndPrice(List<ProductData> productData) {
        return productData.stream()
                .sorted(new ProductData.NameComparator().thenComparing(new ProductData.PriceComparator()))
                .collect(Collectors.toList());
    }
}
