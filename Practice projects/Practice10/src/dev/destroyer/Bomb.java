package dev.destroyer;

import acm.graphics.*;

public abstract class Bomb extends GCompound {
    abstract public void setVelocity(double velocity);
    abstract public double getVelocity();
    abstract public int getRadius();
    abstract public String toString();
    abstract public String getNumberOfProduct();
}