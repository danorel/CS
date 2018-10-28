import acm.program.ConsoleProgram;

public class Compare extends ConsoleProgram {
    private int WIDTH = 320;
    private int HEIGHT = 240;
    public void run(){
        this.setSize(WIDTH, HEIGHT);
        int A = 0, B = 0, C = 0;
        char a = 'A', b = 'B', c = 'C';
        int MAX, MIDDLE, MIN;
        char max, middle, min;
        print("Enter A: ");
        A = readInt();
        print("Enter B: ");
        B = readInt();
        print("Enter C: ");
        C = readInt();
        if(A == B && B == C){
            println(a + " = " + b + " = " + c);
        } else {
            if(A > C){
                if(A > B){
                    MAX = A;
                    max = a;
                    if(B > C){
                        MIDDLE = B;
                        middle = b;
                        MIN = C;
                        min = c;
                    } else {
                        MIDDLE = C;
                        middle = c;
                        MIN = B;
                        min = b;
                    }
                } else {
                    MAX = B;
                    max = b;
                    MIDDLE = A;
                    middle = a;
                    MIN = C;
                    min = c;
                }
            } else {
                if(A > B){
                    MAX = C;
                    max = c;
                    MIDDLE = A;
                    middle = a;
                    MIN = B;
                    min = b;
                } else {
                    if(C > B){
                        MAX = C;
                        max = c;
                        MIDDLE = B;
                        middle = b;
                    } else {
                        MAX = B;
                        max = b;
                        MIDDLE = C;
                        middle = c;
                    }
                    MIN = A;
                    min = a;
                }
            }
            println(MAX + ">" + MIDDLE + ">" + MIN);
            println(max + ">" + middle + ">" + min);
        }

    }
}
