import acm.program.ConsoleProgram;

public class Cos extends ConsoleProgram {
    private double X = 0.0;
    private double minX = - (Math.PI / 4);
    private double maxX = (Math.PI / 4);
    private double eps = 0;
    private int N = 0;

    public void run(){
        checkX();
        checkEps();
        findN();
        println("N(0): "+ this.N);
        println("Summary: " + summary(this.N));
    }

    private void checkEps() {
        do{
            print("Enter epsilon: ");
            this.eps = readDouble();
            if(this.eps <= 0){
                println("Fatal error! You've entered eps <= 0");
            }
        } while(this.eps <= 0);
    }


    private int findN() {
        do{
            this.N++;
        } while(Math.abs(summary(this.N) - summary(this.N - 1)) > this.eps);
        return this.N;
    }

    private void checkX() {
        do{
            print("Enter X from [" + this.minX + ";" + this.maxX + "]: ");
            this.X = readDouble();
            if(this.X > maxX || this.X < minX){
                println("Re-enter your X. It must be from [" + this.minX + ";" + this.maxX + "]: ");
            }
        } while(X > maxX || X < minX);
    }

    private double summary(int n){
        if(n == 0) return 1;
        if(n == 1) return (-( X * X ) / 2) + summary(n - 1);
        else return ((Math.pow(-1, n) * Math.pow(X, 2 * n) / factorial(2 * n)) + summary(n - 1));
    }

    private int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
