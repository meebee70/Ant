package Functionality;

public enum Direction{
	UP(0,-1),
	RIGHT(1,0),
	DOWN(0,1),
	LEFT(-1,0),
	FORWARD(0,0),
	BACKWARD(0,0);
	
	int x,y;
	
	Direction (int x, int y){
		this.x = x;
		this.y = y;
	}
	
	private Direction turnRight(){
		
		switch(this){
			case UP:
				return RIGHT;
			case RIGHT:
				return DOWN;
			case DOWN:
				return LEFT;
			case LEFT:
				return UP;
				
			default:
				return null;
		}
	}
	
	private Direction turnLeft(){
		
		switch(this){
			case UP:
				return LEFT;
			case LEFT:
				return DOWN;
			case DOWN:
				return RIGHT;
			case RIGHT:
				return UP;
				
			default:
				return null;
		}
	}
	
	public Direction turn(Direction d){
		if (d == LEFT){
			return turnLeft();
		}else if (d == RIGHT){
			return turnRight();
		}else if (d == FORWARD){
			return this;
		}else if (d == BACKWARD){
			return turnRight().turnRight();
		}else return null;
		
	}
	
	public int getXSpeed(){
		return x;
	}
	
	public int getYSpeed(){
		return y;
	}
	
	public static Direction getDirection(String s){
		if (s.toUpperCase().equals("UP")){
			return UP;
		}else if (s.toUpperCase().equals("LEFT")){
			return LEFT;
		}else if (s.toUpperCase().equals("DOWN")){
			return DOWN;
		}else if (s.toUpperCase().equals("RIGHT")){
			return RIGHT;
		}else if (s.toUpperCase().equals("FORWARD")){
			return FORWARD;
		}else if (s.toUpperCase().equals("BACKWARD")){
			return BACKWARD;
		}else{
			return null;
		}
	}
	
//	public String toString(){
//		if (this == UP){
//			return "UP";
//		}else if (this == RIGHT){
//			return "RIGHT";
//		}else if (this == DOWN){
//			return "DOWN";
//		}else if (this == LEFT){
//			return "LEFT";
//		}else
//			return null;
//		return this.t
//	}
}
