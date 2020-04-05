// ATM Program

package ATMtest;
import java.util.Scanner;
public class ATM
{
    public ATM(CheckAccounts[] Check,SaveAccounts[] Save)
    {
        Scanner console = new Scanner(System.in);
        String userPin;
        String useraccountno;
        int pinCount = 0;
        boolean error = true;
        while(error)
        {
            if(pinCount == 3) 
            {
                System.out.println("You have exceed 3 times, the program is terminated.");
                break;
            }
            BankAccounts account=new BankAccounts();
            BankAccounts[] array=new BankAccounts[10000];
            System.out.print("Enter Account number: ");
            useraccountno = console.nextLine();
            System.out.print("Enter PIN: ");
            userPin = console.nextLine();
            int pin=10000;
            if(isInteger(userPin)&&isInteger(useraccountno))
            {
                int accnum = Integer.parseInt(useraccountno);
                pin = Integer.parseInt(userPin);
                if(accnum>=0 && accnum<10000)
                {
                    for(int i=0;i<10000;i++){
                        if(Check[i].getAccountNumber()==accnum){
                            account=Check[i];
                            break;
                        }
                    }
                }
                else if(accnum>=10000 || accnum<20000)
                {
                    for(int i=0;i<10000;i++){
                        if(Save[i].getAccountNumber()==accnum){
                            account=Save[i];
                            break;
                        }
                    }
                }
            }
            if(userPin.length()<4 && userPin.length()>4 || useraccountno.length()<5 && useraccountno.length()>5)
            {
                System.out.println("Please Try again, Incorrect Input");
                pinCount++;
            }
            else if(account.getBalance()!=-1 && account.getPin()==pin && pinCount<3 && isInteger(userPin) && isInteger(useraccountno)) 
            {
                System.out.println("Your PIN and account number are correct");
                AccAct.Action(account,Check,Save);
                break;
            }
            else
            {
                System.out.println("Please Try Again, Incorrect Input");
                pinCount++;
            }
        }          
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
}