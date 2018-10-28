import acm.io.IODialog;
import acm.program.ConsoleProgram;

public class HanoiTowers extends ConsoleProgram {
    static int counter = 0;

    public void run(){
        IODialog dialog = new IODialog();
        println("Enter the number of disks: ");
        int number = dialog.readInt();
        HanoiTower(number, 'A', 'B', 'C');
        println("The number of moves: " + counter);
    }

    private void printMove(char from, char to){
        println(from + " -> " + to);
    }

    private void HanoiTower(int NOD, char From, char To, char Middle){
        counter++;
        if(NOD == 1){
            printMove(From, To);
        } else if(NOD > 1){
            HanoiTower(NOD - 1, From, Middle, To);
            printMove(From, To);
            HanoiTower(NOD - 1, Middle, To, From);
        } else {
            showErrorMessage("You've entered not right number!");
        }
    }
}
