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

public class ViewOrder extends JFrame implements ActionListener{

	JTable table;
	JButton Back, deleteorder, updateorder;
	
	ViewOrder(){
		setLayout(null);
		
		JLabel l1 = new JLabel("Order Id");
		l1.setBounds(10,10,105,20);
		add(l1);
		
		JLabel l2 = new JLabel("Customer Name");
		l2.setBounds(115,10,105,20);
		add(l2);
		
		JLabel l3 = new JLabel("Age");
		l3.setBounds(220,10,105,20);
		add(l3);
		
		JLabel l4 = new JLabel("Gender");
		l4.setBounds(325,10,105,20);
		add(l4);
		
		JLabel l5 = new JLabel("Company");
		l5.setBounds(430,10,105,20);
		add(l5);
		
		JLabel l6 = new JLabel("Model");
		l6.setBounds(535,10,105,20);
		add(l6);
		
		JLabel l7 = new JLabel("Availability");
		l7.setBounds(640,10,105,20);
		add(l7);
		
		JLabel l8 = new JLabel("Location");
		l8.setBounds(745,10,105,20);
		add(l8);
		
		JLabel l9 = new JLabel("Status");
		l9.setBounds(850,10,105,20);
		add(l9);
		
		table = new JTable();
		table.setBounds(10, 40, 945, 420);
		add(table);
		
		try {
			DBConnection c = new DBConnection();
		
			String query = "SELECT orderID, name, age, gender, brand, model, availability, location, status FROM `order`";
			ResultSet rs = c.s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Back = new JButton("Back");
		Back.addActionListener(this);
		Back.setBounds(60, 470, 200, 30);
		add(Back);
		
		deleteorder= new JButton("Delete Orders");
		deleteorder.setBounds(260, 470, 200, 30);
		deleteorder.setForeground(Color.RED);
		deleteorder.addActionListener(this); 
		add(deleteorder);
		
		updateorder= new JButton("Update Order");
		updateorder.setBounds(460, 470, 200, 30);
		updateorder.setForeground(Color.MAGENTA);
		updateorder.addActionListener(this); 
		add(updateorder);
		
		setBounds(300, 200, 980, 540);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== deleteorder) {
			setVisible(false);
			new Delete_Order();
		}else if(ae.getSource() == Back) {
			setVisible(false);
			new Order();
		}else if(ae.getSource() == updateorder) {
			setVisible(false);
			new UpdateOrderStatus();
		}		
	}

	public static void main(String[] args) {
		new ViewOrder();

	}
}

