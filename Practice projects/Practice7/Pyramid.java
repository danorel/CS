import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Pyramid extends GraphicsProgram {
    private final int HEIGHT_OF_BRICK = 16;
    private final int WIDTH_OF_BRICK = 40;
    private final int NUMBER_OF_BRICKS = 16;
    private final int WIDTH = 640;
    private final int HEIGHT = 480;
    private GRect gRect;

    public void run(){
        this.setSize(WIDTH, HEIGHT);
        int locationX = WIDTH / 2;
        int locationY = HEIGHT;
        int counter = NUMBER_OF_BRICKS;
        do{
            buildWall(counter, locationX, locationY);
            counter -= 1;
            locationY -= HEIGHT_OF_BRICK;
        } while(counter != 0);
    }

    public void buildWall(int NumberOfBricks, int locX, int locY){
        if(NumberOfBricks % 2 == 0){
            for(int counter = 0, locationX = locX, locationY = locY; counter < (NumberOfBricks / 2); counter++){
                gRect = new GRect(locationX, (locationY - HEIGHT_OF_BRICK), WIDTH_OF_BRICK, HEIGHT_OF_BRICK);
                gRect.setFilled(true);
                gRect.setFillColor(Color.BLUE);
                add(gRect);
                locationX += WIDTH_OF_BRICK;
            }

            for(int counter = 0, locationX = locX, locationY = locY; counter < NumberOfBricks / 2; counter++){
                gRect = new GRect(locationX, (locationY - HEIGHT_OF_BRICK), WIDTH_OF_BRICK, HEIGHT_OF_BRICK);
                gRect.setFilled(true);
                gRect.setFillColor(Color.YELLOW);
                add(gRect);
                locationX -= WIDTH_OF_BRICK;
            }
        } else {
            for(int counter = 0, locationX = locX + (WIDTH_OF_BRICK / 2), locationY = locY; counter < (NumberOfBricks / 2); counter++){
                gRect = new GRect(locationX, (locationY - HEIGHT_OF_BRICK), WIDTH_OF_BRICK, HEIGHT_OF_BRICK);
                gRect.setFilled(true);
                gRect.setFillColor(Color.BLUE);
                add(gRect);
                locationX += WIDTH_OF_BRICK;
            }

            for(int counter = 0, locationX = locX - (WIDTH_OF_BRICK / 2), locationY = locY; counter < NumberOfBricks / 2; counter++){
                gRect = new GRect(locationX, (locationY - HEIGHT_OF_BRICK), WIDTH_OF_BRICK, HEIGHT_OF_BRICK);
                gRect.setFilled(true);
                gRect.setFillColor(Color.YELLOW);
                add(gRect);
                locationX -= WIDTH_OF_BRICK;
            }
        }
    }
}
