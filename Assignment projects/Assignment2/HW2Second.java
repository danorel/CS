import stanford.karel.*;

public class HW2Second extends SuperKarel{

	int counter = 0;

	public void run(){
		run2();
	}


	private void run2(){
		do {
			moveWhileLeftIsBlocked();
			if(leftIsBlocked()){
				break;
			}
			turnLeft();
			moveForward();3
			turnLeft();
			moveForward();
			if(rightIsClear()){
				turnRight();
				moveForward();
				turnRight();
			} else {
				turnAround();
			}
		} while(true);
	}

	private void moveWhileRightIsBlocked(){
		do{
			move();
		} while(rightIsBlocked());
	}

	private void moveWhileLeftIsBlocked(){
		do{
			if(leftIsBlocked() && frontIsBlocked()){
				break;
			} else {
				move();
			}
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
