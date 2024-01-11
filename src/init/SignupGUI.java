package init;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SignupGUI implements ActionListener  {
	JFrame choiceframe;

	private JButton Admin;
	private JButton customer;
	private JButton manager;
	private JButton goback;
	static String choice;
	
	void showchoiceframe() {
		choiceframe = new JFrame("SignUp");
		choiceframe.setSize(720, 640);
		choiceframe.setLayout(null);
		choiceframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Admin = new JButton("As an Admin");
		Admin.setBounds(220, 80, 220, 40);
		Admin.addActionListener(this);
		
		customer = new JButton("As a Customer");
		customer.setBounds(220, 130, 220, 40);
		customer.addActionListener(this);
		
		manager = new JButton("As a Manager");
		manager.setBounds(220, 180, 220, 40);
		manager.addActionListener(this);
		
		goback = new JButton("Go back");
		goback.setBounds(220, 230, 220, 40);
		goback.addActionListener(this);
		
		choiceframe.add(Admin);
		choiceframe.add(customer);
		choiceframe.add(manager);
		choiceframe.add(goback);
		
		choiceframe.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==Admin) {
			SignupGUI.choice="Admin";
			choiceframe.dispose();
			Credentials c=new Credentials();
			c.showCredentialsform();
		}
		else if(e.getSource()==customer) {
			SignupGUI.choice="customer";
			choiceframe.dispose();
			Credentials c=new Credentials();
			c.showCredentialsform();
		}
		else if(e.getSource()==manager) {
			SignupGUI.choice="Manager";
			choiceframe.dispose();
			Credentials c=new Credentials();
			c.showCredentialsform();
		}
		else if(e.getSource()==goback) {
			FDWGUI d = new FDWGUI();
			choiceframe.dispose();
			d.showbasic();
		}
	}
	
	
	
	
	
}
