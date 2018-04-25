package Functionality;

import java.awt.Color;

public class Ant implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2443908233183679294L;
	
	int x,y;
	int initX, initY;
	Direction direction;
	Board board;
	Action[] actions;
	
	public Ant(int x, int y, Board b){
		initX = x;
		initY = y;
		this.x = x;
		this.y = y;
		direction = Direction.UP;
		board = b;
		actions = new Action[2];
		actions[0] = new Action(b.getStartColor(),Colour.black,Direction.LEFT);
		actions[1] = new Action(Colour.black,b.getStartColor(),Direction.RIGHT);
	}
	
	public Ant(int x, int y, Board b, Action[] newActs){
		initX = x;
		initY = y;
		this.x = x;
		this.y = y;
		direction = Direction.UP;
		board = b;
		actions = newActs;
	}
	
	public void doAction(){
		Color c = board.getColour(x,y);
		
		for (Action a : actions){
			if (a.getColour1().getColor() == c){
				direction = direction.turn(a.getDirection());
				board.setColour(x, y, a.getColour2());
				move();
				break;
			}
		}
	}
	
	public void reset(){
		this.x = initX;
		this.y = initY;
		direction = Direction.UP;
	}
	
	public Ant copyAnt(int x, int y, Board b){
		return new Ant(x,y,b,actions);
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
	
	public Action getActionAtIndex(int index){
		return actions[index];
	}
	
	public int getActionsLength(){
		return actions.length;
	}
	
	public Action[] getActions(){
		return actions;
	}
	
	public Direction getDirection(){
		return direction;
	}
	
	public void setActions(Action[] acts){
		actions = acts;
	}
	
	

}
