import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class Assignment5 extends GraphicsProgram{

	public void run(){
		this.setSize(800,400);
		final int deskSize = 8;
		for(int j = 0, addY = 0; j < deskSize; j++, addY += 50){
			for(int i = 0, addX = 0; i < deskSize; i++, addX += 50){
				GRect GR = new GRect(addX, addY,50,50);
				if(i % 2 == 0 && j % 2 == 1){
					GR.setFilled(true);
					GR.setFillColor(Color.BLACK);
				}
				if(i % 2 == 1 && j % 2 == 0){
					GR.setFilled(true);
					GR.setFillColor(Color.BLACK);
				}
				add(GR);
			}

		}

	}
}
