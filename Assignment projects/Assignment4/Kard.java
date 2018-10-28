import stanford.karel.*;

public class Kard extends SuperKarel{

	public void run(){
		run2();
	}

	private void run1() {
		do{
			move();
			if(beepersPresent()){
				turnLeft();
				move();
				check();
				turnAround();
				move();
				move();
				check();
				turnAround();
				move();
				turnRight();
				move();
			} else {
				turnLeft();
				move();
				pickAll();
				turnAround();
				move();
				move();
				pickAll();
				turnAround();
				move();
				turnRight();
				move();
			}
		} while(frontIsClear());
	}

	private void check() {
		if(!beepersPresent()){
			putBeeper();
		} else {
			do{
				pickBeeper();
			} while(beepersPresent());
			putBeeper();
		}
	}

	private void pickAll(){
		if(beepersPresent()){
			do{
				pickBeeper();
			} while(beepersPresent());
		}
	}

	private void run2() {
		int counter = 1;
		do{
			if(!beepersPresent()){
				putBeeper();
			}
			move();
			if(!beepersPresent()){
				putBeeper();
			}
			counter++;
		} while(frontIsClear());
		System.out.println(counter);
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

		do{
			moveX(counter - 1);
			turnAround();
			move();
			turnRight();
			if(frontIsBlocked()){
				break;
			}
			move();
			turnLeft();
			counter -= 2;
			moveX(counter -1);
			turnAround();
		} while(counter != 1);
		if(!beepersPresent()){
			putBeeper();
		}
		turnLeft();
		move();
	}

	private void moveX(int count){
		if(count > 0){
			do{
				if(!beepersPresent()){
					putBeeper();
				}
				move();
				if(!beepersPresent()){
					putBeeper();
				}
				count--;
			} while(count != 0);
		}
	}
}
