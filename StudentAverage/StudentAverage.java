package StudentAverage;

import java.util.Scanner;

public class StudentAverage 
{
    public static void main(String args[])
    {
        int n,k,i,sum=0;
        double avg;
        char ch;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a Student Name: ");
        String s=in.nextLine();
        System.out.println("Enter the Total Subject to find Average: ");
        n=in.nextInt();
        if(n<1){
            System.out.println("Invalid Choice....");
            System.exit(0);
        }
        System.out.println("Enter the Marks Obtained in each Subject (out of 100):");
        for(i=1;i<=n;i++){
            do{
                k=in.nextInt();
                if(k>100 || k<0)
                    System.out.println("Invalid Number!!! \nPlease Enter again...");
            }while(k>100 || k<0);
            System.out.println("Subject "+i+": "+k);
            sum+=k;
        }
        avg=(double)sum/n;
        if(avg>=90)
            ch='A';
        else if(avg>=80) 
            ch='B';
        else if(avg>=70) 
            ch='C';
        else if(avg>=60) 
            ch='D';
        else if(avg>=50) 
            ch='E';
        else
            ch='F';
        System.out.println("Average Marks Obtained by "+s+" in all Subject is: "+avg);
        System.out.println("Grade: "+ch);

        in.close();
    }
}