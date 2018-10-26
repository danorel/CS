import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.*;

public class ProgramHierarchi extends GraphicsProgram {
    private final int WIDTH = 640;
    private final int HEIGHT = 480;

    public void run(){
        this.setSize(WIDTH, HEIGHT);
        int width = 70;
        int height = 20;

        // SUB-RECTANGLE (MIDDLE) - CONSOLE PROGRAM
        GRect gRect = new GRect((WIDTH / 2) - width, (HEIGHT / 2 - height) , 2 * width, 3 * height);
        gRect.setFilled(true);
        gRect.setFillColor(Color.YELLOW);
        add(gRect);
        GLine gLine = new GLine((WIDTH / 2), (HEIGHT / 2) - height, WIDTH / 2, (HEIGHT / 4) + 3 * height );
        add(gLine);
        GLabel label = new GLabel("CONSOLE PROGRAM", (WIDTH / 2) - width, (HEIGHT / 2 + height));
        label.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 14));
        add(label);

        // SUB-RECTANGLE (LEFT) - GRAPHICS PROGRAM
        gRect = new GRect((WIDTH / 4) - width, (HEIGHT / 2 - height) , 2 * width, 3 * height);
        gRect.setFilled(true);
        gRect.setFillColor(Color.YELLOW);
        add(gRect);
        gLine = new GLine((WIDTH / 4), (HEIGHT / 2) - height, WIDTH / 2, (HEIGHT / 4) + 3 * height );
        add(gLine);
        label = new GLabel("GRAPHICS PROGRAM", (WIDTH / 4) - width, (HEIGHT / 2 + height));
        label.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 14));
        add(label);

        // SUB-RECTANGLE (RIGHT) - DIALOG PROGRAM
        gRect = new GRect((WIDTH / 4 * 3) - width, (HEIGHT / 2 - height) , 2 * width, 3 * height);
        gRect.setFilled(true);
        gRect.setFillColor(Color.YELLOW);
        add(gRect);
        gLine = new GLine((WIDTH / 4 * 3), (HEIGHT / 2) - height,WIDTH / 2, (HEIGHT / 4) + 3 * height );
        add(gLine);
        label = new GLabel("DIALOG PROGRAM", (WIDTH / 4 * 3)  - 0.9 * width, (HEIGHT / 2 + height));
        label.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 14));
        add(label);

        // MAIN RECTANGLE - PROGRAM
        gRect = new GRect((WIDTH / 2) - width, ((HEIGHT / 4)) , 2 * width, 3 * height);
        gRect.setFilled(true);
        gRect.setFillColor(Color.CYAN);
        add(gRect);
        label = new GLabel("PROGRAM", (WIDTH / 2) - width / 2, (HEIGHT / 4) + 1.5 * height);
        label.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 14));
        add(label);
    }
}
