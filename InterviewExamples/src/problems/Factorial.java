package problems;

public class Factorial
{
    public static void main(String args[])
    {

        // call the recursive function to generate factorial
        int result = fact(5);

        System.out.println("Factorial of the number is: " + result);
    }

    static int fact(int b)
    {
        if (b <= 1)
            // if the number is 1 then return 1
            return 1;
        else
            // else call the same function with the value - 1
            return b * fact(b - 1);
    }
}
