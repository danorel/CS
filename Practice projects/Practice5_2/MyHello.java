import acm.graphics.*;
import acm.program.*;

import java.awt.*;

public class MyHello extends GraphicsProgram{

	public void run(){
		int Height = 400;
		int Width = 400;
		this.setSize(Width, Height);
		GLabel Gl = new GLabel("Hello, world", Width / 4 + 66, Height / 2 + 5);
		Gl.setFont("TimesNewRoman-14");
		Gl.setColor(Color.BLUE);
		add(Gl);

		int k = 5;
		double R = Height / 10;
		double xR = R / Math.sqrt(2);

		GOval GO1 = new GOval(Width / 2 - (Width / 5)/2, Height / 2 - (Width / 5)/2,  Width/ 5, Height / 5);

        GOval GO2 = new GOval(Width / 2 - k * (Width / 5)/2, Height / 2 - k* (Height / 5)/2,  k* (Width / 5), k * (Height / 5));

        GLine GLD1 = new GLine(0,0, Width / 2 - xR , Height /2 - xR);
        add(GLD1);
        GLine GLD2 = new GLine(0, Height, Width / 2 - xR , Height / 2 + xR);
        add(GLD2);
        GLine GLD3 = new GLine( Width , 0, Width / 2 + xR , Height / 2 - xR);
        add(GLD3);
        GLine GLD4 = new GLine( Width, Height, Width / 2 + xR , Height / 2 + xR);
        add(GLD4);

        GRect GR1 = new GRect(Height /2 - xR ,Height /2 - xR,2*xR,2*xR);
        add(GR1);

        GO1.setFillColor(Color.CYAN);
        add(GO1);
        GO2.setFillColor(Color.CYAN);
        add(GO2);



	}
}
