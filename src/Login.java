import java.util.Scanner;

public class Login {
	

Saving saving=new Saving();
Checking checking=new Checking();
	
	
	long logged_in;
	
	boolean login() {
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("\nEnter Your Account Number : ");
		long account=input.nextLong();

		for(int i=0;i<Customer.customercount;i++) {
			if(Customer.getCustomers()[i].A.getAccountno()==account)
			{	String type=Customer.getCustomers()[i].A.getType();
			for(int j=0;j<Customer.customercount;j++) {
				if(Customer.getCustomers()[i].A.getAccountno()==Customer.getCustomers()[j].A.getAccountno()) {
					continue;
				}
				if(Customer.getCustomers()[i].phone==Customer.getCustomers()[j].phone) {
					System.out.println("\nYou Have Both A Saving and a Checking Account.\nWhich One Do You Want To Open.");
					System.out.println("1. Saving\n2. Checking\nEnter Your Choice : ");
					int choice=input.nextInt();
					switch(choice) {
					case 1: {
						if(type.equals("Saving")) {
							saving.menu(account);break;}
						else {
							saving.menu(Customer.getCustomers()[j].A.getAccountno());
							break;
						}
					}	
					case 2:{
						if(type.equals("Checking")) {
							checking.menu(account);
							break;}
						else {
							checking.menu(Customer.getCustomers()[j].A.getAccountno());
							break;}
					}
					default :{
						System.out.println("Invalid Choice !");
						break;
					}
					}
					return true;}
			}
			}
		}
		for(int i=0;i<Customer.customercount;i++) {
			if(Customer.getCustomers()[i].A.getAccountno()==account)
			{	
				System.out.println("Successfully Logged In");
				logged_in=account;
				if(Customer.getCustomers()[i].A.getType().equals("Checking"))
				{
					checking.menu(logged_in);
				}
				else {
					saving.menu(logged_in);
				}

				return true;
			}
		}
		System.out.println("No such Account Exixts");
		return false;
	}

	
	

}
