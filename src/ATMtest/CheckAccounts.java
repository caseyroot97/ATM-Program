// ATM Program

package ATMtest;
public class CheckAccounts extends BankAccounts
{
    public CheckAccounts()
    {
        super();
    }
    public CheckAccounts(int acnum, int pin, int ssn, double bal)
    {
        super(acnum,pin,ssn,bal);
    }
    @Override
    public int getAccountNumber()
    {
        return super.getAccountNumber();
    }
    @Override
    public double getBalance()
    {
        return super.getBalance();
    }
    @Override
    public double getLastDeposit()
    {
        return super.getLastDeposit();
    } 
    @Override
    public void setAccountNumber(int acnum)
    {
        super.setAccountNumber(acnum);
    }
    @Override
    public void setSocial(int ssn)
    {
        super.setSocial(ssn);
    }
    @Override
    public void setPin(int pin)
    {
        super.setPin(pin);
    }
    @Override
    public void setBalance(double bal)
    {
        super.setBalance(bal);
    }
    @Override
    public void setLastDeposit(double dep)
    {
        super.setLastDeposit(dep);
    }
}
