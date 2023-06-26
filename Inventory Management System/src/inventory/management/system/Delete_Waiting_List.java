package inventory.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class Delete_Waiting_List extends JFrame implements ActionListener{
	
		
		Choice srno;
		JTable table;
		JButton Back, deletewaiting, addwaiting;
		
		Delete_Waiting_List(){
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
			table.setBounds(10, 40, 585, 300);
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
			
			addwaiting= new JButton("Add To Waiting");
			addwaiting.setBounds(210, 470, 200, 30);
			addwaiting.addActionListener(this); 
			add(addwaiting);
			
			deletewaiting = new JButton("Delete Waiting");
			deletewaiting.setBounds(410, 470, 180, 30);
			deletewaiting.setForeground(Color.RED);
			deletewaiting.addActionListener(this);
			add(deletewaiting);
			
			JLabel lblroom = new JLabel("Select Sr No. Which you want to remove: ");
			lblroom.setBounds(65, 400, 300, 20);
			add(lblroom); 
			
			srno = new Choice();
			srno.setBounds(370,400,150,25);
			add(srno);
			
			try {
				DBConnection c = new DBConnection();
				
				String query = "select * from waiting_list";
				
				ResultSet rs = c.s.executeQuery(query);
				
				while(rs.next()) {
					srno.add(rs.getString("sr_number"));
				}

			}catch(Exception e) {
				e.printStackTrace();
			}
			
			setBounds(420, 160, 600, 600);
			setVisible(true);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
		    if (e.getSource() == Back) {
		    	setVisible(false);
		    	new Customer_Waiting();
		    } else if(e.getSource() == addwaiting) {
		    	setVisible(false);
		    	new Add_Waiting_List();
		    }else if(e.getSource() == deletewaiting) {
				try {
					DBConnection c = new DBConnection();
					String query = "delete from waiting_list where sr_number = '"+srno.getSelectedItem()+"'";
					c.s.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Record Deleted Successfully");
					
					setVisible(false);
					 
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		        	
		    } 
		}

		
		public static void main(String[] args) {
			new Delete_Waiting_List();

		}


}

