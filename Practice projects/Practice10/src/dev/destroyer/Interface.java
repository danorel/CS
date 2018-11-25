package dev.destroyer;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Interface extends GraphicsProgram {
    private IODialog dialog = new IODialog();

    private int AmountOfTargets;
    private int AmountOfNuclearBombs = 1;
    private int AmountOfRegularBombs;
    private int currentBomb = 0;

    private  static final int WIDTH = 640;
    private  static final int HEIGHT = 480;
    private  static final int PAUSE_TIME = 20;
    private  int DestroyedTargets = 0;

    private  GImage PLANE;
    private  Plane destroyer;
    private ArrayList<Bomb> bombs;
    private  GObject GraphicObject;
    private  GPoint bombPoint;
    private  Target[] targets;

    private static final int PLANE_START_COORDINATE_X = 0;
    private static final int PLANE_START_COORDINATE_Y = 20;

    private  static final double SCALE = 0.25;
    private  boolean isLeftPressed = false;
    private  boolean isRightPressed = false;

    public void run(){
        this.setSize(WIDTH, HEIGHT);

        AmountOfTargets = WIDTH / 100;
        AmountOfRegularBombs = AmountOfTargets;
        targets = new Target[AmountOfTargets];
        for(int BuildingCounter = 0, DistanceBetweenBuildings = 0; BuildingCounter < targets.length; BuildingCounter++, DistanceBetweenBuildings += (WIDTH / AmountOfTargets)){
            targets[BuildingCounter] = new Building(DistanceBetweenBuildings, HEIGHT);
            add(targets[BuildingCounter].draw());
        }

        destroyer = new Plane();
        bombs = new ArrayList<>();
        for(int counter = 0; counter < AmountOfNuclearBombs; counter++){
            bombs.add(new NuclearBomb(Integer.toString(counter + 1)));
        }
        for(int counter = 0; counter < AmountOfRegularBombs; counter++){
            bombs.add(new RegularBomb(Integer.toString(counter + 1)));
        }
        bombPoint = new GPoint();
        PLANE = new GImage(destroyer.rightPath, PLANE_START_COORDINATE_X, PLANE_START_COORDINATE_Y);
        PLANE.scale(SCALE);
        add(PLANE);
        addKeyListeners();
    }

    public void keyPressed(KeyEvent event){
        if(event.getKeyCode() == 10){
            launchBomb();
            bombs.get(currentBomb).setColor(Color.BLACK);
            bombs.get(currentBomb).setVisible(true);
            add(bombs.get(currentBomb));
            if(getElementAt(PLANE.getX(), HEIGHT - 50) instanceof GRect){
                while(bombs.get(currentBomb).getY() + RegularBomb.RADIUS < (getElementAt(PLANE.getX(), HEIGHT - 50).getHeight())){
                    bombs.get(currentBomb).move(0, bombs.get(currentBomb).getVelocity());
                    add(bombs.get(currentBomb));
                    pause(PAUSE_TIME);
                }
                System.out.println(getElementAt(PLANE.getX(), HEIGHT - 50));
                GraphicObject = (getElementAt(PLANE.getX(), HEIGHT - 50));
                if(bombs.get(currentBomb) instanceof RegularBomb){
                    remove(GraphicObject);
                    DestroyedTargets++;
                } else if(bombs.get(currentBomb) instanceof NuclearBomb){
                    removeAllComponents();
                    DestroyedTargets = AmountOfTargets;
                }
                bombs.remove(currentBomb);
                if(DestroyedTargets >= AmountOfTargets){
                    dialog.println("Congratulations! YOU're a REAL destroyer!");
                    this.exit();
                }
            } else {
                dialog.println("MISS!");
                bombs.remove(currentBomb);
                if(bombs.size() == 0){
                    dialog.println("Sorry! YOU've lost ALL your bombs! WASTED");
                    dialog.println("Amount of alive buildings is " + (AmountOfTargets - DestroyedTargets));
                    this.exit();
                }
            }
        } else if(event.getKeyCode() == 37 || event.getKeyCode() == 38 || event.getKeyCode() == 39 || event.getKeyCode() == 40) {
            remove(PLANE);

            if (event.getKeyCode() == 37) {
                PLANE = new GImage(destroyer.leftPath, PLANE.getX(), PLANE.getY());
                PLANE.move(-destroyer.horizontalVelocity, 0);
                isLeftPressed = true;
                isRightPressed = false;
            }

            if (event.getKeyCode() == 39) {
                PLANE = new GImage(destroyer.rightPath, PLANE.getX(), PLANE.getY());
                PLANE.move(destroyer.horizontalVelocity, 0);
                isRightPressed = true;
                isLeftPressed = false;
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

    public void showListOfBombs(){
        int counter = 0;
        String allBombs = "";
        while(counter != bombs.size() - 1){
            allBombs += (Integer.toString(counter + 1) + ". " + bombs.get(counter) + "\n");
            counter++;
        }
        dialog.println(allBombs);
    }

    public void launchBomb(){
        showListOfBombs();
        currentBomb = dialog.readInt("Enter the number of bomb, you would like to launch. Answer: ");
        currentBomb--;
    }
}
