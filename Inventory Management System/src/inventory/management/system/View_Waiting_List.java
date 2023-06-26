package inventory.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class View_Waiting_List extends JFrame implements ActionListener{

	JTable table;
	JButton Back, deletewaiting, addwaiting;
	
	View_Waiting_List(){
		setLayout(null);
		
		JLabel l1 = new JLabel("Sr No.");
		l1.setBounds(10,10,105,20);
		add(l1);
		
		JLabel l2 = new JLabel("Name");
		l2.setBounds(110,10,105,20);
		add(l2);
		
		JLabel l3 = new JLabel("Mobile");
		l3.setBounds(210,10,105,20);
		add(l3);
		
		JLabel l4 = new JLabel("Brand");
		l4.setBounds(300,10,105,20);
		add(l4);
		
		JLabel l5 = new JLabel("Model");
		l5.setBounds(400,10,105,20);
		add(l5);
		
		JLabel l6 = new JLabel("Date");
		l6.setBounds(500,10,105,20);
		add(l6);
		
		table = new JTable();
		table.setBounds(10, 40, 585, 420);
		add(table);
		
		try {
			DBConnection c = new DBConnection();
		
			String query = "SELECT * from waiting_list";
			ResultSet rs = c.s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Back = new JButton("Back");
		Back.addActionListener(this);
		Back.setBounds(10, 470, 200, 30);
		add(Back);
		
		deletewaiting= new JButton("Delete Waiting");
		deletewaiting.setBounds(410, 470, 180, 30);
		deletewaiting.setForeground(Color.RED);
		deletewaiting.addActionListener(this); 
		add(deletewaiting);
		
		addwaiting= new JButton("Add To Waiting");
		addwaiting.setBounds(210, 470, 200, 30);
		addwaiting.addActionListener(this); 
		add(addwaiting);
		
		setBounds(420, 160, 610, 540);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== deletewaiting) {
			setVisible(false);
			new Delete_Waiting_List();
		}else if(ae.getSource() == Back) {
			setVisible(false);
			new Customer_Waiting();
		}else if(ae.getSource() == addwaiting) {
			setVisible(false);
			new Add_Waiting_List();
		}		
	}

	public static void main(String[] args) {
		new View_Waiting_List();

	}
}

