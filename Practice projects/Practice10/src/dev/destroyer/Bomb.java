package dev.destroyer;

import acm.graphics.*;

public class Bomb extends GCompound {
    public static final int RADIUS = 15;

    /** Creates a new ball with radius r centered at the origin */
    public Bomb() {
        GOval bomb = new GOval(2 * RADIUS, 2 * RADIUS);
        bomb.setFilled(true);
        add(bomb, -RADIUS, -RADIUS);
        markAsComplete();
    }

    /** Creates a new ball with radius r centered at (x, y) */
    public Bomb(double x, double y) {
        setLocation(x, y);
    }

}