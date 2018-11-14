package OOP.program;

import acm.graphics.GCanvas;
import acm.graphics.GRect;

public class FourPointsDice extends Dice {
    FourPointsDice(GRect rectangle, GCanvas InsertInCanvas){
        super(4, rectangle, InsertInCanvas);
    }

    @Override
    public void drawDice() {
        setLowLeftPoint((int)frame.getX(), (int)frame.getY());
        setLowRightPoint((int)frame.getX(), (int)frame.getY());
        setTopRightPoint((int)frame.getX(), (int)frame.getY());
        setTopLeftPoint((int)frame.getX(), (int)frame.getY());
    }
}
