package Functionality;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import Engine.Manager;

import java.awt.Color;

public class Board {
	
	private final Color[][] board;
	private final Color starterColour = Color.WHITE;
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
	public Board(int x, int y,Manager m){
		this.m = m;
		board = new Color[x][y];
		buffedImg = new BufferedImage((int)(x ),(int)( y ), BufferedImage.TYPE_INT_RGB);
		buffedG = buffedImg.getGraphics();
		
		
		for (int i = 0;i <x;i++){
			for (int j = 0;j < y;j++){
				board[i][j] = starterColour;
			}
		}
		
		
	}
	
	public Color getColour(int x, int y){
		return board[x][y];
	}
	
	public void setColour(int x, int y, Color c){
		board[x][y] = c;
	}
	
	
	public void draw(Graphics g){
		
		
		
		for (int i = 0; i < board.length;i++){
			for (int j = 0; j < board[0].length;j++){
				buffedG.setColor(board[i][j]);
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
	
	public Graphics getRawImage(){
		return buffedG;
	}

}
