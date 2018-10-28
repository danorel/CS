import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RusticMultiplication extends ConsoleProgram {
    public void run(){
        println("Rustic Multiplication");
        int number1 = 0;
        do{
            print("Enter number 1: ");
            number1 = readInt();
            if(number1 <= 0){
                println("Re-enter your number 1.");
            }
        } while(number1 <= 0);
        int num1 = number1;

        int number2 = 0;
        do{
            print("Enter number 2: ");
            number2 = readInt();
            if(number2 <= 0){
                println("Re-enter your number 2.");
            }
        } while(number2 <= 0);
        int num2 = number2;

        int S = 0;
        do{
            if(number1 % 2 == 0){
                number1 /= 2;
                number2 *= 2;
                if(number1 % 2 == 1){
                    S += number2;
                }
            } else {
                if(number1 % 2 == 1){
                    S += number2;
                }
                number1 = (number1 - 1) / 2;
                number2 *= 2;
            }
        } while(number1 != 1);
        println(num1 + " * " + num2 + " = " + S);
    }
}
