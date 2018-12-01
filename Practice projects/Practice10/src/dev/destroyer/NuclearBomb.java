package dev.destroyer;

import acm.graphics.GOval;

public class NuclearBomb extends Bomb {
    public static final int RADIUS = 20;
    private double velocity = 1.0;
    private String type = "Nuclear Bomb";
    private String NumberOfProduct;

    public NuclearBomb(String NumberOfProduct) {
        GOval bomb = new GOval(2 * RADIUS, 2 * RADIUS);
        this.NumberOfProduct = NumberOfProduct;
        markAsComplete();
    }

    public NuclearBomb(String NumberOfProduct, double x, double y) {
        this.NumberOfProduct = NumberOfProduct;
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
        return NuclearBomb.RADIUS;
    }

    @Override
    public String toString() {
        return this.type + "\nSpeed: " + this.velocity + "\nRadius: " + NuclearBomb.RADIUS + "\nNumber of product: " + getNumberOfProduct() + "\n";
    }

    @Override
    public String getNumberOfProduct() {
        return this.NumberOfProduct;
    }
}
