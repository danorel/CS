package dev.destroyer;

import acm.graphics.GCompound;
import acm.graphics.GObject;

public abstract class Target extends GCompound {
    protected static final int RGB_MAX = 255;
    protected static final int RGB_MIN = 0;

    abstract public GObject draw();
}
