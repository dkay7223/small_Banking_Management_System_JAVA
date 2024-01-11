
public interface AccountOperations {

	
	void checkbalance(long accountno);
	boolean makeWithdrawal(long accountno);
	boolean makeDeposit(long accountno);
    void printStatement(long accountno);
    boolean transferamount(long accountno) ;
    void calculateInterest(long accountno);
    boolean calculateZakat(long accountno);	
 
}
