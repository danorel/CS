import acm.io.IODialog;
import acm.program.ConsoleProgram;

public class Recursion extends ConsoleProgram {

    public void run(){
        IODialog ioDialog = new IODialog();
        print("Enter number to calculate: ");
        int Number = ioDialog.readInt();
        println();
        int S = 0;
        print("Recursion summary is: ");
        while(Number != 0){
            S += Summary(Number);
            Number--;
        }
        print(S);
    }

    private int Summary(int Number){
        if(Number == 0){
            return 0;
        } else if(Number == 1){
            return 9;
        } else {
            return 2 * Summary(Number - 1) + 3 * Summary(Number - 2);
        }
    }
}
