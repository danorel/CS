package dev.destroyer;

import acm.graphics.GOval;

public class RegularBomb extends Bomb {
    public static final int RADIUS = 15;
    private double velocity = 1.0;
    private String type = "Regular Bomb";
    private String NumberOfProduct;

    public RegularBomb(String NumberOfProduct) {
        GOval bomb = new GOval(2 * RADIUS, 2 * RADIUS);
        this.NumberOfProduct = NumberOfProduct;
        markAsComplete();
    }

    public RegularBomb(double x, double y, String NumberOfProduct) {
        this(NumberOfProduct);
        setLocation(x, y);
    }

    @Override
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    @Override
    public double getVelocity() {
        return this.velocity;
    }

    @Override
    public int getRadius() {
        return RegularBomb.RADIUS;
    }

    @Override
    public String toString() {
        return this.type + "\nSpeed: " + this.velocity + "\nRadius: " + RegularBomb.RADIUS + "\nNumber of product: " + getNumberOfProduct() + "\n";
    }

    @Override
    public String getNumberOfProduct() {
        return this.NumberOfProduct;
    }
}
