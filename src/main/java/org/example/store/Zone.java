package org.example.store;

public enum Zone {

    NORTH(0.173),
    SOUTH(0.122);

    final protected double discount;

    Zone(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
