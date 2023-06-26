package inventory.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;


public class Dashboard extends JFrame implements ActionListener{
	
	JButton logout, quit, orders, stock, customerwaiting, sell, report;
			
	Dashboard(){
		setBounds(0,0, 1550, 1000);
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("src/icons/3.jpg");
		Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1500, 1000);
		add(image);
		
		orders = new JButton("Orders");
		orders.addActionListener(this);
		orders.setBounds(140, 120, 200, 50);
		orders.setBackground(Color.white);
		orders.setFont(new Font("serif",Font.PLAIN,21));
		image.add(orders);
		
		stock = new JButton("Stock");
		stock.addActionListener(this);
		stock.setBounds(140, 180, 200, 50);
		stock.setBackground(Color.white);
		stock.setFont(new Font("serif",Font.PLAIN,21));
		image.add(stock);
		
		sell = new JButton("Sales");
		sell.addActionListener(this);
		sell.setBounds(140, 240, 200, 50);
		sell.setBackground(Color.white);
		sell.setFont(new Font("serif",Font.PLAIN,21));
		image.add(sell);
		
		customerwaiting = new JButton("Customer Waiting");
		customerwaiting.addActionListener(this);
		customerwaiting.setBounds(140, 300, 200, 50);
		customerwaiting.setBackground(Color.white);
		customerwaiting.setFont(new Font("serif",Font.PLAIN,21));
		image.add(customerwaiting);
		
		logout = new JButton("Logout");
		logout.addActionListener(this);
		logout.setBounds(140, 360, 200, 50);
		logout.setForeground(Color.RED);
		logout.setBackground(Color.white);
		logout.setFont(new Font("serif",Font.PLAIN,21));
		image.add(logout);
		
		quit = new JButton("Quit");
		quit.addActionListener(this);
		quit.setBounds(140, 420, 200, 50);
		quit.setForeground(Color.MAGENTA);
		quit.setBackground(Color.white);
		quit.setFont(new Font("serif",Font.PLAIN,21));
		image.add(quit);

		setVisible(true);
		setBounds(100, 0, 1240, 900);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		 
			if(ae.getSource() == logout) {
			setVisible(false);
			new Login();
				}else if(ae.getSource() == quit) {
			System.exit(0);
				}else if(ae.getSource() == orders){
			new Order();		
				}else if(ae.getSource() == sell){
			new Sell();		
				}else if(ae.getSource() == stock){
			new Stock();		
				}else if(ae.getSource() == customerwaiting){
			new Customer_Waiting();		
				}
//				else if(ae.getSource() == report){
//			new Report();		
//				}
		
	}

	public static void main(String[] args) {
		new Dashboard();

	}


}

