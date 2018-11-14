package OOP.program;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

import java.awt.*;

public class runDice extends GraphicsProgram {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 960;
    private static final int NUMBER_OF_VALUES = 7;
    private static final int SQUARE_SIZE = 50;
    private static final int MAX_TIMES = 10;
    private static final int MAX_NUMBER_DICES = 8;

    private int xStartCoordinate;
    private int yStartCoordinate;
    private int NumberOfDices;
    private int Times;
    private int distance = 20;
    private int ScoreOfPlayer1, ScoreOfPlayer2;
    private String Nickname1, Nickname2;
    IODialog dialog = new IODialog();
    private GLabel P1label;
    private GLabel P2label;

    public void run() {
        this.setSize(WIDTH, HEIGHT);
        GLine line = new GLine((int)(WIDTH / 2), 0, (int)(WIDTH / 2), HEIGHT);
        add(line);
        this.Nickname1 = dialog.readLine("Enter your name, player1: ");
        this.Nickname2 = dialog.readLine("And you, player 2: ");
        String answer;
        do {
            do {
                NumberOfDices = dialog.readInt("Enter the number of dices: ");
            } while (NumberOfDices <= 0 || NumberOfDices > MAX_NUMBER_DICES);
            xStartCoordinate = ((WIDTH / 2) - (NumberOfDices * (SQUARE_SIZE + distance))) / 2;
            do {
                Times = dialog.readInt("Enter the iterations: ");
            } while (Times <= 0 || Times > MAX_TIMES);
            yStartCoordinate = ((HEIGHT) - (Times * (SQUARE_SIZE + distance))) / 4;

            drawDesk();
            showResults();

            do {
                answer = dialog.readLine("Do you want to play one more time? (Yes/No)");
            } while (!(answer.equals("No")) && !(answer.equals("Yes")));
            if (answer.equals("Yes")) {
                this.removeAll();
                line = new GLine((int)(WIDTH / 2), 0, (int)(WIDTH / 2), HEIGHT);
                add(line);
                ScoreOfPlayer2 = ScoreOfPlayer1 = 0;
            } else if (answer.equals("No")) {
                exit();
            }
        } while (!answer.equals("No"));
    }

    private void drawDesk() {
        for (int xAxis = 0, xDiff = xStartCoordinate; xAxis < NumberOfDices; xAxis++, xDiff += SQUARE_SIZE + distance) {
            for (int yAxis = 0, yDiff = yStartCoordinate; yAxis < Times; yAxis++, yDiff += SQUARE_SIZE + distance) {
                Dice dice = generateDice(xDiff, yDiff);
                dice.drawDice();
                ScoreOfPlayer1 += dice.value;
            }
        }

        for (int xAxis = 0, xDiff = xStartCoordinate + (WIDTH / 2); xAxis < NumberOfDices; xAxis++, xDiff += SQUARE_SIZE + distance) {
            for (int yAxis = 0, yDiff = yStartCoordinate; yAxis < Times; yAxis++, yDiff += SQUARE_SIZE + distance) {
                Dice dice = generateDice(xDiff, yDiff);
                dice.drawDice();
                ScoreOfPlayer2 += dice.value;
            }
        }
    }

    public void showResults(){
        String stats1 = Nickname1 + " scored: " + ScoreOfPlayer1;
        P1label = new GLabel(stats1);
        P1label.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 24));
        add(P1label, WIDTH / 4 - stats1.length(), 50 );

        String stats2 = Nickname2 + " scored: " + ScoreOfPlayer2;
        P2label = new GLabel(stats2);
        P2label.setFont(new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 24));
        add(P2label, WIDTH / 4 * 3 - stats2.length(), 50);

        if(ScoreOfPlayer1 > ScoreOfPlayer2){
            dialog.println( Nickname1 + " is winner! Congrats!");
        } else if(ScoreOfPlayer1 < ScoreOfPlayer2){
            dialog.println(Nickname2 + " is winner! Congrats!");
        } else {
            dialog.println("Draw!");
        }
    }

    public Dice generateDice(int xDiff, int yDiff) {
        int value = (int) (Math.random() * NUMBER_OF_VALUES);
        Dice dice = new OnePointDice(new GRect(xDiff, yDiff, SQUARE_SIZE, SQUARE_SIZE), this.getGCanvas());;
        switch (value) {
            case 1:
                dice = new OnePointDice(new GRect(xDiff, yDiff, SQUARE_SIZE, SQUARE_SIZE), this.getGCanvas());
                break;
            case 2:
                dice = new TwoPointsDice(new GRect(xDiff, yDiff, SQUARE_SIZE, SQUARE_SIZE), this.getGCanvas());
                break;
            case 3:
                dice = new ThreePointsDice(new GRect(xDiff, yDiff, SQUARE_SIZE, SQUARE_SIZE), this.getGCanvas());
                break;
            case 4:
                dice = new FourPointsDice(new GRect(xDiff, yDiff, SQUARE_SIZE, SQUARE_SIZE), this.getGCanvas());
            case 5:
                dice = new FivePointsDice(new GRect(xDiff, yDiff, SQUARE_SIZE, SQUARE_SIZE), this.getGCanvas());
            case 6:
                dice = new SixPointsDice(new GRect(xDiff, yDiff, SQUARE_SIZE, SQUARE_SIZE), this.getGCanvas());
            case 7:
                dice = new SevenPointsDice(new GRect(xDiff, yDiff, SQUARE_SIZE, SQUARE_SIZE), this.getGCanvas());
            default:
                break;
        }
        return dice;
    }

}
