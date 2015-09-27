package problems;

import java.util.Arrays;

public class LookAndSaySequence
{
    public static String[] look_and_say(String seed, int len)
    {
        String[] seq = new String[len];
        seq[0] = seed;

        for (int i = 1; i < len; i++)
        {
            String val = seq[i - 1];

            StringBuilder nextval = new StringBuilder();
            for (int ix = 0; ix < val.length();)
            {
                char ch = val.charAt(ix);
                int n;
                for (n = 1; ++ix < val.length() && val.charAt(ix) == ch; n++);
                nextval.append(n).append(ch);
            }
            seq[i] = nextval.toString();
        }

        return seq;
    }

    public static void main(String[] args)
    {
        String[] seq = look_and_say("1", 10);
        System.out.println(Arrays.toString(seq));
    }
}
