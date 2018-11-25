package dev.destroyer;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Interface extends GraphicsProgram {
    private int Amount;
    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private GImage PLANE;
    private GImage BOMB;
    private Plane plane;
    private Bomb bomb;
    private GObject gobj;
    private GPoint last;

    private double scale = 0.25;
    private boolean isLeftPressed = false;
    private boolean isRightPressed = false;

    public void run(){
        this.setSize(WIDTH, HEIGHT);
        Amount = WIDTH / 100;
        Target[] targets = new Target[Amount];
        for(int counter = 0, xDifference = 0; counter < targets.length; counter++, xDifference += (WIDTH / Amount)){
            targets[counter] = new Target(xDifference, HEIGHT);
            add(targets[counter].draw());
        }

        plane = new Plane();
        bomb = new Bomb();
        PLANE = new GImage(plane.rightPath, 0, 20);
        PLANE.scale(scale);
        add(PLANE);
        addMouseListeners();
        addKeyListeners();
    }

    public void mousePressed(MouseEvent e) {
        last = new GPoint(e.getPoint());
        gobj = getElementAt(last);
    }

    public void mouseDragged(MouseEvent e) {
        if (gobj == PLANE) {
            gobj.move(e.getX() - last.getX(), e.getY() - last.getY());
            last = new GPoint(e.getPoint());
        }
    }

    public void keyPressed(KeyEvent e) {
//        38 - top, 40 - bottom, 39 - right, 37 - left

        if(e.getKeyCode() == 10){
            BOMB = new GImage(bomb.Path, PLANE.getX(), PLANE.getY());
            BOMB.scale(scale);
            add(BOMB);
            while(BOMB.getY() < getHeight()){
                remove(BOMB);
                BOMB = new GImage(bomb.Path, BOMB.getX(), BOMB.getY());
                BOMB.move(0, bomb.verticalVelocity);
                pause(100);
                add(BOMB);
            }
        } else if(e.getKeyCode() == 37 || e.getKeyCode() == 38 || e.getKeyCode() == 39 || e.getKeyCode() == 40){
            remove(PLANE);

            if(e.getKeyCode() == 37){
                PLANE = new GImage(plane.leftPath, PLANE.getX(), PLANE.getY());
                PLANE.move(-plane.horizontalVelocity, 0);
                isLeftPressed = true;
            }

            if(e.getKeyCode() == 39){
                PLANE = new GImage(plane.rightPath, PLANE.getX(), PLANE.getY());
                PLANE.move(plane.horizontalVelocity, 0);
                isRightPressed = true;
            }

            if(isLeftPressed && e.getKeyCode() == 38){
                PLANE = new GImage(plane.topLeftPath, PLANE.getX(), PLANE.getY());
                PLANE.move(-plane.horizontalVelocity, -plane.verticalVelocity);
            }

            if(isRightPressed && e.getKeyCode() == 38){
                PLANE = new GImage(plane.topRightPath, PLANE.getX(), PLANE.getY());
                PLANE.move(plane.horizontalVelocity, -plane.verticalVelocity);
            }

            if(isRightPressed && e.getKeyCode() == 40){
                PLANE = new GImage(plane.bottomRightPath, PLANE.getX(), PLANE.getY());
                PLANE.move(plane.horizontalVelocity, plane.verticalVelocity);
            }

            if(isLeftPressed && e.getKeyCode() == 40){
                PLANE = new GImage(plane.bottomLeftPath, PLANE.getX(), PLANE.getY());
                PLANE.move(-plane.horizontalVelocity, plane.verticalVelocity);
            }

            PLANE.scale(scale);
            pause(20);
            add(PLANE);
        }
    }
}
