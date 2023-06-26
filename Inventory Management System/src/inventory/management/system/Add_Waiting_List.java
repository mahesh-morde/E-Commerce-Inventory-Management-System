package inventory.management.system;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import inventory.management.system.DBConnection;

public class Add_Waiting_List extends JFrame implements ActionListener{
	
	JTextField tfname, tfmobile, tfbrand, tfmodel, tfdate;
	JButton add, cancel;
	
	Add_Waiting_List(){
		
		setLayout(null);
		
		JLabel heading = new JLabel("Add To Waiting");
		heading.setFont(new Font("Tahoma", Font.BOLD, 18));
		heading.setBounds(150, 40, 200, 20);
		add(heading);
		
		JLabel lblname = new JLabel("Customer Name");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblname.setBounds(70, 90, 200, 20);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(220 , 90, 200, 20);
		add(tfname);
		
		JLabel lblmobile = new JLabel("Mobile");
		lblmobile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmobile.setBounds(70, 125, 200, 30);
		add(lblmobile);
		
		tfmobile = new JTextField();
		tfmobile.setBounds(220, 130, 200, 20);
		add(tfmobile);
		
		JLabel lblbrand = new JLabel("Brand");
		lblbrand.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbrand.setBounds(70, 175, 200, 20);
		add(lblbrand);
		
		tfbrand = new JTextField();
		tfbrand.setBounds(220, 180, 200, 20);
		add(tfbrand);
		
		JLabel lblmodel = new JLabel("Model");
		lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmodel.setBounds(70, 220, 200, 20);
		add(lblmodel);
		
		tfmodel = new JTextField();
		tfmodel.setBounds(220 , 220, 200, 20);
		add(tfmodel);
		
		add= new JButton("Add to List");
		add.setBounds(250, 350, 150, 20);
		add.addActionListener(this); 
		add(add);
		
		cancel= new JButton("Cancel");
		cancel.setBounds(70, 350, 150, 20);
		cancel.addActionListener(this); 
		add(cancel);
		
		ImageIcon i1 = new ImageIcon("src/icons/5.jpg");
		Image i2 = i1.getImage().getScaledInstance(570, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(440, 45, 530, 370);
		add(image);
		
		
		setBounds(300, 200, 980, 500);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== add) {
			
			String name = tfname.getText();
			String mobile = tfmobile.getText();
			String brand = tfbrand.getText();
			String model = tfmodel.getText();
			
			try {
				DBConnection c = new DBConnection();
				
				String query = "insert into waiting_list (customer_name, mobile, brand, model) values ('"+name+"','"+mobile+"','"+brand+"','"+model+"')";
				
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Data Added Sucessfully");
				
				setVisible(false);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Customer_Waiting();
		}
		
	}

	public static void main(String[] args) {
		new Add_Waiting_List();

	}

}
