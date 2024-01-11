package init;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AdminGUI.AdminGUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("unused")
public class FDWGUI implements ActionListener {

	JFrame baseframe;
	private JPanel panel;
	private JButton loginbutton;
	private JButton Signupbutton;
	private JButton Exitbutton;
	private JButton admin;
	private JButton customer;
	private JButton manager;
	private JButton demo;
	
	@SuppressWarnings("static-access")
	public
	void showbasic() {
		// TODO Auto-generated method stub
		baseframe = new JFrame("FoodOnWheels");
		baseframe.setSize(720, 640);
		baseframe.setLayout(null);

		loginbutton = new JButton("Login");
		loginbutton.setBounds(220, 80, 220, 50);
		loginbutton.addActionListener(this);

		Signupbutton = new JButton("Signup");
		Signupbutton.setBounds(220, 180, 220, 50);
		Signupbutton.addActionListener(this);

		Exitbutton = new JButton("Exit");
		Exitbutton.setBounds(220, 280, 220, 50);
		Exitbutton.addActionListener(this);
		
		demo = new JButton("Demo");
		demo.setBounds(220, 380, 220, 50);
		demo.addActionListener(this);
		

		baseframe.add(loginbutton);
		baseframe.add(Signupbutton);
		baseframe.add(Exitbutton);
		baseframe.add(demo);
		
		baseframe.setVisible(true);
		baseframe.setDefaultCloseOperation(baseframe.EXIT_ON_CLOSE);

	}
	protected void demo() {
		baseframe = new JFrame("Demo");
		baseframe.setSize(720, 640);
		baseframe.setLayout(null);

		admin = new JButton("Admin");
		admin.setBounds(220, 80, 220, 50);
		admin.addActionListener(this);

		customer = new JButton("Customer");
		customer.setBounds(220, 180, 220, 50);
		customer.addActionListener(this);
		
		manager = new JButton("Manager");
		manager.setBounds(220, 280, 220, 50);
		manager.addActionListener(this);
		
		baseframe.add(admin);
		baseframe.add(customer);
		baseframe.add(manager);
		
		baseframe.setVisible(true);
		baseframe.setDefaultCloseOperation(baseframe.EXIT_ON_CLOSE);

		
	}

	public static void main(String[] args) {
		FDWGUI d = new FDWGUI();
		d.showbasic();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginbutton) {
			LoginGUI logingui=new LoginGUI();
			logingui.showlogingui();
			baseframe.dispose();
		}
		else if (e.getSource() == Signupbutton) {
			SignupGUI signupgui=new SignupGUI();
			signupgui.showchoiceframe();
			baseframe.dispose();
		} 
		else if (e.getSource() == Exitbutton) {
			baseframe.dispose();
			System.exit(1);
		}
		else if(e.getSource()==demo) {
			baseframe.dispose();
			demo();
		}
		
		
		else if (e.getSource() == admin) {
			AdminGUI a=new AdminGUI();
			a.showchoiceframe();
			baseframe.dispose();
		} 
		else if (e.getSource() == customer) {
			baseframe.dispose();
			System.exit(1);
		}
		else if(e.getSource()==manager) {
			baseframe.dispose();
		}
	}
}
