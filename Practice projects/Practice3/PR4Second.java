import stanford.karel.*;

public class PR4Second extends SuperKarel{

	public void run(){
		do{
			if(beepersPresent()){
				pickBeeper();
			}
			if(facingEast()){
				turnLeft();
			}
			moveCheckAndPickBeeper();
			turnAround();
			moveForward();
			turnAround();
			moveWhileRightIsBlocked();
			if(frontIsBlocked() && rightIsBlocked() && leftIsBlocked()){
				turnRight();
				break;
			}
			turnRight();
			move();
			turnRight();
			moveForward();
			turnAround();
		} while(true);
	}

	public void moveWhileLeftIsBlocked(){
		do{
			if(frontIsBlocked() && rightIsBlocked() && leftIsBlocked()){
				break;
			}
			move();
		} while(leftIsBlocked());
	}

	public void moveWhileRightIsBlocked(){
		do{
			if(frontIsBlocked() && rightIsBlocked() && leftIsBlocked()){
				break;
			}
			move();
		} while(rightIsBlocked());
	}

	public void moveForward() {
		do{
			move();
		} while(frontIsClear());
	}

	public void moveCheckAndPickBeeper() {
		do{
			move();
			if(beepersPresent()){
				pickBeeper();
			}
		} while(frontIsClear());
	}
}
