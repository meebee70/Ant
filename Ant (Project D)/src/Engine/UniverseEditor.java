package Engine;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import Functionality.Direction;
import javafx.scene.paint.Color;
import Functionality.Ant;
import Functionality.Board;
import Functionality.Colour;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class UniverseEditor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4150542299259228718L;
	
	private JPanel contentPane;
	private JTextField widthInput;
	private JTextField heightInput;
	JCheckBox keepAntButton;
	private Manager m;

	/**
	 * Create the frame.
	 */
	public UniverseEditor(Manager m) {
		init();
		this.m = m;
		
	}
	
	private void init(){
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 140);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		widthInput = new JTextField();
		widthInput.setBounds(26, 41, 106, 20);
		contentPane.add(widthInput);
		widthInput.setColumns(10);
		
		heightInput = new JTextField();
		heightInput.setBounds(142, 41, 106, 20);
		contentPane.add(heightInput);
		heightInput.setColumns(10);
		
		JLabel lblUniverseWidth = new JLabel("Universe Width");
		lblUniverseWidth.setBounds(26, 16, 91, 14);
		contentPane.add(lblUniverseWidth);
		
		JLabel lblUniverseHeight = new JLabel("Universe Height");
		lblUniverseHeight.setBounds(142, 16, 86, 14);
		contentPane.add(lblUniverseHeight);
		
		JLabel lblUniverseDefaultColor = new JLabel("Universe Default Colour");
		lblUniverseDefaultColor.setBounds(272, 16, 152, 14);
		contentPane.add(lblUniverseDefaultColor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(Colour.values()));
		comboBox.setBounds(272, 41, 124, 20);
		contentPane.add(comboBox);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int width = 1;
				int height = 1;
				boolean isValid = true;
				
				if (!widthInput.getText().isEmpty()){
					try{
						width = (int)Double.parseDouble(widthInput.getText().trim());
					}catch (Exception e){ widthInput.setText("Please enter a positive integer");;isValid = false;}
				}else{
					widthInput.setText("Please enter a number");
					isValid = false;
				}
				
				if (!heightInput.getText().isEmpty()){
					try{
						height = (int)Double.parseDouble(heightInput.getText().trim());
					}catch (Exception e) { heightInput.setText("Please enter a positive integer");;isValid = false;}
				}else{
					heightInput.setText("Please input a number");
					isValid = false;
				}
				
				
				if (width * height <= 0 ){
					widthInput.setText("Please enter a positive integer");
					heightInput.setText("Please enter a positive integer");
					isValid = false;
				}else if (width * height > Math.pow(5000,2)){//a hard cap on how big the user can make their universe
					if (width >= height){
						widthInput.setText("Please enter a smaller number");
					}else{
						heightInput.setText("Please enter a smaller number");
					}
					isValid = false;
				}
				
				if (isValid){
					Board newBoard = new Board(width, height,(Colour) comboBox.getSelectedItem(), m);
					
					m.setBoard(newBoard);
					
					if (!keepAntButton.isSelected()){
						m.setAnt(new Ant(m.getBoard().getWidth()/2 , m.getBoard().getHeight()/2 , m.getBoard()));						
					}
					
					m.otherWindowOpen = false;
					m.resetBoard();
					dispose();
				}
				
				
				
				
				
			}
		});
		btnAccept.setBounds(236, 72, 89, 23);
		contentPane.add(btnAccept);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				m.otherWindowOpen = false;
				dispose();
			}
		});
		btnCancel.setBounds(335, 72, 89, 23);
		contentPane.add(btnCancel);
		
		keepAntButton = new JCheckBox(" Keep ant");
		//keepAntButton.setSelected(true);
		keepAntButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		keepAntButton.setBounds(26, 68, 97, 23);
		contentPane.add(keepAntButton);
		
		this.setVisible(true);
	}
}
