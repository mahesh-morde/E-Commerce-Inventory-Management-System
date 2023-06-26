
package inventory.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Stock extends JFrame implements ActionListener{
	
	JButton cancel, viewstock, addstock, deletestock, updatestock;

	Stock(){
			
			setLayout(null);
	
	viewstock= new JButton("View Stock");
	viewstock.setBounds(70, 40, 150, 20);
	viewstock.addActionListener(this); 
	add(viewstock);
	
	addstock= new JButton("Add to Stock");
	addstock.setBounds(250, 40, 150, 20);
	addstock.addActionListener(this); 
	add(addstock);
	
	deletestock= new JButton("Delete Stock");
	deletestock.setBounds (610, 40, 150, 20);
	deletestock.setForeground(Color.RED);
	deletestock.addActionListener(this); 
	add(deletestock);
	
	cancel= new JButton("Back");
	cancel.setBounds(330, 80, 150, 20);
	cancel.addActionListener(this); 
	add(cancel);
	
	updatestock= new JButton("Update Stock");
	updatestock.setBounds(430, 40, 150, 20);
	updatestock.addActionListener(this); 
	add(updatestock);
	
	setBounds(400, 200, 800, 150);
	setVisible(true);
	
}

public static void main(String[] args) {
	new Stock();
}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== viewstock) {
			setVisible(false);
			new View_Stock();
		}else if(ae.getSource() == addstock) {
			setVisible(false);
			new Add_Stock();
		}else if(ae.getSource() == cancel) {
			setVisible(false);	
		}else if(ae.getSource() == deletestock) {
			setVisible(false);	
			new Delete_Stock();
		}else if(ae.getSource() == viewstock) {
			setVisible(false);	
			new View_Stock();
		}else if(ae.getSource() == updatestock) {
			setVisible(false);	
			new Update_Stock();
		}
	}
}

