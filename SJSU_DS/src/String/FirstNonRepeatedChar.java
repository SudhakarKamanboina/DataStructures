package String;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatedChar
{
    public static char findFirstNonRepeatedChar(String inputString)
    {
        Map<Character, Integer> charMapCountOne = new LinkedHashMap<Character, Integer>();
        Set<Character> repeatedCharSet = new HashSet<Character>();
        for (char c : inputString.toCharArray())
        {
            if (charMapCountOne.get(c) == null && !repeatedCharSet.contains(c))
            {
                charMapCountOne.put(c, 1);
            }
            else
            {
                repeatedCharSet.add(c);
                charMapCountOne.remove(c);
            }
        }
        if (charMapCountOne.isEmpty())
        {
            return " ".charAt(0);
        }
        return charMapCountOne.keySet().iterator().next();
    }

    public static void main(String[] args)
    {
        System.out.print(FirstNonRepeatedChar.findFirstNonRepeatedChar("aaebbeccad"));
    }
}
