import acm.io.IODialog;
import acm.program.ConsoleProgram;


public class Recursion extends ConsoleProgram {

	public void run() {
		IODialog dialog = new IODialog();
		int number = dialog.readInt();
		println("The factorial of " + number +  " is " + factorial(number));
	}
	
	private long factorial(int Number) {
		if(Number == 0) return 0;
	    else if (Number == 1) return 1;
		else return Number * factorial(Number-1);
	}
}
