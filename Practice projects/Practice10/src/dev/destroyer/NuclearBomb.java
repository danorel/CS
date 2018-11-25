package dev.destroyer;

import acm.graphics.GOval;

public class NuclearBomb extends Bomb {
    public static final int RADIUS = 20;
    private double velocity = 5.0;

    public NuclearBomb() {
        GOval bomb = new GOval(2 * RADIUS, 2 * RADIUS);
        markAsComplete();
    }

    public NuclearBomb(double x, double y) {
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
        return "Speed: " + this.velocity + "\nRadius: " + RegularBomb.RADIUS + "\n";
    }
}
