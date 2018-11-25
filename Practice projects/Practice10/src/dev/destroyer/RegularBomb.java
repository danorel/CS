package dev.destroyer;

import acm.graphics.GOval;

public class RegularBomb extends Bomb {
    public static final int RADIUS = 15;
    private double velocity = 5.0;

    public RegularBomb() {
        GOval bomb = new GOval(2 * RADIUS, 2 * RADIUS);
        markAsComplete();
    }

    public RegularBomb(double x, double y) {
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
        return "Speed: " + this.velocity + "\nRadius: " + RegularBomb.RADIUS + "\n";
    }

}
