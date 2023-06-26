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

public class Add_Stock extends JFrame implements ActionListener {
	JTextField tfid, tfname, tfbrand, tfmodel, tfprice ,tfunits, tfstatus;
	JButton add, cancel;
	
	Add_Stock(){
		
		setLayout(null);
		
		JLabel heading = new JLabel("Add Stock");
		heading.setFont(new Font("Tahoma", Font.BOLD, 20));
		heading.setBounds(150, 40, 200, 20);
		add(heading);
		
		JLabel lblid = new JLabel("Car_id");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblid.setBounds(70, 90, 200, 20);
		add(lblid);
		
		tfid = new JTextField();
		tfid.setBounds(220 , 90, 200, 20);
		add(tfid);
		
		JLabel lblname = new JLabel("Car_name");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblname.setBounds(70, 125, 200, 30);
		add(lblname);
		
		tfname = new JTextField();
		tfname.setBounds(220, 125, 200, 20);
		add(tfname);
		
		JLabel lblbrand = new JLabel("Brand");
		lblbrand.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblbrand.setBounds(70, 160, 200, 20);
		add(lblbrand);
		
		tfbrand = new JTextField();
		tfbrand.setBounds(220, 160, 200, 20);
		add(tfbrand);
		
		JLabel lblmodel = new JLabel("Model");
		lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmodel.setBounds(70, 195, 200, 20);
		add(lblmodel);
		
		tfmodel = new JTextField();
		tfmodel.setBounds(220 , 195, 200, 20);
		add(tfmodel);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblprice.setBounds(70, 230, 200, 20);
		add(lblprice);
		
		tfprice = new JTextField();
		tfprice.setBounds(220 , 230, 200, 20);
		add(tfprice);
		
		JLabel lblunits = new JLabel("Units");
		lblunits.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblunits.setBounds(70, 265, 200, 20);
		add(lblunits);
		
		tfunits = new JTextField();
		tfunits.setBounds(220 , 265, 200, 20);
		add(tfunits);
		
		JLabel lblstatus = new JLabel("Status");
		lblstatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblstatus.setBounds(70, 295, 200, 20);
		add(lblstatus);
		
		tfstatus = new JTextField();
		tfstatus.setBounds(220 , 295, 200, 20);
		add(tfstatus);
		
		add= new JButton("Add to Stock");
		add.setBounds(250, 350, 150, 20);
		add.addActionListener(this); 
		add(add);
		
		cancel= new JButton("Cancel");
		cancel.setBounds(70, 350, 150, 20);
		cancel.addActionListener(this); 
		add(cancel);
		
		ImageIcon i1 = new ImageIcon("src/icons/AddStock.jpeg");
		Image i2 = i1.getImage().getScaledInstance(700, 400, Image.SCALE_AREA_AVERAGING);
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
			
			String id = tfid.getText();
			String name = tfname.getText();
			String brand = tfbrand.getText();
			String model = tfmodel.getText();
			String price = tfprice.getText(); 
			String units = tfunits.getText(); 
			String status= tfstatus.getText();
			
			try {
				DBConnection c = new DBConnection();
				
				String query = "insert into stock ( car_id, car_name, brand, model, price, units, status) values ('"+id+"','"+name+"','"+brand+"','"+model+"','"+price+"','"+units+"','"+status+"')";
				
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Data Added Sucessfully");
				
				setVisible(false);
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}else {
			setVisible(false);
			new Stock();
		}
		
	}

	public static void main(String[] args) {
		new Add_Stock();

	}

}
