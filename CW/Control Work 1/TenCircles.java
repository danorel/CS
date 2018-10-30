import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.io.IODialog;
import acm.program.GraphicsProgram;
//import javafx.scene.shape.Circle;

public class TenCircles extends GraphicsProgram {
    private final int WIDTH = 640;
    private final int HEIGHT = 480;

    private int NOC = 10;
    private int X = 0;
    private int Y = 0;
    private int XDiff = 0;
    private int YDiff = 0;
    private int Radius = 0;
    private GOval circle;

    public void run(){
        this.setSize(WIDTH, HEIGHT);
        int counter = 0;
        do{
//            do{
//                print("Enter the X position: ");
//                this.X = readInt();
//                if(this.X <= 0){
//                    println("Re-enter the X position: ");
//                }
//            } while(this.X <= 0);
            this.X = (int)Math.round(Math.random() * 1000);
//            do{
//                print("Enter the Y position: ");
//                this.Y = readInt();
//                if(this.Y <= 0){
//                    println("Re-enter the Y position: ");
//                }
//            } while(this.Y <= 0);
            this.Y = (int)Math.round(Math.random() * 1000);
//            do{
//                print("Enter the diameter size: ");
//                this.Radius = readInt()/2;
//                if(this.Radius <= 0){
//                    println("Re-enter your radius!");
//                }
//            } while(this.Radius <= 0);
            this.Radius = (int)Math.round(Math.random() * 200);
            addCircle();
            counter++;
        } while(counter != NOC);
    }

    private void addCircle(){
        if(this.X - this.Radius <= 0){
            this.XDiff = this.Radius - this.X;
            this.X += XDiff;
        }

        if(this.X + this.Radius >= this.getWidth()){
            this.XDiff = (this.X + this.Radius)  - this.getWidth();
            this.X -= this.XDiff;
        }

        if(this.Y - this.Radius <= 0){
            this.YDiff = this.Radius - this.Y;
            this.Y += YDiff;
        }

        if(this.Y + this.Radius >= this.getHeight()){
            this.YDiff = (this.Y + this.Radius) - this.getHeight();
            this.Y -= this.YDiff;
        }

        circle = new GOval(this.X - this.Radius, this.Y - this.Radius, 2 * this.Radius, 2 * this.Radius);
        add(circle);

        GLabel gLabel = new GLabel("Orel Danyil", 10, this.getHeight() - 20);
        add(gLabel);
    }
}
