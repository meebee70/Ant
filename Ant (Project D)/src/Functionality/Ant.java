package Functionality;

import java.awt.Color;

public class Ant {
	
	int x,y;
	Direction direction;
	Board board;
	
	public Ant(int x, int y, Board b){
		this.x = x;
		this.y = y;
		direction = Direction.UP;
		board = b;
	}
	
	public void doAction(){
		Color c = board.getColour(x,y);
		
		if (c == Color.WHITE){
			direction = direction.turnLeft();
			board.setColour(x, y, Color.BLACK);
			move();
		}else if (c == Color.BLACK){
			direction = direction.turnRight();
			board.setColour(x,y,Color.ORANGE);
			move();
		}else if (c == Color.ORANGE){
			direction = direction.turnLeft();
			board.setColour(x, y, Color.BLACK);
			move();
		}
	}
	
	private void move(){
		x += direction.getXSpeed();
		y += direction.getYSpeed();
	}
	
	public void setBoard(Board b){
		board = b;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Direction getDirection(){
		return direction;
	}
	
	

}
