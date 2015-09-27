package String;

import java.util.Arrays;

public class AnagramUsingAPI
{

    public static void main(String[] args)
    {
        String s1 = "apple";
        String s2 = "ppela";
        
        AnagramUsingAPI obj = new AnagramUsingAPI();
        System.out.println(obj.isAnagram(s1, s2));

    }
    
    private boolean isAnagram(String s1, String s2)
    {
        if(s1.length() != s2.length())
            return false;
        
        return sort(s1).equals(sort(s2));
    }
    
    private String sort(String temp)
    {
        char[] ar1 = temp.toCharArray();
        Arrays.sort(ar1);
        return new String(ar1);
    }
    

}
