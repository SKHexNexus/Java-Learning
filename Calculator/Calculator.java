package Calculator;
import java.util.*;
public class Calculator
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n;
        double a,b;
        String sum;
        do{
            sum="";
            System.out.println("\nEnter the number to perform Following: \n 1.Addition \n 2.Subtraction \n 3.Multiplication \n 4.Division \n 5.Percentage \n 6.Square Root \n 7.Power \n 8.Exit \n");
            n=sc.nextInt();
            if(n<1 || n>8){
                System.out.println("Invalid choice: ");
                continue;
            }
            switch(n){
                case 1:
                    System.out.println("Enter Two Numbers to add: ");
                    a=sc.nextDouble();
                    b=sc.nextDouble();
                    sum=""+(a+b);  
                    break;
                case 2:
                    System.out.println("Enter Two Numbers to subtract: ");
                    a=sc.nextDouble();
                    b=sc.nextDouble();
                    sum=""+(a-b);
                    break;
                case 3:
                    System.out.println("Enter Two Numbers to Multiply: ");
                    a=sc.nextDouble();
                    b=sc.nextDouble();
                    sum=""+(a*b);
                    break;
                case 4:
                    System.out.println("Enter Two Numbers to Divide: ");
                    a=sc.nextDouble();
                    b=sc.nextDouble();
                    if(b!=0)
                        sum=""+(a/b);
                    else
                        sum="Undefined";
                    break;
                case 5:
                    System.out.println("Enter Two Numbers to Find Percentage(%): ");
                    a=sc.nextDouble();
                    b=sc.nextDouble();
                    if(b!=0)
                        sum=""+((a/b)*100);
                    else
                        sum="Undefined";
                    break;
                case 6:
                    System.out.println("Enter a Number to Find SquareRoot: ");
                    a=sc.nextDouble();
                    if(a>=0)
                        sum=""+(Math.sqrt(a));
                    else
                        sum="NaN";
                    break;
                case 7:
                    System.out.println("Enter Two Numbers to Find Power: ");
                    a=sc.nextDouble();
                    b=sc.nextDouble();
                    sum=""+(Math.pow(a,b));
                    break;
                case 8:
                    System.out.println("Exiting Calculator....");
                    break;
            }
            if(n==8)
                break;
            else
                System.out.println("Result: "+sum);
        }while(n!=8);
        sc.close();
    }
}