package inventory.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Customer_Waiting extends JFrame implements ActionListener{
	
	JButton cancel, viewlist, addlist, deletelist;

	Customer_Waiting(){
			
			setLayout(null);
	
	viewlist= new JButton("View List");
	viewlist.setBounds(70, 40, 150, 20);
	viewlist.addActionListener(this); 
	add(viewlist);
	
	addlist= new JButton("Add to List");
	addlist.setBounds(250, 40, 150, 20);
	addlist.addActionListener(this); 
	add(addlist);
	
	deletelist= new JButton("Delete List");
	deletelist.setBounds(430, 40, 150, 20);
	deletelist.setForeground(Color.RED);
	deletelist.addActionListener(this); 
	add(deletelist);
	
	cancel= new JButton("Back");
	cancel.setBounds(250, 80, 150, 20);
	cancel.addActionListener(this); 
	add(cancel);
	
	setBounds(400, 200, 650, 150);
	setVisible(true);
	
}

public static void main(String[] args) {
	new Customer_Waiting();
}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== viewlist) {
			setVisible(false);
			new View_Waiting_List();
		}else if(ae.getSource() == addlist) {
			setVisible(false);
			new Add_Waiting_List();
		}else if(ae.getSource() == cancel) {
			setVisible(false);	
		}else if(ae.getSource() == deletelist) {
			setVisible(false);	
			new Delete_Waiting_List();
		}
	}
}
