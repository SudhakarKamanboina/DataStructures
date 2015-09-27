package test;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ArrayTest
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String original = "help help how to how act like";
        StringTokenizer st = new StringTokenizer(original, " ");
        Map<String, Integer> mp = new HashMap<String, Integer>();
        while(st.hasMoreElements())
        {
            String str = st.nextToken();
            if(mp.containsKey(str))
            {
                Integer count = mp.get(str)+1;
                mp.put(str, count);
            }
            else
            {
                mp.put(str, 1);
            }
        }
        
        
        for(String str: mp.keySet())
        {
            //System.out.println(str+" : "+mp.get(str));
            int frequency=0;
            String mostUsed = null;
            Integer i = mp.get(str);
            
            if(i>frequency)
            {
                frequency = i;
                mostUsed = str;
            }
            System.out.println(mostUsed + frequency);
            
        }

    }

}
