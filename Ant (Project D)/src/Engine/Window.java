package Engine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Functionality.Action;
import Functionality.Board;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSlider;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JCheckBox;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4850704353898707534L;
	
	private JPanel contentPane;
	private JPanel antPanel = new JPanel();
	JSlider simulationSpeedSlider;
	JCheckBox useSmoothSpeed;
	private Manager m;

	/**
	 * Create the frame.
	 */
	public Window(Manager m) {
		this.m = m;
		
		setResizable(false);
		setTitle("Ant Simulator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		antPanel.setBackground(Color.WHITE);
		
		antPanel.setBounds(0, 0, 407, 403);
		contentPane.add(antPanel);
		antPanel.setLayout(null);
		
		JLabel lblSimulation = new JLabel("Simulation");
		lblSimulation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSimulation.setBounds(500, 11, 85, 25);
		contentPane.add(lblSimulation);
		
		JLabel lblAnt = new JLabel("Ant");
		lblAnt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnt.setBounds(518, 155, 32, 14);
		contentPane.add(lblAnt);
		
		JLabel lblUniverse = new JLabel("Universe");
		lblUniverse.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUniverse.setBounds(500, 269, 67, 14);
		contentPane.add(lblUniverse);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(442, 50, 38, 14);
		contentPane.add(lblSpeed);
		
		simulationSpeedSlider = new JSlider();
		simulationSpeedSlider.setBounds(442, 29, 187, 23);
		contentPane.add(simulationSpeedSlider);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				m.unPause();
			}
		});
		btnPlay.setBounds(442, 80, 89, 23);
		contentPane.add(btnPlay);
		
		JButton btnPause = new JButton("Pause");
		btnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m.pause();
			}
		});
		btnPause.setBounds(540, 80, 89, 23);
		contentPane.add(btnPause);
		
		JButton btnResetSimulation = new JButton("Reset Simulation");
		btnResetSimulation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				m.resetBoard();
			}
		});
		btnResetSimulation.setBounds(465, 114, 152, 23);
		contentPane.add(btnResetSimulation);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!m.otherWindowOpen){
					m.otherWindowOpen = true;
					AntEditor w = new AntEditor(m,m.getAnt());
				}
			}
		});
		btnModify.setBounds(442, 193, 89, 23);
		contentPane.add(btnModify);
		
		JButton btnNew = new JButton("New");
		btnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!m.otherWindowOpen){
					m.otherWindowOpen = true;
					AntEditor w = new AntEditor(m);
				}
			}
		});
		btnNew.setBounds(540, 193, 89, 23);
		contentPane.add(btnNew);
		
		JButton btnNew_1 = new JButton("New");
		btnNew_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!m.otherWindowOpen){
					m.otherWindowOpen = true;
					UniverseEditor ue = new UniverseEditor(m);
				}
				
			}
		});
		btnNew_1.setBounds(489, 294, 89, 23);
		contentPane.add(btnNew_1);
		
		JButton btnSave = new JButton("Save");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = (String) JOptionPane.showInputDialog(contentPane.getParent(), "what would you like to call your ant?","saving my ant",JOptionPane.PLAIN_MESSAGE,null,null,"");
				
				if (!(name == null)){
					try {
						FileOutputStream fileOut = new FileOutputStream("ant saves/" +name);
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(m.getAnt().getActions());
						out.close();
						fileOut.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		btnSave.setBounds(442, 227, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				File folder = new File("ant saves");
				File[] antSaves = folder.listFiles();
				Action[] newActions;
				
				if (antSaves.length > 0){
					
					File file = (File) JOptionPane.showInputDialog(contentPane.getParent(), "Which ant would you like to load?","load ant",JOptionPane.PLAIN_MESSAGE,null,antSaves,"");
					
					
					if (file != null){
						try {
							
							FileInputStream fileIn = new FileInputStream(file);
							ObjectInputStream in = new ObjectInputStream(fileIn);
							newActions = (Action[]) in.readObject();
							in.close();
							fileIn.close();
							
							m.getAnt().setActions(newActions);
							
						} catch (Exception e){}
					}
				}else{
					JOptionPane.showMessageDialog(contentPane.getParent(), "There are no current ant saves!");
				}
				
				m.resetBoard();
				m.setBoard(new Board(m.getBoard().getWidth(),m.getBoard().getHeight(),m.getAnt().getActionAtIndex(0).getColour1(),m));
				m.resetBoard();
			}
		});
		btnLoad.setBounds(540, 227, 89, 23);
		contentPane.add(btnLoad);
		
		useSmoothSpeed = new JCheckBox("use smooth speed");
		useSmoothSpeed.setBounds(500, 50, 137, 23);
		contentPane.add(useSmoothSpeed);
		
		JButton btnExportUniverseAs = new JButton("Export Universe as Image");
		btnExportUniverseAs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String name = (String) JOptionPane.showInputDialog(contentPane.getParent(),"What would you like to name your universe? /n all universes are exported to the universe saves file /n located where you have the program", "Save universe",JOptionPane.PLAIN_MESSAGE,null,null,"" );
				
				if (!(name == null)){
					try{
						File outputFile = new File("universe saves/" +name + ".png");
						ImageIO.write(m.getBoard().getbuffedImage(), "png", outputFile);
					}catch (Exception e){}
				}
			}
		});
		btnExportUniverseAs.setBounds(442, 345, 187, 23);
		contentPane.add(btnExportUniverseAs);
		
		this.setVisible(true);
	}
	
	public JPanel getAntWindow(){
		return antPanel;
	}
}
