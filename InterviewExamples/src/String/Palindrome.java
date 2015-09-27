package String;

public class Palindrome
{

    /**
     * @param args
     */
    /*public static void main(String[] args)
    {
        String temp1 = "nitin";
        Palindrome obj = new Palindrome();
        String temp2 = obj.reverse(temp1);
        System.out.println("is palindrome "+obj.compare(temp1, temp2));
        
    }

    private boolean compare(String temp1, String temp2)
    {
        int i =0;
        boolean result=false;
        if(temp1.length() == temp2.length())
        {
            while(i <=temp1.length()-1)
            {
                //System.out.println("temp1 "+temp1.charAt(i));
                //System.out.println("temp2 "+temp2.charAt(i));
                if(temp1.charAt(i)!= temp2.charAt(i))
                {
                    result= false;
                }
                i++;
            }
            result= true;
        }
        return result;
    }

    private String reverse(String temp1)
    {
        if(temp1.length() <2)
            return temp1;
        return reverse(temp1.substring(1)) + temp1.charAt(0);
    }*/
    // awesome logic
    public static void main(String arg[])
    {
        String temp1 = "toyot";
        Palindrome obj = new Palindrome();
        System.out.println("is palindrome "+obj.compare(temp1));
        
    }

    private boolean compare(String temp1)
    {
        for(int i=0; i < temp1.length()/2;i++)
        {
            if(temp1.charAt(i) != temp1.charAt(temp1.length() -1 - i))
            {
                return false;
            }
        }
        return true;
    }
    
    

}
