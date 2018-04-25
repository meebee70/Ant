package Engine;

import javax.swing.JPanel;
import Functionality.*;

public class Manager implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4349908475210983074L;
	
	private Window frame;
	private Board board;
	private Ant ant;
	private boolean isRunning = true;
	private boolean isPaused = true;
	private boolean done = false;
	boolean otherWindowOpen = false;
	private JPanel antPanel;
	
	int z = 50; // default board size
	int sleepTime = 1;
	
	public Manager(){
		frame = new Window(this);
		antPanel = frame.getAntWindow();
		board = new Board(z,z,Colour.white,this);
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
						sleep(0); 
					} catch (InterruptedException e1) {}
					
					int i = 0;
					while (!isPaused && !done){
						if (frame.useSmoothSpeed.isSelected()){
							try{
								ant.doAction();
								sleepTime = (int) 1000 - (frame.simulationSpeedSlider.getValue() * 10);
								sleep(sleepTime);
							}catch (Exception e){
								done = true;
							}
						}else{
							try {
								ant.doAction();
								sleepTime = (int) (Math.pow(frame.simulationSpeedSlider.getValue() + 1,2)/10 + 1);
								if (i % sleepTime == 0){
	//								System.out.println(sleepTime);
	//								System.out.println(i);
									sleep(1000 - (frame.simulationSpeedSlider.getValue()* 10));
								}
								i++;
							} catch (Exception e) {
								done = true;
								i = 0;
							}
						}
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
	
	public void setAnt(Ant newAnt){
		pause();
		ant = newAnt;
		ant.reset();
	}
	
	public void setBoard(Board newBoard){
		board = newBoard;
		ant = ant.copyAnt(newBoard.getWidth()/2, newBoard.getHeight()/2, newBoard);
	}
	
	public Board getBoard(){
		return board;
	}
	
	
	
	public void finishBoard(){
		done = true;
	}
	
	public void resetBoard(){
		pause();
		board.reset();
		done = false;
	}
	
	public void pause(){
		//System.out.println("pausing");
		isPaused = true;
		//System.out.println("paused " + isPaused);
	}

	public void unPause(){
		//System.out.println("unPausing");
		isPaused = false;
		//System.out.println("paused " + isPaused);
	}
}
