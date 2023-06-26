package inventory.management.system;

import javax.swing.*;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Sell extends JFrame implements ActionListener {

	JTable table;
	JButton Back, submit;
	JLabel lblyear;
	JTextField year;
	JCheckBox available;
	
	Sell(){
		setLayout(null);
		
		JLabel text = new JLabel("Sales Report");
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		text.setBounds(450, 30, 200, 30);
		add(text);
		
		lblyear = new JLabel("Report By Year");
		lblyear.setBounds(70, 80, 1000, 20);
		add(lblyear);
		
		year = new JTextField();
		year.setBounds(160, 80, 150, 25);
		add(year);
		
		available = new JCheckBox("Only Display Delivered");
		available.setBounds(450, 80, 400, 25);
		add(available);
		
		JLabel l1 = new JLabel("Brand");
		l1.setBounds(5,170,80,20);
		add(l1);
		
		JLabel l2 = new JLabel("Model");
		l2.setBounds(275,170,80,20);
		add(l2);
		
		JLabel l3 = new JLabel("Units");
		l3.setBounds(535,170,80,20);
		add(l3);
		
		JLabel l4 = new JLabel("Status");
		l4.setBounds(795,170,80,20);
		add(l4);
		
		table = new JTable();
		table.setBounds(5, 200, 1050, 300);
		add(table);
		
		try {
			DBConnection c = new DBConnection();
		
			String query = "select brand , model, count(*) as model_count , status from `order` group by model , status";
			ResultSet rs = c.s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Back = new JButton("Back To Reception");
		Back.addActionListener(this);
		Back.setBounds(80, 500, 200, 30);
		add(Back);
		
		submit = new JButton("Submit");
		submit.addActionListener(this);
		submit.setBounds(150, 120, 120, 25);
		add(submit);
		
		setBounds(200, 90, 1050, 700);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			
			try {
				
				String query1 = "select  brand , model, count(*) as model_count , status from `order` where year = '"+year.getText()+"'group by model ,status";
				String query2 = "select  brand , model, count(*) as model_count , status from `order` where status = 'Delivered' and year = '"+year.getText()+"'group by model ,status";
				
				DBConnection c = new DBConnection();
				ResultSet rs;
				
				if(available.isSelected()) {
					rs = c.s.executeQuery(query2);
				}else {
					rs = c.s.executeQuery(query1);
				}
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			 
		}else {
			setVisible(false);
		}
		
		
	}

	public static void main(String[] args) {
		new Sell();

	}

}
