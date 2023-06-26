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
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class View_Stock extends JFrame implements ActionListener{

	JTable table;
	JButton Back;
	
	View_Stock(){
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("src/icons/Stock.jpeg");
		Image i2 = i1.getImage().getScaledInstance(490, 595, Image.SCALE_AREA_AVERAGING);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(550, 0, 600, 600);
		add(image);
		
		JLabel l1 = new JLabel("Car Id");
		l1.setBounds(5,10,80,20);
		add(l1);
		
		JLabel l2 = new JLabel("Car Name");
		l2.setBounds(90,10,80,20);
		add(l2);
		
		JLabel l3 = new JLabel("Brand");
		l3.setBounds(175,10,80,20);
		add(l3);
		
		JLabel l4 = new JLabel("Model");
		l4.setBounds(265,10,80,20);
		add(l4);
		
		JLabel l5 = new JLabel("Price");
		l5.setBounds(350,10,80,20);
		add(l5);
		
		JLabel l6 = new JLabel("Units");
		l6.setBounds(435,10,80,20);
		add(l6);
		
		JLabel l7 = new JLabel("Ststus");
		l7.setBounds(520,10,80,20);
		add(l7);
		
		table = new JTable();
		table.setBounds(5, 40, 600, 400);
		add(table);
		
		try {
			DBConnection c = new DBConnection();
		
			String query = "select * from stock";
			ResultSet rs = c.s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Back = new JButton("Back");
		Back.addActionListener(this);
		Back.setBounds(200, 480, 150, 30);
		add(Back);
		
		setBounds(250, 200, 1100, 600);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Stock();
		
	}

	public static void main(String[] args) {
		new View_Stock();

	}
}