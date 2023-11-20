package bankapp;
public class BankApp {

public static class BankAccount{          //parent class
    public static String accountNumber;
    public static String accountHolderName;
    public static double balance;
    
public BankAccount(){};              //constructor
public BankAccount(String accountNumber,String accountHolderName,double balance){
        BankAccount.accountNumber=accountNumber;
        BankAccount.accountHolderName=accountHolderName;
        BankAccount.balance=balance;
}

public void getinfo(){        //getter method
    System.out.println("Account Number :"+BankAccount.accountNumber);
    System.out.println("Account holder name:"+BankAccount.accountHolderName);
    System.out.println("Balance is :"+BankAccount.balance);
 
}

public void withdraw(double amount){    //withdraw merhod
    if (amount>BankAccount.balance){
        System.out.println("YOU HAVE INSUFFICIENT BALANCE");}
    else{
         BankAccount.balance =  BankAccount.balance- amount;
         System.out.println("The balance after withdrawal is :"+BankAccount.balance);
                }
    }
public void deposit(double amount){       //deposit method
     BankAccount.balance = BankAccount.balance+amount;
    System.out.println("Balance after depositing is :"+BankAccount.balance);}
    
 public void printAccountDetails(){                       //overriding
    System.out.println("ACCOUNT DETAILS:");
    System.out.println("ACCOUNT NUMBER"+BankAccount.accountNumber);
    System.out.println("ACCOUNT HOLDER NAME :"+BankAccount.accountHolderName);
    System.out.println("PRESENT BALANCE:"+BankAccount.balance);
}
    
}

public static class SavingAccount extends BankAccount{ //subclass saving account

    double interest_rate;
   
    public SavingAccount(double interest_rate){
        
        this.interest_rate=interest_rate;
}

public  void  get(){ //getter method
     SavingAccount.balance=SavingAccount.balance+(SavingAccount.balance/this.interest_rate);
    System.out.println("Balance after addding interest is: "+ SavingAccount.balance);
}

public void printAccountDetails(){                         //overriding
    System.out.println("ACCOUNT DETAILS:");
    System.out.println("ACCOUNT NUMBER :"+SavingAccount.accountNumber);
    System.out.println("ACCOUNT HOLDER NAME :"+SavingAccount.accountHolderName);
    System.out.println("PRESENT BALANCE:"+SavingAccount.balance);
}
}

public static class CheckingAccount extends BankAccount{ //subclass checking account
    double overdraftlimit;
    
    public CheckingAccount(double overdraftlimit){
        this.overdraftlimit=overdraftlimit;
    }
    
public void verify_withdraw(double amount){
    if (amount>CheckingAccount.balance+overdraftlimit){
        System.out.println("Your requested withdrawal amount is "+amount+"Insuffiecint Balance.You Cannot Exceed The Overdraft Limit");}
    else{
         CheckingAccount.balance =  CheckingAccount.balance- amount;
         System.out.println("The balance after withdrawal ia :"+CheckingAccount.balance);}
    }    
public void getter(){        // getter
    System.out.println("your overdraft limit is:"+this.overdraftlimit);
}
public void printAccountDetails(){                           //overriding
    System.out.println("ACCOUNT DETAILS:");
    System.out.println("ACCOUNT NUMBER : "+CheckingAccount.accountNumber);
    System.out.println("ACCOUNT HOLDER NAME : "+CheckingAccount.accountHolderName);
    System.out.println("PRESENT BALANCE: "+CheckingAccount.balance);}
}

public static void main(String[] args) {
        BankAccount obj = new BankAccount("123","SABA NIDA",600000);
        CheckingAccount obj1 = new CheckingAccount(8000);
        SavingAccount obj2 = new SavingAccount(10);
        System.out.println("SAVING ACCOUNT");
        obj.getinfo();
        obj.withdraw(5000);
        obj.deposit(1000);
        obj2.get();
        System.out.println();
        obj2.printAccountDetails();  
        System.out.println();
        System.out.println("CHECKING ACCOUNT");
        obj.getinfo();
        obj1.getter();
        obj1.verify_withdraw(700000);
        System.out.println();
        obj1.printAccountDetails();  
        System.out.println();              }
} 


