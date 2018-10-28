import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FriendlyNumbers extends ConsoleProgram {
    private int Diapason = 10000;
    private int ID = 0;

    private Map friendlyNumbers = new HashMap();

    public void run(){
        int firstSummary = 0;
        int secondSummary = 0;

        int firstMod = 1;
        int secondMod = 1;

        int firstNumber = 2;
        int secondNumber = 2;

        int summary1 = 0;
        int summary2 = 0;

        do{
            print("What diapason do you want to test? Answer: ");
            this.Diapason = readInt();
            if(this.Diapason <= 0){
                println("Failed to assign! Re-enter your diapason.");
            }
        } while(this.Diapason <= 0);

        for(; firstNumber <= Diapason; firstNumber++){
            summary1 = getSummary(firstSummary, firstMod, firstNumber);
            for(; secondNumber <= Diapason; secondNumber++){
                if(secondNumber == summary1){
                    summary2 = getSummary(secondSummary, secondMod, secondNumber);
                    if(summary2 == firstNumber && firstNumber != secondNumber){
                        friendlyNumbers.put(this.ID, firstNumber);
                        this.ID++;
                        friendlyNumbers.put(this.ID, firstNumber);
                        this.ID++;
                    }
                }
            }
            secondNumber = 2;
        }

        if(friendlyNumbers.size() == 0){
            println("No numbers on diapason from 0 to " + this.Diapason + "!");
        } else {
            int counter = 0;
            do{
                println(friendlyNumbers.get(counter) + " and " + friendlyNumbers.get(counter + 1) + " are friendly numbers! ");
                counter += 2;
            } while(friendlyNumbers.size() != counter);
        }
    }

    private int getSummary(int firstSummary, int firstMod, int firstNumber) {
        do {
            if (firstNumber % firstMod == 0) {
                firstSummary += firstMod;
            }
            firstMod++;
        } while (firstNumber != firstMod);
        return firstSummary;
    }
}
