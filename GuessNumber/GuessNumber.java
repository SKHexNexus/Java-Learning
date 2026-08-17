package GuessNumber;
import java.util.*;

public class GuessNumber 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n,i=0;
        int x=(int)(Math.random()*1000);
        System.out.println("Computer chooses a number from 1-1000");

        do{
            i++;
            System.out.println("Enter your Guess: ");
            n=sc.nextInt();
            if(n<x)
                System.out.println("Too Low");
            else if(n>x)
                System.out.println("Too High");
            else
            {
                System.out.println("Congratulation- You got it correct");
                System.out.println("You took "+i+" attempt");
            }
        }while(n!=x);
        sc.close();
    }
}
