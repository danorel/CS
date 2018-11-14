package OOP.program;

import acm.graphics.GCanvas;
import acm.graphics.GRect;

public class OnePointDice extends Dice {

    OnePointDice(GRect rectangle, GCanvas InsertInCanvas){
        super(1, rectangle, InsertInCanvas);
    }

    @Override
    public void drawDice() {
        setMiddlePoint((int)frame.getX(), (int)frame.getY());
    }
}
