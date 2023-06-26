package inventory.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Order extends JFrame implements ActionListener{
	
	JButton order, cancel, vieworder, deleteorder, updateorderstatus;
	
	Order(){
		setLayout(null);
		
		vieworder= new JButton("View Orders");
		vieworder.setBounds(70, 40, 150, 20);
		vieworder.addActionListener(this); 
		add(vieworder);
		
		order= new JButton("Create New Order");
		order.setBounds(250, 40, 150, 20);
		order.addActionListener(this); 
		add(order);
		
		deleteorder= new JButton("Delete Orders");
		deleteorder.setBounds(610, 40, 150, 20);
		deleteorder.setForeground(Color.RED);
		deleteorder.addActionListener(this); 
		add(deleteorder);
		
		updateorderstatus= new JButton("Update Orders Status");
		updateorderstatus.setBounds(430, 40, 150, 20);
		updateorderstatus.addActionListener(this); 
		add(updateorderstatus);
		
		cancel= new JButton("Back");
		cancel.setBounds(330, 80, 150, 20);
		cancel.addActionListener(this); 
		add(cancel);
		
		setBounds(400, 200, 800, 150);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Order();
	}
		
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()== order) {
				setVisible(false);
				new Create_Order();
			}else if(ae.getSource() == cancel) {
				setVisible(false);
			}else if(ae.getSource() == vieworder) {
				setVisible(false);
				new ViewOrder();
			}else if(ae.getSource() == deleteorder) {
				setVisible(false);
				new Delete_Order();
			}else if(ae.getSource() == updateorderstatus) {
				setVisible(false);
				new UpdateOrderStatus();
			}
		}
}