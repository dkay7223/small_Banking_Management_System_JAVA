import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Scanner;

public class Checking extends Account
{


	
	public boolean makeDeposit(long accountno) {
		// TODO Auto-generated method stub

		//check if next month has started in real-time
		ZonedDateTime compare = ZonedDateTime.now();
		for(int j=0;j<Transactions.transcount;j++) {
			if(accountno==T.transactions[j].C.A.getAccountno()) {
				if(T.transactions[j].getTrans_type().equals("Tax")) {
					ZonedDateTime now =T.transactions[j].trans_date;
				if(compare.getMonthValue()>now.getMonthValue()) {
				T.transactions[j].C.A.trans_no=0;
				}
				if (compare.getMonthValue()<now.getMonthValue()) {
					if(compare.getYear()>now.getYear()) {
						T.transactions[j].C.A.trans_no=0;
					}
				}
			}
		}
	}
			
		Scanner input=new Scanner(System.in);
		System.out.println("\nEnter the amount you want to deposit : ");
		double amount=input.nextDouble();
		
		for(int i=0;i<Customer.customercount;i++) {
			
			if (accountno==Customer.getCustomers()[i].A.getAccountno()) {
				if(Customer.getCustomers()[i].A.getTrans_no()<2) {	
					
				Customer.getCustomers()[i].A.balance+=amount;
				Customer.getCustomers()[i].A.trans_no++;
				System.out.println("Operation Successful!\n");
				return true;}
					
					else {
						double trans_fee=10;
						Customer.getCustomers()[i].A.balance+=amount-trans_fee;
						Customer.getCustomers()[i].A.trans_no++;
						String transactiontype="Deposit";
						ZonedDateTime now = ZonedDateTime.now();
						Transactions CT=new Transactions(Customer.getCustomers()[i],transactiontype,amount,now);
						T.transactions[Transactions.transcount]=CT;
						Transactions.transcount++;
						 transactiontype="Tax";
						  now = ZonedDateTime.now();
						 CT=new Transactions(Customer.getCustomers()[i],transactiontype,trans_fee,now);
						T.transactions[Transactions.transcount]=CT;
						Transactions.transcount++;
						System.out.println("Rs 10. Transaction fee Deducted.");
						System.out.println("Operation Successful!\n");
					}
				}
			}
		return true;	}
		
	
	//make withdrawal
		public boolean makeWithdrawal(long accountno) {
			Scanner input=new Scanner(System.in);
			
			
			//check if next month has started in real-time
			ZonedDateTime compare = ZonedDateTime.now();
			for(int j=0;j<Transactions.transcount;j++) {
				if(accountno==T.transactions[j].C.A.getAccountno()) {
					if(T.transactions[j].getTrans_type().equals("Tax")) {
						ZonedDateTime now =T.transactions[j].trans_date;
					if(compare.getMonthValue()>now.getMonthValue()) {
					T.transactions[j].C.A.trans_no=0;
					}
					if (compare.getMonthValue()<now.getMonthValue()) {
						if(compare.getYear()>now.getYear()) {
							T.transactions[j].C.A.trans_no=0;
						}
					}
				}
			}
		}
			double trans_fee=10;
	
			System.out.println("Enter the amount you want to Withdraw : ");
			double amount=input.nextDouble();
			for(int i=0;i<Customer.customercount;i++) {
				if(Customer.getCustomers()[i].A.getAccountno()==accountno) {
					
					if(Customer.getCustomers()[i].A.getBalance()-(amount+trans_fee)>=-5010) {
				if(Customer.getCustomers()[i].A.getTrans_no()>=2) {
									Customer.getCustomers()[i].A.balance-=amount+trans_fee;
									Customer.getCustomers()[i].A.trans_no++;
									String transactiontype="Tax";
									ZonedDateTime now = ZonedDateTime.now();
									Transactions CT_1=new Transactions(Customer.getCustomers()[i],transactiontype,trans_fee,now);
									T.transactions[Transactions.transcount]=CT_1;
									Transactions.transcount++;
								    transactiontype="Withdrawal";
								    Transactions CT_2=new Transactions(Customer.getCustomers()[i],transactiontype,amount,now);
									T.transactions[Transactions.transcount]=CT_2;
									Transactions.transcount++;
									System.out.println("Rs.10/- Transaction Fee Deducted");
									System.out.println("Your Balance is : "+Customer.getCustomers()[i].A.balance);
									System.out.println("Operation Successful!\n");
									return true;
								}
							else {
								ZonedDateTime now = ZonedDateTime.now();
								Customer.getCustomers()[i].A.balance-=amount;
								Customer.getCustomers()[i].A.trans_no++;
							    String transactiontype="Withdrawal";
							    Transactions CT_2=new Transactions(Customer.getCustomers()[i],transactiontype,amount,now);
								T.transactions[Transactions.transcount]=CT_2;
								Transactions.transcount++;
								System.out.println("Your Balance is : "+Customer.getCustomers()[i].A.balance);
								System.out.println("Operation Successful!\n");
								return true;
							}
						}
					else {
						while(Customer.getCustomers()[i].A.getBalance()-(amount+trans_fee)<-5010) {
							System.out.println("You can only withdraw Rs. 5000/- at MAX above your Balance.");
							System.out.println("1. Re-Enter The Amount\n2. Exit Withdraw Operation\nEnter your Choice :  ");
							int choice=input.nextInt();
						switch (choice) {
						case 1: {
							System.out.println("Enter Amount : ");
							amount=input.nextDouble();
							break;
						}
						case 2: {
							return true;
						}
						default : {
							System.out.println("Invalid Choice ! ");
							break;
						}
						
						}
						}
						

						if(Customer.getCustomers()[i].A.getTrans_no()>=2) {
														
									Customer.getCustomers()[i].A.balance-=amount+trans_fee;
									Customer.getCustomers()[i].A.trans_no++;
									String transactiontype="Tax";
									ZonedDateTime now = ZonedDateTime.now();
									Transactions CT_1=new Transactions(Customer.getCustomers()[i],transactiontype,trans_fee,now);
									T.transactions[Transactions.transcount]=CT_1;
									Transactions.transcount++;
								    transactiontype="Withdrawal";
								    Transactions CT_2=new Transactions(Customer.getCustomers()[i],transactiontype,amount,now);
									T.transactions[Transactions.transcount]=CT_2;
									Transactions.transcount++;
									System.out.println("Rs.10/- Transaction Fee Deducted");
									System.out.println("Your Balance is : "+Customer.getCustomers()[i].A.balance);
									System.out.println("Operation Successful!\n");
									return true;
								}
							else {
								ZonedDateTime now = ZonedDateTime.now();
								Customer.getCustomers()[i].A.balance-=amount;
								Customer.getCustomers()[i].A.trans_no++;
							    String transactiontype="Withdrawal";
							    Transactions CT_2=new Transactions(Customer.getCustomers()[i],transactiontype,amount,now);
								T.transactions[Transactions.transcount]=CT_2;
								Transactions.transcount++;
								System.out.println("Your Balance is : "+Customer.getCustomers()[i].A.balance);
								System.out.println("Operation Successful!\n");
								return true;
							}
						}
			
		}
			}
			return true;	}

		
		
		//submenu checking
		void menu(long account) {
			Scanner input=new Scanner(System.in);
			System.out.println("\n");
			System.out.println("--------------WELCOME TO YOUR CHECKING ACCOUNT------------");
			System.out.println("|                   1.  Deposit Amount                    |");
			System.out.println("|                   2.  Withdraw Amount                   |");
			System.out.println("|                   3.  Transfer Amount                   |"); 
			System.out.println("|                   4.  Check Balance                     |"); 
			System.out.println("|                   5.  Print Statement                   |"); 	
			System.out.println("|                   6.  Display Deductions                |"); 
			System.out.println("|                   7.  Display Transactions              |"); 
			System.out.println("|                   8.  Exit to Main Menu                 |"); 
			System.out.println(" ---------------------------------------------------------");

			System.out.println("Enter your choice : ");
			int choice=input.nextInt();

			switch(choice) {
			case 1:{
				makeDeposit(account);
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
				T.displaydeductions(account);
				menu( account);
				break;}
			case 7:{
				T.displayTransactions(account);
				menu(account);
				break;
			}
			case 8: {
				break;
			}
			default:{
				System.out.println("Invalid Choice!");break;
			}
			}	

		}

		
}
