package accountManagement;
import java.lang.*;
import java.awt.*;
import java.util.*;
import java.security.*;
public class SavingsAccount extends Account
{
	public SavingsAccount()
	{
		super();
	}
	public SavingsAccount(int acnum, int pin, int ssn, int bal, int dep)
	{
		super(acnum,pin,ssn,bal,dep);
	}
	
}
