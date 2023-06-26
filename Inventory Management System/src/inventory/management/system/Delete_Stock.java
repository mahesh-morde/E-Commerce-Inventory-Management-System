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

public class Delete_Stock extends JFrame implements ActionListener{
	
		
		Choice id;
		JTable table;
		JButton Back, delete, updatestock;
		
		Delete_Stock(){
	setLayout(null);
			
	JLabel l1 = new JLabel("Car ID");
	l1.setBounds(10,10,106,20);
	add(l1);

	JLabel l2 = new JLabel("Car Name");
	l2.setBounds(138,10,128,20);
	add(l2);

	JLabel l3 = new JLabel("Brand");
	l3.setBounds(268,10,128,20);
	add(l3);

	JLabel l4 = new JLabel("Model");
	l4.setBounds(395,10,128,20);
	add(l4);

	JLabel l5 = new JLabel("Price");
	l5.setBounds(525,10,128,20);
	add(l5);

	JLabel l6 = new JLabel("Units");
	l6.setBounds(650,10,128,20);
	add(l6);

	JLabel l7 = new JLabel("Status");
	l7.setBounds(780,10,128,20);
	add(l7);
			
			table = new JTable();
			table.setBounds(10, 40, 900, 300);
			add(table);
			
			try {
				DBConnection c = new DBConnection();
			
				String query = "SELECT * FROM stock";
				ResultSet rs = c.s.executeQuery(query);
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			Back = new JButton("Back");
			Back.addActionListener(this);
			Back.setBounds(50, 500, 120, 30);
			add(Back);
			
			delete = new JButton("Delete Stock");
			delete.addActionListener(this);
			delete.setBounds(170, 500, 200, 30);
			delete.setForeground(Color.RED);
			add(delete);
			
			updatestock = new JButton("Update Stock");
			updatestock.addActionListener(this);
			updatestock.setBounds(370, 500, 200, 30);
			updatestock.setForeground(Color.MAGENTA);
			add(updatestock);
			
			JLabel lblroom = new JLabel("Select Stock Which you want to remove: ");
			lblroom.setBounds(65, 400, 300, 20);
			add(lblroom); 
			
			id = new Choice();
			id.setBounds(370,400,150,25);
			add(id);
			
			try {
				DBConnection c = new DBConnection();
				
				String query = "select * from stock";
				
				ResultSet rs = c.s.executeQuery(query);
				
				while(rs.next()) {
					id.add(rs.getString("car_id"));
				}

			}catch(Exception e) {
				e.printStackTrace();
			}
			
			setBounds(300, 200, 920, 600);
			setVisible(true);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
		    if (e.getSource() == Back) {
		    	setVisible(false);
		    	new Order();
		    } else if(e.getSource() == updatestock) {
		    	setVisible(false);
		    	new Update_Stock();
		    }else if(e.getSource() == delete) {
				
				try {
					DBConnection c = new DBConnection();
					String query = "delete from stock where orderID = '"+id.getSelectedItem()+"'";
					c.s.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Stock Record Deleted Successfully");
					
					setVisible(false);
					 
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		        	
		    } 
		}

		
		public static void main(String[] args) {
			new Delete_Stock();

		}


}
