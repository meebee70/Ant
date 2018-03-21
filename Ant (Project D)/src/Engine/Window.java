package Engine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.Color;

public class Window extends JFrame {

	private JPanel contentPane;
	private JPanel antPanel = new JPanel();
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
		
		this.setVisible(true);
	}
	
	public JPanel getAntWindow(){
		return antPanel;
	}
}
