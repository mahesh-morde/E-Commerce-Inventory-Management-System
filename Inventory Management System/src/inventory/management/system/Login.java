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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
		JTextField username;
		JPasswordField passward;
		JButton Login, Cancel;
		
	   	Login(){
			
//			getContentPane().setBackground(Color.WHITE);
			
			setLayout(null);
			
			JLabel user = new JLabel("Username");
			user.setBounds(40, 35, 100, 10);
			add(user);
			
			username = new JTextField();
			username.setBounds(150, 20,150, 30);
			add(username);
			
			JLabel pass = new JLabel("Password");
			pass.setBounds(40, 85, 100, 10);
			add(pass);
			
			passward = new JPasswordField();
			passward.setBounds(150, 70,150, 30);
			add(passward);
			
			Login = new JButton("Login");
			Login.setBounds(40,150,120,30);
			Login.setBackground(Color.BLACK);
			Login.addActionListener(this);
			add(Login);
			
			Cancel = new JButton("Cancel");
			Cancel.setBounds(180,150,120,30);
			Cancel.setBackground(Color.BLACK);
			Cancel.addActionListener(this);
			add(Cancel);
			
			ImageIcon i1 = new ImageIcon("src/icons/2.jpg");
			Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel image = new JLabel(i3);
			image.setBounds(350, 10, 200, 200);
			add(image);
			
			setBounds(500,200,600,300);
			setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Login) {
			String user = username.getText();
			String pass = passward.getText();
			
			try {
				DBConnection c = new DBConnection();
				
				String query = "SELECT * FROM login WHERE username = '"+user+"' AND password = '"+pass+"'";
	
				ResultSet rs = c.s.executeQuery(query);
				
				if(rs.next()) {
					setVisible(false);
					new Dashboard();
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Passward\n Try Again");
					setVisible(true);
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource() == Cancel) {
			setVisible(false);
			System.exit(0);
		}
	}

public static void main(String[] args) {
	new Login();

	}

}
