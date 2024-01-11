
import java.time.ZonedDateTime;
import java.util.Scanner;

public class Account implements AccountOperations {


	private long accountno;
	protected double balance;
	ZonedDateTime date = ZonedDateTime.now();
	private String type;
	protected int trans_no;
	
	
	
	
	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}
	
	public long getAccountno() {
		return accountno;
	}

	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	Transactions T=new Transactions();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getTrans_no() {
		return trans_no;
	}

	public void setTrans_no(int trans_no) {
		this.trans_no = trans_no;
	}

	
	
	//parameterised
	Account(long accountno,double balance, ZonedDateTime date,String type){
		this.accountno=accountno;
		this.balance=balance;
		this.date=date;
		this.type=type;
		this.setTrans_no(0);
		
	}
	
	//default
		Account(){
			
		}
	
	

	@Override
	public void checkbalance(long accountno) {
		// TODO Auto-generated method stub
		for(int i=0;i<Customer.customercount;i++) {
			if (accountno==Customer.getCustomers()[i].A.accountno) {
				System.out.println("\n*************BALANCE INQUIRY********************");
				System.out.println("Name            : "+Customer.getCustomers()[i].name);
				System.out.println("Your Balance is : "+Customer.getCustomers()[i].A.balance);
			}
		}
		
	}


	@Override
	public boolean makeDeposit(long accountno) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("\nEnter the amount you want to deposit : ");
		double amount=input.nextDouble();
		for(int i=0;i<Customer.customercount;i++) {
			if (accountno==Customer.getCustomers()[i].A.accountno) {
				Customer.getCustomers()[i].A.balance+=amount;
				String transactiontype="Deposit";
				ZonedDateTime now = ZonedDateTime.now();
				Transactions CT=new Transactions(Customer.getCustomers()[i],transactiontype,amount,now);
				T.transactions[Transactions.transcount]=CT;
				Transactions.transcount++;
				System.out.println("Operation Successful!\n");
				return true;}
		}
		return false;
	}

	@Override
	public void printStatement(long accountno) {
		// TODO Auto-generated method stub
		for(int i=0;i<Customer.customercount;i++) {
			if (accountno==Customer.getCustomers()[i].A.accountno) {
				System.out.println("\n_________________________________________________________________________");
				System.out.println("********************ACCOUNT STATEMENT************************************");
				System.out.println("-------------------------------------------------------------------------");
				System.out.println("Account Type        :  "+ Customer.getCustomers()[i].A.type+"            ");
				System.out.println("Name                :  "+ Customer.getCustomers()[i].name);
				System.out.println("Address             :  "+ Customer.getCustomers()[i].address);
				System.out.println("Phone               :  "+ Customer.getCustomers()[i].phone);
				System.out.println("Account Number      :  "+Customer.getCustomers()[i].A.accountno);
				System.out.println("Date Created        :  "+ Customer.getCustomers()[i].A.date+" |");
				System.out.println("Balance             :  "+Customer.getCustomers()[i].A.balance);
				System.out.println("------------------------------------------------------------------------");
				System.out.println("                  TRANSACTIONS/DEDUCTIONS                                        ");
				System.out.println("------------------------------------------------------------------------");
				System.out.printf("%-22s%-22s%-22s\n","Amount","Type","Date");
				System.out.println("-------------------------------------------------------------------------");
				for(int j=0;j<Transactions.transcount;j++) {
					if(accountno==T.transactions[j].C.A.getAccountno()) {
						System.out.printf("Rs.%-19.2f%-22s%s/%s",T.transactions[j].getTrans_fee(), T.transactions[j].getTrans_type(),T.transactions[j].trans_date.getMonth(),T.transactions[j].trans_date.getDayOfMonth());
					}
					System.out.println("\n");
				}
				System.out.println("*************************************************************************\n");}}
		
	}

	@Override
	public boolean transferamount(long accountno) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("\nEnter the Bank Account you want to transfer Amount to :");
		double account=input.nextDouble();
		for(int i=0;i<Customer.customercount;i++) {
			if (accountno==Customer.getCustomers()[i].A.accountno) {
				for(int j=0;j<Customer.customercount;j++) {
					if(account==Customer.getCustomers()[j].A.accountno) {		
						//payee info
						System.out.println("\n---------PAYEE INFORMATION---------");
						System.out.println("Account Type        :  "+ Customer.getCustomers()[j].A.type);
						System.out.println("Name                :  "+ Customer.getCustomers()[j].name);
						System.out.println("Address             :  "+ Customer.getCustomers()[j].address);
						System.out.println("Phone               :  "+ Customer.getCustomers()[j].phone);
						System.out.println("\n------------------------------------");
						//transfer
						System.out.println("\nNow enter the Amount you want to transfer :");
						double amount=input.nextDouble();
						Customer.getCustomers()[i].A.balance-=amount;
						Customer.getCustomers()[j].A.balance+=amount;
						String transactiontype="Transfer OutGoing";
						ZonedDateTime now = ZonedDateTime.now();
						Transactions CT=new Transactions(Customer.getCustomers()[i],transactiontype,amount,now);
						T.transactions[Transactions.transcount]=CT;
						Transactions.transcount++;
						String transactiontype1="Transfer InComing";
						Transactions CT_2=new Transactions(Customer.getCustomers()[j],transactiontype1,amount,now);
						T.transactions[Transactions.transcount]=CT_2;
						Transactions.transcount++;
						System.out.println("Operation Successful!\n");
						return true;
					}					
				}
			}
		}
		System.out.println("\nPAYEE Does not Exist.");
		return false;
	}

	@Override
	public boolean makeWithdrawal(long accountno) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void calculateInterest(long accountno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean calculateZakat(long accountno) {
		// TODO Auto-generated method stub
		return false;
	}




	
}
