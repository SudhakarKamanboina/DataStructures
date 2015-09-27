package problems;

import java.util.Scanner;

public class Fibonacci
{

    public static void main(String[] args)
    {
        System.out.println("\n Please enter the number ");
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        for(int i=1; i<=input;i++)
        {
            System.out.println(iterativeFib(i));
        }
    }
    
    public static int recursiveFib(int n)
    {
        if (n==1 || n==2)
            return 1;
        return recursiveFib(n-1) + recursiveFib(n-2);
    }
    
    
    public static int iterativeFib(int n)
    {
        if (n==1 || n==2)
            return 1;
        
        int fibonnaci=1, fib1=1, fib2=1;
        for(int i=3; i<=n; i++)
        {
            fibonnaci = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibonnaci;
        }
        return fibonnaci;
    }

}
