package problems;

import java.util.Scanner;

public class PerfectSquare
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner sn = new Scanner(System.in);
        int lines = sn.nextInt();
        for(int i=0; i<lines; i++)
        {
            String intLines = sn.nextLine();
            String[] intVal = intLines.split(" ");
            System.out.println(checkForPerfectSquare(intVal));
            
        }
    }
    
    private static int checkForPerfectSquare(String[] input)
    {
        int count = 0;
        int startInt = Integer.parseInt(input[0]);
        int endInt = Integer.parseInt(input[1]);
            for(int i = startInt; i<= endInt; i++)
            {
                double sqt = Math.sqrt(i);
                if(sqt*sqt == i)
                {
                    count++;
                }
            }
        return count;
    }

}
