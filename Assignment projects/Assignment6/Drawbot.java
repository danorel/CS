import acm.io.IODialog;
import acm.program.GraphicsProgram;
import acm.graphics.*;
import java.awt.*;

public class Drawbot extends GraphicsProgram {

    public void run(){
        IODialog dialog = new IODialog();
        int width = 0;
        int height = 1;
        // Program normal working height: 400, width: 800
        do{
            do{
                height = dialog.readInt("Enter height of the window:");
                if(height < 200 || height > 600) {
                    println("Enter height from 200 to 600.");
                }
            } while(height < 200 || height > 600);
            do{
                width = dialog.readInt("Enter width of the window:");
                if(width < 400 || width > 800) {
                    println("Enter width from 400 to 800.");
                }
            } while(width < 400 || width > 800);
            if(height > width) {
                println(height + "(height) is greater than " + width + "(width). Enter params one more time");
            }
        } while(height > width);

        setSize(width, height);
        final int HEAD_WIDTH = Math.round(width/8) * 3;
        final int HEAD_HEIGHT = Math.round(height/8);
        GRect GR = new GRect(HEAD_WIDTH, HEAD_HEIGHT, Math.round(width/8) * 2, HEAD_HEIGHT * 6);
        GR.setFilled(true);
        GR.setFillColor(Color.GRAY);
        add(GR);

        final int EYE_RADIUS = Math.round(width/18);
        int xPointOvalOne =(width/64)*32;
        int yPointOvalOne =(height/16)*5;
        GOval GO_One = new GOval(xPointOvalOne - Math.round(width/20), yPointOvalOne, EYE_RADIUS, EYE_RADIUS);
        GO_One.setFilled(true);
        GO_One.setFillColor(Color.CYAN);
        add(GO_One);

        int xPointOvalTwo =(width/64)*34;
        int yPointOvalTwo =(height/16)*5;
        GOval GO_Two = new GOval(xPointOvalTwo, yPointOvalTwo, EYE_RADIUS,  EYE_RADIUS);
        GO_Two.setFilled(true);
        GO_Two.setFillColor(Color.RED);
        add(GO_Two);

        final int MOUTH_WIDTH = (width/16) * 7;
        final int MOUTH_HEIGHT = (height/16)*10;
        int xMT = (width / 32) * 4;
        int yMT = (height / 32) * 4;
        GRect GSmile = new GRect(MOUTH_WIDTH, MOUTH_HEIGHT, xMT, yMT);
        GSmile.setFilled(true);
        GSmile.setFillColor(Color.WHITE);
        add(GSmile);
    }
}
