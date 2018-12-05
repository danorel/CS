package OOP.program;

import acm.graphics.GCanvas;
import acm.graphics.GOval;
import acm.graphics.GRect;

import java.awt.*;

public abstract class Dice{
    private static final int SQUARE_SIZE = 50;
    private static final int DIAMETER = SQUARE_SIZE/5;
    private static final int RADIUS = DIAMETER/2;
    public int value;
    protected GOval point;
    protected GCanvas canvas;
    protected GRect frame;

    Dice(int value, GRect rect, GCanvas canvas){
        this.canvas = canvas;
        frame = new GRect(rect.getX(), rect.getY(), SQUARE_SIZE, SQUARE_SIZE);
        frame.setFilled(true);
        frame.setFillColor(Color.RED);
        canvas.add(frame);
        this.value = value;
    }

    abstract void drawDice();

    protected void setMiddlePoint(int x, int y) {
        x += SQUARE_SIZE / 2 - RADIUS;
        y += SQUARE_SIZE / 2 - RADIUS;
        point = new GOval(x, y, DIAMETER, DIAMETER);
        point.setFilled(true);
        point.setFillColor(Color.BLACK);
        canvas.add(point);
    }

    protected void setMiddleRightPoint(int x, int y) {
        setMiddlePoint(x + (SQUARE_SIZE/4), y);
    }

    protected void setMiddleLeftPoint(int x, int y){
        setMiddlePoint(x - (SQUARE_SIZE/4), y);
    }

    protected void setTopRightPoint(int x, int y){
        setMiddlePoint(x + (SQUARE_SIZE/4), y - (SQUARE_SIZE/4));
    }

    protected void setTopLeftPoint(int x, int y){
        setMiddlePoint(x - (SQUARE_SIZE/4), y - (SQUARE_SIZE/4));
    }

    protected void setLowLeftPoint(int x, int y){
        setMiddlePoint(x - (SQUARE_SIZE/4), y + (SQUARE_SIZE/4));
    }

    protected void setLowRightPoint(int x, int y){
        setMiddlePoint(x + (SQUARE_SIZE/4), y + (SQUARE_SIZE/4));
    }
}
