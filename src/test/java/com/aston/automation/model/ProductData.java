package com.aston.automation.model;

import java.util.Comparator;
import java.util.Objects;

public class ProductData {
    private int position;
    private String name;
    private int price;

    public ProductData(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public ProductData(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return price == that.price && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public static class NameComparator implements Comparator<ProductData> {
        public int compare(ProductData a, ProductData b) {

            return a.getName().compareTo(b.getName());
        }
    }

    public static class PriceComparator implements Comparator<ProductData> {
        public int compare(ProductData a, ProductData b) {

            return Integer.compare(a.getPrice(), b.getPrice());
        }
    }
}

