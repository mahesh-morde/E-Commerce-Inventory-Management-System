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

public class Create_Order extends JFrame implements ActionListener{
	
	JTextField tfname, tfage, tfcompany, tfcarmodel, tflocation;
	JButton order, cancel;
	JComboBox gendercombo, caravailablecombo ;
	
	Create_Order(){
		
		setLayout(null);
		
		JLabel heading = new JLabel("Order Details");
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
		
		JLabel lblage = new JLabel("Age");
		lblage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblage.setBounds(70, 125, 200, 30);
		add(lblage);
		
		tfage = new JTextField();
		tfage.setBounds(220, 130, 200, 20);
		add(tfage);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblgender.setBounds(70, 175, 200, 20);
		add(lblgender);
		
		String genderoptions[] = {"Male" , "Female"};
		gendercombo = new JComboBox(genderoptions);
		gendercombo.setBounds(220, 175, 200, 20);
		add(gendercombo);
		
		JLabel lblcompany = new JLabel("Car Company");
		lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblcompany.setBounds(70, 220, 200, 20);
		add(lblcompany);
		
		tfcompany = new JTextField();
		tfcompany.setBounds(220 , 220, 200, 20);
		add(tfcompany);
		
		JLabel lblcarmodel = new JLabel("Car Model");
		lblcarmodel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblcarmodel.setBounds(70, 260, 200, 20);
		add(lblcarmodel);
		
		tfcarmodel = new JTextField();
		tfcarmodel.setBounds(220 , 260, 200, 20);
		add(tfcarmodel);
		
		JLabel lblavailable = new JLabel("Availability");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblavailable.setBounds(70, 300, 200, 20);
		add(lblavailable);
		
		String caravaillableoptions[] = {"Available" , "Not-Available"};
		caravailablecombo = new JComboBox(caravaillableoptions);
		caravailablecombo.setBounds(220, 300, 200, 20);
		add(caravailablecombo);
		
		JLabel lbllocation = new JLabel("Delivery Location");
		lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbllocation.setBounds(70, 340, 200, 20);
		add(lbllocation);
		
		tflocation = new JTextField();
		tflocation.setBounds(220 , 340, 200, 20);
		add(tflocation);
		
		
		order= new JButton("Generate Order");
		order.setBounds(250, 410, 150, 20);
		order.addActionListener(this); 
		add(order);
		
		cancel= new JButton("Cancel");
		cancel.setBounds(70, 410, 150, 20);
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
		if(ae.getSource()== order) {
			
			String name = tfname.getText();
			String age = tfage.getText();
			String company = tfcompany.getText();
			String gender = (String) gendercombo.getSelectedItem();
			String model = tfcarmodel .getText();
			String available = (String) caravailablecombo.getSelectedItem();
			String Location = tflocation.getText();
			
			try {
				DBConnection c = new DBConnection();
				
				String query = "insert into `order`  (name, age, gender, brand, model, availability, location) values ('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+Location+"')";
				
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Order Generated Sucessfully");
				
				setVisible(false);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Order();
		}
		
	}

	public static void main(String[] args) {
		new Create_Order();

	}

}
