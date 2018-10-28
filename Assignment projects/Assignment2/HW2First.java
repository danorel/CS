import stanford.karel.*;

public class HW2First extends SuperKarel{

	public void run(){
		run1();
	}

	private void run1(){
		do{
			move();
		} while(!(beepersPresent()) && frontIsClear());
		if(beepersPresent()){
			pickBeeper();
			turnAround();
			moveForward();
			turnAround();
		} else {
			turnRight();
			moveWhileLeftIsBlocked();
			turnLeft();
			move();
			pickBeeper();
			turnAround();
			move();
			turnRight();
			moveForward();
			turnLeft();
			moveForward();
			turnAround();
		}
	}

	private void moveWhileRightIsBlocked(){
		do{
			move();
		} while(rightIsBlocked());
	}

	private void moveWhileLeftIsBlocked(){
		do{
			move();
		} while(leftIsBlocked());
	}

	private void moveAndPutBeeper() {
		move();
		putBeeper();
	}

	private void moveForwardAndPutBeeper() {
		do {
			moveAndPutBeeper();
		} while(frontIsClear());
	}

	private void doubleMove() {
		move();
		move();
	}

	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}

	public void turnAround() {
		turnLeft();
		turnLeft();
	}

	private void moveForward() {
		do {
			move();
		} while(frontIsClear());
	}

	private void goToTheNewspaper() {
		doubleMove();
		turnRight();
		move();
		turnLeft();
		move();
	}

	private void pickTheNewspaper() {
		pickBeeper();
	}

	private void returnToPosition() {
		turnAround();
		moveForward();
		turnRight();
		moveForward();
		turnRight();
	}
}


