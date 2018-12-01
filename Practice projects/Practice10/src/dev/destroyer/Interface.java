package dev.destroyer;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Interface extends GraphicsProgram {
    private IODialog dialog = new IODialog();

    private int AmountOfTargets;

    private  static final int WIDTH = 640;
    private  static final int HEIGHT = 480;
    private  static final double PAUSE_TIME = 20;

    private  GImage PLANE;
    private  Plane destroyer;
    private ArrayList<Bomb> bombs;
    private  GObject GraphicObject;
    private  GPoint bombPoint;
    private  Target[] targets;
    private  GPoint lastPoint;

    private GObject object;

    private static final int PLANE_START_COORDINATE_X = 0;
    private static final int PLANE_START_COORDINATE_Y = 100;

    private  static final double SCALE = 0.05;

    public void run(){
        this.setSize(WIDTH, HEIGHT);

        AmountOfTargets = WIDTH / 100;
        targets = new Target[AmountOfTargets];
        for(int BuildingCounter = 0, DistanceBetweenBuildings = 0; BuildingCounter < targets.length; BuildingCounter++, DistanceBetweenBuildings += (WIDTH / AmountOfTargets)){
            targets[BuildingCounter] = new Building(DistanceBetweenBuildings, HEIGHT);
            add(targets[BuildingCounter].draw());
        }

        destroyer = new Plane();
        PLANE = new GImage(destroyer.rightPath, PLANE_START_COORDINATE_X, PLANE_START_COORDINATE_Y);
        PLANE.scale(SCALE);
        add(PLANE);

        while(true){
            if(PLANE.getX() + PLANE.getWidth() >= this.getWidth()){
                PLANE.setLocation(PLANE_START_COORDINATE_X, PLANE.getY());
            }
            if(destroyer.verticalVelocity == 0){
                PLANE = new GImage(destroyer.rightPath, PLANE.getX(), PLANE.getY());
                PLANE.scale(SCALE);
            } else if(destroyer.verticalVelocity == 3){
                PLANE = new GImage(destroyer.bottomRightPath, PLANE.getX(), PLANE.getY());
                PLANE.scale(SCALE);
            } else if(destroyer.verticalVelocity == -3){
                PLANE = new GImage(destroyer.topRightPath, PLANE.getX(), PLANE.getY());
                PLANE.scale(SCALE);
            }
            PLANE.move(destroyer.horizontalVelocity, destroyer.verticalVelocity);
            pause(PAUSE_TIME);
            add(PLANE);
            addKeyListeners();
        }
    }

    public void keyPressed(KeyEvent event){
        if (event.getKeyCode() == 38) {
            destroyer.horizontalVelocity = 2;
            destroyer.verticalVelocity = -3;
        }

        if (event.getKeyCode() == 40) {
            destroyer.horizontalVelocity = 2;
            destroyer.verticalVelocity = 3;
        }

        if(event.getKeyCode() == 39){
            destroyer.horizontalVelocity = 3;
            destroyer.verticalVelocity = 0;
        }
    }
}
