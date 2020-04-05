// ATM Program

package ATMtest;
import java.util.*;
public class AccountManage 
{
    public static void closeAccount(CheckAccounts[] Check,SaveAccounts[] Save)
    {
        int accountNum=0,element=-1;
        String acnum;
        boolean loop=true;
        Scanner scan = new Scanner(System.in);
        while(loop){
            do
            {
                System.out.print("Enter Account number: ");
                acnum = scan.next();
            }while(!isInteger(acnum));
            accountNum=Integer.parseInt(acnum);
            if(accountNum>=0 && accountNum<10000)
            {
                for(int i=0;i<10000;i++){
                    if(Check[i].getAccountNumber()==accountNum){
                        element=i;
                        loop=false;
                        break;
                    }
                }
            }
            else if(accountNum>=10000 && accountNum<20000)
            {
                for(int i=0;i<10000;i++){
                    if(Save[i].getAccountNumber()==accountNum){
                        element=i;
                        loop=false;
                        break;
                    }
                }
            }
            else{
                System.out.println("Account number invalid, please try again.");
            }
            if(element==-1){
                System.out.println("Account number invalid, please try again.");
            }
        }
        System.out.print("Are you sure you want to CLOSE this account?(Y/N): ");
        String response = scan.next();
        if(response.equals("Y"))
        {
            if(accountNum>=0 && accountNum<10000)
            {
                System.out.println("Account #"+String.format("%05d",accountNum)+" has been closed.");
                CheckAccounts c=new CheckAccounts();
                Check[element] = c;
            }
            else if(accountNum>=10000 && accountNum<20000)
            {
                System.out.println("Account #"+String.format("%05d",accountNum)+" has been closed.");
                SaveAccounts s=new SaveAccounts();
                Save[element] = s;
            }
        }
    }
    public static void openAccount(CheckAccounts[] Check,SaveAccounts[] Save)
    {
        int acnum,pin = 10000,ssn = 0;
        double bal = 0;
        String excp;
        Scanner scan = new Scanner(System.in);
        do
        {
            do
            {
                System.out.print("Please enter a 4-digit PIN: ");
                excp=scan.next();
                if(!isNumeric(excp))
                {
                    System.out.println("Invalid response, please try again.");
                }
            }while(!isNumeric(excp));  
            pin=Integer.parseInt(excp);
            if(pin>9999||pin<0)
                System.out.println("PIN does not fit the criteria, please try again.");
        }while(pin<0||pin>9999);
        do
        {
            do
            {
                System.out.print("Please enter your social security number: ");
                excp=scan.next();
                if(!isNumeric(excp))
                {
                    System.out.println("Invalid response, please try again.");
                }
            }while(!isNumeric(excp));  
            ssn=Integer.parseInt(excp);   
            if(String.valueOf(ssn).length()!=9)
                System.out.println("Invalid social security number, please try again.");
        }while(String.valueOf(ssn).length()!=9);
        do
        {
            do
            {
                System.out.print("Please enter the amount you'd like to deposit: ");
                excp=scan.next();
                if(!isNumeric(excp))
                {
                    System.out.println("Invalid response, please try again.");
                }
            }while(!isNumeric(excp));  
            bal=Double.parseDouble(excp);
            if(bal<=0)
                System.out.println("You must make a deposit, please try again.");
        }while(bal<=0);
        String type;
        boolean copy;
        do
        {
            System.out.print("1) Checking Account\n2) Savings Account\nWhich account type would you like?(1/2): ");
            type = scan.next();
            switch(type)
            {
                case "1":
                    do
                    {
                        Random rand = new Random();
                        acnum = rand.nextInt(10000);
                        copy=false;
                        for(int i=0;i<10000;i++)
                        {
                            if(acnum==Check[i].getAccountNumber())
                            {
                                copy=true;
                                break;
                            }
                        }
                        if(copy==false)
                        {
                            for(int i=0;i<10000;i++)
                            {      
                                if(Check[i].getBalance()==-1)
                                {
                                    CheckAccounts c = new CheckAccounts(acnum,pin,ssn,bal); 
                                    Check[i]=c;
                                    String numstr = String.format("%05d",acnum);
                                    System.out.println("Your account number is "+numstr);
                                    break;
                                }    
                                if(i==9999){
                                    System.out.println("Error: no more checking accounts available!");
                                }
                            }
                        }
                    }while(copy);
                    break;
                case "2":
                    do
                    {
                        Random rand = new Random();
                        acnum = rand.nextInt(10000);
                        copy=false;
                        for(int i=0;i<10000;i++)
                        {
                            if(acnum+10000==Save[i].getAccountNumber())
                            {
                                copy=true;
                                break;
                            }
                        }
                        if(copy==false)
                        {
                            for(int i=0;i<10000;i++)
                            {      
                                if(Save[i].getBalance()==-1)
                                {
                                    SaveAccounts s = new SaveAccounts(acnum,pin,ssn,bal); 
                                    Save[i]=s;
                                    System.out.println("Your account number is "+s.getAccountNumber());
                                    break;
                                } 
                                if(i==9999){
                                    System.out.println("Error: no more saving accounts available!");
                                }
                            }
                        }
                    }while(copy);
                    break;
                default:
                    System.out.println("Invalid response, please try again.");
            }
        }while(type.equals("1")&&type.equals("2"));
    }
    public static boolean isInteger(String str)
    { 
        try  
        {  
          int i=Integer.parseInt(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
          return false;  
        }  
        return true;  
    }
    public static boolean isNumeric(String str)
    { 
        try  
        {  
          double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
          return false;  
        }  
        return true;  
    }
}