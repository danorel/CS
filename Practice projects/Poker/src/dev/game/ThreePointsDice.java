package OOP.program;

import acm.graphics.GCanvas;
import acm.graphics.GRect;

public class ThreePointsDice extends Dice {
    ThreePointsDice(GRect rectangle, GCanvas InsertInCanvas){
        super(3, rectangle, InsertInCanvas);
    }

    @Override
    public void drawDice() {
        setLowLeftPoint((int)frame.getX(), (int)frame.getY());
        setMiddlePoint((int)frame.getX(), (int)frame.getY());
        setTopRightPoint((int)frame.getX(), (int)frame.getY());
    }
}
