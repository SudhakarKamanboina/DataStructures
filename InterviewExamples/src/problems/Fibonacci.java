package problems;

public class Fibonacci
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        /*int prev =0,  next=1, sum=0;
        for(int i=0;i<10;i++)
        {
            sum = prev + next;
            System.out.println(sum);
            prev = next;
            next = sum;
        }*/
        
        
        //for(int i=1;i<=5;i++)
        System.out.println(Fibonacci.recursive(6));
    }
    
    public static int recursive(int number){
        if(number == 1 || number == 2){
            return 1;
        }
      
        return recursive(number-1) + recursive(number -2); //tail recursion
    }

}
