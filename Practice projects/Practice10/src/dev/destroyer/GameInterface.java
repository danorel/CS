package dev.destroyer;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

import java.awt.event.KeyEvent;

public class GameInterface extends GraphicsProgram {

    private int WIDTH;
    private int HEIGHT;
    private static final double PAUSE_TIME = 20;

    private  GImage PLANE_IMAGE;
    private  Plane AIRPLANE;

    private GImage BACKGROUND_IMAGE;

    private static final int PLANE_START_COORDINATE_X = 0;
    private static final int PLANE_START_COORDINATE_Y = 100;

    private static final double SCALE = 0.25;

    public GameInterface(int WIDTH, int HEIGHT){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
    }

    public void run(){
        this.start();
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        start_game();
    }

    private void start_game(){

        BACKGROUND_IMAGE = new GImage(Background.PATH);
        add(BACKGROUND_IMAGE);

        AIRPLANE = new Plane();
        PLANE_IMAGE = new GImage(AIRPLANE.rightPath, PLANE_START_COORDINATE_X, PLANE_START_COORDINATE_Y);
        PLANE_IMAGE.scale(SCALE);
        add(PLANE_IMAGE);

        while(true){
            if(PLANE_IMAGE.getX() + PLANE_IMAGE.getWidth() >= this.getWidth()){
                PLANE_IMAGE.setLocation(PLANE_START_COORDINATE_X, PLANE_IMAGE.getY());
            }
            if(AIRPLANE.verticalVelocity == 0){
                PLANE_IMAGE = new GImage(AIRPLANE.rightPath, PLANE_IMAGE.getX(), PLANE_IMAGE.getY());
                PLANE_IMAGE.scale(SCALE);
            } else if(AIRPLANE.verticalVelocity == 3){
                PLANE_IMAGE = new GImage(AIRPLANE.bottomRightPath, PLANE_IMAGE.getX(), PLANE_IMAGE.getY());
                PLANE_IMAGE.scale(SCALE);
            } else if(AIRPLANE.verticalVelocity == -3){
                PLANE_IMAGE = new GImage(AIRPLANE.topRightPath, PLANE_IMAGE.getX(), PLANE_IMAGE.getY());
                PLANE_IMAGE.scale(SCALE);
            }
            PLANE_IMAGE.move(AIRPLANE.horizontalVelocity, AIRPLANE.verticalVelocity);
            pause(PAUSE_TIME);
            add(PLANE_IMAGE);
            addKeyListeners();
        }
    }

    public void keyPressed(KeyEvent event){
        if (event.getKeyCode() == 38) {
            AIRPLANE.horizontalVelocity = 2;
            AIRPLANE.verticalVelocity = -3;
        }

        if (event.getKeyCode() == 40) {
            AIRPLANE.horizontalVelocity = 2;
            AIRPLANE.verticalVelocity = 3;
        }

        if(event.getKeyCode() == 39){
            AIRPLANE.horizontalVelocity = 3;
            AIRPLANE.verticalVelocity = 0;
        }
    }
}
