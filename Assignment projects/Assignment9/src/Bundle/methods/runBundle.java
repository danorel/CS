package Bundle.methods;

import java.util.Scanner;

public class runBundle {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runBundle bundle = new runBundle();
        bundle.run();
    }

    public void run(){
        Bundle bundle = new Bundle();
        System.out.println("Hello, dear user! Let me introduce my API - set of functions. Let us test them!");
        String answer;
        int value;
        do{
            System.out.println("What function do you want to test?");
            System.out.println("1. showTenTimesNameSurname");
            System.out.println("2. showTableOfSquaredNumbers");
            System.out.println("3. showTableOfSquaredOddNumbers");
            System.out.println("4. showTableOfCountedNumbers");
            System.out.println("5. showTableOfCountedOddNumbers");
            System.out.println("6. showTableOfFractionalNumbers");
            System.out.println("7. showTableOfSquaredTwo");
            System.out.println("8. showComputedFactorial");
            System.out.println("9. showTableOfFunctionValues");
            System.out.println("10. showRandomGeneratedTable");
            System.out.println("11. showTableOfApplePrices");
            System.out.println("12. showSamples");
            System.out.println("13. showTheMiddleSummaryOfManuallyEnteredNumbers");
            System.out.println("14. showTheMaxNumber");
            System.out.println("15. showNumberIfSimple");
            System.out.println("16. showTheGuessingGame");
            System.out.println();
            System.out.print("Option: ");
            value = scanner.nextInt();
            switch(value){
                case 1:
                    String name, surname;
                    System.out.print("Enter the name: ");
                    name = scanner.next();
                    System.out.print("Enter the surname: ");
                    surname = scanner.next();
                    bundle.showTenTimesNameSurname(name, surname);
                    break;
                case 2:
                    bundle.showTableOfSquaredNumbers();
                    break;
                case 3:
                    bundle.showTableOfSquaredOddNumbers();
                    break;
                case 4:
                    bundle.showTableOfCountedNumbers();
                    break;
                case 5:
                    bundle.showTableOfCountedOddNumbers();
                    break;
                case 6:
                    bundle.showTableOfFractionalNumbers();
                    break;
                case 7:
                    bundle.showTableOfSquaredTwo();
                    break;
                case 8:
                    bundle.showComputedFactorial();
                    break;
                case 9:
                    bundle.showTableOfFunctionValues();
                    break;
                case 10:
                    bundle.showRandomGeneratedTable();
                    break;
                case 11:
                    bundle.showTableOfApplePrices();
                    break;
                case 12:
                    bundle.showSamples();
                    break;
                case 13:
                    bundle.showTheMiddleSummaryOfManuallyEnteredNumbers();
                    break;
                case 14:
                    bundle.showTheMaxNumber();
                    break;
                case 15:
                    bundle.showNumberIfSimple();
                    break;
                case 16:
                    bundle.showTheGuessingGame();
                    break;
                default:
                    System.err.println("FATAL ERROR! Not valid value");
                    break;
            }

            do{
                System.out.print("Do you want to continue testing?(Yes/No): ");
                answer = scanner.nextLine();
            } while(!answer.equals("Yes") && !answer.equals("No"));
        } while(!answer.equals("No"));

    }
}
