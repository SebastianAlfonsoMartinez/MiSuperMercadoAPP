package org.miApp.stock;

import org.miApp.product.Product;

public class Stock {
    private Integer stock;

    public Stock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stock=" + stock +
                '}';
    }
}
