import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

public class Manager {

	private String name,address,phone;
	
	
	
	Customer b=new Customer();
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	Manager(){
		
	}
	
	
	boolean openaccount() {
		Random rand=new Random() ; //instance of random class		
		Scanner input=new Scanner(System.in);
		System.out.println("Which Account Do you want to open ? \n1. Checking\n2. Saving\n3. Both");
		System.out.println("Enter your Choice : ");
		int choice=input.nextInt();
		switch(choice) {
		case 1: {
			String accounttype="Checking";
			input.nextLine();
			System.out.println("Enter the name of the Customer ");
			String name=input.nextLine();
			System.out.println("Enter the address of the Customer ");
			String address=input.nextLine();
			System.out.println("Enter the Phone Number of the Customer ");
			String phone=input.next();
			
			for(int i=0;i<Customer.customercount;i++) {
				if(name.equals(Customer.getCustomers()[i].name)) {
					if(address.equals(Customer.getCustomers()[i].address)) {
						if(accounttype.equals(Customer.getCustomers()[i].A.getType())) {
							System.out.println("\nYou already have a Checking Account.\nYou cannot Open More.");
							return false;
						}
					}
				}
			}
			
			long rand_accountno = rand.nextInt((100000 -10000) + 1) + 10000;
			System.out.println("Enter the Opening Balance of the Customer ");
			double balance=input.nextDouble();
			ZonedDateTime date = ZonedDateTime.now();
			Account acc=new Account(rand_accountno,balance,date,accounttype);
			Customer holder=new Customer(name, address,phone,acc);
			Customer.getCustomers()[Customer.customercount]=holder;
			Customer.customercount++;
			System.out.println("Your Account Number is : "+ rand_accountno);
			System.out.println("******Checking Account Opened******\n");
			break;
		}
		case 2: {
			String accounttype="Saving";
			input.nextLine();
			System.out.println("Enter the name of the Customer ");
			String name=input.nextLine();
			System.out.println("Enter the address of the Customer ");
			String address=input.nextLine();
			System.out.println("Enter the Phone Number of the Customer ");
			String phone=input.next();
			
			for(int i=0;i<Customer.customercount;i++) {
				if(name.equals(Customer.getCustomers()[i].name)) {
					if(address.equals(Customer.getCustomers()[i].address)) {
						if(accounttype.equals(Customer.getCustomers()[i].A.getType())) {
							System.out.println("\nYou already have a Saving Account.\nYou cannot Open More.");
							return false;
						}
					}
				}
			}
			
			long rand_accountno = rand.nextInt((100000 -10000) + 1) + 10000;
			System.out.println("Enter the Opening Balance of the Customer ");
			double balance=input.nextDouble();
			ZonedDateTime date = ZonedDateTime.now();
			Account acc=new Account(rand_accountno,balance,date,accounttype);
			Customer holder=new Customer(name, address,phone,acc);
			Customer.getCustomers()[Customer.customercount]=holder;
			Customer.customercount++;
			System.out.println("Your Account Number is : "+ rand_accountno);
			System.out.println("******Saving Account Opened******");
			break;
		}		
		case 3:{
			
			String accounttype="Checking";
			input.nextLine();
			System.out.println("Enter the name of the Customer ");
			String name=input.nextLine();
			System.out.println("Enter the address of the Customer ");
			String address=input.nextLine();
			System.out.println("Enter the Phone Number of the Customer ");
			String phone=input.next();
			
			for(int i=0;i<Customer.customercount;i++) {
				if(name.equals(Customer.getCustomers()[i].name)) {
					if(address.equals(Customer.getCustomers()[i].address)) {
							System.out.println("\nYou already have one of the Two Accounts.\nYou cannot Open Two Account of Same Account Type.");
							return false;
					}
				}
			}
			
			long rand_accountno = rand.nextInt((100000 -10000) + 1) + 10000;
			System.out.println("Enter the Opening Balance of the Customer for Checking Account ");
			double balance=input.nextDouble();
			ZonedDateTime date = ZonedDateTime.now();
			Account acc_1=new Account(rand_accountno,balance,date,accounttype);
			Customer holder_1=new Customer(name, address,phone,acc_1);
			Customer.getCustomers()[Customer.customercount]=holder_1;
			Customer.customercount++;
			System.out.println("Your Account Number is for Checking Account is : "+ rand_accountno);
			System.out.println("******Checking Account Opened******\n");
			accounttype="Saving";
			input.nextLine();
			 rand_accountno = rand.nextInt((100000 -10000) + 1) + 10000;
			System.out.println("Enter the Opening Balance of the Customer for Saving Account");
			 balance=input.nextDouble();
			 date = ZonedDateTime.now();
				Account acc_2=new Account(rand_accountno,balance,date,accounttype);
				Customer holder_2=new Customer(name, address,phone,acc_2);
			Customer.getCustomers()[Customer.customercount]=holder_2;
			 Customer.customercount++;
			System.out.println("Your Account Number for Saving Account is : "+ rand_accountno);
			System.out.println("******Saving Account Opened******");
		break;
		}
		}
		return true;
	}
	
	boolean closeaccount() {
		Scanner input=new Scanner(System.in);
		System.out.println("\nEnter the account Number you want to close :");
		long account=input.nextLong();
		for(int i=0;i<Customer.customercount;i++) {
			if (account==Customer.getCustomers()[i].A.getAccountno()) {
				System.out.println("----Account Details Below----");
				System.out.println("Name : "+Customer.getCustomers()[i].name);	
				System.out.println("Account Number : "+Customer.getCustomers()[i].A.getAccountno());			
				System.out.println("\nDo you want to delete this account ?\n1. Yes\n2. No\nEnter Your Choice");
				int choice=input.nextInt();
				switch(choice) {
				case 1: {
					for(int j = i; j <Customer.customercount - 1; j++){
						b.getCustomers()[j] = b.getCustomers()[j+1];} 
					Customer.customercount--;
					System.out.println("Account Deleted Successfully");
					break;
				}
				case 2:{
					System.out.println("As you wish!");
					break;
				}
				default: {
					System.out.println("Invalid Choice !");
					break;
				}
				}
		return true;	}
		}	
		System.out.println("Account Does not Exist");
		return false;
	}
	
	
	
	
 
	
	
	
	
}
