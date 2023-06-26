package inventory.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateOrderStatus extends JFrame implements ActionListener{
	
	JLabel text, lblid;
	JTextField ccustomer;
	
	JButton update, check, back;
	
	UpdateOrderStatus(){
		setLayout(null);
		
		text = new JLabel("UPDATE ORDER STATUS");
		text.setFont(new Font("Tahoma", Font.BOLD, 20));
		text.setBounds(80, 50, 300, 30);
		add(text);
		
		lblid = new JLabel("Customer ID");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblid.setBounds(40, 130, 180, 20);
		add(lblid);
		
		ccustomer = new JTextField();
		ccustomer.setBounds(200, 130, 180, 25);
		add(ccustomer);
		
		
		
		check = new JButton("Delivered");
		check.setBounds(80, 200, 100, 30);
		check.addActionListener(this);
		add(check);
		
		update = new JButton("Canceled");
		update.setBounds(220, 200, 100, 30);
		update.addActionListener(this);
		add(update);
		
		back = new JButton("Back");
		back.setBounds(150, 250, 100, 30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon("src/icons/orderstatusupdate.jpeg");
		Image i2 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_AREA_AVERAGING);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 30, 500, 300);
		add(image);
		
		setBounds(300, 200, 900, 390);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
	    if(ae.getSource() == check) {
	        String id = ccustomer.getText();
	      
	        try {
	            DBConnection c = new DBConnection();
	            
	            String query = "update `order` set status= 'Delivered' where orderID ='"+id+"'";
	            c.s.executeUpdate(query);

	            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
	            
	            setVisible(false);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	      
	    } else if(ae.getSource() == update) {
	        String id = ccustomer.getText();
	      
	       
	        try {
	            DBConnection c = new DBConnection();
	            
	            String query = "update `order` set status= 'canceled' where orderID='"+id+"'";
	            c.s.executeUpdate(query);

	            JOptionPane.showMessageDialog(null, "Data Updated Successfully");
	            
	            setVisible(false);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    } else if(ae.getSource() == back) {
	    	setVisible(false);
	    	new Order();
	    }
	}


	public static void main(String[] args){
		new UpdateOrderStatus();

	}

}
