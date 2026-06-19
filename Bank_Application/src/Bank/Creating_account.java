package Bank;

import java.util.ArrayList;

public class Creating_account{

	private String Customer_name;
	private String mobile_no;
	private String address;
            double ini_depo;
	private String account_type;
	final private long acc_num;
	private int pin;
	private String Psw;
	static String Bank_name="State Bank of India";
 	 ArrayList<String> history = new ArrayList<>();
	
	public Creating_account(String Customer_name,String Mobile_no,String address,double ini_depo,String account_type,long acc_num,int pin,String psw) {

	     this.Customer_name=Customer_name;
	     this.mobile_no=Mobile_no;
	     this.address=address;
	     this.ini_depo=ini_depo;
	     this.account_type=account_type;
	     this.acc_num=acc_num;
	     this.pin=pin;
	     this.Psw=psw;
	}

	public String getCustomer_name() {
		return Customer_name;
	}

	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getPsw() {
		return Psw;
	}

	public void setPsw(String psw) {
		Psw = psw;
	}

	public long getAcc_num() {
		return acc_num;
	}
	public void account_details() {
		
		  System.out.println(Bank_name);
		  System.out.println("Customer Name:"+Customer_name);
		  System.out.println("Mobile No:"+mobile_no);
		  System.out.println("Address :"+address);
		  System.out.println("Account type:"+account_type);
		  System.out.println("Account number:"+acc_num);
		  System.out.println("Account Balance:"+ini_depo);
		  
	}
	
	 
}
