import acm.program.ConsoleProgram;

import java.util.ArrayList;

public class IdealNumbers extends ConsoleProgram {
    private int Diapason = 10000;
    private ArrayList<Integer> idealNumbers = new ArrayList<>();
    
    public void run(){
        int Summary = 0;
        int mod = 1;

        do{
            print("What diapason do you like to test? Answer: ");
            this.Diapason = readInt();
            if(this.Diapason <= 0){
                println("Failed to assign! Re-enter your diapason.");
            }
        } while(this.Diapason <= 0);

        for(int Number = 2; Number <= this.Diapason; Number++){
            do{
                if(Number % mod == 0){
                    Summary += mod;
                }
                mod++;
            } while(Number != mod);
            if(Number == Summary){
                idealNumbers.add(Number);
            }
            mod = 1;
            Summary = 0;
        }

        int counter = 0;
        do{
            println("Ideal number is: " + idealNumbers.get(counter));
            counter++;
        } while (counter != idealNumbers.size());
    }
}
