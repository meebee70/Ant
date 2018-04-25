package Engine;

import Functionality.Action;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Functionality.Action;
import Functionality.Ant;
import Functionality.Colour;
import Functionality.Direction;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AntEditor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Manager m;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public AntEditor(Manager m) {
		init(m);
	}
	
	
	public AntEditor(Manager m,Ant a){
		init(m);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		
		
		Ant ant = m.getAnt();
		if (m.getAnt().getActionsLength() > 0){
			while (table.getRowCount() < m.getAnt().getActionsLength()){ // gives the table the appropriate amount of space to represent the ant
				model.addRow(new Object[]{null,null,null});
			}
			
			
			for (int i = 0; i < table.getRowCount();i++){
				table.setValueAt(ant.getActionAtIndex(i).getColour1().toString(), i, 0);
				table.setValueAt(ant.getActionAtIndex(i).getColour2().toString(), i, 1);
				table.setValueAt(ant.getActionAtIndex(i).getDirection().toString(), i, 2);
			}
		}else{
			model.addRow(new Object[]{null,null,null});
		}
	}
	
	
	private void init(Manager m){
		this.m = m;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 534, 257);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 36, 508, 153);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"Colour #1", "Colour #2", "Direction"
				}
			);
		table.setModel(model);
		
		TableColumn colour1 = table.getColumnModel().getColumn(0);
		colour1.setCellEditor(new DefaultCellEditor(
				new JComboBox(Colour.values())
				));
		
		TableColumn colour2 = table.getColumnModel().getColumn(1);
		colour2.setCellEditor(new DefaultCellEditor(
				new JComboBox(Colour.values())
				));
		
		TableColumn directions = table.getColumnModel().getColumn(2);
		Direction[] d = {Direction.LEFT, Direction.RIGHT, Direction.FORWARD, Direction.BACKWARD};
		directions.setCellEditor(new DefaultCellEditor(
				new JComboBox(d)
				));
		
		JLabel lblInstructionListFor = new JLabel("Instruction list for the ant");
		lblInstructionListFor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblInstructionListFor.setBounds(0, 11, 222, 14);
		contentPane.add(lblInstructionListFor);
		
		JButton buttonAccept = new JButton("Accept");
		buttonAccept.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Action[] newActions = new Action[table.getRowCount()];
				
				
				for (int i = 0; i < table.getRowCount();i++){
					
					Colour c1,c2;
					Direction d;
					
					if (model.getValueAt(i, 0).getClass() == Colour.class){
						c1 = (Colour) model.getValueAt(i, 0);
					}else{
						c1 = Colour.toColour( (String) model.getValueAt(i, 0));
					}
					
					if (model.getValueAt(i,1).getClass() == Colour.class){
						c2 = (Colour)model.getValueAt(i, 1);
					}else{
						c2 = Colour.toColour( (String) model.getValueAt(i, 1));
					}
					
					if (model.getValueAt(i,2).getClass() == Direction.class){
						d = (Direction) model.getValueAt(i, 2);
					}else{
						d = Direction.getDirection( (String) model.getValueAt(i, 2));
					}
					
					newActions[i] = new Action(c1,c2,d);
				}
				
				
				m.getAnt().setActions(newActions);
				
				m.otherWindowOpen = false;
				setVisible(false);
				
				m.resetBoard();
				
				dispose();
					
				
			}
		});
		buttonAccept.setBounds(320, 200, 89, 23);
		contentPane.add(buttonAccept);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//when we decide to cancel anything we have done/changed
				m.otherWindowOpen = false;
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setBounds(419, 200, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnNewAction = new JButton("New Action");
		btnNewAction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model.addRow(new Object[]{null,null,null});
			}
		});
		btnNewAction.setBounds(10, 200, 113, 23);
		contentPane.add(btnNewAction);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				model.removeRow(table.getSelectedRow());
			}
		});
		btnDelete.setBounds(133, 200, 89, 23);
		contentPane.add(btnDelete);
		setVisible(true);
		//table.set
		
		
	}
}
