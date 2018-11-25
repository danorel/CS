package dev.destroyer;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Interface extends GraphicsProgram {
    protected int AmountOfTargets;
    protected static final int WIDTH = 640;
    protected static final int HEIGHT = 480;
    protected static final int PAUSE_TIME = 20;

    protected GImage PLANE;
    protected Plane destroyer;
    protected Bomb bomb;
    protected GObject GraphicObject;
    protected GPoint bombPoint;
    private Target[] targets;

    private static final int PLANE_START_COORDINATE_X = 0;
    private static final int PLANE_START_COORDINATE_Y = 20;

    protected static final double SCALE = 0.25;
    protected boolean isLeftPressed = false;
    protected boolean isRightPressed = false;

    public void run(){
        this.setSize(WIDTH, HEIGHT);

        AmountOfTargets = WIDTH / 100;
        targets = new Target[AmountOfTargets];
        for(int BuildingCounter = 0, DistanceBetweenBuildings = 0; BuildingCounter < targets.length; BuildingCounter++, DistanceBetweenBuildings += (WIDTH / AmountOfTargets)){
            targets[BuildingCounter] = new Building(DistanceBetweenBuildings, HEIGHT);
            add(targets[BuildingCounter].draw());
        }

        destroyer = new Plane();
        bomb = new Bomb();
        bombPoint = new GPoint();
        PLANE = new GImage(destroyer.rightPath, PLANE_START_COORDINATE_X, PLANE_START_COORDINATE_Y);
        PLANE.scale(SCALE);
        add(PLANE);
        addKeyListeners();
    }

    public void keyPressed(KeyEvent event){
        if(event.getKeyCode() == 10){
            bomb = new Bomb(PLANE.getX(), PLANE.getY());
            bomb.setColor(Color.BLACK);
            bomb.setVisible(true);
            add(bomb);
            while(bomb.getY() + Bomb.RADIUS < getHeight()){
                bomb.move(0, 5);
                pause(PAUSE_TIME);
            }
            bombPoint.setLocation(bomb.getX(), bomb.getY());
            GraphicObject = getElement(0);
            System.out.println(GraphicObject);
            if(GraphicObject instanceof GRect){
                remove(GraphicObject);
            }
        } else if(event.getKeyCode() == 37 || event.getKeyCode() == 38 || event.getKeyCode() == 39 || event.getKeyCode() == 40) {
            remove(PLANE);

            if (event.getKeyCode() == 37) {
                PLANE = new GImage(destroyer.leftPath, PLANE.getX(), PLANE.getY());
                PLANE.move(-destroyer.horizontalVelocity, 0);
                isLeftPressed = true;
            }

            if (event.getKeyCode() == 39) {
                PLANE = new GImage(destroyer.rightPath, PLANE.getX(), PLANE.getY());
                PLANE.move(destroyer.horizontalVelocity, 0);
                isRightPressed = true;
            }

            if (isLeftPressed && event.getKeyCode() == 38) {
                PLANE = new GImage(destroyer.topLeftPath, PLANE.getX(), PLANE.getY());
                PLANE.move(-destroyer.horizontalVelocity, -destroyer.verticalVelocity);
            }

            if (isRightPressed && event.getKeyCode() == 38) {
                PLANE = new GImage(destroyer.topRightPath, PLANE.getX(), PLANE.getY());
                PLANE.move(destroyer.horizontalVelocity, -destroyer.verticalVelocity);
            }

            if (isRightPressed && event.getKeyCode() == 40) {
                PLANE = new GImage(destroyer.bottomRightPath, PLANE.getX(), PLANE.getY());
                PLANE.move(destroyer.horizontalVelocity, destroyer.verticalVelocity);
            }

            if (isLeftPressed && event.getKeyCode() == 40) {
                PLANE = new GImage(destroyer.bottomLeftPath, PLANE.getX(), PLANE.getY());
                PLANE.move(-destroyer.horizontalVelocity, destroyer.verticalVelocity);
            }

            PLANE.scale(SCALE);
            pause(PAUSE_TIME);
            add(PLANE);
        }
    }
}
