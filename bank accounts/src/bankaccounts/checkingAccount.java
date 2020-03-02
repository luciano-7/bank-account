
package bankaccounts;

/**
 *
 * @author Pablo Velazquez
 */
public class checkingAccount extends Account {
    
    public checkingAccount(double balance, double annualIntRate){
        super(balance, annualIntRate);
    }
    
    @Override
    public void Withdraw(double w){
        if ((balance - w) < 0){ //do not allow withdrawal greater than balance
            System.out.println("Withdrawal will lower balance under 0.");
            System.out.println("Service charge of 15 dollars being placed.");
            balance -= 15;  
        }
        else{
            super.Withdraw(w);
        }       
    }
    
    @Override
    public double monthlyProc(){
        monthlySC = (withdrawals * 0.10) + 5;
        super.monthlyProc();
        return balance;
    }
}