package inventory.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import inventory.management.system.Login;

public class InventoryManagementSystem extends JFrame implements ActionListener{
	
	InventoryManagementSystem(){
		
setLayout(null);
		
		ImageIcon i1 = new ImageIcon("src/icons/1.jpg");
		JLabel image = new JLabel(i1);
		image.setBounds(0,0,1366,565);
		add(image);
		
		JLabel text1 = new JLabel ("CarZONE");
		text1.setBounds(650,90,1000,90);
		text1.setForeground(Color.RED);
		text1.setFont(new Font("serif",Font.PLAIN,80));
		image.add(text1);
		
		JLabel text = new JLabel ("Find Your Perfect Match on Wheels");
		text.setBounds(600,200,1000,90);
		text.setForeground(Color.RED);
		text.setFont(new Font("serif",Font.PLAIN,50));
		image.add(text);
		
		JButton next = new JButton("Next");
		next.setBounds(1110,450,150,50);
		next.setBackground(Color.white);
		next.setForeground(Color.MAGENTA);
		next.setFont(new Font("serif",Font.PLAIN,21));
		next.addActionListener(this);
		image.add(next);
		
		
		setVisible(true);
		setBounds(37,140,1366,565);
		
		while(true) {
			text.setVisible(false);
			try{
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try{
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new InventoryManagementSystem();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
		new Login();		
	}

}
