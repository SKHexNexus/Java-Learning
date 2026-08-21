package ATMSimulation;

import java.util.Scanner;

public class ATMSimulation 
{
    static int Pin;
    public static boolean isValid(int Pi){
        return Pi>999 && Pi<10000;
    }
    public static void changePin(Scanner in)
    {
        int NPin,CPin=0;
        do{
            System.out.println("Enter NEW PIN:");
            do{
                NPin=in.nextInt();
                if(NPin==Pin)
                    System.out.println("New Pin Matches with Initial Pin...\nPlease write different PIN to update..");
            }while(!isValid(NPin) ||NPin==Pin);

            System.out.println("Enter Again To CONFIRM PIN:");
                CPin=in.nextInt();
            if(!isValid(CPin))
                System.out.println("PINs must be 4 digits...");
            else if(NPin!=CPin)
                System.out.println("PINs do not match. Try Again...");
        }while(NPin!=CPin);
        Pin=CPin;
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);

        String Hname,SecAns,Ans,AccNo,AcNo;
        int CurPin;
        long InBal,Bal;
        int n,i=0;

        System.out.println("Enter the Holder Name: ");
        Hname=in.nextLine();
        System.out.println("Enter Account Number: ");
        AccNo=in.next();
        do{
            System.out.println("Enter PIN(4 digit): ");
            Pin=in.nextInt();
        }while(!isValid(Pin));

        do{
        System.out.println("Enter Initial Balance: ");
        InBal=in.nextLong();
        }while(InBal<0);
        
        System.out.println("Security Question: What is Your Favourite Colour? ");
        SecAns=in.next();

        do{
            System.out.println("\t---ATM Menu---");
            System.out.println("1.Check Balance \n2.Deposit Money \n3.Withdraw Money \n4.Change PIN \n5.Exit");
            n=in.nextInt();
            switch(n){
                case 1:
                    System.out.println("Account holder: "+Hname+"\nAccount No.:"+AccNo);
                    System.out.println("Your Current Balance is:"+InBal);
                    break;
                case 2:
                    System.out.println("Enter the Amount to Deposit: ");
                    Bal=in.nextLong();
                    if(Bal<=0){
                        System.out.println("Invalid Amount...");
                        continue;
                    }
                    else
                        InBal+=Bal;
                    System.out.println("Your Current Balance is: "+InBal);
                    break;
                case 3:
                    System.out.println("Enter the Amount to Withdraw: ");
                    Bal=in.nextLong();
                    if(Bal<1){
                        System.out.println("Invalid Amount...");
                        continue;
                    }
                    else if(Bal<=InBal)
                        InBal-=Bal;
                    else{
                        System.out.println("Transaction Failed: Insufficient Balance...");
                        System.out.println("Your Current Balance is: "+InBal);
                        continue;
                    }
                    System.out.println("Your Current Balance is: "+InBal);
                    break;
                case 4:
                    i=0;
                    do{
                        do{
                            System.out.println("Enter Current PIN(4-Digit): ");
                                CurPin=in.nextInt();
                        }while(!isValid(CurPin));
                        if(CurPin!=Pin){
                            System.out.println("Incorrect PIN... ");
                            i++;
                            System.out.println("Attempts remaining:"+(4-i)+"\n");
                            if(i==4)
                                System.out.println("Too many incorrect attempts. Please verify your account to reset your PIN.\n");
                            }
                            else
                                i=4;
                    }while(i!=4);

                    if(CurPin!=Pin){
                        System.out.println("Enter Your Account Number: ");
                        AcNo=in.next();
                        if(!AccNo.equals(AcNo)){
                            System.out.println("Sorry...No such Account Found...");
                            continue;
                        }
                        System.out.println("Enter Security Question's Answer: \n\"Question:what is Your favourite Colour:\"");
                        Ans=in.next();
                        if(Ans.equalsIgnoreCase(SecAns)){
                            changePin(in);
                            System.out.println("Your PIN Has Been Changed Successfully!!");
                        }
                        else
                            System.out.println("Sorry...PIN cannot be Changed...");
                    }
                    else{
                        changePin(in);
                        System.out.println("Your PIN Has Been Changed Successfully!!");
                    }
                    break;
                    default:
                        if(n!=5)
                            System.out.println("Enter Valid Number to Perform Task...");
            }
        }while(n!=5);
        in.close();
    }
}