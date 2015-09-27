package String;

import java.util.Scanner;

public class RemoveCharFrmString
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("Enter String ");
        Scanner scn = new Scanner(System.in);
        String input = scn.nextLine();
        
        
        System.out.println("Enter the char to remove");
        char remove = scn.nextLine().charAt(0);
        
        RemoveCharFrmString obj = new RemoveCharFrmString();
        
        String result = obj.remove(input, remove);
        System.out.println(result);
    }

    private String remove(String input, char remove)
    {
        char[] temp = input.toCharArray();
        int pos=0;
        int j=0;
        for(int i=0; i < temp.length; i++)
        {
            if(temp[i] != remove)
            {
                System.out.println(temp[i]);
               temp[pos++] = temp[i];
            }
        }
        for(int i=0; i < temp.length; i++)
        {
            System.out.println(temp[i]);
        }
        return new String(temp, 0, pos);
    }

}
