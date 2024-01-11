import java.text.DecimalFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;

public class Transactions {
	
	private String trans_type;
	private double trans_fee;
	ZonedDateTime trans_date = ZonedDateTime.now();

	Customer C;
    static Transactions [] transactions=new Transactions[5000];



	public Transactions[] getTransactions() {
	return transactions;
}
	public void setTransactions(Transactions[] transactions) {
	this.transactions = transactions;
}


	static int transcount=0;

	DecimalFormat ft = new DecimalFormat("####");
	
	public ZonedDateTime getTrans_date() {
		return trans_date;
	}
	public void setTrans_date(ZonedDateTime trans_date) {
		this.trans_date = trans_date;
	}

	
	public String getTrans_type() {
		return trans_type;
	}
	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}
	public double getTrans_fee() {
		return trans_fee;
	}
	public void setTrans_fee(double trans_fee) {
		this.trans_fee = trans_fee;
	}

	
	
	//parameterised
	Transactions(Customer C, String trans_type, double trans_fee,  ZonedDateTime trans_date){
		this.trans_date=trans_date;
		this.trans_fee=trans_fee;
		this.trans_type=trans_type;
		this.C=C;
	}
	
	//default
	Transactions(){
	}
	
	void viewAllTransactions() {
		System.out.println("\n\n*************************************************************ALL TRANSACTIONS********************************************************************");
		System.out.printf("%-9s%-22s%-22s%-22s%-22s%25s\n","Sr.No","NAME","ACCOUNT NO","TRANSACTION TYPE","TRANSACTION FEE","DATE/TIME");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0; i<transcount; i++) {
			System.out.printf("%-9d%-22s%-22d%-22s%-22.2f%25s\n",(i+1),transactions[i].C.name,transactions[i].C.A.getAccountno(),transactions[i].trans_type,transactions[i].trans_fee,transactions[i].getTrans_date());	
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
	}
	
	
	//method to display deductions
	 void displaydeductions(long accountno) {
		ft = new DecimalFormat("#.##");
		System.out.println("\n\n---------------------------------DEDUCTIONS-------------------------------------");
		int k=1;
		for(int i=0;i<transcount;i++) {
			if (accountno==transactions[i].C.A.getAccountno()) {
				if(transactions[i].trans_type.equals("Tax") || transactions[i].trans_type.equals("Zakat") ) {
					System.out.println(k+". Rs."+ft.format(transactions[i].trans_fee)+"/-"+"\t\tTime : " + transactions[i].getTrans_date());	
					k++;}
			}
			else {
				System.out.println("No Deductions !");
			}
		}
		System.out.println("--------------------------------------------------------------------------------\n");
	}

	
	//method to display transactions
	 void displayTransactions(long accountno) {
		System.out.println("-------------------------------------TRANSACTION DETAILS-----------------------------------------");
		System.out.printf("%-7s%-18s%-23s%25s\n","Sr.","Transactions","Type","Date and Time of Transaction");	
		int k=1;
		for(int i=0;i<transcount;i++) {	
			if (accountno==transactions[i].C.A.getAccountno()) {
				if(transactions[i].trans_type.equals("Withdrawal") || transactions[i].trans_type.equals("Deposit") || transactions[i].trans_type.equals("Interest") || transactions[i].trans_type.equals("Transfer OutGoing") || transactions[i].trans_type.equals("Transfer InComing") ) {
					System.out.printf("%-7sRs.%-15s%-23s%25s\n",k,ft.format(transactions[i].trans_fee),transactions[i].trans_type,transactions[i].getTrans_date());	
					k++;
				}
			}
			else {
				System.out.println("No Transactions !");
			}
		}
		System.out.println("-------------------------------------------------------------------------------------------------");
	}

	

}
