import acm.io.IODialog;
import acm.program.ConsoleProgram;

public class GeneralClass extends ConsoleProgram {
    public void run(){
         println("Function fibonacci is running...");
         task1(); // Fibonacci
         println("Function countDigits is running...");
         task2(); // Number of digits
         println("Function factorial is running...");
         task3(); // Factorial
    }

    private void task1() {
        IODialog dialog = new IODialog();
        int number = dialog.readInt();

        for(int counter = 0; counter <= number; counter++){
            println(counter + "-" + fibonacci(counter));
        }
    }

    private void task2() {
        IODialog dialog = new IODialog();
        int number = dialog.readInt();
        println("The number of digits in number " + number +  " is " + countDigits(number));
    }

    private void task3() {
        IODialog dialog = new IODialog();
        int number = dialog.readInt();
        println("The factorial of " + number +  " is " + factorial(number));
    }

    private int fibonacci(int Number){
        if(Number == 0 || Number == 1) return Number;
        else return fibonacci(Number - 1) + fibonacci(Number - 2);
    }

    private int countDigits(int Number){
        int count = 1;
        if ((Number / 10) > 0) {
            count += countDigits(Number/10);
            return count;
        } else return 1;
    }

    private long factorial(int Number) {
        if(Number == 0) return 0;
        else if (Number == 1) return 1;
        else return Number * factorial(Number-1);
    }
}
