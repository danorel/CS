import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;

public class NSD extends ConsoleProgram {
    private final int WIDTH = 320;
    private final int HEIGHT = 240;
    private int NOB = 8;
    private int RADIUS = 20;

    public void run(){
        this.setSize(WIDTH, HEIGHT);
        int number1 = 0, number2 = 0;
        do{
            print("Enter number 1: ");
            number1 = readInt();
            if(number1 <= 0){
                println("Re-enter number 1! Failed to assign.");
            }
        } while(number1 <= 0);

        do{
            print("Enter number 2: ");
            number2 = readInt();
            if(number2 <= 0){
                println("Re-enter number 2! Failed to assign.");
            }
        } while(number2 <= 0);

        println("NSD(" + number1 + "," + number2 + ") is " + NSD(number1, number2));
    }

    private int NSD(int value1, int value2){
        if(value1 == 0){
            return value2;
        }
        do{
            if(value1 > value2){
                value1 = value1 - value2;
            } else {
                value2 = value2 - value1;
            }
        } while(value2 != 0);
        return value1;
    }
}
