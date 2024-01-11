package init;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Login {

	private JFrame frmLogin;
	private JTextField user;
	private JPasswordField pin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frmLogin.setTitle("Login ");
		frmLogin.setForeground(Color.BLACK);
		frmLogin.setBackground(new Color(0, 0, 0));
		frmLogin.setBounds(100, 100, 464, 376);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(UIManager.getColor("Button.disabledShadow"));
		frmLogin.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setBounds(187, 33, 121, 44);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Candara", Font.BOLD, 32));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(36, 107, 92, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pin :");
		lblNewLabel_2.setForeground(SystemColor.activeCaption);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(91, 164, 92, 14);
		panel.add(lblNewLabel_2);
		
		user = new JTextField();
		user.setToolTipText("");
		user.setBackground(SystemColor.control);
		user.setForeground(Color.BLACK);
		user.setBounds(149, 105, 183, 20);
		panel.add(user);
		user.setColumns(10);
		
		
		JLabel success= new JLabel("");
		success.setBounds(47, 265, 450, 34);
		success.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(success);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(SystemColor.activeCaption);
		btnNewButton.setBackground(SystemColor.window);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username= user.getText();
				String password= pin.getText();
				
				
				if(e.getSource()== btnNewButton) {
					if (password.length()!=0 || username.length()!=0) {
						if (password.length()>=5 ) {
							if(username.equals("Daniyal") && password.equals("151515")) {
								JOptionPane.showMessageDialog(new JFrame(), "Welcome to Your Account !");
							}
							else {
								JOptionPane.showMessageDialog(new JFrame(), "Invalid Account Id or Pin!!");
							}
						}
						else {
							JOptionPane.showMessageDialog(new JFrame(), "Password should have atleast 5 characters!!");							
						}
					}
					else {
						JOptionPane.showMessageDialog(new JFrame(), "Empty Fields!");	
						}
					
				}		
							
			}
		});
		btnNewButton.setBounds(200, 231, 89, 23);
		panel.add(btnNewButton);
		
		pin = new JPasswordField();
		pin.setBackground(SystemColor.control);
		pin.setForeground(Color.BLACK);
		pin.setBounds(149, 162, 183, 20);
		panel.add(pin);
		
	}
}
