package dev.destroyer;

import acm.graphics.GRect;

import java.awt.*;

public class Building extends Target {
    private int Width, Height;

    private static final int MAX_BUILDING_X = 100;
    private static final int MIN_BUILDING_X = 50;

    private static final int MAX_BUILDING_Y = 400;
    private static final int MIN_BUILDING_Y = 300;

    private static final int RGB_MAX = 255;
    private static final int RGB_MIN = 0;

    private int xCoordinate, yCoordinate;
    public GRect Building;

    public Building(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public GRect draw(){
        Height = (int)(Math.random() * (MAX_BUILDING_Y - MIN_BUILDING_Y)) + MIN_BUILDING_Y;
        Width = (int)(Math.random() * (MAX_BUILDING_X - MIN_BUILDING_X)) + MIN_BUILDING_X;
        Building = new GRect(xCoordinate, Height, Width, (yCoordinate - 25) - Height);
        int r = (int)(Math.random() * RGB_MAX) + RGB_MIN;
        int g = (int)(Math.random() * RGB_MAX) + RGB_MIN;
        int b = (int)(Math.random() * RGB_MAX) + RGB_MIN;
        Building.setFillColor(new Color(r, g, b));
        Building.setFilled(true);
        return Building;
    }
}
