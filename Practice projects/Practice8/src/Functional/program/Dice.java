package Functional.program;

import acm.graphics.*;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Dice extends GraphicsProgram {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 960;
    private static final int NUMBER_OF_VALUES = 7;
    private static final int SQUARE_SIZE = 50;
    private static final int DIAMETER = SQUARE_SIZE/5;
    private static final int RADIUS = SQUARE_SIZE/10;
    private static final int MAX_TIMES = 10;
    private static final int MAX_NUMBER_DICES = 8;

    private int xStartCoordinate;
    private int yStartCoordinate;
    private int NumberOfDices;
    private int Times;
    private int distance = 20;
    private int ScoreOfPlayer1, ScoreOfPlayer2;
    private String Nickname1, Nickname2;

    private IODialog dialog = new IODialog();
    private GOval circle;
    private GLabel P1label;
    private GLabel P2label;

    public void run(){
        this.setSize(WIDTH, HEIGHT);
        GLine line = new GLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        add(line);
        this.Nickname1 = dialog.readLine("Enter your name, player1: ");
        this.Nickname2 = dialog.readLine("And you, player 2: ");
        String answer;
        int value;
        do {
            do{
                NumberOfDices = dialog.readInt("Enter the number of dices: ");
            } while(NumberOfDices <= 0 || NumberOfDices > MAX_NUMBER_DICES);
            xStartCoordinate = ((WIDTH / 2) - (NumberOfDices * (SQUARE_SIZE + distance)))/2;
            do {
                Times = dialog.readInt("Enter the iterations: ");
            } while(Times <= 0 || Times > MAX_TIMES);
            yStartCoordinate = ((HEIGHT) - (Times * (SQUARE_SIZE + distance)))/4;

            buildBoard(this.Nickname1);
            String stats1 = Nickname1 + " scored: " + ScoreOfPlayer1;
            P1label = new GLabel(stats1);
            P1label.setFont(new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 24));
            add(P1label, WIDTH / 4 - stats1.length(), 50 );

            buildBoard(this.Nickname2);
            String stats2 = Nickname2 + " scored: " + ScoreOfPlayer2;
            P2label = new GLabel(stats2);
            P2label.setFont(new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 24));
            add(P2label, WIDTH / 4 * 3 - stats2.length(), 50);

            showResults();

            do {
                answer = dialog.readLine("Do you want to play one more time? (Yes/No)");
            } while(!(answer.equals("No")) && !(answer.equals("Yes")));
            if(answer.equals("Yes")){
                clearBoard();
            } else if(answer.equals("No")){
                exit();
            }
        } while(!answer.equals("No"));
    }

    private void showResults(){
        if(ScoreOfPlayer1 > ScoreOfPlayer2){
            dialog.println(Nickname1 + " is winner! Congrats!");
        } else if(ScoreOfPlayer2 > ScoreOfPlayer1){
            dialog.println(Nickname2 + " is winner! Congrats!");
        } else {
            dialog.println("Draw!");
        }
    }

    private void buildBoard(String nickname) {
        int value;
        if(nickname.equals(Nickname1)){
            for(int xAxis = 0, xDiff = xStartCoordinate; xAxis < NumberOfDices; xAxis++, xDiff += SQUARE_SIZE + distance){
                for(int yAxis = 0, yDiff = yStartCoordinate; yAxis < Times; yAxis++, yDiff += SQUARE_SIZE + distance){
                    value = 1 + (int)(Math.random() * NUMBER_OF_VALUES);
                    this.ScoreOfPlayer1 += value;
                    drawDice(xDiff, yDiff, value);
                }
            }
        } else if(nickname.equals(Nickname2)){
            for(int xAxis = 0, xDiff = xStartCoordinate + WIDTH/2; xAxis < NumberOfDices; xAxis++, xDiff += SQUARE_SIZE + distance){
                for(int yAxis = 0, yDiff = yStartCoordinate; yAxis < Times; yAxis++, yDiff += SQUARE_SIZE + distance){
                    value = 1 + (int)(Math.random() * NUMBER_OF_VALUES);
                    this.ScoreOfPlayer2 += value;
                    drawDice(xDiff, yDiff, value);
                }
            }
        }
    }

    private void clearBoard() {
        ScoreOfPlayer1 = 0;
        ScoreOfPlayer2 = 0;
        removeAll();
        GLine line = new GLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        add(line);
    }

    public void drawDice(int x, int y, int value){
        GRect dice = new GRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
        dice.setFilled(true);
        dice.setFillColor(Color.CYAN);
        add(dice);
        x += SQUARE_SIZE / 2 - RADIUS;
        y += SQUARE_SIZE / 2 - RADIUS;
        switch(value) {
            case 1:
                setMiddlePoint(x, y);
                break;
            case 2:
                setMiddleLeftPoint(x, y);
                setMiddleRightPoint(x, y);
                break;
            case 3:
                setMiddlePoint(x, y);
                setTopRightPoint(x, y);
                setLowLeftPoint(x, y);
                break;
            case 4:
                setLowLeftPoint(x, y);
                setTopRightPoint(x, y);
                setLowRightPoint(x ,y);
                setTopLeftPoint(x, y);
                break;
            case 5:
                setLowLeftPoint(x, y);
                setTopRightPoint(x, y);
                setLowRightPoint(x ,y);
                setTopLeftPoint(x, y);
                setMiddlePoint(x, y);
                break;
            case 6:
                setLowLeftPoint(x, y);
                setTopRightPoint(x, y);
                setLowRightPoint(x ,y);
                setTopLeftPoint(x, y);
                setMiddleLeftPoint(x, y);
                setMiddleRightPoint(x, y);
                break;
            case 7:
                setLowLeftPoint(x, y);
                setTopRightPoint(x, y);
                setLowRightPoint(x ,y);
                setTopLeftPoint(x, y);
                setMiddleLeftPoint(x, y);
                setMiddleRightPoint(x, y);
                setMiddlePoint(x,y);
            default:
                break;
        }
    }

    private void setMiddlePoint(int x, int y) {
        circle = new GOval(x, y, DIAMETER, DIAMETER);
        circle.setFilled(true);
        circle.setFillColor(Color.BLACK);
        add(circle);
    }

    private void setMiddleRightPoint(int x, int y) {
        setMiddlePoint(x + (SQUARE_SIZE/4), y);
    }

    private void setMiddleLeftPoint(int x, int y){
        setMiddlePoint(x - (SQUARE_SIZE/4), y);
    }

    private void setTopRightPoint(int x, int y){
        setMiddlePoint(x + (SQUARE_SIZE/4), y - (SQUARE_SIZE/4));
    }

    private void setTopLeftPoint(int x, int y){
        setMiddlePoint(x - (SQUARE_SIZE/4), y - (SQUARE_SIZE/4));
    }

    private void setLowLeftPoint(int x, int y){
        setMiddlePoint(x - (SQUARE_SIZE/4), y + (SQUARE_SIZE/4));
    }

    private void setLowRightPoint(int x, int y){
        setMiddlePoint(x + (SQUARE_SIZE/4), y + (SQUARE_SIZE/4));
    }
}
