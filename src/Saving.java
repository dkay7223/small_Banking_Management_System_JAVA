import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Scanner;

public class Saving extends Account {

	private double interestrate=0.025;
	
	

	
	
	
	DecimalFormat ft = new DecimalFormat("####");

	public double getInterestrate() {
		return interestrate;
	}

	public void setInterestrate(double interestrate) {
		this.interestrate = interestrate;
		System.out.println("New Interest Rate Specified Successfully.\n");
	}
	
	
	
	
	//make withdrawal
		public boolean makeWithdrawal(long accountno) {
			Scanner input=new Scanner(System.in);
			System.out.println("Enter the amount you want to Withdraw : ");
			double amount=input.nextDouble();
			for(int i=0;i<Customer.customercount;i++) {
				if (accountno==Customer.getCustomers()[i].A.getAccountno()) {
					if(Customer.getCustomers()[i].A.balance>=amount) {
						ZonedDateTime now = ZonedDateTime.now();				
						Customer.getCustomers()[i].A.balance-=amount;				
						String transactiontype="Withdrawal";
						Transactions CT=new Transactions(Customer.getCustomers()[i],transactiontype,amount,now);
						T.transactions[Transactions.transcount]=CT;
						Transactions.transcount++;
						System.out.println("Operation Successful!\n");
			return true;}
					else
					{
						System.out.println("Your Balance is : "+Customer.getCustomers()[i].A.balance);
						System.out.println("You Cannot withdarw more than your Balance");
					}
			}
			}
			return false;
			}

		
		
		
		//calculate zakat
		public boolean calculateZakat(long accountno) {
			
			//check if one year has passes in real-time
			ZonedDateTime compare = ZonedDateTime.now();
			for(int j=0;j<Transactions.transcount;j++) {
				if(accountno==T.transactions[j].C.A.getAccountno()) {
					if(T.transactions[j].getTrans_type().equals("Zakat")) {
						ZonedDateTime now =T.transactions[j].trans_date;
					if(!compare.isAfter(now.plusYears(1))) {
					System.out.println("Zakat is Deducted only Once Anually.");	
					return true;
					}
				}
			}
		}
			
			
			
			
			
			 ft = new DecimalFormat("#.##");
			for(int i=0;i<Customer.customercount;i++) {
				if (accountno==Customer.getCustomers()[i].A.getAccountno()) {
					
				
					
					
					
			if(Customer.getCustomers()[i].A.balance>=20000) {
				double zakat=(Customer.getCustomers()[i].A.balance*2.5)/100;
				Customer.getCustomers()[i].A.balance-=zakat;
				System.out.println("Zakat Mondatory on your Balance is "+ft.format(zakat)+" Anually.");
				System.out.println("Zakat Deducted.\nYour Balance is now : "+ft.format(Customer.getCustomers()[i].A.balance));
				ZonedDateTime now = ZonedDateTime.now();
				String transactiontype="Zakat";
				Transactions CT=new Transactions(Customer.getCustomers()[i],transactiontype,zakat,now);
				T.transactions[Transactions.transcount]=CT;
				Transactions.transcount++;
			}
			else {
				System.out.println("Not eligible for Zakat, your balance is below Rs.20,000/-");
			}}}
			return true;
		}
		
		
		//calculate interest s
		public void calculateInterest(long accountno) {
			 ft = new DecimalFormat("#.##");
			for(int i=0;i<Customer.customercount;i++) {
				if (accountno==Customer.getCustomers()[i].A.getAccountno()) {
			double interest=Customer.getCustomers()[i].A.balance*interestrate;
			System.out.println("Your Interest is : "+ft.format(interest));
			Customer.getCustomers()[i].A.balance=Customer.getCustomers()[i].A.balance+Customer.getCustomers()[i].A.balance*interestrate;
			System.out.println("Your Updated Balance is : "+ft.format(Customer.getCustomers()[i].A.balance));
			ZonedDateTime now = ZonedDateTime.now();
			String transactiontype="Interest";
			Transactions CT=new Transactions(Customer.getCustomers()[i],transactiontype,interest,now);
			T.transactions[Transactions.transcount]=CT;
			Transactions.transcount++;
		}
	}
		}
	
	
		
		//sub menu saving
		void menu(long account) {
			Scanner input=new Scanner(System.in);
			System.out.println("\n");
			System.out.println("-------------WELCOME TO YOUR SAVING ACCOUNT------------");
			System.out.println("|                  1.  Deposit Amount                 |");
			System.out.println("|                  2.  Withdraw Amount                |");
			System.out.println("|                  3.  Transfer Amount                |"); 
			System.out.println("|                  4.  Check Balance                  |"); 
			System.out.println("|                  5.  Print Statement                |"); 
			System.out.println("|                  6.  Calculate Zakat                |"); 
			System.out.println("|                  7.  Calculate Interest             |"); 
			System.out.println("|                  8.  Display Deductions             |"); 
			System.out.println("|                  9.  Display Transactions           |"); 
			System.out.println("|                  10. Exit to Main Menu              |"); 
			System.out.println(" -----------------------------------------------------");
			
			System.out.println("Enter your choice : ");
			int choice=input.nextInt();
			
			switch(choice) {
			case 1:{
				super.makeDeposit(account);
				menu( account);
				break;}
			case 2:{
				makeWithdrawal(account);
				menu( account);
				break;}
			case 3:{
				super.transferamount(account);
				menu( account);
				break;}
			case 4:{
				super.checkbalance(account);
				menu( account);
				break;}
			case 5:{
				super.printStatement(account);
				menu( account);
				break;}
			case 6:{
				calculateZakat(account);
				menu( account);
				break;}
			case 7:{
				calculateInterest(account);
				menu( account);
				break;}	
			case 8:{
				T.displaydeductions(account);
				menu( account);
				break;}	
			case 9:{
				T.displayTransactions(account);
				menu(account);
				break;
			}
			case 10: {
				break;
			}
			default:{
				System.out.println("Invalid Choice!");
				break;
			}
			}	
		}
	
	
	
	
}
