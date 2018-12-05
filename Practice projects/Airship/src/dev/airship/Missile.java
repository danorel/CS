package dev.airship;

import acm.graphics.GImage;

public class Missile {


    public double horizontalVelocity = 2.0;
    public double verticalVelocity = 0.0;

    private int StartXCoordinate, StartYCoordinate;
    private String src;
    private GImage Missle;

    public Missile(String src, int StartXCoordinate, int StartYCoordinate) {
        this.src = src;
        this.StartXCoordinate = StartXCoordinate;
        this.StartYCoordinate = StartYCoordinate;
        loadImage();
    }

    public void move(){
        Missle.move(horizontalVelocity, verticalVelocity);
    }

    public void shoot(){

    }

    public double getX(){
        return Missle.getX();
    }

    public double getY(){
        return Missle.getY();
    }

    private void loadImage() {
        Missle = new GImage(src, StartXCoordinate, StartYCoordinate);
        Missle.scale(0.2);
    }

    public double getWidth(){
        return Missle.getWidth();
    }

    public double getHeight(){
        return Missle.getHeight();
    }

    public GImage getImage(){
        return Missle;
    }
}
