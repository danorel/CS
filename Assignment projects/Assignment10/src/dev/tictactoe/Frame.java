package dev.tictactoe;

import acm.graphics.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends GRect implements MouseListener {
    private GCanvas canvas;
    private double start_x_coordinate, start_y_coordinate, width, height;
    private boolean isFree = true;
    private TicTacToeGame TTTG = new TicTacToeGame(canvas);
    private int my_i, my_j;
    private GFillable myObject;
    private static boolean shouldDrawCross = true;

    public Frame(double start_x_coordinate, double start_y_coordinate, double width, double height, int i, int j) {
        super(start_x_coordinate, start_y_coordinate, width, height);
        this.start_x_coordinate = start_x_coordinate;
        this.start_y_coordinate = start_y_coordinate;
        this.width = width;
        this.height = height;
        isFree = true;
        my_i = i;
        my_j = j;
        this.setColor(new Color(0xDC48A8));
        this.setVisible(false);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isFree && !TTTG.isFinished()) {
            if (shouldDrawCross) {
                drawCross();
                TTTG.changeBoardState(my_i, my_j, 1);
            } else {
                drawNaught();
                TTTG.changeBoardState(my_i, my_j, 2);
            }
            isFree = false;
            shouldDrawCross = !shouldDrawCross;
            this.setColor(Color.RED);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setVisible(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setVisible(false);
    }


    private void drawCross(){
        int x = (int) this.getX();
        int y = (int) this.getY();
        int width = (int) this.getWidth();
        int height = (int) this.getHeight();

        GPolygon cross = new GPolygon();
        cross.addVertex(x + width/4, y);
        cross.addVertex(x + width/2, y + height/4);
        cross.addVertex(x + 3*width/4, y);
        cross.addVertex(x + width, y + height/4);
        cross.addVertex(x + 3*width/4, y + height/2);
        cross.addVertex(x + width, y + 3*height/4);
        cross.addVertex(x + 3*width/4, y + height);
        cross.addVertex(x + width/2, y + 3*height/4);
        cross.addVertex(x + width/4, y + height);
        cross.addVertex(x, y + 3*height/4);
        cross.addVertex(x + width/4, y + height/2);
        cross.addVertex(x, y + height/4);
        cross.setFilled(true);
        cross.setFillColor(Color.BLACK);
        canvas.add(cross);
    }

    private void drawNaught() {
        int x = (int) this.getX();
        int y = (int) this.getY();
        int width = (int) this.getWidth();
        int height = (int) this.getHeight();

        GOval outerCircle = new GOval(x, y, width, height);
        outerCircle.setFilled(true);
        outerCircle.setFillColor(Color.BLACK);

        GOval innerCircle = new GOval(x + width/4, y + width/4, width/2, height/2);
        innerCircle.setFilled(true);
        innerCircle.setFillColor(Color.WHITE);

        canvas.add(outerCircle);
        canvas.add(innerCircle);

        myObject = outerCircle;
    }

    public void setUpCanvas(GCanvas canvas){
        this.canvas = canvas;
    }

    public void setUpGame(TicTacToeGame TTTG){
        this.TTTG = TTTG;
    }

    public GFillable getMyObject() {
        return myObject;
    }
}
