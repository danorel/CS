import acm.io.IODialog;
import acm.program.GraphicsProgram;
import acm.graphics.*;
import java.awt.*;

public class Target extends GraphicsProgram {

    private final int WIDTH = 640;
    private final int HEIGHT = 480;
    private int XCenter = WIDTH / 2;
    private int YCenter = HEIGHT / 2;
    private int Diameter = 400;
    private int Radius = Diameter / 2;
    private GOval oval;

    public void run(){
        this.setSize(WIDTH, HEIGHT);
        int circles = 1;
        IODialog dialog = new IODialog();
        do{
            dialog.println("Enter the number of circles. Task 'Target' contains 3 circles.");
            circles = dialog.readInt();
            if(circles <= 0){
                dialog.println("Fatal Error! Re-enter the number of circles: task 'Target' contains 3 circles.");
            }
        } while(circles <= 0);

        int label = 0;
        for(int counter = 0; counter < circles; counter++) {
            if(counter % 2 == 0) {
                    oval = new GOval(XCenter - Radius / (Math.pow(2, counter)), YCenter - Radius / (Math.pow(2, counter)), Diameter / (Math.pow(2, counter)), Diameter / (Math.pow(2, counter)));
                    oval.setFilled(true);
                    oval.setFillColor(Color.red);
                    add(oval);
            } else {
                oval = new GOval(XCenter - Radius / (Math.pow(2, counter)), YCenter - Radius/ (Math.pow(2, counter)), Diameter / (Math.pow(2, counter)), Diameter / (Math.pow(2, counter)));
                oval.setFilled(true);
                oval.setFillColor(Color.white);
                add(oval);
            }
        }
    }
}

