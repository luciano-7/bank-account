/*Pablo Velazquez
* This program allows the user to set up a bank account with user defined
* account balance and annual interest rate. Then it creates two accounts, one checking
* and one savings, and allows the user to deposit or withdraw from the selected account.
* It also lets the user see the stats of the account for the month. When monthlyProc and stats
* are checked, it acts as if a month had passed.
*/
package bankaccounts;

import java.util.Scanner;

/**
 *
 * @author Pablo Velazquez
 */
public class BankAccounts{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        Scanner userInput = new Scanner(System.in);
        int choice, pick; //choice is for the user selected account, pick is for the menu options.
        double money, accountbal, yIntRate; //money is for the amount withdrawn or deposited,
                                            //accountbal is for the account balance,
                                            //yIntRate is for the annual interest rate.
        
        System.out.print("Enter the account balance: ");
        accountbal = userInput.nextDouble();
        System.out.print("Enter the annual interest rate: ");
        yIntRate = userInput.nextDouble();
        
        Account myAccount = new Account(accountbal, yIntRate);
        Account mySA = new savingsAccount(myAccount.balance, myAccount.annualIntRate);
        Account myCA = new checkingAccount(myAccount.balance, myAccount.annualIntRate);
        
        do{
            accountMenu(); //menu displaying the two accounts
            choice = userInput.nextInt();
            switch (choice){ //switch statement based on user choice of account
                case 0: //exit
                    break;
                case 1: //savings account
                    savingsMenu(); //menu displaying savings account options
                    pick = userInput.nextInt();
                    switch (pick){
                        case 1: //deposit
                            System.out.println("How much to deposit: ");
                            money = userInput.nextDouble();
                            mySA.Deposit(money);
                            break;
                            
                        case 2: //withdraw
                            System.out.println("How much to withdraw: ");
                            money = userInput.nextDouble();
                            mySA.Withdraw(money);
                            break;
                            
                        case 3: //monthlyProc
                            System.out.println("BALANCE: "+ mySA.monthlyProc());
                            break;
                            
                        case 4: //stats
                            System.out.println("Beginning balance: " + myAccount.balance);
                            System.out.println("Amount of deposits: " + mySA.deposits);
                            System.out.println("Amount of withdrawals: " + mySA.withdrawals);
                            System.out.println("Ending balance: " + mySA.monthlyProc());
                            break;
                            
                        default:
                            System.out.println("Please enter a valid choice.");                
                    }
                    break;
                case 2: //checking account
                    checkingMenu();
                    pick = userInput.nextInt();
                    switch (pick){
                        case 1: //withdraw
                            System.out.println("How much to withdraw: ");
                            money = userInput.nextDouble();
                            myCA.Withdraw(money);
                            break;
                        case 2: //monthlyProc
                            System.out.println("BALANCE: "+ myCA.monthlyProc());
                            break;
                        case 3: //stats
                            System.out.println("Beginning balance: " + myAccount.balance);
                            System.out.println("Amount of withdrawals: " + myCA.withdrawals);
                            System.out.println("Ending balance: " + myCA.monthlyProc());
                            break;
                            
                        default:
                            System.out.println("Please enter a valid choice");               
                    }
                    break;
                    
                default:
                    System.out.println("Please pick an account (or 0 to exit).");
            }
        } while (choice != 0); //exit when user picks 0
        userInput.close();
    }
    
    private static void savingsMenu(){ //savings account menu
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. monthlyProc");
        System.out.println("4. Month Stats");
        System.out.print("Select an option: ");
    }
    
    private static void checkingMenu(){ //checking account menu
        System.out.println("1. Withdraw");
        System.out.println("2. monthlyProc");
        System.out.println("3. Month Stats");
        System.out.print("Select an option: ");
    }
    
    private static void accountMenu(){ //account menu
        System.out.println("1. Savings.");
        System.out.println("2. Checking.");
        System.out.println("0. Exit.");
        System.out.print("Select an account (0 to exit): ");
    }
    
    
}

