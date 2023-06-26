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

public class Delete_Order extends JFrame implements ActionListener{
	
		
		Choice id;
		JTable table;
		JButton Back, delete, updateorder;
		
		Delete_Order(){
	setLayout(null);
			
	JLabel l1 = new JLabel("OrderID");
	l1.setBounds(0,10,106,20);
	add(l1);

	JLabel l2 = new JLabel("Name");
	l2.setBounds(116,10,222,20);
	add(l2);

	JLabel l3 = new JLabel("Age");
	l3.setBounds(232,10,338,20);
	add(l3);

	JLabel l4 = new JLabel("Gender");
	l4.setBounds(358,10,454,20);
	add(l4);

	JLabel l5 = new JLabel("Company");
	l5.setBounds(464,10,570,20);
	add(l5);

	JLabel l6 = new JLabel("Model");
	l6.setBounds(580,10,686,20);
	add(l6);

	JLabel l7 = new JLabel("Availability");
	l7.setBounds(696,10,802,20);
	add(l7);
	
	JLabel l8 = new JLabel("Location");
	l8.setBounds(812,10,928,20);
	add(l8);

	JLabel l9 = new JLabel("Status");
	l9.setBounds(938,10,1044,20);
	add(l9);
			
			table = new JTable();
			table.setBounds(0, 40, 1050, 300);
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
			Back.setBounds(50, 500, 120, 30);
			add(Back);
			
			delete = new JButton("Delete Order");
			delete.addActionListener(this);
			delete.setBounds(170, 500, 200, 30);
			delete.setForeground(Color.RED);
			add(delete);
			
			updateorder = new JButton("Update Order");
			updateorder.addActionListener(this);
			updateorder.setBounds(370, 500, 200, 30);
			updateorder.setForeground(Color.MAGENTA);
			add(updateorder);
			
			JLabel lblroom = new JLabel("Select Order Which you want to remove: ");
			lblroom.setBounds(65, 400, 300, 20);
			add(lblroom); 
			
			id = new Choice();
			id.setBounds(370,400,150,25);
			add(id);
			
			try {
				DBConnection c = new DBConnection();
				
				String query = "select * from `order`";
				
				ResultSet rs = c.s.executeQuery(query);
				
				while(rs.next()) {
					id.add(rs.getString("orderID"));
				}

			}catch(Exception e) {
				e.printStackTrace();
			}
			
			setBounds(300, 200, 1050, 600);
			setVisible(true);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
		    if (e.getSource() == Back) {
		    	setVisible(false);
		    	new Order();
		    } else if(e.getSource() == updateorder) {
		    	setVisible(false);
		    	new UpdateOrderStatus();
		    }else if(e.getSource() == delete) {
				
				try {
					DBConnection c = new DBConnection();
					String query = "delete from `order` where orderID = '"+id.getSelectedItem()+"'";
					c.s.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Order Record Deleted Successfully");
					
					setVisible(false);
					 
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		        	
		    } 
		}

		
		public static void main(String[] args) {
			new Delete_Order();

		}


}
