
package bankaccounts;

/**
 *
 * @author Pablo Velazquez
 */
public class Account {
    
    public double balance; //hold account balance
    public int deposits; //hold number of deposits
    public int withdrawals; //hold number of withdrawals
    public double annualIntRate; //hold annual interest rate
    public double monthlySC; //hold monthly service charges

    public Account(double balance, double annualIntRate) {
        this.balance = balance;
        this.annualIntRate = annualIntRate;
    }


    public void Deposit(double d) //add deposit to balance
    {
        balance = balance + d;
        deposits += 1; //increase amount of deposits
    }
    
    public void Withdraw (double w) //subtract withdrawal from balance
    {
        balance = balance - w;
        withdrawals += 1; //increase amount of withdrawals
    }
    
    public double calcInt() //calculate interest
    {
        double monthlyIntRate, monthlyInt; 
        monthlyIntRate = (annualIntRate/12); //get monthly interest rate
        monthlyInt = (balance * monthlyIntRate); //get monthly interest
        balance = (balance + monthlyInt);
        return balance;
    }
    
    public double monthlyProc() //get monthlyProc
    {
        balance = balance - monthlySC;
        calcInt();
        withdrawals = 0; //reset the variables
        deposits = 0;
        monthlySC = 0;
        
        return balance;       
    }
    
}
