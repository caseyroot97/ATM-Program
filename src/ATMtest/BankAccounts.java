// ATM Program

package ATMtest;
public class BankAccounts {
    private int AccountNumber;
    private int PIN;
    private int SocialSecurity;
    protected double balance;
    protected double LastDeposit;
    public BankAccounts(){
        AccountNumber = 0;
        PIN = 0;
        SocialSecurity = 0;
        balance = -1;
        LastDeposit = 0;
    }
    public BankAccounts(int acnum, int pin, int ssn, double bal){
        AccountNumber = acnum;
        PIN = pin;
        SocialSecurity = ssn;
        balance = bal;
        LastDeposit = bal;
    }
    public int getAccountNumber()
    {
        return AccountNumber;
    }
    public int getPin()
    {
        return PIN;
    }
    public double getBalance()
    {
        return balance;
    }
    public double getLastDeposit()
    {
        return LastDeposit;
    } 
    public void setAccountNumber(int acnum)
    {
        AccountNumber = acnum;
    }
    public void setSocial(int ssn)
    {
        SocialSecurity = ssn;
    }
    public void setPin(int pin)
    {
        PIN = pin;
    }
    public void setBalance(double bal)
    {
        balance = bal;
    }
    public void setLastDeposit(double dep)
    {
        LastDeposit = dep;
    }
 
}