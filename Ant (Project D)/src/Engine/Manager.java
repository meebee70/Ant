package Engine;

import javax.swing.JPanel;
import Functionality.*;

public class Manager {
	
	private Window frame;
	private Board board;
	private Ant ant;
	private boolean isRunning = true;
	private JPanel antPanel;
	
	int z = 500; // temporary constant for easy adjustment of board size
	int sleepTime = 5;
	
	public Manager(){
		frame = new Window(this);
		antPanel = frame.getAntWindow();
		board = new Board(z,z,this);
		ant = new Ant(z/2, z/2,board);
	}
	
	public void run(){
		
		Thread drawer = new Thread(){
			public void run(){
				while (true){
					board.draw(antPanel.getGraphics());
				}
			}
		};
		
		Thread anter = new Thread(){
			public void run(){
				while (isRunning){
					try {
						sleep(sleepTime);
						ant.doAction();
					} catch (Exception e) {
						isRunning = false;
					}
					
				}
			}
		};
		
		
		drawer.start();
		anter.start();
		
	}
	
	public boolean isRunning(){
		return isRunning;
	}
	
	public Ant getAnt(){
		return ant;
	}

}
