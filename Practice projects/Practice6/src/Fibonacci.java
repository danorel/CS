import acm.io.IODialog;
import acm.program.*;
import java.util.Scanner;
import acm.program.GraphicsProgram;

public class Fibonacci extends ConsoleProgram {
    public void run() {
        // Input from the embed console:
        IODialog dialog = new IODialog();
        int number = dialog.readInt();
//        int result = fibonacci(number);

        // Input from the classic console:
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a number: ");
//        int number = Integer.parseInt(scanner.nextLine());
        for(int counter = 0, gy = 0; counter <= number; counter++, gy+=30){
            println(counter + "-" + fibonacci(counter));
        }
    }

    public int fibonacci(int Number){
        if(Number == 0 || Number == 1) return Number;
        else return fibonacci(Number - 1) + fibonacci(Number - 2);
    }
}