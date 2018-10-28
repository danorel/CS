import acm.program.ConsoleProgram;

public class Algorithm extends ConsoleProgram {
    private final int WIDTH = 320;
    private final int HEIGHT = 240;

    public void run(){
        this.setSize(WIDTH, HEIGHT);

        print("Enter the number to analyse: ");
        int number = readInt();
        int counter = 1;
        do{
            if(number % 2 == 0){
                print(counter + ". " + number + " -> ");
                number /= 2;
                println(number);
            } else {
                print(counter + ". " + number + " -> ");
                number = (number * 3) + 1;
                println(number);
            }
            counter++;
        } while(number != 1);
        println("The number of steps in such algorithm: " + (counter - 1));
    }
}
