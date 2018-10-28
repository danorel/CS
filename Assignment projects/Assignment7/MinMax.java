import acm.program.ConsoleProgram;

import java.util.ArrayList;

public class MinMax extends ConsoleProgram {
    private final int WIDTH = 320;
    private final int HEIGHT = 240;

    public void run() {
        this.setSize(WIDTH, HEIGHT);
        println("This program is looking for max and min values.");
        println("Enter 'stop' to quit from the cycle!");
        String str = "";
        ArrayList<Integer> iArr = new ArrayList<>();
        int MAX, MIN;
        boolean start = true;
        int counter = 0;

        print("? ");
        str = readLine();
        if(str.equals("stop")){
            MAX = 0;
            MIN = 0;
            start = false;
        } else {
            iArr.add(Integer.parseInt(str));
            MAX = iArr.get(0);
            MIN = iArr.get(0);
        }

        while(start == true){
            print("? ");
            str = readLine();
            if(str.equals("stop")){
                start = false;
            } else {
                iArr.add(Integer.parseInt(str));
                counter++;
                if(iArr.get(counter) >= MAX){
                    MAX = iArr.get(counter);
                } else if(iArr.get(counter) <= MIN){
                    MIN = iArr.get(counter);
                }
            }
        }

        if(iArr.size() == 0){
            println("You've entered no numbers. MAX and MIN elements does not exist!");
        } else if(iArr.size() == 1){
            println("MAX = MIN, you've entered one number: " + iArr.get(0));
        } else {
            println("MAX: " + MAX + ", MIN: " + MIN);
        }

    }
}
