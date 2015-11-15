package paypal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AnagramPalindrom {

	public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();
        if( checkPalindrome(input) )
            System.out.println("Yes");
        else
            System.out.println("No");
    }
   
	// This is for lower case alphabets
	private static boolean checkPalindrome(String input) {
		int[] count = new int[26];
		char[] inputArray = input.toCharArray();
		for(int i=0; i<input.length();i++)
		{
			count[inputArray[i]-'a']++;
		}
		
		int oddCount=0;
		for(int cnt:count)
		{
			if(oddCount > 1)
				return false;
			if(cnt%2==1)
				oddCount++;
		}
		
		return true;
	}

	//This is for any kind of input
	private static boolean checkPalindromeForAnyInput(String input)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int i = 0; i < input.length(); i++ )
        {
            if(null != map.get(input.charAt(i)))
            {
            	int val = map.get(input.charAt(i)).intValue()+1;
            }
            else
            {
            	map.put(Integer.valueOf(input.charAt(i)), Integer.valueOf(1));
            }
        	
        }
        int oddOccur = 0;
        Iterator<Integer> it = map.values().iterator();
        int cnt=0;
        while(it.hasNext())
        {
            cnt= it.next().intValue();
        	if( oddOccur > 1)
                return false;
            if( cnt%2 == 1 )
                oddOccur++;
        }
        return true;
    }
	
}
