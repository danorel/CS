import acm.program.ConsoleProgram;

import static java.lang.StrictMath.toRadians;

public class Sqrt extends ConsoleProgram {
    private final int WIDTH = 320;
    private final int HEIGHT = 240;

    public void run() {
        this.setSize(WIDTH, HEIGHT);
        println("Enter values to compute Pythagorean theorem.");
        print("Enter number 1: ");
        int number1 = readInt();
        print("Enter number 2: ");
        int number2 = readInt();
        System.out.println(Math.sqrt(5));

        double number = Math.sqrt( Math.pow(number1, 2) + Math.pow(number2, 2));
        print("Result: " + number);
    }
}
