package Functionality;

public enum Direction {
	UP(0,-1),
	RIGHT(1,0),
	DOWN(0,1),
	LEFT(-1,0);
	
	int x,y;
	
	Direction (int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Direction turnRight(){
		
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
	
	public Direction turnLeft(){
		
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
	
	public int getXSpeed(){
		return x;
	}
	
	public int getYSpeed(){
		return y;
	}

}
