
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Scanner;


public class BankDatabase {
		 
	Customer c=new Customer();
	Transactions t=new Transactions();
	//accounts
    long accountno[]=new long[500];
    String name[]=new String[500];
    String address[]=new String[500];
    double balance[]=new double[500];
    String phone[]=new String[500];
    ZonedDateTime A_date[]=new ZonedDateTime[500];
    int numberTrans[]=new int[500];
    String A_type[]=new String[500];
    //transactions
    String T_type[]=new String[500];
   long T_account[]=new long[500];
    double fee[]=new double[500];
    ZonedDateTime T_date[]=new ZonedDateTime[500];
    
    
    
    //default
    BankDatabase(){
 
    }
    
	
    void convert() {
    	
    for(int i=0;i<Customer.customercount;i++) {
    	accountno[i]=Customer.getCustomers()[i].A.getAccountno();
    	name[i]=Customer.getCustomers()[i].name;
    	address[i]=Customer.getCustomers()[i].address;
    	balance[i]=Customer.getCustomers()[i].A.balance;
    	phone[i]=Customer.getCustomers()[i].phone;
    	A_date[i]=Customer.getCustomers()[i].A.getDate();
    	numberTrans[i]=Customer.getCustomers()[i].A.trans_no;
    	A_type[i]=Customer.getCustomers()[i].A.getType();
    }
    
    for(int i=0; i<Transactions.transcount;i++) {
    	T_type[i]=t.transactions[i].getTrans_type();
    	T_date[i]=t.transactions[i].getTrans_date();
    	fee[i]=t.transactions[i].getTrans_fee();
    	T_account[i]=t.transactions[i].C.A.getAccountno(); 			
    }
    
    }
    
    void read() {
    	
   	 //create file Accounts
   	 try {
   	      File accounts = new File("Accounts.txt");      
   	      if (accounts.createNewFile()) {
   	        System.out.println("File created: " + accounts.getName());
   	      } else {
   	        System.out.println("Accounts File already exists.");
   	      }
   	    } catch (IOException e) {
   	      System.out.println("An error occurred.");
   	      e.printStackTrace();
   	    }
    	
	 //create file Transactions
	 try {
	      File transactions = new File("Transactions.txt");
	      
	      if (transactions.createNewFile()) {
	        System.out.println("File created: " + transactions.getName());
	      } else {
	        System.out.println("Transactions File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }	

   	 //read
   	 try {
   		   File myObj = new File("Accounts.txt");
   		      Scanner myReader = new Scanner(myObj); 		     
   		      int k=0;
   	      while(myReader.hasNext()) {    	  
   	    	  String line = myReader.nextLine();
   	    	  String[] lineArray = line.split(",");    			  
   	    			 long account =Long.parseLong(lineArray[0]);    	    			
   	    			 double bal=Double.parseDouble(lineArray[1]);
  	    			 String nam=lineArray[2];
   	    			 String ty=lineArray[3];	   
   	    			 String ad=lineArray[4];
 	    			 String ph=lineArray[5];
   	    			 int tno=Integer.parseInt(lineArray[6]);	    			 
   	    			 ZonedDateTime zdt = ZonedDateTime.parse( lineArray[7] );
 	    			 Account A=new Account(account, bal,zdt,ty );
   	    			 A.setTrans_no(tno);
   	    			 Customer C=new Customer(nam, ad, ph, A);
   	    			 Customer.getCustomers()[k]=C;
   	    			 Customer.customercount++; 	    		
   	    			 k++;
   	    		  }
   	    	   
   	myReader.close();
   	 }catch (IOException e) {
   	      System.out.println("An error occurred.");
   	      e.printStackTrace();
   	    }
   	 
   	 
   	 
   	 //read transactions
   	 //read
   	 try {
   		   File myObj = new File("Transactions.txt");
   		      Scanner myReader = new Scanner(myObj); 		     
   		      int k=0;
   	      while(myReader.hasNext()) {	    	  
   	    	  String line = myReader.nextLine();
   	    	  String[] lineArray = line.split(",");	    			  
   	    			 long account =Long.parseLong(lineArray[0]);    
   	    			 String ty=lineArray[1];
   	    			 double fee=Double.parseDouble(lineArray[2]);
   	    			 ZonedDateTime zdt = ZonedDateTime.parse( lineArray[3] );   	    		
   	    			 int i=0;
   	    			 for( i=0; i<Customer.customercount;i++) {
   	    				 if(account==Customer.getCustomers()[i].A.getAccountno()) {
   	    					 break;
   	    				 }
   	    			 }  	    			 
   	    			Transactions T=new Transactions(Customer.getCustomers()[i],ty,fee,zdt);
   	    			t.transactions[k]=T;
   	    			Transactions.transcount++;  		
   	    			 k++;
   	    		  }
   	    	   
   	myReader.close();
   	 }catch (IOException e) {
   	      System.out.println("An error occurred.");
   	      e.printStackTrace();
   	    }   	
    }
	
 void writeAccounts() {
	 //create file Accounts
	 try {
	      File accounts = new File("Accounts.txt");      
	      if (accounts.createNewFile()) {
	        System.out.println("File created: " + accounts.getName());
	      } else {
	        System.out.println("Accounts File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }	 
	 	 //write to a file
	 try {
		  FileWriter myWriter = new FileWriter("Accounts.txt");
	      for(int i=0;i<Customer.customercount;i++) {
	    myWriter.write(accountno[i]+",");
	    myWriter.write(balance[i]+",");
	    myWriter.write(name[i]+",");
	    myWriter.write(A_type[i]+",");
	    myWriter.write(address[i]+",");
	    myWriter.write(phone[i]+",");
	    myWriter.write(numberTrans[i]+",");
	    myWriter.write(A_date[i]+"");
	    myWriter.write("\n");}
	    myWriter.close();
	      System.out.println("Successfully wrote to the Accounts file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    } 	 
 }
	      
 
 void writeTransactions() {
	 //create file Transactions
	 try {
	      File transactions = new File("Transactions.txt");
	      
	      if (transactions.createNewFile()) {
	        System.out.println("File created: " + transactions.getName());
	      } else {
	        System.out.println("Transactions File already exists.");
	      }
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }	 
	 //write to a file
	 try {
	
		  FileWriter myWriter = new FileWriter("Transactions.txt");
	      for(int i=0;i<Transactions.transcount;i++) {
	    myWriter.write(T_account[i]+",");
	    myWriter.write(T_type[i]+",");
	    myWriter.write(fee[i]+",");
	    myWriter.write(T_date[i]+"");
	    myWriter.write("\n");}
	    myWriter.close();
	      System.out.println("Successfully wrote to the Transactions file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }	 
 }
	      
	  

	
	

}
