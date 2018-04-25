package Functionality;

import java.awt.Color;

public class Action implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4594508432991556625L;
	
	Colour c1, c2;
	Direction d;
	
	public Action(Colour col1, Colour col2, Direction d){
		c1 = col1;
		c2 = col2;
		this.d = d;
	}
	
	public Colour getColour1(){
		return c1;
	}
	
	public Colour getColour2(){
		return c2;
	}
	
	public Direction getDirection(){
		return d;
	}
	
	public Action toAction(Colour col1, Colour col2, Direction dir){
		return new Action(col1,col2,dir);
	}
	
}
