import stanford.karel.*;

public class PR4First extends SuperKarel{

	public void run(){
		do{
			if(beepersPresent()){
				pickBeeper();
			}
			moveCheckAndPickBeeper();
			turnAround();
			moveForward();
			turnAround();
			moveWhileLeftIsBlocked();
			if(frontIsBlocked() && rightIsBlocked() && leftIsBlocked()){
				break;
			}
			turnLeft();
			move();
			turnLeft();
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
