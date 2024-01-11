import java.util.Scanner;

public class Bank {
	
	private final String Owner;
	private final String phone;
	private final String email;
	
	public String getOwner() {
		return Owner;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}
	
	
	Bank(){
		Owner="Usman";
		phone="03335558960";
		email="hello@ubl.edu.pk";
	}

	
	void owner() {
		System.out.println("\n*****OWNER*****");
		System.out.println("Name : "+getOwner());
		System.out.println("Phone : "+getPhone());
		System.out.println("Email : "+getEmail());
		System.out.println("\n");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank B=new Bank();
		BankDatabase BD=new BankDatabase();
		Account A=new Account();
		Manager M=new Manager();
		Login L=new Login();
		Saving saving=new Saving();
		Transactions T=new Transactions();
		 Customer C = new Customer();

		
		BD.read();
		
		System.out.println("	  \t\t   WELCOME \n\t\tTO THE ACCOUNT MANAGEMENT SYSTEM\n\n");
		int choice=0;
		do {
			Scanner input=new Scanner(System.in);
			System.out.println("\t\t__________________________");
			System.out.println("\t\t|*******MAIN MENU********|");
			System.out.println("\t\t|------------------------|");
			System.out.println("\t\t|1. Open a New Account   |");
			System.out.println("\t\t|2. Close an account     |");
			System.out.println("\t\t|3. Login to Your Account|"); 
			System.out.println("\t\t|4. Specify Interest Rate|"); 
			System.out.println("\t\t|5. Print Owner Details  |");
			System.out.println("\t\t|6. All Accounts Details |");
			System.out.println("\t\t|7. View All Transactions|");
			System.out.println("\t\t|8. Exit                 |");
			System.out.println("\t\t ------------------------");
			System.out.println("\t\tEnter your choice : ");
			choice=input.nextInt();
			switch(choice) {
			case 1:{
				M.openaccount();
				break;
			}
			case 2: {
				M.closeaccount();
				break;
			}
			case 3:{L.login();
			break;
			}
			case 4: {
				System.out.println("Please Specify the Interest Rate for all Saving Accounts.");
				double rate=input.nextDouble();
				saving.setInterestrate(rate);
				break;
			}
			case 5:{
				B.owner();
				break;
			}
			
			case 6:{
				C.viewAllCustomers();
				break;
			}
			case 7:{
				
				T.viewAllTransactions();
				break;
			}
			case 8: {
				BD.convert();
				BD.writeAccounts();
				BD.writeTransactions();
				choice=8;System.out.println("\n\n\t\t\tEXITING!\n\t\t********THANKYOU******* "); break;
			}
			}
		}while(choice!=8);
		
	
		
		
		

	}

}
