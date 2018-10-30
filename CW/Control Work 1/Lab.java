import stanford.karel.*;

public class Lab extends SuperKarel {
    private int countDiamonds = 0;

    public void run(){
        cycle();
    }

    private void cycle() {
        do{
            turnLeft();
            moveForwardAndCheckBeeper();
            if(frontIsBlocked() && rightIsBlocked()){
                break;
            }
            turnRight();
            moveForwardAndCheckBeeper();
            turnRight();
            moveForwardAndCheckBeeper();
            turnRight();
            moveForwardAndCheckBeeper();
            turnAround();
        } while(true);

        do{
            putBeeper();
           countDiamonds--;
        } while(countDiamonds != 0);
    }

    public void moveForwardAndCheckBeeper(){
        do{
            if(!beepersPresent()){
                move();
            } else {
                do{
                    pickBeeper();
                    this.countDiamonds++;
                } while(beepersPresent());
                move();
            }
        } while(frontIsClear());
    }
}
