
package bankaccounts;

/**
 *
 * @author Pablo Velazquez
 */
public class savingsAccount extends Account{

    private boolean status = true;
    
    public savingsAccount(double balance, double annualIntRate){
        super(balance, annualIntRate);
    }
    
    private boolean checkStatus(){ //check if account is under 25 dollars
        if (balance < 25){
            status = false;
        }
        return status;
    }
    
    @Override
    public void Withdraw(double w){
        checkStatus();
        if (status == false){ //if balance < 25, no withdrawals
            System.out.println("No withdrawals allowed.");
        }
        else{
            super.Withdraw(w);
        }
    }
    
    @Override
    public void Deposit(double d){
        checkStatus();
        if (status == false){
            if ((balance + d) > 25){ //activate account if balance is over 25
                status = true;
                super.Deposit(d);
                System.out.println("Your account is active.");
            }
        }
        else{
            super.Deposit(d);
        }
    }
    
    @Override
    public double monthlyProc(){
        if (withdrawals > 4){
            monthlySC = (withdrawals - 4) * 1;
        }
        super.monthlyProc();
        checkStatus();
        return balance;
    }
    
}
