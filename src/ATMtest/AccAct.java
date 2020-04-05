// ATM Program

package ATMtest;
import java.util.Scanner;
public class AccAct
{
    static void Action(BankAccounts accNum,CheckAccounts[] Check,SaveAccounts[] Save)
    { 
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        String input,am,acc,resp="Z";
        double amount;
        int accnt;
        while(loop)
        {
            System.out.print("1) Deposit\n2) Withdraw\n3) View account Balance\n4) Transfer Funds\n5) View Last Deposit Amount\n6) Cancel\nPlease enter the number of the option you'd like to select from the menu above: ");
            input=sc.next();
            switch(input)
            {
                case "1":
                    do
                    {
                        System.out.print("Please enter the amount you are depositing to your BankAccounts: ");
                        am=sc.next();
                        if(!isNumeric(am))
                        {
                            System.out.println("Invalid response, please try again.");
                        }
                    }while(!isNumeric(am));  
                    amount=Double.parseDouble(am);
                    System.out.println("$"+amount+" has been deposited to your BankAccounts.");
                    accNum.setLastDeposit(amount);
                    amount += accNum.getBalance();
                    accNum.setBalance(amount);
                    System.out.println("You now have $"+amount+" in your account.");
                    break;
                case "2":
                    do
                    {
                        System.out.print("Please enter the amount you are withdrawing from your BankAccounts: ");
                        am=sc.next();
                        if(!isNumeric(am))
                        {
                            System.out.println("Invalid response, please try again.");
                        }
                    }while(!isNumeric(am));  
                    amount=Double.parseDouble(am);
                    if(amount>accNum.getBalance())
                    {
                        System.out.println("Sorry, you don't have enough money to withdraw $"+amount+".");
                        break;
                    }
                    System.out.println("$"+amount+" has been withdrawn from your BankAccounts.");
                    amount = accNum.getBalance()-amount;
                    accNum.setBalance(amount);
                    System.out.println("You have $"+amount+" left in your account.");
                    break;
                case "3":
                    System.out.println("Your current BankAccounts balance is $" +accNum.getBalance());
                    break;
                case "4":
                    boolean exists = false,loop2=true;
                    BankAccounts account=new BankAccounts();
                    do
                    {
                        do
                        {
                            System.out.print("Please enter the account you would like to transfer to: ");
                            acc=sc.next();
                            if(!isNumeric(acc))
                            {
                                System.out.println("Invalid response, please try again.");
                            }
                        }while(!isInteger(acc));  
                        accnt=Integer.parseInt(acc);
                        if(accnt>=0 && accnt<10000)
                        {
                            for(int i=0;i<10000;i++){
                                if(Check[i].getAccountNumber()==accnt){
                                    account=Check[i];
                                    exists=true;
                                    break;
                                }
                            }
                        }
                        else if(accnt>=10000 || accnt<20000)
                        {
                            for(int i=0;i<10000;i++){
                                if(Save[i].getAccountNumber()==accnt){
                                    account=Save[i];
                                    exists=true;
                                    break;
                                }
                            }
                        }
                        if(!exists)
                        {
                            System.out.println("Invalid account number, please try again.");
                        }
                    }while(!exists);
                    while(loop2)
                    {
                        do
                        {
                            System.out.print("Please enter the amount you would like to transfer: ");
                            am=sc.next();
                            if(!isNumeric(am))
                            {
                                System.out.println("Invalid response, please try again.");
                            }
                        }while(!isNumeric(am));  
                        amount=Double.parseDouble(am);
                        if(amount>accNum.getBalance())
                        {
                            System.out.println("Sorry, you don't have enough money to transfer $"+amount+". Would you like to enter another amount?(Y/N)");
                            while(!resp.equals("Y")&&!resp.equals("N"))
                            {
                                resp=sc.next();
                            }
                            if(resp.equals("N")){
                                loop2=false;
                            }
                            resp="Z";
                        }
                        else
                        {
                            loop2=false;
                        }
                        if(amount<=accNum.getBalance())
                        {
                            System.out.println("$"+amount+" has been transfered to account #"+String.format("%05d",account.getAccountNumber())+". You have $"+(accNum.getBalance()-amount)+" left in your account.");
                            accNum.setBalance(accNum.getBalance()-amount);
                            account.setBalance(account.getBalance()+amount);
                        }
                    }
                    break;
                case "5":
                    System.out.println("Your last deposit amount was $" + accNum.getLastDeposit());
                    break;
                case "6":
                    loop=false;
                    System.out.println("Exiting ATM, have a nice day!");
                    break;
                default:
                    System.out.println("Invalid response, please try again.");
            }
            if(loop==false)
            {
                break;
            }
            while(!resp.equals("Y")&&!resp.equals("N")&&!input.equals("6"))
            {
                System.out.print("Would you like to perform another action on your account?(Y/N): ");
                resp=sc.next();
            }
            if(resp.equals("N"))
            {
                loop=false;
                System.out.println("Exiting ATM, have a nice day!");
            }
            resp="Z";
        }
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