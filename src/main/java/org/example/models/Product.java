package org.example.models;

import org.example.store.Zone;

public class Product {

    String nameProduct;

    double price;

    String category;

    Zone zone;

    int quantity;

    double discountValue;
    double subtotal;

    double total;

    public Product(String nameProduct, double price, String category, Zone zone, int quantity, double subtotal, double total, double discountValue) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.category = category;
        this.zone = zone;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.total = total;
        this.discountValue = discountValue;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public Product(String nameProduct, double price, String category, int quantity, double discountValue) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.discountValue = discountValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Zone getZone() {
        return zone;
    }
}
