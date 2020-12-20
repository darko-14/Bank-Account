import java.util.Scanner;

public class Bank {
    public static void main(String[] args){
        Account acc = new Account("Darko", "12512");
        acc.menu();
    }   
}

class Account {
    
    String userName;
    String userID;
    int balance;
    int lastTransaction;

    Account(String name, String id){
        userName = name;
        userID = id;
    }

    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            lastTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            lastTransaction = -amount;
        }
    }

    void getLastTransaction(){
        if (lastTransaction > 0){
            System.out.println("Deposited: " + lastTransaction);
        }
        else if(lastTransaction < 0){
            System.out.println("Withdrawn: " + Math.abs(lastTransaction));
        }
        else{
            System.out.println("No transaction yet");
        }
    }

    void menu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wellcome " + userName);
        System.out.println("Your id is: " + userID);
        System.out.println("\n");
        System.out.println("A - Check Ballance");
        System.out.println("B - Deposit");
        System.out.println("C - Withdraw");
        System.out.println("D - Last Transaction");
        System.out.println("E - Exit");
        System.out.println("\n");

        do{
            
            System.out.println("Enter an option");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch(option){

                case 'A': 
                    System.out.println("------------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("------------------------------------");
                    System.out.println("\n");
                    break;

                case 'B': 
                    System.out.println("------------------------------------");
                    System.out.println("Enter an amount to deposit");
                    System.out.println("------------------------------------");
                    int depositAamount = scanner.nextInt();
                    deposit(depositAamount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("------------------------------------");
                    System.out.println("Enter an amount to withdraw");
                    System.out.println("------------------------------------");
                    int withdrawAamount = scanner.nextInt();
                    withdraw(withdrawAamount);
                    System.out.println("\n");
                    break;
                
                case 'D':
                    System.out.println("------------------------------------");
                    getLastTransaction();
                    System.out.println("------------------------------------");
                    System.out.println("\n");
                    break;
                
                case 'E':
                    System.out.println("------------------------------------");
                    scanner.close();
                    break;

                default:
                    System.out.println("------------------------------------");
                    System.out.println("Invalid input. Try again!");
                    break;
            }
        }
        while(option != 'E');
            System.out.println("Thank you for using our services. Have a nice day!");
        


    }
}