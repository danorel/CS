import acm.io.IODialog;
import acm.program.*;
import java.util.Scanner;
import acm.program.GraphicsProgram;

public class Fibonacci extends ConsoleProgram {
    public void run() {
        // Input from the embed console:
        IODialog dialog = new IODialog();
        println("Enter the number to calculate.");
        int number = dialog.readInt();
        println("Enter the restriction number.");
        int restriction = dialog.readInt();
        for(int counter = 0; counter <= number; counter++){
            if(fibonacci(counter) > restriction) break;
            println(counter + "-" + fibonacci(counter));
        }
    }

    private int fibonacci(int Number){
        if(Number == 0 || Number == 1) return Number;
        else return fibonacci(Number - 1) + fibonacci(Number - 2);
    }
}