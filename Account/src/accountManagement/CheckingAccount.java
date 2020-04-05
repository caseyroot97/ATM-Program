package accountManagement;
import java.lang.*;
import java.awt.*;
import java.util.*;
import java.security.*;
public class CheckingAccount extends Account
{
	public CheckingAccount()
	{
		super();
	}
	public CheckingAccount(int acnum, int pin, int ssn, int bal, int dep)
	{
		super(acnum,pin,ssn,bal,dep);
	}
	
}
