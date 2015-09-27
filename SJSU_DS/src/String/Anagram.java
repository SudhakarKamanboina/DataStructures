package String;

public class Anagram
{

    public static void main(String[] args)
    {
        String s1 = "apple";
        String s2 = "ppela";
        
        Anagram obj = new Anagram();
        System.out.println(obj.isAnagram(s1.toLowerCase(), s2.toLowerCase())); 
        
    }
    
    private boolean isAnagram(String s1, String s2) // Assuming strings are in lowercase 
    {
        if(s1.length() != s2.length())  //check whether lengths are equal
            return false;
        
        char[] tArray = s1.toCharArray();
        int[] asci = new int[256];
        
        for(char s: tArray)
        {
            asci[s]++;   //Increment value at that specific position(asci value) w.r.t number of repeating characters.
        }
        
        /*for(int i=0; i< asci.length; i++)
            System.out.println(i+" - "+asci[i]);*/
        
        for(int j=0; j<s2.length(); j++)
        {
            int c = s2.charAt(j);
            if(--asci[c] < 0)   // Decrement the count of repeating variable n if there are more occurences 
                return false;
        }
        
        return true;
    }

}
