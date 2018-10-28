import acm.program.ConsoleProgram;

public class Exp extends ConsoleProgram {
    private double X = 0.0;
    private double minX = 0;
    private double maxX = 1;
    private double eps = 0;
    private int N = 0;

    public void run(){
        checkX();
        checkEps();
        println("N(0): " + findN());
        println("Result: " + summary(this.N));
    }

    private void checkEps() {
        do{
            print("Enter eps: ");
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
            print("Enter X between [" + this.minX + ";" + this.maxX + "): ");
            this.X = readDouble();
            if(this.X >= maxX || this.X < minX){
                println("Re-enter your X. It must be from [" + this.minX + ";" + this.maxX + "): ");
            }
        } while(X >= maxX || X < minX);
    }

    private double summary(int n){
        if(n == 0) return 1;
        if(n == 1) return X + summary(n - 1);
        else return ((Math.pow(X, n) / factorial(n)) + summary(n - 1));
    }

    private int factorial(int n){
        if(n == 0 || n == 1){
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
