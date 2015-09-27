package String;

public class UniqueString
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("output "+UniqueString.unique("SUDHAKAR"));
    }
    
    public static boolean unique(String str)
    {
        if(str.length() > 256)
            return false;
        
        boolean[] char_set = new boolean[256];
        for(int i=0; i< str.length();i++)
        {
            int val = str.charAt(i);   // this returns ASCII value of char
            if(char_set[val])
                return false;
            
            char_set[val] = true;       // this sets the value at respective index to true 
        }
        return true;
    }

}
