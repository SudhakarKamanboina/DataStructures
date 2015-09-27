package problems;

import java.util.Scanner;

public class Factorial
{

    public static void main(String[] args)
    {
        System.out.println("Please enter the number ");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        System.out.print("Factorial of "+input+ " is "+iterativeFact(input));
        
    }
    
    public static int recursiveFact(int n)
    {
        if(n==0)
            return 1;
        return n * recursiveFact(n-1);
    }
    
    public static int iterativeFact(int n)
    {
        int result=1;
        for(int i=1; i<=n; i++)
        {
            result = result * i;
        }
        return result;
    }

}
