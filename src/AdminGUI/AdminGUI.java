package AdminGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import init.Credentials;
import init.FDWGUI;

public class AdminGUI implements ActionListener  {
	JFrame choiceframe;

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton goback;
	static String choice;
	
	public void showchoiceframe() {
		choiceframe = new JFrame("SignUp");
		choiceframe.setSize(720, 640);
		choiceframe.setLayout(null);
		choiceframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1 = new JButton("Add Users");
		btn1.setBounds(100, 80, 220, 40);
		btn1.addActionListener(this);
		
		btn2 = new JButton("Modify Users");
		btn2.setBounds(100, 130, 220, 40);
		btn2.addActionListener(this);
		
		btn3 = new JButton("Delete Users");
		btn3.setBounds(100, 180, 220, 40);
		btn3.addActionListener(this);
		
		btn4 = new JButton("Approve and add Stocks");
		btn4.setBounds(380, 80, 220, 40);
		btn4.addActionListener(this);
		
		btn5 = new JButton("Approve Exchange");
		btn5.setBounds(380, 130, 220, 40);
		btn5.addActionListener(this);
		
		btn6 = new JButton("Modify Interest");
		btn6.setBounds(380, 180, 220, 40);
		btn6.addActionListener(this);
		
		goback = new JButton("logout");
		goback.setBounds(220, 230, 220, 40);
		goback.addActionListener(this);
		
		choiceframe.add(btn1);
		choiceframe.add(btn2);
		choiceframe.add(btn3);
		choiceframe.add(btn4);
		choiceframe.add(btn5);
		choiceframe.add(btn6);
		
		choiceframe.add(goback);
		
		choiceframe.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btn1) {
			choiceframe.dispose();
			Credentials c=new Credentials();
			c.showCredentialsform();
				}
		else if(e.getSource()==btn2) {
			JOptionPane.showMessageDialog(btn2, "Successful!");
			showchoiceframe();
		}
	else if(e.getSource()==btn3) {
		JOptionPane.showMessageDialog(btn3, "Successful!");
		showchoiceframe();

		}else if(e.getSource()==btn4) {
			JOptionPane.showMessageDialog(btn4, "Successful!");
			showchoiceframe();
		}
	else if(e.getSource()==btn5) {
		JOptionPane.showMessageDialog(btn5, "Successful!");
		showchoiceframe();

		}
		else if(e.getSource()==goback) {
			choiceframe.dispose();
			FDWGUI d = new FDWGUI();
			d.showbasic();
			}
	}
	
	
	
}