package dev.destroyer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SpaceShip {

    public double horizontalVelocity = 2.0;
    public double verticalVelocity = 0.0;

    public static final int width = 700;
    public static final int height = 408;
    public static final int SCALE = 6;

    public int x, y;
    public int w, h;

    private Image spaceShip;

    public SpaceShip() {
        loadImage();
    }

    private void loadImage() {
        ImageIcon ImgIcon = new ImageIcon("src/image/plane_models/plane_model_1_right.jpg");
        spaceShip = ImgIcon.getImage();

        w = spaceShip.getWidth(null) / SCALE;
        h = spaceShip.getHeight(null) / SCALE;

        spaceShip = spaceShip.getScaledInstance(width / SCALE, height / SCALE, 1);
    }

    public void move(){
        x += horizontalVelocity;
        y += verticalVelocity;
    }

    public int getCurrentX(){
        return x;
    }

    public int getCurrentY(){
        return y;
    }

    public int getWidth(){
        return w;
    }

    public int getHeight(){
        return h;
    }

    public Image getImage(){
        return spaceShip;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            horizontalVelocity = 2;
            verticalVelocity = 0;
        }
        if(key == KeyEvent.VK_LEFT){
            horizontalVelocity = -2;
            verticalVelocity = 0;
        }
        if(key == KeyEvent.VK_UP){
            horizontalVelocity = 0;
            verticalVelocity = 2;
        }
        if(key == KeyEvent.VK_DOWN){
            horizontalVelocity = 0;
            verticalVelocity = -2;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            horizontalVelocity = 0;
            verticalVelocity = 0;
        }
        if(key == KeyEvent.VK_LEFT){
            horizontalVelocity = 0;
            verticalVelocity = 0;
        }
        if(key == KeyEvent.VK_UP){
            horizontalVelocity = 0;
            verticalVelocity = 0;
        }
        if(key == KeyEvent.VK_DOWN){
            horizontalVelocity = 0;
            verticalVelocity = 0;
        }
    }
}
