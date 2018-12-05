package OOP.program;

import acm.graphics.GCanvas;
import acm.graphics.GRect;

public class SixPointsDice extends Dice {

    SixPointsDice(GRect rectangle, GCanvas InsertInCanvas){
        super(6, rectangle, InsertInCanvas);
    }

    @Override
    public void drawDice() {
        setLowLeftPoint((int)frame.getX(), (int)frame.getY());
        setLowRightPoint((int)frame.getX(), (int)frame.getY());
        setTopRightPoint((int)frame.getX(), (int)frame.getY());
        setTopLeftPoint((int)frame.getX(), (int)frame.getY());
        setMiddleLeftPoint((int)frame.getX(), (int)frame.getY());
        setMiddleRightPoint((int)frame.getX(), (int)frame.getY());
    }
}
