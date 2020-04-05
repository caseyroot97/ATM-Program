// ATM Program

package ATMtest;
import java.util.*;
public class ATMtest 
{
    public static void main(String[] args) 
    {
        CheckAccounts[] Check=new CheckAccounts[10000];
        SaveAccounts[] Save=new SaveAccounts[10000];
        CheckAccounts chk=new CheckAccounts();
        for(int i=0;i<10000;i++)
        {
            Check[i]=chk;
        }
        SaveAccounts sav=new SaveAccounts();
        for(int i=0;i<10000;i++)
        {
            Save[i]=sav;
        }
        CheckAccounts a=new CheckAccounts(1,5678,123456789,300);
        Check[0]=a;
        CheckAccounts b=new CheckAccounts(2,4567,234567890,4000);
        Check[1]=b;
        CheckAccounts c=new CheckAccounts(3,3456,345678901,70);
        Check[2]=c;
        CheckAccounts d=new CheckAccounts(4,2345,456789012,5000);
        Check[3]=d;
        SaveAccounts w=new SaveAccounts(1,1234,567890123,700);
        Save[0]=w;
        SaveAccounts x=new SaveAccounts(2,0123,234567890,2000);
        Save[1]=x;
        SaveAccounts y=new SaveAccounts(3,6789,789012345,9000);
        Save[2]=y;
        SaveAccounts z=new SaveAccounts(4,7890,890123456,1000);
        Save[3]=z;
        boolean loop=true;
        String input;
        Scanner sc=new Scanner(System.in);
        while(loop)
        {
            System.out.print("1) Bank Customer\n2) Bank Staff\n3) Timer\n4) Exit Program\nSelect which actor you would like(1-4): ");
            input=sc.next();
            switch(input)
            {
                case "1":
                    ATM atm = new ATM(Check,Save);
                    break;
                case "2":
                    boolean loop2=true;
                    while(loop2)
                    {
                        System.out.print("1) Open account\n2) Close account\n3) Cancel\nSelect which option you would like(1-3): ");
                        String input2=sc.next();
                        switch(input2)
                        {
                            case "1":
                                AccountManage.openAccount(Check,Save);
                                break;
                            case "2":
                                AccountManage.closeAccount(Check,Save);
                                break;
                            case "3":
                                loop2=false;
                                break;
                            default:
                                System.out.println("Invalid input, please try again.");
                        }
                    }
                    break;
                case "3":
                    for(int i=0;i<1000;i++)
                    {
                        if(Save[i].getBalance()!=-1)
                        {
                            Save[i].setBalance(Save[i].getBalance()+Save[i].getBalance()*0.05);
                        }
                    }
                    System.out.println("Interest has been added to all savings accounts.");
                    break;
                case "4":
                    loop=false;
                    break;
                default:
                    System.out.println("Invalid input, please try again.");
            }
        }
    }
}