import acm.io.IODialog;
import acm.program.ConsoleProgram;

public class CountDigits extends ConsoleProgram {
    public void run(){
        IODialog dialog = new IODialog();
        int number = dialog.readInt();
        println("The number of digits in number " + number +  " is " + countDigits(number));
    }

    private int countDigits(int Number){
        int count = 1;
        if ((Number / 10) > 0) {
            count += countDigits(Number/10);
            return count;
        } else return 1;
    }
}
