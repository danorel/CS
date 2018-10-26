import stanford.karel.*;

public class Clear extends SuperKarel{

	public void run(){
		int counter = 1;
		do{
			putBeeper();
			move();
			counter++;
		} while(frontIsClear());
		putBeeper();
		turnAround();
		do{
			if(beepersPresent()){
				pickBeeper();
			}
			move();
			if(beepersPresent()){
				pickBeeper();
			}
		} while(frontIsClear());
		turnAround();
		moveX(counter/2);
		putBeeper();
		System.out.println(counter);
	}

	public void moveX(int xMoves){
		for(int counter = 0; counter < xMoves; counter++){
			move();
		}
	}
}
