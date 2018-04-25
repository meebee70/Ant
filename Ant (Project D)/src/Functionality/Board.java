package Functionality;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import Engine.Manager;

import java.awt.Color;

public class Board implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6744659760631806689L;
	
	private final Colour[][] board;
	private final int width,height;
	private final Colour starterColour;
	private BufferedImage buffedImg;
	private Graphics buffedG;
	private Manager m;
	private Color antColour = Color.RED;
	
	/**
	 * 
	 * @param x how many squares the board should be wide
	 * @param y how many squares the board should be tall
	 * @param width the amount of width the board should take physically take up
	 * @param height the amount of height the board should physically take up
	 */
	public Board(int x, int y,Colour c,Manager m){
		this.m = m;
		board = new Colour[x][y];
		width = x;
		height = y;
		starterColour = c;
		buffedImg = new BufferedImage((int)(x ),(int)( y ), BufferedImage.TYPE_INT_RGB);
		buffedG = buffedImg.getGraphics();
		
		
		for (int i = 0;i <x;i++){
			for (int j = 0;j < y;j++){
				board[i][j] = starterColour;
			}
		}
	}
	
	public void reset(){
		for (int i = 0;i <width;i++){
			for (int j = 0;j < height;j++){
				board[i][j] = starterColour;
			}
		}
		
		m.getAnt().reset();
	}
	
	public Color getColour(int x, int y){
		if ((x >= width || x < 0) || (y >= height || y < 0)){
			m.finishBoard();
			return null;
		}
		
		return board[x][y].getColor();
	}
	
	public void setColour(int x, int y, Colour c){
		board[x][y] = c;
	}
	
	
	public void draw(Graphics g){
		
		
		
		for (int i = 0; i < board.length;i++){
			for (int j = 0; j < board[0].length;j++){
				buffedG.setColor(board[i][j].getColor());
				buffedG.fillRect((int)(i),(int) (j),1,1);
				//System.out.println(i + " " + j);
			}
		}
		
		buffedG.setColor(antColour);
		buffedG.fillRect(m.getAnt().x, m.getAnt().y, 1, 1);
		
		g.drawImage(buffedImg, 0, 0, 407, 403, 0, 0, buffedImg.getWidth(), buffedImg.getHeight(), null);
		
	}
	
	public void setAntColour(Color c){
		antColour = c;
	}
	
	public int getWidth(){
		return board.length;
	}
	
	public int getHeight(){
		return board[0].length;
	}
	
	public Colour getStartColor(){
		return starterColour;
	}
	
	public Graphics getRawImage(){
		return buffedG;
	}
	
	public BufferedImage getbuffedImage(){
		return buffedImg;
	}

}
