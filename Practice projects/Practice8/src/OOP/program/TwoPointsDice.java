package OOP.program;

import acm.graphics.GCanvas;
import acm.graphics.GRect;

public class TwoPointsDice extends Dice {

    TwoPointsDice(GRect rectangle, GCanvas InsertInCanvas){
        super(2, rectangle, InsertInCanvas);
    }

    @Override
    public void drawDice() {
        setMiddleLeftPoint((int)frame.getX(), (int)frame.getY());
        setMiddleRightPoint((int)frame.getX(), (int)frame.getY());
    }
}
