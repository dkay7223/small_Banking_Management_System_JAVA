
public class Customer {

	String name,address,phone;
	
	
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
	public static int getCustomercount() {
		return customercount;
	}
	public void setCustomercount(int customercount) {
		Customer.customercount = customercount;
	}


	Account A;
	static Customer[] customers=new Customer[500];
	static int customercount=0;
	
	
	
	public static Customer[] getCustomers() {
		return customers;
	}
	public static void setCustomers(Customer[] customers) {
		Customer.customers = customers;
	}
	
	
	//parameterised constructor
	Customer(String name, String address, String phone, Account A){
		this.address=address;
		this.name=name;
		this.phone=phone;
		this.A=A;
	}
	
	//default constructor
	Customer(){
	}
	
	
	void viewAllCustomers() {
		System.out.println("\n\n*************************************************************************ALL ACCOUNTS*********************************************************************************");
		System.out.printf("%-9s%-22s%-22s%-22s%-22s%-22s%25s\n","Sr.No","NAME","PHONE","ACCOUNT TYPE","ACCOUNT NO.","BALANCE","DATE");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0; i<customercount; i++) {
			System.out.printf("%-9d%-22s%-22s%-22s%-22d%-22.2f%-22s\n",(i+1),customers[i].name,customers[i].phone,customers[i].A.getType(),customers[i].A.getAccountno(),customers[i].A.balance,customers[i].A.getDate());	
		}
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n");
	}
	
}
