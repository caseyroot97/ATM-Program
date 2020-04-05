package ATMtest;
import java.lang.*;
import java.awt.*;
import java.util.*;
public class Account 
{
	private int AccountNumber;
	private int PIN;
	private int SocialSecurity;
	protected double balance;
	protected double LastDeposit;
	
	public Account()
	{
		AccountNumber = 0;
		PIN = 0;
		SocialSecurity = 0;
		balance = 0;
		LastDeposit = 0;
	}
	public Account(int acnum, int pin, int ssn, int bal, int dep)
	{
		AccountNumber = acnum;
		PIN = pin;
		SocialSecurity = ssn;
		balance = bal;
		LastDeposit = dep;
	}
	public void closeAccount(Account acc)
	{
		
	}
	public Account openAccount(int which)
	{
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a 4-digit PIN: ");
		int pin = scan.nextInt();
		System.out.print("Please enter your social security number: ");
		int ssn = scan.nextInt();
		System.out.print("Which account type would you like?:/n 1. Checking Account/n 2. Savings Account");
                
		Account acc = new Account();
		return acc;
	}
}
