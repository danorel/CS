package dev.destroyer;

import acm.graphics.GOval;
import acm.graphics.GRect;

import java.awt.*;

public class Target {
    private int X, Y;

    private static final int MAX_BUILDING_X = 100;
    private static final int MIN_BUILDING_X = 50;

    private static final int MAX_BUILDING_Y = 400;
    private static final int MIN_BUILDING_Y = 300;

//    private static final int MAX_AIRSHIP_Y = 400;
//    private static final int MIN_AIRSHIP_Y = 300;

    private static final int RGB_MAX = 255;
    private static final int RGB_MIN = 0;
    private int xCoordinate, yCoordinate;
    GRect Building;
//    GOval AirShip;

    public Target(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public GRect draw(){
        Y = (int)(Math.random() * (MAX_BUILDING_Y - MIN_BUILDING_Y)) + MIN_BUILDING_Y;
        X = (int)(Math.random() * (MAX_BUILDING_X - MIN_BUILDING_X)) + MIN_BUILDING_X;
        Building = new GRect(xCoordinate, Y, X, (yCoordinate - 25) - Y);
        int r = (int)(Math.random() * RGB_MAX) + RGB_MIN;
        int g = (int)(Math.random() * RGB_MAX) + RGB_MIN;
        int b = (int)(Math.random() * RGB_MAX) + RGB_MIN;
        Building.setFillColor(new Color(r, g, b));
        Building.setFilled(true);
        return Building;
    }

//    public GOval draw(double Radius){
//        X = (int)(Math.random());
//        AirShip = new GOval(xCoordinate, Y, Radius, Radius);
//        AirShip.setFillColor(Color.BLACK);
//        AirShip.setFilled(true);
//        return AirShip;
//    }
}
