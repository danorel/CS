package dev.airship;

import acm.graphics.GCompound;
import acm.graphics.GObject;

public abstract class Target extends GCompound {
    abstract public GObject draw();
}
