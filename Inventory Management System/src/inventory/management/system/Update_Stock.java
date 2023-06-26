package inventory.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;



public class Update_Stock extends JFrame implements ActionListener{
	
	JLabel text, lblid;
	JTextField sid , sdata ;
	JCheckBox units, status;
	
	JButton update, check, back;
	
	Update_Stock(){
		setLayout(null);
		
		text = new JLabel("UPDATE STOCK");
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		text.setBounds(150, 50, 300, 30);
		add(text);
		
		lblid = new JLabel("Car ID");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblid.setBounds(90, 130, 180, 20);
		add(lblid);
		
		sid = new JTextField();
		sid.setBounds(170, 130, 165, 25);
		add(sid);
		
		units = new JCheckBox("Update Units");
		units.setBounds(90, 170, 100, 30);
		add(units);
		
		status = new JCheckBox("Update Status");
		status.setBounds(220, 170, 150, 30);
		add(status);
		
		sdata = new JTextField();
		sdata.setBounds(90, 220, 250, 25);
		add(sdata);
		
		
		update = new JButton("Update");
		update.setBounds(90, 270, 100, 30);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(240, 270, 100, 30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon("src/icons/updatestock.jpg");
		Image i2 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_AREA_AVERAGING);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 30, 500, 300);
		add(image);
		
		setBounds(300, 200, 950, 400);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == update) {
			String updata = sdata.getText();
			String id = sid.getText();
			try {
				
				String query1 = "update stock set units= '"+updata+"' where  car_id ='"+id+"'";
				String query2 = "update stock set status= '"+updata+"' where  car_id ='"+id+"'";
				
				DBConnection c = new DBConnection();
				
				
				if(units.isSelected()) {
					c.s.executeUpdate(query1);
				}else if(status.isSelected()){
					c.s.executeUpdate(query2);
				}else {
					JOptionPane.showMessageDialog(null, "Please check the update option");
					setVisible(true);
				}
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			 
		}else {
			setVisible(false);
			new Stock();
		}
		
	}

	public static void main(String[] args){
		new Update_Stock();

	}

	

}
