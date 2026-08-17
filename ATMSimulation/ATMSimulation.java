package ATMSimulation;

import java.util.*;

public class ATMSimulation 
{
    static int Pin;
    static String P;
    public void ChangePin(Scanner in)
    {
        int NPin,CPin=0;
        String NP,CP;
        do{
            System.out.println("Enter NEW PIN:");
            do{
                NPin=in.nextInt();
                NP=String.valueOf(NPin);
            }while(NP.length()!=4 || NPin==Pin);
            System.out.println("Enter Again To CONFIRM PIN:");
            do{
                CPin=in.nextInt();
                CP=String.valueOf(CPin);
            }while(CP.length()!=4);
        }while(!CP.equals(NP));
        Pin=CPin;P=CP;
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        ATMSimulation ob=new ATMSimulation();

        String Hname,SecAns,Ans,AccNo,AcNo,CP="";
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
            P=String.valueOf(Pin);
        }while((P.length())!=4);

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
                                CP=String.valueOf(CurPin);
                        }while((CP.length())!=4);
                    if(!CP.equals(P)){
                        System.out.println("Incorrect PIN... ");
                        i++;
                        System.out.println("Attempts remaining:"+(4-i)+"\n");
                        if(i==4)
                            System.out.println("Too many incorrect attempts. Please verify your account to reset your PIN.\n");
                    }
                    else
                        i=4;
                    }while(i!=4);

                    if(!CP.equals(P)){
                        System.out.println("Enter Your Account Number: ");
                        AcNo=in.next();
                        if(!AccNo.equals(AcNo)){
                            System.out.println("Sorry...No such Account Found...");
                            continue;
                        }
                        System.out.println("Enter Security Question's Answer: \n\"Question:what is Your favourite Colour:\"");
                        Ans=in.next();
                        if(Ans.equalsIgnoreCase(SecAns)){
                            ob.ChangePin(in);
                            System.out.println("Your PIN Has Been Changed Successfully!!");
                        }
                        else
                            System.out.println("Sorry...PIN cannot be Changed...");
                    }
                    else{
                        ob.ChangePin(in);
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