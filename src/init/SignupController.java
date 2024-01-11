package init;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignupController {

	protected void init_Restaurents(JTextField name, JTextField address, JTextField phone, JTextField email,
			JPasswordField password) {
		String Cname = name.getText();
		String Caddress = address.getText();
		String Cemail = email.getText();
		String Cphone = phone.getText();
		String Cpassword = String.valueOf(password.getPassword());
		System.out.println("Name     :"+Cname);
		System.out.println("address  :"+Caddress);
		System.out.println("CNIC     :"+Cemail);
		System.out.println("Phone    :"+Cphone);
		System.out.println("Password :"+Cpassword);
	
	}
	
	protected void init_Customers(JTextField name, JTextField address, JTextField phone, JTextField email,
			JPasswordField password) {
		String Cname = name.getText();
		String Caddress = address.getText();
		String Cemail = email.getText();
		String Cphone = phone.getText();
		String Cpassword = String.valueOf(password.getPassword());
		System.out.println("Name     :"+Cname);
		System.out.println("address  :"+Caddress);
		System.out.println("CNIC     :"+Cemail);
		System.out.println("Phone    :"+Cphone);
		System.out.println("Password :"+Cpassword);

	}
	
	protected void init_Riders(JTextField name, JTextField address, JTextField phone, JTextField email, JPasswordField password) {
		String Cname = name.getText();
		String Caddress = address.getText();
		String Cemail = email.getText();
		String Cphone = phone.getText();
		String Cpassword = String.valueOf(password.getPassword());
		System.out.println("Name     :"+Cname);
		System.out.println("address  :"+Caddress);
		System.out.println("CNIC     :"+Cemail);
		System.out.println("Phone    :"+Cphone);
		System.out.println("Password :"+Cpassword);

	}

}
