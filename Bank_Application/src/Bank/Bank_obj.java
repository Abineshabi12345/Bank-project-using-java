package Bank;

import java.util.*;

public class Bank_obj{

	static ArrayList<Creating_account> accounts = new ArrayList<>();
	   static long acc_no;
	   static Scanner sc=new Scanner(System.in);
	   public static void main(String[] args) throws InterruptedException { 
		
		   boolean flag=true;
		   
		   
		do{
			
			System.out.println("Welcome to State Bank of India");
			System.out.println("==============================");
			System.out.println("1.) Create Account\n2.) Deposit Money\n3.)Withdraw Money\n4.) Check Balance\n5.) Transfer Money\n6.)Transaction History\n7.)Exit");
			System.out.println("Enter the input:");
			int user_input=sc.nextInt();
			switch(user_input){
			
			case 1:
			{
				System.out.println("Enter user name:");
				String name=sc.next();
			    System.out.println("Enter Mobile No:");
                String  Mobile_No=sc.next();
                System.out.println("Enter the address:");
                String address=sc.next();
                System.out.println("Enter the initial deposite amount:");
                double amount=sc.nextDouble();
                System.out.println("Enter the account Type:");
                String acc_type=sc.next();
//                System.out.println("Enter account number:");
//                long acc_num=sc.nextLong();
                System.out.println("Enter Pin:");
                int pin=sc.nextInt();
                System.out.println("Enter password:");
                String psw=sc.next();
                
                if(Mobile_No.length()==10 && amount>=100){
                	
                	   System.out.println("Wait We are generating Account nummber....");  
                	   Thread.sleep(6000);
                	   
                	    acc_no=1000000000+(long)(Math.random()* 9000000000L);
                	   
                	   System.out.println("Your Account number:"+acc_no);
                	     
                }
                else {
                	
                	        System.out.println("Check you Mobile Number and amount");
                }
                Creating_account  acc_detail=new Creating_account(name,Mobile_No,address,amount,acc_type,acc_no,pin,psw);   
                 
                accounts.add(acc_detail);
                
                 System.out.println("Account Created Successfully.....");
                 
                  break;
		  }
			case 2:
			{
				System.out.println("Enter the account number:");
				long user_inp=sc.nextLong();
				System.out.println("Enter Deposite amount:");
				double amo=sc.nextDouble();
				boolean flags=false;
				for(Creating_account acc:accounts)
				{
					if(acc.getAcc_num()==user_inp){
						flags=true;
						acc.account_details();
					    acc.ini_depo+=amo;
					    System.out.println("Amount Deposited Successfully");
					    
					    System.out.println("Available Balance:"+acc.ini_depo);
					    
					 }
					
				}
				
				if(!flags){
					
					System.out.println("Invaild Account Number"); 
				 }
				
				break;
			}
				
				
				
			
			case 3:
			{
				
				System.out.println("Enter the account number:");
				long user_inp=sc.nextLong();
				System.out.println("Enter Withdraw amount:");
				double amo=sc.nextDouble();
				System.out.println("Enter PIN:");
				int pin=sc.nextInt();
				 boolean found=false;
				 for(Creating_account acc:accounts){
					 
					    if(acc.getAcc_num()==user_inp && acc.getPin()==pin){
					    	  
					    	    found=true;
					    	
					    	    if(acc.ini_depo>=amo){
					    	    	
					    	    	     acc.ini_depo-=amo;
					    	    	     acc.history.add("Withdrawn Rs."+amo);
					    	    	     System.out.println("Withdraw Successful");
					    	    	     System.out.println("Available Balance:"+acc.ini_depo);
					    	    }
					    	    else {
					    	    	
					    	    	     System.out.println("Insufficient Balance");
					    	    }
					    }
				}
				 if(!found)
				 {
				     System.out.println("Invalid Account Number or PIN");
				 } 
				 
				break;
				
			}
			case 4:{
				
				System.out.println("Enter the account number:");
				long user_inp=sc.nextLong();
				System.out.println("Enter PIN:");
				int pin=sc.nextInt();
				boolean found=false;
				for(Creating_account acc:accounts){
					 
				    if(acc.getAcc_num()==user_inp && acc.getPin()==pin){
				    	
				    	      found=true;
				    	      
				    	      System.out.println("Current Balance:"+acc.ini_depo);
				    	      
				      }
				}
				 if(!found)
				 {
				     System.out.println("Invalid Account Number or PIN");
				 } 
				    
				break;
		     }
			case 5:
			{
				System.out.println("Sender Account number:");
				long acc1=sc.nextLong();
				System.out.println("Receiver Account number:");
				long acc2=sc.nextLong();
				System.out.println("Enter the amount:");
				double amount=sc.nextDouble();
				System.out.println("Enter PIN:");
				int pin=sc.nextInt();
				Creating_account sender_acc=null;
				Creating_account receiver_acc=null;
				  for(Creating_account acc:accounts) {

					     if(acc.getAcc_num()==acc1 && acc.getPin()==pin){
					    	 
					    	        sender_acc=acc;
					       }
					     else if(acc.getAcc_num()==acc2){
                             
					    	       receiver_acc=acc;
					     }
				  }
				  
				   if(sender_acc==null) {
					   
					      System.out.println("Invalid Sender Account Number or PIN");
				   }
				   else if(receiver_acc==null) {
					   
					   System.out.println("Invalid receiver Account Number");
				   }
				   else if(sender_acc.ini_depo<amount) {
					   
					   System.out.println("Insufficient Balance");
					       
				   }
				   else{
					   
					   sender_acc.ini_depo-=amount;    
					   receiver_acc.ini_depo+=sender_acc.ini_depo;
					   sender_acc.history.add("Deposited Rs."+amount);
					   sender_acc.history.add(
							    "Transferred Rs." + amount +
							    " to Account No : " +receiver_acc
							);
					   receiver_acc.history.add(
							    "Received Rs."+amount+
							    "from Account No :"+sender_acc
							);
					   System.out.println("Transfer Successful");
					   System.out.println("Transferred Amount :"+amount);
					   System.out.println("Available Balance :"+ sender_acc.ini_depo);
					   
				   }
				
				break;
				
			}
			case 6:{
				
				       System.out.println("Sender Account number:");
						long acc_num=sc.nextLong();
						System.out.println("Enter PIN:");
						int pin=sc.nextInt();
						boolean found=false;
						for(Creating_account acc: accounts){
							
							if(acc.getAcc_num()==acc_num && acc.getPin()==pin){
						    	
					    	      found=true;
					    	      
					    	      System.out.println("===== Transaction History =====");
					    	      if(acc.history.isEmpty())
					    	      {
					    	    	     System.out.println("No Transactions Found");
					    	      }
					    	      else{
					    	    	      
					    	    	        for(String h:acc.history){
					    	    	        	
					    	    	        	     System.out.println(h);
					    	    	        }
					    	      }
					    	      
							}
						}
				break;
				
			}
			case 7:{
				
				    flag=false;
				break;
				 
			}
			}
		
		}while(flag);
	   
		}
}



