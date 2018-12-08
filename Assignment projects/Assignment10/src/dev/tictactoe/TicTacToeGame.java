package dev.tictactoe;

import acm.graphics.GCanvas;
import acm.graphics.GLine;
import acm.graphics.GPolygon;
import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

import java.awt.*;

//public class TicTacToeGame extends GraphicsProgram {
//    private static final int WIDTH = 480;
//    private static final int HEIGHT = 480;
//    private IODialog dialog;
//    private static final int FIELD_LENGTH = WIDTH / 3;
//
//    private static final int SIZE = 3;
//    private Frame[][] FIELDS = new Frame[SIZE][SIZE];
//
//    private String Player1, Player2;
//    public boolean isFinished = false;
//    private GCanvas canvas;
//
//    public void init(){
//        dialog = new IODialog();
//        initNicknames();
//    }
//
//    private void initNicknames() {
//        do{
//            Player1 = dialog.readLine("What's your nickname, player1?");
//        } while(Player1.equals(""));
//        do{
//            Player2 = dialog.readLine("And yours, player2?");
//        } while(Player2.equals(""));
//    }
//
//    public void run(){
//        this.setSize(WIDTH, HEIGHT);
//        createDesk();
//        createFields();
//    }
//
//    public void createDesk(){
//        GRect VER_LINE_1 = new GRect(WIDTH / 3, 0, WIDTH / 3, HEIGHT);
//        GRect VER_LINE_2 = new GRect((WIDTH / 3) * 2, 0, (WIDTH / 3) * 2, HEIGHT);
//        GRect HOR_LINE_1 = new GRect(0, HEIGHT / 3, WIDTH, HEIGHT / 3);
//        GRect HOR_LINE_2 = new GRect(0, (HEIGHT / 3) * 2, WIDTH, (HEIGHT / 3) * 2);
//        add(VER_LINE_1);
//        add(VER_LINE_2);
//        add(HOR_LINE_1);
//        add(HOR_LINE_2);
//    }
//
//    public void createFields(){
//        for(int X_AXIS = 0, X_DIFF = 0; X_AXIS < SIZE; X_AXIS++, X_DIFF += FIELD_LENGTH){
//            for(int Y_AXIS = 0, Y_DIFF = 0; Y_AXIS < SIZE; Y_AXIS++, Y_DIFF += FIELD_LENGTH){
//                FIELDS[X_AXIS][Y_AXIS] = new Frame(X_DIFF, Y_DIFF, FIELD_LENGTH, FIELD_LENGTH, this.getGCanvas());
//                add(FIELDS[X_AXIS][Y_AXIS]);
//            }
//        }
//    }
//
//    public void changeBoardState(int my_i, int my_j, int i) {
//
//    }
//}
//
//package com.glomozda.tictactoe;
//
//        import java.awt.Color;
//
//        import acm.graphics.GCanvas;
//        import acm.graphics.GLine;
//

public class TicTacToeGame {

    private GCanvas canvas;

    private Frame[][] cells = new Frame[3][3];
    private int[][] boardState = new int[3][3];
    private boolean isFinished;

    public boolean isFinished() {
        return isFinished;
    }

    public TicTacToeGame(GCanvas canvas) {
        this.canvas = canvas;
    }

    public void newGame() {
        initialSetUp();
    }

    public void changeBoardState(int i, int j, int code) {
        boardState[i][j] = code;
        int whaw = weHaveAWinner();
        if (whaw != 0) {
            isFinished = true;
            switch (whaw) {
                case 4:
                    cells[0][0].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[1][1].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[2][2].getMyObject().setFillColor(new Color(0xDC0003));
                    break;
                case -4:
                    cells[2][0].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[1][1].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[0][2].getMyObject().setFillColor(new Color(0xDC0003));
                    break;
                case 1:
                    cells[0][0].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[0][1].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[0][2].getMyObject().setFillColor(new Color(0xDC0003));
                    break;
                case 2:
                    cells[1][0].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[1][1].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[1][2].getMyObject().setFillColor(new Color(0xDC0003));
                    break;
                case 3:
                    cells[2][0].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[2][1].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[2][2].getMyObject().setFillColor(new Color(0xDC0003));
                    break;
                case -1:
                    cells[0][0].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[1][0].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[2][0].getMyObject().setFillColor(new Color(0xDC0003));
                    break;
                case -2:
                    cells[0][1].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[1][1].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[2][1].getMyObject().setFillColor(new Color(0xDC0003));
                    break;
                case -3:
                    cells[0][2].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[1][2].getMyObject().setFillColor(new Color(0xDC0003));
                    cells[2][2].getMyObject().setFillColor(new Color(0xDC0003));
                    break;
            }
        }
    }

    private int weHaveAWinner() {
        if ((boardState[0][0] == boardState[1][1]) && (boardState[1][1] == boardState[2][2])) {
            return 4;
        }

        if ((boardState[2][0] == boardState[1][1]) && (boardState[1][1] == boardState[0][2])) {
            return -4;
        }

        for (int i = 0; i < 3; i++) {
            if ((boardState[i][0] == boardState[i][1]) && (boardState[i][1] == boardState[i][2])) {
                return i + 1;
            }
            if ((boardState[0][i] == boardState[1][i]) && (boardState[1][i] == boardState[2][i])) {
                return -(i + 1);
            }
        }

        return 0;
    }

    private void initialSetUp() {

        isFinished = false;

        int x = canvas.getX();
        int y = canvas.getY();
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        int cellWidth = canvasWidth/3;
        int cellHeight = canvasHeight/3;

        GLine line = new GLine(x + cellWidth, y, x + cellWidth, y + canvasHeight);
        line.setColor(Color.BLACK);
        canvas.add(line);

        line = new GLine(x + 2*cellWidth, y, x + 2*cellWidth, y + canvasHeight);
        line.setColor(Color.BLACK);
        canvas.add(line);

        line = new GLine(x, y + cellHeight, x + canvasWidth, y + cellHeight);
        line.setColor(Color.BLACK);
        canvas.add(line);

        line = new GLine(x, y + 2*cellHeight, x + canvasWidth, y + 2*cellHeight);
        line.setColor(Color.BLACK);
        canvas.add(line);

        int counter = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Frame(x + cellWidth*i, y + cellHeight*j + 1,
                        cellWidth, cellHeight - 2, i, j);
                cells[i][j].setUpCanvas(canvas);
                cells[i][j].setUpGame(this);
                canvas.add(cells[i][j]);

                boardState[i][j] = 100 + counter++;
            }
    }
}
