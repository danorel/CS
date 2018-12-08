package Bundle.methods;

import java.util.Date;
import java.util.Scanner;

public class Bundle {
    private static final int times = 10;
    private Scanner scanner = new Scanner(System.in);

    // #1. Ten times show name and surname
    public void showTenTimesNameSurname(String name, String surname){
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);
        String capitalizedSurname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        for(int counter = 0; counter < times; counter++){
            System.out.println((counter + 1) + ". " + capitalizedName + " " + capitalizedSurname);
        }
    }

    // #2. Show table of squared first ten positive int numbers
    public void showTableOfSquaredNumbers(){
        System.out.println("The table of squared odd numbers from 1 to 10");
        for(int xAxis = 1; xAxis <= times; xAxis++){
            System.out.println(xAxis + " -> " + (int)Math.pow(xAxis, 2));
        }
    }

    // #3. Show table of squared first 5 positive int odd numbers
    public void showTableOfSquaredOddNumbers(){
        System.out.println("The table of first 5 int squared odd numbers");
        for(int xAxis = 1; xAxis <= times; xAxis++){
            if(xAxis % 2 == 1){
                System.out.println(xAxis + " -> " + (int)Math.pow(xAxis, 2));
            }
        }
    }

    // #4. Summary of first N positive numbers
    public void showTableOfCountedNumbers(){
        System.out.print("Enter the number to compute the sequence of numbers: ");
        String counter = scanner.next();
        int Summary = 0;
        int number = Integer.parseInt(counter);
        for(int count = 1; count <= number; count++){
            Summary += count;
        }
        System.out.println("Total summary of odd numbers in this diapason: " + Summary);
    }

    // #5. Summary of first N positive odd numbers
    public void showTableOfCountedOddNumbers(){
        System.out.print("Enter the number to compute the sequence of odd numbers: ");
        String counter = scanner.next();
        int number = Integer.parseInt(counter);
        int Summary = 0;
        for(int count = 1; count <= number; count++){
            if(count % 2 == 1){
                Summary += count;
            }
        }
        System.out.println("Total summary of odd numbers in this diapason: " + Summary);
    }

    // #6. Summary of first 1/N positive odd numbers
    public void showTableOfFractionalNumbers(){
        System.out.print("Enter the number to compute the sequence of numbers, type (1/N): ");
        String counter = scanner.next();
        double Summary = 0.0;
        int number = Integer.parseInt(counter);
        for(int count = 1; count <= number; count++){
            Summary += (double)1/count;
        }
        String summary = Double.toString(Summary);
        System.out.println("Total summary of numbers, type (1/N), in this diapason: " + summary.substring(0,3));
    }

    // #7. The table of Math.pow(2, from 0 to 10)
    public void showTableOfSquaredTwo(){
        System.out.println("The table of computing Math.pow(2,[0,10])");
        for(int count = 0; count <= 10; count++){
            System.out.println(2 + "^" + count + " = " + (int)Math.pow(2,count));
        }
    }

    // #8. Computing the factorial of N
    public void showComputedFactorial(){
        long Number;
        String number;
        System.out.print("Enter the number, which will be used in computing factorial(number): ");
        do {
            number = scanner.nextLine();
            Number = Long.parseLong(number);
            if(Number < 0){
                System.out.print("Re-input the number: ");
            }
        } while(Number < 0);

        int factorialSummary = 1;
        for(int count = 1; count <= Number; count++){
            if(factorialSummary >= Long.MAX_VALUE){
                System.out.println("The factorial(" + count + ") is bigger than Integer diapason! The summary will be assigned 0 value. Stopping the computing...");
                break;
            }
            factorialSummary *= count;
        }
        System.out.println("Factorial(" + Number + ") -> " + factorialSummary);
    }

    // #9. Summary of the function
    public void showTableOfFunctionValues(){
        double X, Y;
        double Summary = 0;
        String number;
        for(double diapason = -2; diapason < 2; diapason += 0.5){
            X = diapason;
            Y = (-2.4*Math.pow(X, 2)) + (5 * X) - 3;
            number = Double.toString(Y);
            if(number.length() > 4){
                System.out.println("The Y value with step " + diapason + " is " + number.substring(0, 5));
            } else {
                System.out.println("The Y value with step " + diapason + " is " + number.substring(0, 4));
            }
        }
    }

    // #10. Generating the random numbers from diapason [1,10] and
    // computing their median
    public void showRandomGeneratedTable(){
        int generatedNumber, Summary = 0;
        for(int counter = 0; counter < 10; counter++){
            generatedNumber = 1 + (int)(Math.random() * 10);
            System.out.println((counter + 1) + ". " + generatedNumber);
            Summary += generatedNumber;
        }
        System.out.println("The middle of these numbers is " + (double)Summary/10);
    }

    // #11. The apple prices per 100g
    public void showTableOfApplePrices(){
        System.out.print("Enter the apple price per 1 kilogram: ");
        double price = scanner.nextDouble();
        String Price;
        System.out.println("Price per 1 kilogram is " + price + "$");
        for(double step = 1; step <= 10; step++){
            Price = Double.toString(price * step/10);
            if(Price.length() > 4){
                System.out.println((step/10 * 1000) + "g. costs " + Price.substring(0, 4)  + "$");
            } else {
                System.out.println((step/10 * 1000) + "g. costs " + Price.substring(0, 3)  + "$");
            }
        }
    }

    // #12. Perfect adding numbers
    public void showSamples(){
        int Number1, Number2, generateOperator, Result;
        char[] operators = {'+', '-'};
        int countAnswers = 0;
        int guess;
        double SummarySecs = 0.0;
        for(int counter = 0; counter < 10; counter++){
            Number1 = 1 + (int)(Math.random() * 100);
            Number2 = 1 + (int)(Math.random() * 100);
            generateOperator = (int)(Math.random() * 2);
            if(operators[generateOperator] == '+'){
                Result = Number1 + Number2;
                System.out.println(Number1 + " + " + Number2 + " equals?");
                System.out.print("Enter your guess: ");
                Date startTime = new Date();
                guess = scanner.nextInt();
                Date endTime = new Date();
                System.out.println((double)((endTime.getTime() - startTime.getTime()) / 1000) + "s passed!");
                SummarySecs += (double)((endTime.getTime() - startTime.getTime()) / 1000);
                if(guess == Result){
                    countAnswers++;
                }
            } else if(operators[generateOperator] == '-'){
                if(Number2 > Number1){
                    Result = Number2 - Number1;
                    System.out.println(Number2 + " - " + Number1 + " equals?");
                    System.out.print("Enter your guess: ");
                    Date startTime = new Date();
                    guess = scanner.nextInt();
                    Date endTime = new Date();
                    System.out.println((double)((endTime.getTime() - startTime.getTime()) / 1000) + "s passed!");
                    SummarySecs += (double)((endTime.getTime() - startTime.getTime()) / 1000);
                    if(guess == Result){
                        countAnswers++;
                    }
                } else {
                    Result = Number1 - Number2;
                    System.out.println(Number1 + " - " + Number2 + " equals?");
                    System.out.print("Enter your guess: ");
                    Date startTime = new Date();
                    guess = scanner.nextInt();
                    Date endTime = new Date();
                    System.out.println((double)((endTime.getTime() - startTime.getTime()) / 1000) + "s passed!");
                    SummarySecs += (double)((endTime.getTime() - startTime.getTime()) / 1000);
                    if(guess == Result){
                        countAnswers++;
                    }
                }
            }
        }
        double coefficientOfEfficiency = 0;
        if(SummarySecs <= 30){
            coefficientOfEfficiency = 1.3;
        } else if(SummarySecs > 30 && SummarySecs <= 40){
            coefficientOfEfficiency = 1.15;
        } else if(SummarySecs > 40 && SummarySecs <= 50){
            coefficientOfEfficiency = 1.0;
        } else {
            coefficientOfEfficiency = 0.85;
        }

        System.out.println("Your result is " + countAnswers + " right answers!" + "The total time is " + SummarySecs);
        if(countAnswers * coefficientOfEfficiency >= 10){
            System.out.println("Perfect result!");
        } else if(countAnswers * coefficientOfEfficiency < 10 && countAnswers * coefficientOfEfficiency > 8){
            System.out.println("Good result!");
        } else if(countAnswers * coefficientOfEfficiency < 8 && countAnswers * coefficientOfEfficiency > 6){
            System.out.println("Normal result!");
        } else {
            System.out.println("Awful result!");
        }
    }

    // #13. Summary of positive numbers
    public void showTheMiddleSummaryOfManuallyEnteredNumbers(){
        System.out.println("Enter 0 to terminate the program");
        int Number, Summary = 0, counter = 0;
        do{
            System.out.print("Input the number: ");
            Number = scanner.nextInt();
            if(Number == 0){
                break;
            } else if(Number > 0) {
                Summary += Number;
                counter++;
            } else {
                System.out.println("Fatal ERROR! You've entered the negative number.");
            }
        } while(Number < 0 || Number != 0);
        if(counter == 0){
            System.out.println("The Summary of entered numbers is " + Summary + ". The middle of that Summary is " + 0);
        } else {
            System.out.println("The Summary of entered numbers is " + Summary + ". The middle of that Summary is " + (double)Summary/counter);
        }
    }

    // #14. Get the max number from the sequence
    public void showTheMaxNumber(){
        System.out.println("Enter the value smaller than 0 to terminate!");
        int Number, Max = 0;
        System.out.print("Input value: ");
        Number = scanner.nextInt();
        if(Number <= 0){
            Max = 0;
        } else {
            Max = Number;
        }

        while(Number > 0){
            System.out.print("Input value: ");
            Number = scanner.nextInt();
            if(Number == 0){
                break;
            } else if(Number < 0){
                System.out.println("Fatal ERROR! Value is negative. Stopping the algorithm!");
            } else {
                if(Max <= Number){
                    Max = Number;
                }
            }
        }

        System.out.println("MAX from the sequence is " + Max);
    }


    // #15. Check if simple
    public void showNumberIfSimple(){
        int countDividers = 0;
        System.out.print("Enter the number of type int: ");
        int Number = scanner.nextInt();

        if(Number > 0){
            for(int counter = 1; counter <= Number; counter++){
                if(Number % counter == 0){
                    countDividers++;
                }
            }
        } else {
            for(int counter = -1; counter >= Number; counter--){
                if(Number % counter == 0){
                    countDividers++;
                }
            }
        }

        if(countDividers == 2){
            System.out.println(Number + " is a simple one!");
        } else {
            System.out.println(Number + " is not a simple one!");
        }
    }

    // #16. Guess the number in diapason from [0, 100]
    public void showTheGuessingGame(){
        System.out.println("Let's start!");
        int Number, guess;
        String answer = "";
        do {
            Number = 1 + (int) (Math.random() * 100);
            for (int counter = 0; counter < 7; counter++) {
                System.out.print("Guess #" + (counter + 1) + ": ");
                guess = scanner.nextInt();
                if (guess > Number) {
                    System.out.println("Less...");
                } else if (guess < Number) {
                    System.out.println("More...");
                } else {
                    System.out.println("Guessed! The number of steps: " + (counter + 1) + ". Perfect result!");
                    break;
                }
                if (counter == 7) {
                    System.out.println("Failed!");
                }
            }

            do {
                System.out.print("Do you want to play one more time?(Yes/No): ");
                answer = scanner.nextLine();
            } while (!answer.equals("Yes") && !answer.equals("No"));
        } while(!answer.equals("No"));
    }
}
