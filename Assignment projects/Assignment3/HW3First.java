import stanford.karel.*;

public class HW3First extends SuperKarel{

	public void run(){
		do{
			if(frontIsBlocked() && leftIsBlocked() && rightIsBlocked() ){
				putBeeper();
				break;
			}
			// 1x1

			if(frontIsBlocked()){
				turnLeft();
				do{
					putAndMove();
				} while(frontIsClear());
				break;
			}
			// 1x10

			do{
				putAndMove();
			} while(frontIsClear());
			turnLeft();
			if(frontIsBlocked() && rightIsBlocked()){
				break;
			}

			if(!beepersPresent()){
				move();
				turnLeft();
			} else {
				turnRight();
				turnAround();
				move();
				turnRight();
				move();
				turnLeft();
			}

			do{
				putAndMove();
			} while(frontIsClear());
			turnRight();
			if(frontIsBlocked() && leftIsBlocked()){
				break;
			}
			move();
			turnRight();
		} while(true);
	}

	private void putAndMove(){
		if(!beepersPresent()){
			putBeeper();
		}
		move();
		if(frontIsClear()){
			move();
			putBeeper();
		}
	}
}
