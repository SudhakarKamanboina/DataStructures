package test;

public class Test
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println(removeVow("abchdhcishaba"));
    }
    
    public static String removeVow(String str)
    {
        String vowvels = "aeiouAEIOU";
        char[] strChar = str.toCharArray();
        int length = strChar.length;
        for(int i=0; i<length; i++)
        {
            if(vowvels.contains(String.valueOf(strChar[i])))
            {
                int j =i;
                for(;j<length-1;j++)
                {
                    strChar[j] = strChar[j+1];
                }
                length--;
            }
        }
        return new String(strChar, 0, length);
    }

}
